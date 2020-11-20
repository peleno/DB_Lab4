package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "city")
public class City {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "region_id")
    private Integer regionId;

    public City() {}

    public City(Integer id, String name, Integer regionId) {
        this.id = id;
        this.name = name;
        this.regionId = regionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-20s %d", id, name, regionId);
    }
}
