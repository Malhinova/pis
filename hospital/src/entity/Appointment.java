package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * This class is an entity that corresponds to a row in the "appointment" table
 */
public class Appointment implements Serializable {

    private static final long serialVersionUID = -6376113176559283121L;

    private Long id = -1L;
    private Long patientId;
    private Long doctorId;
    private Date appointmentDate;
    private String description;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id.equals(that.id) &&
                Objects.equals(patientId, that.patientId) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(appointmentDate, that.appointmentDate) &&
                Objects.equals(description, that.description) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, doctorId, appointmentDate, description, status);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", appointmentDate=" + appointmentDate +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
