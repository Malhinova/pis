package commands;

import services.DoctorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteDoctorAction implements Action {

    private DoctorService doctorService;

    public DeleteDoctorAction(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long doctorId = Long.parseLong(request.getParameter("doctorId"));
        doctorService.deleteDoctor(doctorId);
        return "/success.jsp";
    }
}
