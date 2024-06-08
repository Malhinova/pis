package dao;

import entity.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void save(Doctor doctor) {
        String sql = "INSERT INTO doctor (firstName, secondName, specialization, appointment_price, login, password) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, doctor.getFirstName());
            stmt.setString(2, doctor.getSecondName());
            stmt.setString(3, doctor.getSpecialization());
            stmt.setDouble(4, doctor.getAppointmentPrice());
            stmt.setString(5, doctor.getLogin());
            stmt.setString(6, doctor.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Doctor doctor) {
        String sql = "UPDATE doctor SET firstName = ?, secondName = ?, specialization = ?, appointment_price = ?, login = ?, password = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, doctor.getFirstName());
            stmt.setString(2, doctor.getSecondName());
            stmt.setString(3, doctor.getSpecialization());
            stmt.setDouble(4, doctor.getAppointmentPrice());
            stmt.setString(5, doctor.getLogin());
            stmt.setString(6, doctor.getPassword());
            stmt.setLong(7, doctor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long doctorId) {
        String sql = "DELETE FROM doctor WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, doctorId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Doctor findById(Long doctorId) {
        String sql = "SELECT * FROM doctor WHERE id = ?";
        Doctor doctor = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, doctorId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getLong("id"));
                doctor.setFirstName(rs.getString("firstName"));
                doctor.setSecondName(rs.getString("secondName"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setAppointmentPrice(rs.getDouble("appointment_price"));
                doctor.setLogin(rs.getString("login"));
                doctor.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctor;
    }

    public Doctor findByLogin(String login) {
        String sql = "SELECT * FROM doctor WHERE login = ?";
        Doctor doctor = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getLong("id"));
                doctor.setFirstName(rs.getString("firstName"));
                doctor.setSecondName(rs.getString("secondName"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setAppointmentPrice(rs.getDouble("appointment_price"));
                doctor.setLogin(rs.getString("login"));
                doctor.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctor;
    }

    public List<Doctor> findAll() {
        String sql = "SELECT * FROM doctor";
        List<Doctor> doctors = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getLong("id"));
                doctor.setFirstName(rs.getString("firstName"));
                doctor.setSecondName(rs.getString("secondName"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setAppointmentPrice(rs.getDouble("appointment_price"));
                doctor.setLogin(rs.getString("login"));
                doctor.setPassword(rs.getString("password"));
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }
}
