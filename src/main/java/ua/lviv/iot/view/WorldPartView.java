package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.WorldPart;
import ua.lviv.iot.service.WorldPartService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class WorldPartView {
    public static void selectAll() throws SQLException {
        System.out.println("Table: WorldPart");
        WorldPartService worldPartService = new WorldPartService();
        List<WorldPart> worldParts = worldPartService.findAll();
        for (WorldPart worldPart : worldParts) {
            System.out.println(worldPart);
        }
    }

    public static void selectById() throws  SQLException {
        System.out.print("Please, enter id of world part: ");
        Scanner scanner = Controller.getScanner();
        int id = scanner.nextInt();
        scanner.nextLine();
        WorldPartService worldPartService = new WorldPartService();
        WorldPart worldPart = worldPartService.findById(id);
        System.out.println(worldPart);
    }

    public static void create() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter name for new world part: ");
        String name = scanner.nextLine();
        WorldPart worldPart = new WorldPart(0, name);
        WorldPartService worldPartService = new WorldPartService();
        int count = worldPartService.create(worldPart);
        System.out.printf("There are created %d rows%n", count);
    }

    public static void update() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.println("Please, enter id of world part you want to change: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please, enter new name for this world part: ");
        String name = scanner.nextLine();
        WorldPart worldPart = new WorldPart(id, name);
        WorldPartService worldPartService = new WorldPartService();
        int count = worldPartService.update(worldPart);
        System.out.printf("There are updated %d rows%n", count);
    }

    public static void delete() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.println("Please, enter id of world part you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        WorldPartService worldPartService = new WorldPartService();
        int count = worldPartService.delete(id);
        System.out.printf("There are deleted %d rows%n", count);
    }
}
