package com.academicbot.dao.RegisterDao;

import com.academicbot.Helpers.DataBaseConnection;
import com.academicbot.dao.UserDao.UserDao;
import com.academicbot.dao.UserDao.UserDaoImpl;
import com.academicbot.example.Main;
import com.academicbot.pojo.Designation;
import com.academicbot.pojo.Faculty;
import com.academicbot.pojo.Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDaoImpl implements RegisterDao{

    private final Connection connection = DataBaseConnection.getDataBaseConnection();
    private final UserDao userDao = (UserDao) Main.getApplicationContext().getBean("userDao");

    @Override
    public boolean registerStudent(Student student, String userName, String password) throws SQLException {
        String query = "INSERT INTO STUDENT(USERNAME, USN, DATE_OF_BIRTH, FIRST_NAME, LAST_NAME, MIDDLE_NAME) VALUES(?, ? ,?, ?, ?, ?, ?)";

        userDao.createUser(userName, password, Designation.STUDENT);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, student.getUserName());
        preparedStatement.setString(2, student.getUsn());
        preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
        preparedStatement.setString(4, student.getName().getFirstName());
        preparedStatement.setString(5, student.getName().getLastName());
        preparedStatement.setString(6, student.getName().getLastName());

        int  result = preparedStatement.executeUpdate();
        return result != 0;
    }

    @Override
    public boolean registerFaculty(Faculty faculty, String userName, String password) throws SQLException{
        String query = "INSERT INTO FACULTY(USERNAME, FACULTY_NAME, FACUTLY_ID, DATE_OF_JOINING, DATE_OF_RELEASE, DEPARTMENT) " +
                "VALUES( ?, ?, ?, ?, ?, ?,)";

        userDao.createUser(userName, password, faculty.getDesignation());

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, faculty.getUserName());
        preparedStatement.setString(2, faculty.getFacultyName());
        preparedStatement.setString(3, faculty.getIdNumber());
        preparedStatement.setDate(4, Date.valueOf(faculty.getDateOfJoining()));
        preparedStatement.setDate(5, Date.valueOf(faculty.getDateOfRelease()));
        preparedStatement.setString(6, faculty.getDepartmentNames().getDepartmentName());

        int result  = preparedStatement.executeUpdate();
        return result != 0;
    }

    @Override
    public boolean removeUserByUserName(String userName) throws SQLException {
        String query = "DELETE FROM STUDENT WHERE USERNAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userName);
        int result = preparedStatement.executeUpdate();
        return result != 0;
    }

    @Override
    public boolean removeFacultyByID(String id) throws SQLException {
        String query = "DELETE FROM FACULTY WHERE userName = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);

        int result = preparedStatement.executeUpdate();
        return result != 0;
    }

    @Override
    public boolean removeUserByUSN(String usn) throws SQLException {
        String query = "DELETE FROM STUDENT WHERE USN = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usn);

        int result = preparedStatement.executeUpdate();
        return result != 0;
    }
}
