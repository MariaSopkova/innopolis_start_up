package ru.innopolis.stc12.dao;

import org.springframework.stereotype.Service;
import ru.innopolis.stc12.dto.RegistrationPageDTO;

@Service
public interface RegistrationUserDao {
    public boolean addUser(RegistrationPageDTO pageDTO);
}
