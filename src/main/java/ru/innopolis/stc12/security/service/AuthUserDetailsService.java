package ru.innopolis.stc12.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.pojo.RoleAction;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.model.WebUserDetails;

import java.util.stream.Collectors;

@Service("userDetails")
public class AuthUserDetailsService implements UserDetailsService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userDao.getUserByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username [" + username + "] not found");
        }
        return new WebUserDetails(
                user,
                user.getRoleActions()
                        .stream()
                        .map(RoleAction::getAction)
                        .collect(Collectors.toList()));
    }
}
