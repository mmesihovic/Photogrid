package nwt.tim14.microservices.user.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date birthDate;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private Boolean enabled;

    public User(String firstName, String lastName, Date birthDate, String username, String email, String password, Boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
