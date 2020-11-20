package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;
import ua.lviv.iot.model.WeatherCondition;

import java.sql.SQLException;
import java.util.List;

public class WeatherConditionService {
    public List<WeatherCondition> findAll() throws SQLException {
        return new GeneralDaoImpl<WeatherCondition, Integer>(WeatherCondition.class).findAll();
    }

    public WeatherCondition findById(Integer id) throws SQLException {
        return new GeneralDaoImpl<WeatherCondition, Integer>(WeatherCondition.class).findById(id);
    }

    public int create(WeatherCondition entity) throws SQLException {
        return new GeneralDaoImpl<WeatherCondition, Integer>(WeatherCondition.class).create(entity);
    }

    public int update(WeatherCondition entity) throws SQLException {
        return new GeneralDaoImpl<WeatherCondition, Integer>(WeatherCondition.class).update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GeneralDaoImpl<WeatherCondition, Integer>(WeatherCondition.class).delete(id);
    }
}
