package com.learnersacademy.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/learnersacademy";
        String username = "root";
        String password = "kHing$!x6";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to the database successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
