package com.academicbot.Helpers;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static Connection connectionInstance;

    private DataBaseConnection(){}

    static {
        String userName = "root";
        String password = "prkadmin69";
        String url = "jdbc:mysql://localhost:3306/AcademicBot";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectionInstance = DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getDataBaseConnection() {
        return connectionInstance;
    }
}
