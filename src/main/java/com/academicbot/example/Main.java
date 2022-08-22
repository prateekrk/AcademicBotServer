package com.academicbot.example;

import com.academicbot.Helpers.Exceptions.LoginError;
import com.academicbot.dao.UserDao.UserDao;
import com.academicbot.pojo.Designation;
import javafx.fxml.LoadException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class Main {
    static AbstractApplicationContext applicationContext;
    public static void main(String[] args) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("AcademicBotConfig.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//        userDao.createUser("prateek.17cs@cmr.edu.in", "prtk33", Designation.STUDENT);
//        userDao.createUser("pratik.17cs@cmr.edu.in", "prtk34", Designation.STUDENT);
//        userDao.createUser("sachin.17cs@cmr.edu.in", "sach42", Designation.STUDENT);
//        userDao.createUser("shreyas.17cs@cmr.edu.in", "shrey48", Designation.STUDENT);
        try {
            userDao.login("prateek.17cs@cmr.edu.in", "prtk33");
        } catch (LoginError e) {
            System.out.println("Login failed");
        }

    }

    public static AbstractApplicationContext getApplicationContext() {
        return applicationContext;
    }
}