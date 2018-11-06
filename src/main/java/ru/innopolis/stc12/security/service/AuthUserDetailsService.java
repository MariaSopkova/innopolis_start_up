package ru.innopolis.stc12.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.model.WebUserDetails;

public class AuthUserDetailsService implements UserDetailsService {
  private UserDao userDao;

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userDao.getUser(username);
    if (user == null) {
      throw new UsernameNotFoundException("User with username [" + username + "] not found");
    }
    return new WebUserDetails(user, userDao.getAuthorities(username));
  }
}
