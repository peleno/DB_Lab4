package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.CityDAO;
import ua.lviv.iot.model.City;
import ua.lviv.iot.persistent.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDAO {
    private static final String FIND_ALL = "SELECT * FROM city";
    private static final String FIND_BY_ID = "SELECT * FROM city WHERE id = ?";
    private static final String CREATE = "INSERT INTO city(name, region_id) values (?, ?)";
    private static final String UPDATE = "UPDATE city SET name = ?, region_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM city WHERE id = ?";

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while (rs.next()) {
                    cities.add((City) new Transformer(City.class).fromResultSetToEntity(rs));
                }
            }
        }
        return cities;
    }

    @Override
    public City findById(Integer id) throws SQLException {
        City city = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    city = (City) new Transformer(City.class).fromResultSetToEntity(rs);
                }
            }
        }
        return city;
    }

    @Override
    public int create(City entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getRegionId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(City entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getRegionId());
            ps.setInt(3, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}
