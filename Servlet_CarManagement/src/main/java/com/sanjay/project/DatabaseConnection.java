package com.sanjay.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/servletproject_carmanagement";
    private static final String USER = "root";
    private static final String PASSWORD = "Sanjay@123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insertTestData() {
        String testUsername = "testUser";
        String testPassword = "testPassword";
        String testEmail = "test@example.com";
        String testName = "Test User";
        String testRole = "user";

        String insertTestUserSQL = "INSERT INTO User (username, password, email, name, role) VALUES ('" +
                testUsername + "', '" + testPassword + "', '" + testEmail + "', '" + testName + "', '" + testRole + "')";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(insertTestUserSQL);
            System.out.println("Test data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to insert test data.");
        }
    }
}
