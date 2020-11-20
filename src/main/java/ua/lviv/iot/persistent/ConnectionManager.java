package ua.lviv.iot.persistent;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static String url;
    private static String user;
    private static String password;

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            getCredentials();
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("SQLException " + e.getMessage());
                System.out.println("SQLState " + e.getSQLState());
                System.out.println("VendorError " + e.getErrorCode());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Closed connection");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getCredentials() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String credentialsPath = rootPath + "credentials.properties";
        Properties credentialsProps = new Properties();
        try (FileInputStream inputStream = new FileInputStream(credentialsPath)) {
            credentialsProps.load(inputStream);
            url = credentialsProps.getProperty("url");
            user = credentialsProps.getProperty("user");
            password = credentialsProps.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
