package ru.innopolis.stc12.service.registration;

import ru.innopolis.stc12.dto.RegistrationPageDTO;
import ru.innopolis.stc12.pojo.User;

public class RegistrationUserDtoAdapter {
     static public User convertUserDtpToUserPojo(RegistrationPageDTO pageDTO){
         User user = new User();
         user.setName(pageDTO.getFirstName());
         user.setFamilyName(pageDTO.getSurname());
         user.setEmail(pageDTO.getEmail());
         user.setLogin(pageDTO.getLogin());
         user.setPassword(pageDTO.getPassword());
         user.setEnabled(true);
         return user;
     }
}
