package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;
import ua.lviv.iot.model.Region;

import java.sql.SQLException;
import java.util.List;

public class RegionService {
    public List<Region> findAll() throws SQLException {
        return new GeneralDaoImpl<Region, Integer>(Region.class).findAll();
    }

    public Region findById(Integer id) throws SQLException {
        return new GeneralDaoImpl<Region, Integer>(Region.class).findById(id);
    }

    public int create(Region entity) throws SQLException {
        return new GeneralDaoImpl<Region, Integer>(Region.class).create(entity);
    }

    public int update(Region entity) throws SQLException {
        return new GeneralDaoImpl<Region, Integer>(Region.class).update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GeneralDaoImpl<Region, Integer>(Region.class).delete(id);
    }
}
