package ua.lviv.iot.controller;

import ua.lviv.iot.persistent.ConnectionManager;
import ua.lviv.iot.view.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner scanner = new Scanner(System.in);

    public Controller() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("A", "   A - Select all tables");

        menu.put("1", "   1 - Table: world_part");
        menu.put("11", "   11 - Select world_part");
        menu.put("12", "   12 - Find world_part by id");
        menu.put("13", "   13 - Create new world_part");
        menu.put("14", "   14 - Update world_part");
        menu.put("15", "   15 - Delete world_part");

        menu.put("2", "   2 - Table: country");
        menu.put("21", "   21 - Select country");
        menu.put("22", "   22 - Find country by id");
        menu.put("23", "   23 - Create new country");
        menu.put("24", "   24 - Update country");
        menu.put("25", "   25 - Delete country");

        menu.put("3", "   3 - Table: region");
        menu.put("31", "   31 - Select region");
        menu.put("32", "   32 - Find region by id");
        menu.put("33", "   33 - Create new region");
        menu.put("34", "   34 - Update region");
        menu.put("35", "   35 - Delete region");

        menu.put("4", "   4 - Table: city");
        menu.put("41", "   41 - Select city");
        menu.put("42", "   42 - Find city by id");
        menu.put("43", "   43 - Create new city");
        menu.put("44", "   44 - Update city");
        menu.put("45", "   45 - Delete city");

        menu.put("5", "   5 - Table: hourly_forecast_for_city");
        menu.put("51", "   51 - Select hourly_forecast_for_city");
        menu.put("52", "   52 - Find hourly_forecast_for_city by id");
        menu.put("53", "   53 - Create new hourly_forecast_for_city");
        menu.put("54", "   54 - Update hourly_forecast_for_city");
        menu.put("55", "   55 - Delete hourly_forecast_for_city");

        menu.put("6", "   6 - Table: hourly_forecast");
        menu.put("61", "   61 - Select hourly_forecast");
        menu.put("62", "   62 - Find hourly_forecast by id");
        menu.put("63", "   63 - Create new hourly_forecast");
        menu.put("64", "   64 - Update hourly_forecast");
        menu.put("65", "   65 - Delete hourly_forecast");

        menu.put("7", "   7 - Table: daily_forecast");
        menu.put("71", "   71 - Select daily_forecast");
        menu.put("72", "   72 - Find daily_forecast by id");
        menu.put("73", "   73 - Create new daily_forecast");
        menu.put("74", "   74 - Update daily_forecast");
        menu.put("75", "   75 - Delete daily_forecast");

        menu.put("8", "   8 - Table: weather");
        menu.put("81", "   81 - Select weather");
        menu.put("82", "   82 - Find weather by id");
        menu.put("83", "   83 - Create new weather");
        menu.put("84", "   84 - Update weather");
        menu.put("85", "   85 - Delete weather");

        menu.put("9", "   9 - Table: precipitation");
        menu.put("91", "   91 - Select precipitation");
        menu.put("92", "   92 - Find precipitation by id");
        menu.put("93", "   93 - Create new precipitation");
        menu.put("94", "   94 - Update precipitation");
        menu.put("95", "   95 - Delete precipitation");

        menu.put("Q", "   Q - Exit");

        methodsMenu.put("A", this::selectAllTables);

        methodsMenu.put("11", WorldPartView::selectAll);
        methodsMenu.put("12", WorldPartView::selectById);
        methodsMenu.put("13", WorldPartView::create);
        methodsMenu.put("14", WorldPartView::update);
        methodsMenu.put("15", WorldPartView::delete);

        methodsMenu.put("21", CountryView::selectAll);
        methodsMenu.put("22", CountryView::selectById);
        methodsMenu.put("23", CountryView::create);
        methodsMenu.put("24", CountryView::update);
        methodsMenu.put("25", CountryView::delete);

        methodsMenu.put("31", RegionView::selectAll);
        methodsMenu.put("32", RegionView::selectById);
        methodsMenu.put("33", RegionView::create);
        methodsMenu.put("34", RegionView::update);
        methodsMenu.put("35", RegionView::delete);

        methodsMenu.put("41", CityView::selectAll);
        methodsMenu.put("42", CityView::selectById);
        methodsMenu.put("43", CityView::create);
        methodsMenu.put("44", CityView::update);
        methodsMenu.put("45", CityView::delete);

        methodsMenu.put("51", HourlyForecastForCityView::selectAll);
        methodsMenu.put("52", HourlyForecastForCityView::selectById);
        methodsMenu.put("53", HourlyForecastForCityView::create);
        methodsMenu.put("54", HourlyForecastForCityView::update);
        methodsMenu.put("55", HourlyForecastForCityView::delete);

        methodsMenu.put("61", HourlyForecastView::selectAll);
        methodsMenu.put("62", HourlyForecastView::selectById);
        methodsMenu.put("63", HourlyForecastView::create);
        methodsMenu.put("64", HourlyForecastView::update);
        methodsMenu.put("65", HourlyForecastView::delete);

        methodsMenu.put("71", DailyForecastView::selectAll);
        methodsMenu.put("72", DailyForecastView::selectById);
        methodsMenu.put("73", DailyForecastView::create);
        methodsMenu.put("74", DailyForecastView::update);
        methodsMenu.put("75", DailyForecastView::delete);

        methodsMenu.put("81", WeatherView::selectAll);
        methodsMenu.put("82", WeatherView::selectById);
        methodsMenu.put("83", WeatherView::create);
        methodsMenu.put("84", WeatherView::update);
        methodsMenu.put("85", WeatherView::delete);

        methodsMenu.put("91", PrecipitationView::selectAll);
        methodsMenu.put("92", PrecipitationView::selectById);
        methodsMenu.put("93", PrecipitationView::create);
        methodsMenu.put("94", PrecipitationView::update);
        methodsMenu.put("95", PrecipitationView::delete);
    }

    private void selectAllTables() throws SQLException {
        WorldPartView.selectAll();
        System.out.println("\n----------------------------------------------\n");
        CountryView.selectAll();
        System.out.println("\n----------------------------------------------\n");
        RegionView.selectAll();
        System.out.println("\n----------------------------------------------\n");
        CityView.selectAll();
        System.out.println("\n----------------------------------------------\n");
        HourlyForecastForCityView.selectAll();
        System.out.println("\n----------------------------------------------\n");
        HourlyForecastView.selectAll();
        System.out.println("\n----------------------------------------------\n");
        DailyForecastView.selectAll();
        System.out.println("\n----------------------------------------------\n");
        WeatherView.selectAll();
        System.out.println("\n----------------------------------------------\n");
        PrecipitationView.selectAll();
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet()) {
            if (key.length() == 1) System.out.println(menu.get(key));
        }
    }

    private void outputSubMenu(String fig) {
        System.out.println("\nSubMENU:");
        for (String key : menu.keySet()) {
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) {
                System.out.println(menu.get(key));
            }
        }
    }

    public void init() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = scanner.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = scanner.nextLine().toUpperCase();
            }
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println("Incorrect input");
            }
        } while (!keyMenu.equals("Q"));
        ConnectionManager.closeConnection();
    }

    public static Scanner getScanner() {return scanner;}
}
