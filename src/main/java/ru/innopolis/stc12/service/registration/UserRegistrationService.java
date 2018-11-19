package ru.innopolis.stc12.service.registration;

import ru.innopolis.stc12.dto.RegistrationPageDTO;

public interface UserRegistrationService {
    public void setRegistrationPageInfoData(String firstName, String surname, String login, String email, String password, String passwordDouble);

    public boolean isFirstNameEmpty();

    public boolean isSurnameEmpty();

    public boolean isLoginEmpty();

    public boolean isEmailEmpty();

    public boolean isPasswordEmpty();

    public boolean isPasswordDoubleEmpty();

    public boolean isPasswordEquals();

    public boolean isEmailUnique();

    public boolean isEmailValid();

    public boolean isLoginUnique();

    public RegistrationPageDTO getRegistrationInfo();
}
