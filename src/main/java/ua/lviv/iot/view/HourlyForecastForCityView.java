package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.HourlyForecastForCity;
import ua.lviv.iot.service.HourlyForecastForCityService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HourlyForecastForCityView {
    public static void selectAll() throws SQLException {
        System.out.println("Table: hourly_forecast_for_city");
        System.out.printf("%-5s %-8s %s%n", "id", "city_id", "hourly_forecast_id");
        HourlyForecastForCityService service = new HourlyForecastForCityService();
        List<HourlyForecastForCity> hourlyForecastsForCity = service.findAll();
        for (HourlyForecastForCity hourlyForecastForCity : hourlyForecastsForCity) {
            System.out.println(hourlyForecastForCity);
        }
    }

    public static void selectById() throws  SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter id of hourly_forecast_for_city: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        HourlyForecastForCityService service = new HourlyForecastForCityService();
        HourlyForecastForCity hourlyForecastForCity = service.findById(id);
        System.out.printf("%-5s %-8s %s%n", "id", "city_id", "hourly_forecast_id");
        System.out.println(hourlyForecastForCity);
    }

    public static void create() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter city_id for new hourly_forecast_for_city: ");
        Integer cityId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please, enter hourly_forecast_id for new hourly_forecast_for_city: ");
        Integer hourlyForecastId = scanner.nextInt();
        scanner.nextLine();
        HourlyForecastForCity hourlyForecastForCity = new HourlyForecastForCity(0, cityId, hourlyForecastId);
        HourlyForecastForCityService service = new HourlyForecastForCityService();
        int count = service.create(hourlyForecastForCity);
        System.out.printf("There are created %d rows%n", count);
    }

    public static void update() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter id of hourly_forecast_for_city you want to change: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new city_id for this hourly_forecast_for_city: ");
        Integer cityId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please, enter new hourly_forecast_id for this hourly_forecast_for_city: ");
        Integer hourlyForecastId = scanner.nextInt();
        scanner.nextLine();

        HourlyForecastForCity hourlyForecastForCity = new HourlyForecastForCity(id, cityId, hourlyForecastId);
        HourlyForecastForCityService service = new HourlyForecastForCityService();
        int count = service.update(hourlyForecastForCity);
        System.out.printf("There are updated %d rows%n", count);
    }

    public static void delete() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter id of hourly_forecast_for_city you want to delete: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        HourlyForecastForCityService service = new HourlyForecastForCityService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows%n", count);
    }
}
