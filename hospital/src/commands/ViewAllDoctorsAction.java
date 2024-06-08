package commands;

import entity.Doctor;
import services.DoctorService;



public class ViewAllDoctorsAction implements Action {

    private DoctorService doctorService;

    public ViewAllDoctorsAction(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        request.setAttribute("doctors", doctors);
        return "/view_all_doctors.jsp";
    }
}
