package commands;

import entity.Doctor;
import service.DoctorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAddDoctorAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // Simulate request parameters
        String firstName = "John";
        String secondName = "Doe";
        String specialization = "Cardiologist";
        String login = "johndoe";
        String password = "password123";
        String appointmentPriceStr = "100.0";

        // Convert appointmentPriceStr to double
        double appointmentPrice = Double.parseDouble(appointmentPriceStr);

        // Create a new Doctor object
        Doctor doctor = new Doctor();
        doctor.setFirstName(firstName);
        doctor.setSecondName(secondName);
        doctor.setSpecialization(specialization);
        doctor.setLogin(login);
        doctor.setPassword(password);
        doctor.setAppointmentPrice(appointmentPrice);

        // Create a DoctorService instance
        DoctorService doctorService = new DoctorService();

        // Add the doctor
        doctorService.addDoctor(doctor);

        // Get the added doctor
        Doctor addedDoctor = doctorService.findByLogin(login);

        // Verify that the added doctor is not null and has the correct data
        assert addedDoctor != null;
        assert addedDoctor.getFirstName().equals(firstName);
        assert addedDoctor.getSecondName().equals(secondName);
        assert addedDoctor.getSpecialization().equals(specialization);
        assert addedDoctor.getAppointmentPrice() == appointmentPrice;
        assert addedDoctor.getLogin().equals(login);
        assert addedDoctor.getPassword().equals(password);

        // Print success message
        System.out.println("Doctor added successfully!");

        // Return null, as there is no redirect URL
        return null;
    }
}
