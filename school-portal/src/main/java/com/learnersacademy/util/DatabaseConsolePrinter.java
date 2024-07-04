package com.learnersacademy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConsolePrinter {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/learnersacademy";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "kHing$!x6";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {

            printTableData(statement, "students");
            printTableData(statement, "teachers");
            printTableData(statement, "classes");
            printTableData(statement, "subjects");
            printTableData(statement, "class_subject");
            printTableData(statement, "teacher_class");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printTableData(Statement statement, String tableName) throws Exception {
        System.out.println("Data from table: " + tableName);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
