package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.GeneralDaoImpl;
import ua.lviv.iot.model.WorldPart;

import java.sql.SQLException;
import java.util.List;

public class WorldPartService {
    public List<WorldPart> findAll() throws SQLException {
        //return new WorldPartDaoImpl().findAll();
        return new GeneralDaoImpl<WorldPart, Integer>(WorldPart.class).findAll();
    }

    public WorldPart findById(Integer id) throws SQLException {
        //return new WorldPartDaoImpl().findById(id);
        return new GeneralDaoImpl<WorldPart, Integer>(WorldPart.class).findById(id);
    }

    public int create(WorldPart worldPart) throws SQLException {
        //return new WorldPartDaoImpl().create(worldPart);
        return new GeneralDaoImpl<WorldPart, Integer>(WorldPart.class).create(worldPart);
    }

    public int update(WorldPart worldPart) throws SQLException {
        //return new WorldPartDaoImpl().update(worldPart);
        return new GeneralDaoImpl<WorldPart, Integer>(WorldPart.class).update(worldPart);
    }

    public int delete(Integer id) throws SQLException {
        //return new WorldPartDaoImpl().delete(id);
        return new GeneralDaoImpl<WorldPart, Integer>(WorldPart.class).delete(id);
    }
}
