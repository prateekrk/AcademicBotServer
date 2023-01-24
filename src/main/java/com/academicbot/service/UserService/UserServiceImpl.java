package com.academicbot.service.UserService;

import com.academicbot.Helpers.ApplicationContext;
import com.academicbot.Helpers.Exceptions.LoginError;
import com.academicbot.dao.UserDao.UserDao;
import com.academicbot.pojo.Designation;
import com.academicbot.pojo.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = (UserDao) ApplicationContext.getContext().getBean("userDao");
    @Override
    public User getUser(String userName) throws SQLException {
        return userDao.getUser(userName);
    }

    @Override
    public boolean resetPassword(String password, String userName) throws SQLException {
        return userDao.resetPassword(password, userName);
    }

    @Override
    public boolean createUser(String userName, String password, Designation designation) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        return userDao.createUser(userName, password, designation);
    }

    @Override
    public boolean removeUser(String userName) throws SQLException {
        return userDao.removeUser(userName);
    }

    @Override
    public boolean login(String userName, String password) throws SQLException, LoginError, NoSuchAlgorithmException, InvalidKeySpecException {
        return userDao.login(userName, password);
    }
}
