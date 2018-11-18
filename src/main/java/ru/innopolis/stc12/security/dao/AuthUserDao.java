package ru.innopolis.stc12.security.dao;

import ru.innopolis.stc12.pojo.User;

import java.util.List;

public interface AuthUserDao {

    User getUserByLogin(String login);

    List<String> getAuthorities(String login);
}
