package com.academicbot.dao.UserDao;

import com.academicbot.Helpers.DataBaseConnection;
import com.academicbot.pojo.Designation;
import com.academicbot.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private Connection connection = DataBaseConnection.getDataBaseConnection();
    @Override
    public User getUser(String userName) throws SQLException {
        String query = " select * from User where userName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userName);
        ResultSet result = preparedStatement.executeQuery();
        User user = new User();
        while(result.next()) {
            Designation designation = Designation.valueOf(result.getString("designation"));
            user.setUserName(result.getString("userName"));
            user.setDesignation(designation);
        }
        return user;
    }

    @Override
    public boolean resetPassword(String password, String userName) throws SQLException {
        String query = "Update User set password = ? where userName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, userName);
        int result = preparedStatement.executeUpdate();

        return result != 0;
    }

    @Override
    public boolean createUser(String userName, String password, Designation designation) throws SQLException {
        String query = "INSERT INTO USER VALUES(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, designation.getValue());
        preparedStatement.executeUpdate(query);
        int result = preparedStatement.executeUpdate();
        return result != 0;
    }

    @Override
    public boolean removeUser(String userName) throws SQLException {
        String query = "DELETE FROM USER WHERE USERNAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int result = preparedStatement.executeUpdate(query);
        return result != 0;
    }
}
