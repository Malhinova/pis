package commands;

import entity.MedicalHistory;
import services.MedicalHistoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViewMedicalHistoryAction implements Action {

    private MedicalHistoryService medicalHistoryService;

    public ViewMedicalHistoryAction(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long patientId = Long.parseLong(request.getParameter("patientId"));
        List<MedicalHistory> medicalHistory = medicalHistoryService.getMedicalHistory(patientId);
        request.setAttribute("medicalHistory", medicalHistory);
        return "/view_medical_history.jsp";
    }
}
