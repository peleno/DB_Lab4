package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

import java.sql.Time;

@Table(name = "daily_forecast")
public class DailyForecast {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "day")
    private Integer day;
    @Column(name = "sunrise")
    private Time sunrise;
    @Column(name = "sunset")
    private Time sunset;
    @Column(name = "moonrise")
    private Time moonrise;
    @Column(name = "moonset")
    private Time moonset;
    @Column(name = "monthly_forecast_year")
    private Integer monthlyForecastYear;
    @Column(name = "monthly_forecast_month")
    private String monthlyForecastMonth;

    public DailyForecast() {
    }

    public DailyForecast(Integer id, Integer day, Time sunrise, Time sunset, Time moonrise, Time moonset, Integer monthlyForecastYear, String monthlyForecastMonth) {
        this.id = id;
        this.day = day;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.monthlyForecastYear = monthlyForecastYear;
        this.monthlyForecastMonth = monthlyForecastMonth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Time getSunrise() {
        return sunrise;
    }

    public void setSunrise(Time sunrise) {
        this.sunrise = sunrise;
    }

    public Time getSunset() {
        return sunset;
    }

    public void setSunset(Time sunset) {
        this.sunset = sunset;
    }

    public Time getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(Time moonrise) {
        this.moonrise = moonrise;
    }

    public Time getMoonset() {
        return moonset;
    }

    public void setMoonset(Time moonset) {
        this.moonset = moonset;
    }

    public Integer getMonthlyForecastYear() {
        return monthlyForecastYear;
    }

    public void setMonthlyForecastYear(Integer monthlyForecastYear) {
        this.monthlyForecastYear = monthlyForecastYear;
    }

    public String getMonthlyForecastMonth() {
        return monthlyForecastMonth;
    }

    public void setMonthlyForecastMonth(String monthlyForecastMonth) {
        this.monthlyForecastMonth = monthlyForecastMonth;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-5d %-10s %-10s %-10s %-10s %-25s %s", id, day, sunrise, sunset, moonrise, moonset, monthlyForecastYear, monthlyForecastMonth);
    }
}
