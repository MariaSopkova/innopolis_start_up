package ru.innopolis.stc12.dao;

import org.springframework.stereotype.Service;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
  @Override public User getUser(String username) {
    return new User();
  }

  @Override public List<String> getAuthorities(String username) {
    ArrayList<String> strings = new ArrayList<>();
    strings.add(Actions.USER_PROFILE_VIEW);
    return strings;
  }
}
