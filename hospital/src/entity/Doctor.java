package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class is an entity that corresponds to a row in the "doctor" table
 */
public class Doctor implements Serializable {

    private static final long serialVersionUID = -5130013188728843121L;

    private Long id = -1L;
    private String FirstName;
    private String SecondName;
    private String specialization;
    private double appointmentPrice;
    private String login;
    private String password;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return FirstName;
    }
    public String getSecondName() {
        return SecondName;
    }

    public void setFirstName(String name) {
    	this.FirstName= name;
    }
    public void setSecondName(String name) {
    	this.SecondName= name;
    }


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getAppointmentPrice() {
        return appointmentPrice;
    }

    public void setAppointmentPrice(double appointmentPrice) {
        this.appointmentPrice = appointmentPrice;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id.equals(doctor.id) &&
                Double.compare(doctor.appointmentPrice, appointmentPrice) == 0 &&
                Objects.equals(FirstName, doctor.FirstName) &&
                Objects.equals(SecondName, doctor.SecondName) &&
                Objects.equals(specialization, doctor.specialization) &&
                Objects.equals(login, doctor.login) &&
                Objects.equals(password, doctor.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FirstName,SecondName, specialization, appointmentPrice, login, password);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", appointmentPrice=" + appointmentPrice +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
