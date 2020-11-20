package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;
import ua.lviv.iot.model.DailyForecast;

import java.sql.SQLException;
import java.util.List;

public class DailyForecastService {
    public List<DailyForecast> findAll() throws SQLException {
        return new GeneralDaoImpl<DailyForecast, Integer>(DailyForecast.class).findAll();
    }

    public DailyForecast findById(Integer id) throws SQLException {
        return new GeneralDaoImpl<DailyForecast, Integer>(DailyForecast.class).findById(id);
    }

    public int create(DailyForecast entity) throws SQLException {
        return new GeneralDaoImpl<DailyForecast, Integer>(DailyForecast.class).create(entity);
    }

    public int update(DailyForecast entity) throws SQLException {
        return new GeneralDaoImpl<DailyForecast, Integer>(DailyForecast.class).update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GeneralDaoImpl<DailyForecast, Integer>(DailyForecast.class).delete(id);
    }
}
