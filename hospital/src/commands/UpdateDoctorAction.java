package commands;

import entity.Doctor;
import service.DoctorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateDoctorAction implements Action {

    private DoctorService doctorService;

    public UpdateDoctorAction(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long doctorId = Long.parseLong(request.getParameter("doctorId"));
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String specialization = request.getParameter("specialization");
        Double appointmentPrice = Double.parseDouble(request.getParameter("appointmentPrice"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Doctor doctor = new Doctor(doctorId, firstName, secondName, specialization, appointmentPrice, login, password);
        doctorService.updateDoctor(doctor);

        return "/success.jsp";
    }
}
