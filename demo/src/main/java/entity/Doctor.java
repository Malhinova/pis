package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String secondName;
    private String specialization;
    private Double appointmentPrice;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public Doctor() {}

    public Doctor(Long id, String firstName, String secondName, String specialization, Double appointmentPrice, User user) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.specialization = specialization;
        this.appointmentPrice = appointmentPrice;
        this.user = user;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Double getAppointmentPrice() {
        return appointmentPrice;
    }

    public void setAppointmentPrice(Double appointmentPrice) {
        this.appointmentPrice = appointmentPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
