package com.academicbot.dao.UserDao;

import com.academicbot.Helpers.DataBaseConnection;
import com.academicbot.Helpers.Exceptions.LoginError;
import com.academicbot.pojo.Designation;
import com.academicbot.pojo.User;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

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
    public boolean createUser(String userName, String password, Designation designation) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        String query = "INSERT INTO USER VALUES(?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, designation.getValue());
        String[] encryption = createHashWithSalt(password);
        preparedStatement.setString(3, encryption[0]);
        preparedStatement.setString(4, encryption[1]);
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

    @Override
    public boolean login(String userName, String password) throws SQLException, LoginError, NoSuchAlgorithmException, InvalidKeySpecException {
        String query = "SELECT * FROM USER WHERE USERNAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        String[] credentials = new String[2];
        while(resultSet.next()) {
            credentials[0] = resultSet.getString("SALT");
             credentials[1] = resultSet.getString("HASHED_VALUE");
        }
        matchHashValue(password, credentials);
        return true;
    }

    private String[] createHashWithSalt(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return getCredentials(password, salt);
    }

    private String[] getCredentials(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        String saltString = Base64.getEncoder().encodeToString(salt);
        String hashString = Base64.getEncoder().encodeToString(hash);
        return new String[] {saltString, hashString};
    }

    private String[] createHashWithSalt(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[15];
        random.nextBytes(salt);

        return getCredentials(password, salt);
    }

    private void matchHashValue(String password, String[] credentials)  throws NoSuchAlgorithmException, InvalidKeySpecException, LoginError{
        byte[] salt = Base64.getDecoder().decode(credentials[0]);
        String obtainedHash = createHashWithSalt(password, salt)[1];
        if (!obtainedHash.contentEquals(credentials[1])) {
            throw new LoginError();
        }
    }
}
