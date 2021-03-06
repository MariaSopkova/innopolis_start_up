package ru.innopolis.stc12.dao;

import org.springframework.security.access.annotation.Secured;
import ru.innopolis.stc12.pojo.Pet;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);

    User getUserByFamilyname(String familyName);

    User getUserById(int id);

    boolean deleteUserById(int id);

    boolean deleteUserByName(String name);

    boolean createUser(User user);

    @Secured(Actions.USER_LIST_VIEW)
    List<User> getUsersList();

    User getUserByLogin(String login);

    User getUserByEmail(String email);

    boolean updateUser(User user);
}
