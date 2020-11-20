package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "world_part")
public class WorldPart {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 20)
    private String name;

    public WorldPart() {}

    public WorldPart(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-5s", id, name);
    }
}
