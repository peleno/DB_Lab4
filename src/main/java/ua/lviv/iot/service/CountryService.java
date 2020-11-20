package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;
import ua.lviv.iot.model.Country;

import java.sql.SQLException;
import java.util.List;

public class CountryService {
    public List<Country> findAll() throws SQLException {
        return new GeneralDaoImpl<Country, Integer>(Country.class).findAll();
    }

    public Country findById(Integer id) throws SQLException {
        return new GeneralDaoImpl<Country, Integer>(Country.class).findById(id);
    }

    public int create(Country entity) throws SQLException {
        return new GeneralDaoImpl<Country, Integer>(Country.class).create(entity);
    }

    public int update(Country entity) throws SQLException {
        return new GeneralDaoImpl<Country, Integer>(Country.class).update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GeneralDaoImpl<Country, Integer>(Country.class).delete(id);
    }
}
