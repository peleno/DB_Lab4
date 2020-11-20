package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;
import ua.lviv.iot.model.Weather;

import java.sql.SQLException;
import java.util.List;

public class WeatherService {
    public List<Weather> findAll() throws SQLException {
        return new GeneralDaoImpl<Weather, Integer>(Weather.class).findAll();
    }

    public Weather findById(Integer id) throws SQLException {
        return new GeneralDaoImpl<Weather, Integer>(Weather.class).findById(id);
    }

    public int create(Weather entity) throws SQLException {
        return new GeneralDaoImpl<Weather, Integer>(Weather.class).create(entity);
    }

    public int update(Weather entity) throws SQLException {
        return new GeneralDaoImpl<Weather, Integer>(Weather.class).update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GeneralDaoImpl<Weather, Integer>(Weather.class).delete(id);
    }
}
