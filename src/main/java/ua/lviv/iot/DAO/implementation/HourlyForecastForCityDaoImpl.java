package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.HourlyForecastForCityDAO;
import ua.lviv.iot.model.HourlyForecastForCity;
import ua.lviv.iot.persistent.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HourlyForecastForCityDaoImpl implements HourlyForecastForCityDAO {
    private static final String FIND_ALL = "SELECT * FROM hourly_forecast_for_city";
    private static final String FIND_BY_ID = "SELECT * FROM hourly_forecast_for_city WHERE id = ?";
    private static final String CREATE = "INSERT INTO hourly_forecast_for_city(city_id, hourly_forecast_id) values (?, ?)";

    @Override
    public List<HourlyForecastForCity> findAll() throws SQLException {
        List<HourlyForecastForCity> hourlyForecastForCityList = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while (rs.next()) {
                    hourlyForecastForCityList.add((HourlyForecastForCity) new Transformer(HourlyForecastForCity.class).fromResultSetToEntity(rs));
                }
            }
        }
        return hourlyForecastForCityList;
    }

    @Override
    public HourlyForecastForCity findById(Integer id) throws SQLException {
        HourlyForecastForCity hourlyForecastForCity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    hourlyForecastForCity = (HourlyForecastForCity) new Transformer(HourlyForecastForCity.class).fromResultSetToEntity(rs);
                }
            }
        }
        return hourlyForecastForCity;
    }

    @Override
    public int create(HourlyForecastForCity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getCityId());
            ps.setInt(2, entity.getHourlyForecastId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(HourlyForecastForCity entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Integer integer) throws SQLException {
        return 0;
    }
}
