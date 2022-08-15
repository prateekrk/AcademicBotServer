package com.academicbot.dao.UserDao;

import com.academicbot.pojo.Designation;
import com.academicbot.pojo.User;

import java.sql.SQLException;

public interface UserDao {

    User getUser(String userName) throws SQLException;
    boolean resetPassword(String password, String userName) throws  SQLException;
    boolean createUser(String userName, String password, Designation designation) throws SQLException;
    boolean removeUser(String userName) throws  SQLException;
}
