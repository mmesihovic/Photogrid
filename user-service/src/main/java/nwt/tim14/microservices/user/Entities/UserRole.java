package nwt.tim14.microservices.user.Entities;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column
    private Long userID;
    @Column
    private Long roleID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public UserRole(Long userID, Long roleID) {
        this.userID = userID;
        this.roleID = roleID;
    }
}
