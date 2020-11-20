package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "hourly_forecast")
public class HourlyForecast {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "hour")
    private Integer hour;
    @Column(name = "daily_forecast_id")
    private Integer dailyForecastId;
    @Column(name = "weather_id")
    private Integer weatherId;

    public HourlyForecast() {}

    public HourlyForecast(Integer id, Integer hour, Integer dailyForecastId, Integer weatherId) {
        this.id = id;
        this.hour = hour;
        this.dailyForecastId = dailyForecastId;
        this.weatherId = weatherId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getDailyForecastId() {
        return dailyForecastId;
    }

    public void setDailyForecastId(Integer dailyForecastId) {
        this.dailyForecastId = dailyForecastId;
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-5d %-20d %d", id, hour, dailyForecastId, weatherId);
    }
}
