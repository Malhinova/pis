package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * This class is an entity that corresponds to a row in the "medical_history" table
 */
public class MedicalHistory implements Serializable {

    private static final long serialVersionUID = -4130013188728843121L;

    private Long id = -1L;
    private Long patientId;
    private Long doctorId;
    private String diseaseDescription;
    private Date dateDiagnosed;

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

    public String getDiseaseDescription() {
        return diseaseDescription;
    }

    public void setDiseaseDescription(String diseaseDescription) {
        this.diseaseDescription = diseaseDescription;
    }

    public Date getDateDiagnosed() {
        return dateDiagnosed;
    }

    public void setDateDiagnosed(Date dateDiagnosed) {
        this.dateDiagnosed = dateDiagnosed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalHistory that = (MedicalHistory) o;
        return id.equals(that.id) &&
                Objects.equals(patientId, that.patientId) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(diseaseDescription, that.diseaseDescription) &&
                Objects.equals(dateDiagnosed, that.dateDiagnosed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, doctorId, diseaseDescription, dateDiagnosed);
    }

    @Override
    public String toString() {
        return "MedicalHistory{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", diseaseDescription='" + diseaseDescription + '\'' +
                ", dateDiagnosed=" + dateDiagnosed +
                '}';
    }
}
