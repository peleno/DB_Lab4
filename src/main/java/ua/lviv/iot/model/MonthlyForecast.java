package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "monthly_forecast")
public class MonthlyForecast {
    @Column(name = "year")
    private Integer year;
    @Column(name = "month", length = 10)
    private String month;

    public MonthlyForecast() {}

    public MonthlyForecast(Integer year, String month) {
        this.year = year;
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "MonthlyForecast{" +
                "year=" + year +
                ", month='" + month + '\'' +
                '}';
    }
}
