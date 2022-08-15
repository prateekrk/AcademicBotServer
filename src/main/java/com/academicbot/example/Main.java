package com.academicbot.example;

import com.academicbot.dao.UserDao.UserDao;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    static AbstractApplicationContext applicationContext;
    public static void main(String[] args) throws SQLException {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("AcademicBotConfig.xml");
    }

    public static AbstractApplicationContext getApplicationContext() {
        return applicationContext;
    }
}