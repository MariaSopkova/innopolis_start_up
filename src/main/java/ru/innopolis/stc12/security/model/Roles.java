package ru.innopolis.stc12.security.model;

public final class Roles {
    public static final String ROLE_GUEST = "guest";
    public static final String ROLE_SYSTEM = "system";
    public static final String ROLE_SUPERUSER = "admin";
    public static final String ROLE_MODERATOR = "moderator";
    public static final String ROLE_USER = "user";

    private Roles() {
        throw new AssertionError();
    }
}
