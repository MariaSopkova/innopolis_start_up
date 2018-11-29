package ru.innopolis.stc12.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role_actions")
public final class Role {
    @Column(name = "role")
    public static final String ROLE_GUEST = "guest";
    public static final String ROLE_SYSTEM = "system";
    public static final String ROLE_SUPERUSER = "admin";
    public static final String ROLE_MODERATOR = "moderator";
    public static final String ROLE_USER = "user";

    private Role() {
        throw new AssertionError();
    }
}
