package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "hourly_forecast_for_city")
public class HourlyForecastForCity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "city_id")
    private Integer cityId;
    @Column(name = "hourly_forecast_id")
    private Integer hourlyForecastId;

    public HourlyForecastForCity() {}

    public HourlyForecastForCity(Integer id, Integer cityId, Integer hourlyForecastId) {
        this.id = id;
        this.cityId = cityId;
        this.hourlyForecastId = hourlyForecastId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getHourlyForecastId() {
        return hourlyForecastId;
    }

    public void setHourlyForecastId(Integer hourlyForecastId) {
        this.hourlyForecastId = hourlyForecastId;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-8d %d", id, cityId, hourlyForecastId);
    }
}
