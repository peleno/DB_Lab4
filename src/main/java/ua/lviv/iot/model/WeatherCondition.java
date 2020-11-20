package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "weather_condition")
public class WeatherCondition {
    @Column(name = "id")
    private Integer id;
    @Column(name = "description", length = 50)
    private String description;
    // actually, it is a blob
    private String icon;
    @Column(name = "day")
    private Boolean day;
    @Column(name = "day")
    private Boolean night;

    public WeatherCondition () {}

    public WeatherCondition(Integer id, String description, String icon, Boolean day, Boolean night) {
        this.id = id;
        this.description = description;
        this.icon = icon;
        this.day = day;
        this.night = night;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getDay() {
        return day;
    }

    public void setDay(Boolean day) {
        this.day = day;
    }

    public Boolean getNight() {
        return night;
    }

    public void setNight(Boolean night) {
        this.night = night;
    }
}
