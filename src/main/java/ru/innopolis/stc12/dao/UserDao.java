package ru.innopolis.stc12.dao;

import ru.innopolis.stc12.pojo.User;

import java.util.List;

public interface UserDao {
  User getUser(String username);

  List<String> getAuthorities(String username);
}
