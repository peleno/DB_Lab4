package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Region;
import ua.lviv.iot.service.RegionService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class RegionView {
    public static void selectAll() throws SQLException {
        System.out.println("Table: region");
        System.out.printf("%-5s %-20s %s%n", "id", "name", "country_id");
        RegionService service = new RegionService();
        List<Region> regions = service.findAll();
        for (Region region : regions) {
            System.out.println(region);
        }
    }

    public static void selectById() throws  SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter id of region: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        RegionService service = new RegionService();
        Region region = service.findById(id);
        System.out.printf("%-5s %-20s %s%n", "id", "name", "country_id");
        System.out.println(region);
    }

    public static void create() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter name for new region: ");
        String name = scanner.nextLine();
        System.out.print("Please, enter country_id for new region: ");
        Integer countryId = scanner.nextInt();
        scanner.nextLine();
        Region region = new Region(0, name, countryId);
        RegionService service = new RegionService();
        int count = service.create(region);
        System.out.printf("There are created %d rows%n", count);
    }

    public static void update() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter id of region you want to change: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new name for this region: ");
        String name = scanner.nextLine();

        System.out.print("Please, enter country_id for this region: ");
        Integer countryId = scanner.nextInt();
        scanner.nextLine();

        Region region = new Region(id, name, countryId);
        RegionService service = new RegionService();
        int count = service.update(region);
        System.out.printf("There are updated %d rows%n", count);
    }

    public static void delete() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter id of region you want to delete: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        RegionService service = new RegionService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows%n", count);
    }
}
