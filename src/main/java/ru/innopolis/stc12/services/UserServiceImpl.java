package ru.innopolis.stc12.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.pojo.User;

/**
 * Implementation for UserService {@link UserService}
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return 0;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }
}
