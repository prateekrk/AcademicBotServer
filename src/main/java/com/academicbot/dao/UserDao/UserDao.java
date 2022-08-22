package com.academicbot.dao.UserDao;

import com.academicbot.Helpers.Exceptions.LoginError;
import com.academicbot.pojo.Designation;
import com.academicbot.pojo.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public interface UserDao {

    User getUser(String userName) throws SQLException;
    boolean resetPassword(String password, String userName) throws  SQLException;
    boolean createUser(String userName, String password, Designation designation) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException;
    boolean removeUser(String userName) throws  SQLException;
    boolean login(String userName, String password) throws  SQLException, LoginError, NoSuchAlgorithmException, InvalidKeySpecException;
}
