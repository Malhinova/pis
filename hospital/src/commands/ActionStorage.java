package commands;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.DoctorService;

public class ActionStorage {
    private static final ActionStorage instance = new ActionStorage();
    private Map<String, Action> actions = new HashMap<>();
    private DoctorService doctorService;

    private ActionStorage() {
        // Initialize DoctorService
        doctorService = new DoctorService();

        // Add your actions here
        actions.put("/addDoctor", new AddDoctorAction());
        actions.put("/updateDoctor", new UpdateDoctorAction(doctorService));
        actions.put("/deleteDoctor", new DeleteDoctorAction());
        actions.put("/viewDoctor", new ViewDoctorAction(doctorService));
    }

    public static ActionStorage getInstance() {
        return instance;
    }

    public Action getAction(HttpServletRequest request) {
        String actionName = request.getServletPath();
        return actions.get(actionName);
    }
}
