package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSqlConnectionExample {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    @BeforeAll
    public static void setUp() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/hospital";
        String username = "postgres";
        String password = "root";

        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    @Test
    public void testDoctorQuery() throws SQLException {
        String sql = "SELECT * FROM doctor";
        resultSet = statement.executeQuery(sql);

        assertNotNull(resultSet, "ResultSet should not be null");

        boolean hasResults = false;
        while (resultSet.next()) {
            hasResults = true;
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("secondName");
            String specialization = resultSet.getString("specialization");
            double appointmentPrice = resultSet.getDouble("appointment_price");

            assertNotNull(firstName, "First name should not be null");
            assertNotNull(lastName, "Last name should not be null");
            assertNotNull(specialization, "Specialization should not be null");
            assertTrue(appointmentPrice > 0, "Appointment price should be greater than 0");

            System.out.println("Doctor: " + id + ", " + firstName + " " + lastName + ", " +
                    specialization + ", " + appointmentPrice);
        }
        
        assertTrue(hasResults, "Query should return at least one result");
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
}

