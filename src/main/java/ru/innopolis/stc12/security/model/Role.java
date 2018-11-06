package ru.innopolis.stc12.security.model;

public final class Role {

  public static final String ROLE_GUEST = "ROLE_GUEST";
  public static final String ROLE_SYSTEM = "ROLE_SYSTEM";
  public static final String ROLE_SUPERUSER = "ROLE_SUPERUSER";
  public static final String ROLE_MODERATOR = "ROLE_MODERATOR";
  public static final String ROLE_USER = "ROLE_USER";

  private Role() {
    throw new AssertionError();
  }
}
