package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "precipitation")
public class Precipitation {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "rain")
    private Double rain;
    @Column(name = "snow")
    private Double snow;
    @Column(name = "ice")
    private Double ice;

    public Precipitation() {}

    public Precipitation(Integer id, Double rain, Double snow, Double ice) {
        this.id = id;
        this.rain = rain;
        this.snow = snow;
        this.ice = ice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Double getSnow() {
        return snow;
    }

    public void setSnow(Double snow) {
        this.snow = snow;
    }

    public Double getIce() {
        return ice;
    }

    public void setIce(Double ice) {
        this.ice = ice;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-8.2f %-8.2f %-8.2f", id, rain, snow, ice);
    }
}
