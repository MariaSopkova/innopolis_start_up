package ru.innopolis.stc12.services;

import ru.innopolis.stc12.pojo.User;

/**
 * Service class for {@link User}
 */
public interface UserService {
    int save(User user);

    User getUserByName(String name);
}
