package ru.innopolis.stc12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.innopolis.stc12.dao.UserDaoImpl;
import ru.innopolis.stc12.pojo.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-config.xml" );
        UserDaoImpl userDaoImpl = (UserDaoImpl) context.getBean("UserDao" );

        ArrayList<User> users = (ArrayList<User>) userDaoImpl.listUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
