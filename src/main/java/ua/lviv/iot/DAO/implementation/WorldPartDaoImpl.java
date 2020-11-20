package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.WorldPartDAO;
import ua.lviv.iot.model.WorldPart;
import ua.lviv.iot.persistent.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorldPartDaoImpl implements WorldPartDAO {
    private static final String FIND_ALL = "SELECT * FROM world_part";
    private static final String FIND_BY_ID = "SELECT * FROM world_part WHERE id = ?";
    private static final String CREATE = "INSERT INTO world_part(name) values (?)";
    private static final String UPDATE = "UPDATE world_part SET name = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM world_part WHERE id = ?";

    @Override
    public List<WorldPart> findAll() throws SQLException {
        List<WorldPart> worldParts = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()){
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    worldParts.add((WorldPart) new Transformer(WorldPart.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return worldParts;
    }

    @Override
    public WorldPart findById(Integer id) throws SQLException {
        WorldPart worldPart = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    worldPart = (WorldPart) new Transformer(WorldPart.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return worldPart;
    }

    @Override
    public int create(WorldPart entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, entity.getName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(WorldPart entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }


}
