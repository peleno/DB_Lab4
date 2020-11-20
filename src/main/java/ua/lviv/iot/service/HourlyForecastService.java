package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;
import ua.lviv.iot.model.HourlyForecast;

import java.sql.SQLException;
import java.util.List;

public class HourlyForecastService {
    public List<HourlyForecast> findAll() throws SQLException {
        return new GeneralDaoImpl<HourlyForecast, Integer>(HourlyForecast.class).findAll();
    }

    public HourlyForecast findById(Integer id) throws SQLException {
        return new GeneralDaoImpl<HourlyForecast, Integer>(HourlyForecast.class).findById(id);
    }

    public int create(HourlyForecast entity) throws SQLException {
        return new GeneralDaoImpl<HourlyForecast, Integer>(HourlyForecast.class).create(entity);
    }

    public int update(HourlyForecast entity) throws SQLException {
        return new GeneralDaoImpl<HourlyForecast, Integer>(HourlyForecast.class).update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GeneralDaoImpl<HourlyForecast, Integer>(HourlyForecast.class).delete(id);
    }
}
