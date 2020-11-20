package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "country")
public class Country {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "world_part_id")
    private Integer worldPartId;

    public Country () {}

    public Country(Integer id, String name, Integer worldPartId) {
        this.id = id;
        this.name = name;
        this.worldPartId = worldPartId;
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

    public Integer getWorldPartId() {
        return worldPartId;
    }

    public void setWorldPartId(Integer worldPartId) {
        this.worldPartId = worldPartId;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-20s %d", id, name, worldPartId);
    }
}
