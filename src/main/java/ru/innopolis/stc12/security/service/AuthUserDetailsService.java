package ru.innopolis.stc12.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.dao.AuthUserDao;
import ru.innopolis.stc12.security.model.WebUserDetails;

@Service
public class AuthUserDetailsService implements UserDetailsService {
    private AuthUserDao userDao;

    @Autowired
    public void setUserDao(AuthUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userDao.getUserByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username [" + username + "] not found");
        }
        return new WebUserDetails(user, userDao.getAuthorities(username));
    }
}
