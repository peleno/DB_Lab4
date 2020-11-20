package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;
import ua.lviv.iot.model.City;

import java.sql.SQLException;
import java.util.List;

public class CityService {
    public List<City> findAll() throws SQLException {
        return new GeneralDaoImpl<City, Integer>(City.class).findAll();
    }

    public City findById(Integer id) throws SQLException {
        return new GeneralDaoImpl<City, Integer>(City.class).findById(id);
    }

    public int create(City entity) throws SQLException {
        return new GeneralDaoImpl<City, Integer>(City.class).create(entity);
    }

    public int update(City entity) throws SQLException {
        return new GeneralDaoImpl<City, Integer>(City.class).update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GeneralDaoImpl<City, Integer>(City.class).delete(id);
    }
}
