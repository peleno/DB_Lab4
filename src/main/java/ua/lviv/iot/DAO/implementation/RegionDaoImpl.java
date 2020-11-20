package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.RegionDAO;
import ua.lviv.iot.model.Region;
import ua.lviv.iot.persistent.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegionDaoImpl implements RegionDAO {
    private static final String FIND_ALL = "SELECT * FROM region";
    private static final String FIND_BY_ID = "SELECT * FROM region WHERE id = ?";
    private static final String CREATE = "INSERT INTO region(name, country_id) values (?, ?)";
    private static final String UPDATE = "UPDATE region SET name = ?, country_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM region WHERE id = ?";

    @Override
    public List<Region> findAll() throws SQLException {
        List<Region> regions = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while (rs.next()) {
                    regions.add((Region) new Transformer(Region.class).fromResultSetToEntity(rs));
                }
            }
        }
        return regions;
    }

    @Override
    public Region findById(Integer id) throws SQLException {
        Region region = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    region = (Region) new Transformer(Region.class).fromResultSetToEntity(rs);
                }
            }
        }
        return region;
    }

    @Override
    public int create(Region entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getCountryId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Region entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getCountryId());
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
