package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.CountryDAO;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.persistent.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements CountryDAO {
    private static final String FIND_ALL = "SELECT * FROM country";
    private static final String FIND_BY_ID = "SELECT * FROM country WHERE id = ?";
    private static final String CREATE = "INSERT INTO country(name, world_part_id) values (?, ?)";
    private static final String UPDATE = "UPDATE country SET name = ?, world_part_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM country WHERE id = ?";

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)){
                while(rs.next()) {
                    countries.add((Country) new Transformer(Country.class).fromResultSetToEntity(rs));
                }
            }
        }
        return countries;
    }

    @Override
    public Country findById(Integer id) throws SQLException {
        Country country = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    country = (Country) new Transformer(Country.class).fromResultSetToEntity(rs);
                }
            }
        }
        return country;
    }

    @Override
    public int create(Country entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getWorldPartId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Country entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getWorldPartId());
            ps.setInt(3, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}
