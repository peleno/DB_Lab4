package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;
import ua.lviv.iot.model.Precipitation;

import java.sql.SQLException;
import java.util.List;

public class PrecipitationService {
    public List<Precipitation> findAll() throws SQLException {
        return new GeneralDaoImpl<Precipitation, Integer>(Precipitation.class).findAll();
    }

    public Precipitation findById(Integer id) throws SQLException {
        return new GeneralDaoImpl<Precipitation, Integer>(Precipitation.class).findById(id);
    }

    public int create(Precipitation entity) throws SQLException {
        return new GeneralDaoImpl<Precipitation, Integer>(Precipitation.class).create(entity);
    }

    public int update(Precipitation entity) throws SQLException {
        return new GeneralDaoImpl<Precipitation, Integer>(Precipitation.class).update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GeneralDaoImpl<Precipitation, Integer>(Precipitation.class).delete(id);
    }
}
