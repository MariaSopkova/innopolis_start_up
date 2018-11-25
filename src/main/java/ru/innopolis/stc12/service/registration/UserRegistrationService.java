package ru.innopolis.stc12.service.registration;

import ru.innopolis.stc12.dto.RegistrationPageDTO;

public interface UserRegistrationService {
    boolean addUser(RegistrationPageDTO pageDTO);

    RegistrationPageDTO createRegistrationPageInfoData(String firstName, String surname, String login, String email, String password, String passwordDouble);

    boolean isFirstNameEmpty(RegistrationPageDTO registrationInfo);

    boolean isSurnameEmpty(RegistrationPageDTO registrationInfo);

    boolean isLoginEmpty(RegistrationPageDTO registrationInfo);

    boolean isEmailEmpty(RegistrationPageDTO registrationInfo);

    boolean isPasswordEmpty(RegistrationPageDTO registrationInfo);

    boolean isPasswordDoubleEmpty(RegistrationPageDTO registrationInfo);

    boolean isPasswordEquals(RegistrationPageDTO registrationInfo);

    boolean isEmailUnique(RegistrationPageDTO registrationInfo);

    boolean isEmailValid(RegistrationPageDTO registrationInfo);

    boolean isLoginUnique(RegistrationPageDTO registrationInfo);
}
