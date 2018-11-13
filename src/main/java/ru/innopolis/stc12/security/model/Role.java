package ru.innopolis.stc12.security.model;

public final class Role {

    public static final String ROLE_GUEST = "guest";
    public static final String ROLE_SYSTEM = "system";
    public static final String ROLE_SUPERUSER = "admin";
    public static final String ROLE_MODERATOR = "moderator";
    public static final String ROLE_USER = "user";

    private Role() {
        throw new AssertionError();
    }
}
