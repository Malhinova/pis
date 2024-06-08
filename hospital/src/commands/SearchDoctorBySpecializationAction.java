package hospital.commands;

import entity.Doctor;
import services.DoctorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SearchDoctorBySpecializationAction implements Action {

    private DoctorService doctorService;

    public SearchDoctorBySpecializationAction(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String specialization = request.getParameter("specialization");
        List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
        request.setAttribute("doctors", doctors);
        return "/search_results.jsp";
    }
}
