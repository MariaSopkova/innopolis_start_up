package ru.innopolis.stc12.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_authorities")
public class RoleAction implements Serializable {
    private String role;
    private String action;
    @Id
    private int id;

    @Column(name = "authority", length = 1024, insertable = false, updatable = false)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Column(name = "role", length = 128, insertable = false, updatable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
