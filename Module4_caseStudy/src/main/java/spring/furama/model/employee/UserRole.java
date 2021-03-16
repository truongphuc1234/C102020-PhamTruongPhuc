package spring.furama.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @EmbeddedId
    private UserRoleKey id;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private AppRole role;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private AppUser appUser;

    public UserRoleKey getId() {
        return id;
    }

    public void setId(UserRoleKey id) {
        this.id = id;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    public AppUser getUserAccount() {
        return appUser;
    }

    public void setUserAccount(AppUser appUser) {
        this.appUser = appUser;
    }
}
