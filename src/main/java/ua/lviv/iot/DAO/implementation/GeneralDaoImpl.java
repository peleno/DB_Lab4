package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.GeneralDAO;
import ua.lviv.iot.model.Weather;
import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;
import ua.lviv.iot.persistent.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneralDaoImpl<T, ID> implements GeneralDAO<T, ID> {
    private static final String FIND_ALL_TEMPLATE = "SELECT * FROM %s";
    private static final String FIND_BY_ID_TEMPLATE = "SELECT * FROM %s WHERE %s = ?";
    private static final String CREATE_TEMPLATE = "INSERT INTO %s VALUES %s";
    private static final String UPDATE_TEMPLATE = "UPDATE %s SET %s = ? WHERE %s = ?";
    private static final String UPDATE_FOR_ALL_FIELDS = "UPDATE %s SET %s WHERE %s = ?";
    private static final String DELETE_TEMPLATE = "DELETE FROM %s WHERE %s = ?";

    private final Class<T> clazz;

    private String tableName;
    private String primaryKey = null;
    private List<String> columnNames;

    private List<String> fieldNames;

    private String findAllQuery;
    private String findByIdQuery;
    private String createQuery;
    private List<String> updateQueries;
    private String updateQuery;
    private String deleteQuery;

    public GeneralDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
        this.columnNames = new ArrayList<>();
        this.updateQueries = new ArrayList<>();
        this.fieldNames = new ArrayList<>();

        if (this.clazz.isAnnotationPresent(Table.class)) {
            Table table = this.clazz.getAnnotation(Table.class);
            tableName = table.name();
        }
        Field[] fields = this.clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                String name = column.name();
                if (field.isAnnotationPresent(PrimaryKey.class)) {
                    primaryKey = name;
                } else {
                    columnNames.add(name);
                    fieldNames.add(field.getName());
                }
            }
        }
        setFindAllQuery();
        setFindByIdQuery();
        setCreateQuery();
        setUpdateQueries();
        setUpdateQuery();
        setDeleteQuery();

    }

    @Override
    public List<T> findAll() throws SQLException {
        List<T> entities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(findAllQuery)) {
                while (rs.next()) {
                    entities.add(new Transformer<>(this.clazz).fromResultSetToEntity(rs));
                }
            }
        }
        return entities;
    }

    @Override
    public T findById(ID id) throws SQLException {
        T entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(findByIdQuery)) {
            ps.setInt(1, (Integer) id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entity = new Transformer<>(this.clazz).fromResultSetToEntity(rs);
                }
            }
        }
        return entity;
    }

    @Override
    public int create(T entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(createQuery)) {
            int parameterPosition = 1;
            for (String fieldName : fieldNames) {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                ps.setObject(parameterPosition, field.get(entity));
                parameterPosition++;
            }
            return ps.executeUpdate();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(T entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            int parameterPosition = 1;
            for (String fieldName : fieldNames) {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                ps.setObject(parameterPosition, field.get(entity));
                parameterPosition++;
            }
            Field pkField = clazz.getDeclaredField(primaryKey);
            pkField.setAccessible(true);
            ps.setObject(parameterPosition, pkField.get(entity));
            return ps.executeUpdate();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(ID id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
            ps.setInt(1, (Integer) id);
            return ps.executeUpdate();
        }
    }


    private void setFindAllQuery() {
        findAllQuery = String.format(FIND_ALL_TEMPLATE, tableName);
    }

    private void setFindByIdQuery() {
        findByIdQuery = String.format(FIND_BY_ID_TEMPLATE, tableName, primaryKey);
    }

    private void setCreateQuery() {
        StringBuilder tableAndColumnNames = new StringBuilder(tableName + "(" + columnNames.get(0));
        StringBuilder valuesPlaceholder = new StringBuilder("(?");
        for (int i = 1; i < columnNames.size(); i++) {
            tableAndColumnNames.append(", " + columnNames.get(i));
            valuesPlaceholder.append(", ?");
        }
        tableAndColumnNames.append(")");
        valuesPlaceholder.append(")");
        createQuery = String.format(CREATE_TEMPLATE, tableAndColumnNames.toString(), valuesPlaceholder.toString());
    }

    private void setUpdateQueries() {
        for (String columnName : columnNames) {
            updateQueries.add(String.format(UPDATE_TEMPLATE, tableName, columnName, primaryKey));
        }
    }

    private void setUpdateQuery() {
        StringBuilder columnsForUpdate = new StringBuilder(columnNames.get(0) + " = ?");
        for (int i = 1; i < columnNames.size(); i++) {
            columnsForUpdate.append(", ").append(columnNames.get(i)).append(" = ?");
        }
        updateQuery = String.format(UPDATE_FOR_ALL_FIELDS, tableName, columnsForUpdate.toString(), primaryKey);
    }

    private void setDeleteQuery() {
        deleteQuery = String.format(DELETE_TEMPLATE, tableName, primaryKey);
    }

    public static void main(String[] args) {
        GeneralDaoImpl<Weather, Integer> generalDao = new GeneralDaoImpl<>(Weather.class);
        try {
            List<Weather> entities = generalDao.findAll();
            for (Weather entity : entities) {
                System.out.println(entity);
            }
            System.out.println(generalDao.createQuery);
            System.out.println(generalDao.findAllQuery);
            System.out.println(generalDao.findByIdQuery);
            System.out.println(generalDao.deleteQuery);
            for (String updateQuery : generalDao.updateQueries) {
                System.out.println(updateQuery);
            }
            System.out.println(generalDao.updateQuery);
            for (String fieldName : generalDao.fieldNames) {
                System.out.println(fieldName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
