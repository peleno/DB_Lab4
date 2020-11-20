package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "weather")
public class Weather {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "temperature")
    private Integer temperature;
    @Column(name = "real_feel_temperature")
    private Integer realFeelTemperature;
    @Column(name = "water_temperature")
    private Integer waterTemperature;
    @Column(name = "humidity")
    private Integer humidity;
    @Column(name = "indoor_humidity")
    private Integer indoorHumidity;
    @Column(name = "pressure")
    private Integer pressure;
    @Column(name = "wind_speed")
    private Integer windSpeed;
    @Column(name = "wind_direction", length = 3)
    private String windDirection;
    @Column(name = "wind_gusts")
    private Integer windGusts;
    @Column(name = "dew_point")
    private Integer dewPoint;
    @Column(name = "cloud_ceiling")
    private Integer cloudCeiling;
    @Column(name = "precipitation_probability")
    private Integer precipitationProbability;
    @Column(name = "precipitation_id")
    private Integer precipitationId;
    @Column(name = "weather_condition_id")
    private Integer weatherConditionId;
    @Column(name = "thunderstorm_probability")
    private Integer thunderstormProbability;

    public Weather() {}

    public Weather(Integer id, Integer temperature, Integer realFeelTemperature, Integer waterTemperature, Integer humidity, Integer indoorHumidity, Integer pressure, Integer windSpeed, String windDirection, Integer windGusts, Integer dewPoint, Integer cloudCeiling, Integer precipitationProbability, Integer precipitationId, Integer weatherConditionId, Integer thunderstormProbability) {
        this.id = id;
        this.temperature = temperature;
        this.realFeelTemperature = realFeelTemperature;
        this.waterTemperature = waterTemperature;
        this.humidity = humidity;
        this.indoorHumidity = indoorHumidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.windGusts = windGusts;
        this.dewPoint = dewPoint;
        this.cloudCeiling = cloudCeiling;
        this.precipitationProbability = precipitationProbability;
        this.precipitationId = precipitationId;
        this.weatherConditionId = weatherConditionId;
        this.thunderstormProbability = thunderstormProbability;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15d %-25d %-20d %-10d %-20d %-10d %-11d %-15s %-11d %-10d %-15d %-27d %-20d %-25d %s",
                id, temperature, realFeelTemperature, waterTemperature, humidity, indoorHumidity, pressure, windSpeed,
                windDirection, windGusts, dewPoint, cloudCeiling, precipitationProbability, precipitationId,
                weatherConditionId, thunderstormProbability);
    }
}
