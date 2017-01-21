package by.ibank.db.dao;

import by.ibank.db.entity.User;

import java.util.Random;

/**
 * Created by Olga on 21.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        for (int i = 0; i < 10; i++) {
            User user = new User(0, "Andrei" + (int)(Math.random() * 100), "Andrei@mail.ru", "12345");
            long userId = userDao.create(user);
            System.out.println(userDao.getById(userId));
        }
        System.out.println(userDao.getAll());
    }
}
