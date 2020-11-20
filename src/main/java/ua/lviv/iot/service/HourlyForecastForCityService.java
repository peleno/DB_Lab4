package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;
import ua.lviv.iot.model.HourlyForecastForCity;

import java.sql.SQLException;
import java.util.List;

public class HourlyForecastForCityService {
    public List<HourlyForecastForCity> findAll() throws SQLException {
        return new GeneralDaoImpl<HourlyForecastForCity, Integer>(HourlyForecastForCity.class).findAll();
    }

    public HourlyForecastForCity findById(Integer id) throws SQLException {
        return new GeneralDaoImpl<HourlyForecastForCity, Integer>(HourlyForecastForCity.class).findById(id);
    }

    public int create(HourlyForecastForCity entity) throws SQLException {
        return new GeneralDaoImpl<HourlyForecastForCity, Integer>(HourlyForecastForCity.class).create(entity);
    }

    public int update(HourlyForecastForCity entity) throws SQLException {
        return new GeneralDaoImpl<HourlyForecastForCity, Integer>(HourlyForecastForCity.class).update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GeneralDaoImpl<HourlyForecastForCity, Integer>(HourlyForecastForCity.class).delete(id);
    }
}
