package ua.lviv.iot.transformer;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Table;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Transformer<T> {
    private final Class<T> clazz;

    public Transformer(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T fromResultSetToEntity(ResultSet rs) throws SQLException {
        T entity = null;
        try {
            entity = clazz.getConstructor().newInstance();
            if (clazz.isAnnotationPresent(Table.class)) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    // if field is annotated with @Column
                    if (field.isAnnotationPresent(Column.class)) {
                        Column column = field.getAnnotation(Column.class);
                        String name = column.name();
                        field.setAccessible(true);
                        Class fieldType = field.getType();
                        if (fieldType == String.class) {
                            field.set(entity, rs.getString(name));
                        } else if (fieldType == Integer.class) {
                            field.set(entity, rs.getInt(name));
                        } else if (fieldType == Time.class) {
                            field.set(entity, rs.getTime(name));
                        } else if (fieldType == Double.class) {
                            field.set(entity, rs.getDouble(name));
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
