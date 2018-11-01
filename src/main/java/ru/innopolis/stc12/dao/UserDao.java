package ru.innopolis.stc12.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.stc12.pojo.User;

public interface UserDao extends JpaRepository<User, Integer> {
    public User getUserByName();

    public User getUserBySurname();

    public User getUserById();

    public boolean update(User user);

    public boolean deleteUserById();

    public boolean deleteUserByName();

    public boolean addUser(User user);
}
