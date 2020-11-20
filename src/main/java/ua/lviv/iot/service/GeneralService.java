package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class GeneralService<T> {
    private Class<T> clazz;

    public GeneralService(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> findAll() throws SQLException {
        return new GeneralDaoImpl<T, Integer>(clazz).findAll();
    }

    public T findById(Integer id) throws SQLException {
        return new GeneralDaoImpl<T, Integer>(clazz).findById(id);
    }

    public int create(T entity) throws SQLException {
        return new GeneralDaoImpl<T, Integer>(clazz).create(entity);
    }

    public int update(T entity) throws SQLException {
        return new GeneralDaoImpl<T, Integer>(clazz).update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GeneralDaoImpl<T, Integer>(clazz).delete(id);
    }
}
