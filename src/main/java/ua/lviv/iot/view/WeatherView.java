package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Weather;
import ua.lviv.iot.service.WeatherService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class WeatherView {

    public static void selectAll() throws SQLException {
        System.out.println("Table: weather");
        System.out.printf("%-5s %-15s %-25s %-20s %-10s %-20s %-10s %-11s %-15s %-11s %-10s %-15s %-27s %-20s %-25s %s%n", "id", "temperature",
                "real_feel_temperature", "water_temperature", "humidity", "indoor_humidity", "pressure", "wind_speed",
                "wind_direction", "wind_gusts", "dew_point", "cloud_ceiling", "precipitation_probability",
                "precipitation_id", "weather_condition_id", "thunderstorm_probability");
        WeatherService service = new WeatherService();
        List<Weather> weathers = service.findAll();
        for (Weather weather : weathers) {
            System.out.println(weather);
        }
    }

    public static void selectById() throws  SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter id of weather: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        WeatherService service = new WeatherService();
        Weather weather = service.findById(id);
        System.out.printf("%-5s %-15s %-25s %-20s %-10s %-20s %-10s %-11s %-15s %-11s %-10s %-15s %-27s %-20s %-25s %s%n",
                "id", "temperature", "real_feel_temperature", "water_temperature", "humidity", "indoor_humidity",
                "pressure", "wind_speed", "wind_direction", "wind_gusts", "dew_point", "cloud_ceiling",
                "precipitation_probability", "precipitation_id", "weather_condition_id", "thunderstorm_probability");
        System.out.println(weather);
    }

    public static void create() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter temperature for new weather: ");
        Integer temperature = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter real_feel_temperature for new weather: ");
        Integer realFeelTemperature = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter water_temperature for new weather: ");
        Integer waterTemperature = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter humidity for new weather: ");
        Integer humidity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter indoor_humidity for new weather: ");
        Integer indoorHumidity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter pressure for new weather: ");
        Integer pressure = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter wind_speed for new weather: ");
        Integer windSpeed = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter wind_direction for new weather: ");
        String windDirection = scanner.nextLine();

        System.out.print("Please, enter wind_gusts for new weather: ");
        Integer windGusts = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter dew_point for new weather: ");
        Integer dewPoint = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter cloud_ceiling for new weather: ");
        Integer cloudCeiling = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter precipitation_probability for new weather: ");
        Integer precipitationProbability = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter precipitation_id for new weather: ");
        Integer precipitationId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter weather_condition_id for new weather: ");
        Integer weatherConditionId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter thunderstorm_probability for new weather: ");
        Integer thunderstormProbability = scanner.nextInt();
        scanner.nextLine();

        Weather weather = new Weather(0, temperature, realFeelTemperature, waterTemperature, humidity, indoorHumidity,
                pressure, windSpeed, windDirection, windGusts, dewPoint, cloudCeiling, precipitationProbability,
                precipitationId, weatherConditionId, thunderstormProbability);
        WeatherService service = new WeatherService();
        int count = service.create(weather);
        System.out.printf("There are created %d rows%n", count);
    }

    public static void update() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter id of weather you want to change: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new temperature for this weather: ");
        Integer temperature = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new real_feel_temperature for this weather: ");
        Integer realFeelTemperature = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new water_temperature for this weather: ");
        Integer waterTemperature = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new humidity for this weather: ");
        Integer humidity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new indoor_humidity for this weather: ");
        Integer indoorHumidity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new pressure for this weather: ");
        Integer pressure = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new wind_speed for this weather: ");
        Integer windSpeed = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new wind_direction for this weather: ");
        String windDirection = scanner.nextLine();

        System.out.print("Please, enter new wind_gusts for this weather: ");
        Integer windGusts = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new dew_point for this weather: ");
        Integer dewPoint = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new cloud_ceiling for this weather: ");
        Integer cloudCeiling = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new precipitation_probability for this weather: ");
        Integer precipitationProbability = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new precipitation_id for this weather: ");
        Integer precipitationId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new weather_condition_id for this weather: ");
        Integer weatherConditionId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please, enter new thunderstorm_probability for this weather: ");
        Integer thunderstormProbability = scanner.nextInt();
        scanner.nextLine();

        Weather weather = new Weather(id, temperature, realFeelTemperature, waterTemperature, humidity, indoorHumidity,
                pressure, windSpeed, windDirection, windGusts, dewPoint, cloudCeiling, precipitationProbability,
                precipitationId, weatherConditionId, thunderstormProbability);
        WeatherService service = new WeatherService();
        int count = service.update(weather);
        System.out.printf("There are updated %d rows%n", count);
    }

    public static void delete() throws SQLException {
        Scanner scanner = Controller.getScanner();
        System.out.print("Please, enter id of weather you want to delete: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        WeatherService service = new WeatherService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows%n", count);
    }

}
