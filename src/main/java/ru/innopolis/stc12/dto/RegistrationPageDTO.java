package ru.innopolis.stc12.dto;

public class RegistrationPageDTO {
    private String firstName;
    private String surname;
    private String login;
    private String email;
    private String password;
    private String passwordDouble;

    public RegistrationPageDTO(String firstName, String surname, String login, String email, String password, String passwordDouble) {
        this.firstName = firstName;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.password = password;
        this.passwordDouble = passwordDouble;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getPasswordDouble() {
        return passwordDouble;
    }

    public void setPasswordDouble(String passwordDouble) {
        this.passwordDouble = passwordDouble;
    }
}
