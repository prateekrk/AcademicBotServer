package com.academicbot.example;

import com.academicbot.Helpers.ApplicationContext;
import com.academicbot.Helpers.Exceptions.LoginError;
import com.academicbot.dao.UserDao.UserDao;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        AbstractApplicationContext applicationContext = ApplicationContext.getContext();
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        try {
            userDao.login("prateek.17cs@cmr.edu.in", "prtk33");
        } catch (LoginError e) {
            System.out.println("Login failed");
        }

    }
}