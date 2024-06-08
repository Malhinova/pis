package commands;

import services.AppointmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class ScheduleAppointmentAction implements Action {

    private AppointmentService appointmentService;

    public ScheduleAppointmentAction(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long patientId = Long.parseLong(request.getParameter("patientId"));
        Long doctorId = Long.parseLong(request.getParameter("doctorId"));
        LocalDateTime appointmentDate = LocalDateTime.parse(request.getParameter("appointmentDate"));
        String description = request.getParameter("description");

        appointmentService.scheduleAppointment(patientId, doctorId, appointmentDate, description);
        return "/success.jsp";
    }
}
