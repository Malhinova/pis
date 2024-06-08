package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Doctor;
import service.DoctorService;

public class AddDoctorAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String specialization = request.getParameter("specialization");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String appointmentPriceStr = request.getParameter("appointmentPrice");

        double appointmentPrice = Double.parseDouble(appointmentPriceStr);

        Doctor doctor = new Doctor();
        doctor.setFirstName(firstName);
        doctor.setSecondName(secondName);
        doctor.setSpecialization(specialization);
        doctor.setLogin(login);
        doctor.setPassword(password);
        doctor.setAppointmentPrice(appointmentPrice);

        DoctorService doctorService = new DoctorService();
        doctorService.addDoctor(doctor);

        return "/doctorList.jsp"; // redirect to doctor list page after adding
    }
}
