package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String secondName;
    private String email;
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // Default constructor

    // Constructor with all fields
    public Patient(Long id, String firstName, String secondName, String email, String phone, User user) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phone = phone;
        this.user = user;
    }

    // Getters and setters
    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getfirstname() {
        return firstName;
    }

    public void setfirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getsecondname() {
        return secondName;
    }

    public void setsecondname(String secondName) {
        this.secondName = secondName;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

    