package service;

import dao.DoctorDAO;
import entity.Doctor;

import java.util.List;

public class DoctorService {

    private final DoctorDAO doctorDAO;

    public DoctorService() {
        this.doctorDAO = new DoctorDAO();
    }

    public void addDoctor(Doctor doctor) {
        doctorDAO.save(doctor);
    }

    public void updateDoctor(Doctor doctor) {
        doctorDAO.update(doctor);
    }

    public void deleteDoctor(Long doctorId) {
        doctorDAO.delete(doctorId);
    }

    public Doctor getDoctorById(Long doctorId) {
        return doctorDAO.findById(doctorId);
    }
    public Doctor findByLogin(String login) {
        return doctorDAO.findByLogin(login);
    }
    public List<Doctor> getAllDoctors() {
        return doctorDAO.findAll();
    }
}
