package com.academicbot.dao.studentDao;

import com.academicbot.Helpers.DataBaseConnection;
import com.academicbot.pojo.AdmissionDetail;
import com.academicbot.pojo.NameModel;
import com.academicbot.pojo.Semester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class StudentDaoImpl implements StudentDao {
    private final Connection connection = DataBaseConnection.getDataBaseConnection();

    @Override
    public boolean addAdmissionDetail(String usn, AdmissionDetail admissionDetail) throws SQLException {
        String query = "INSERT INTO ADMISSION_DETAILS (USN, DATE_OF_ADMISSION, DATE_OF_FINISH) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usn);
        preparedStatement.setDate(2, Date.valueOf(admissionDetail.getDateOfAdmission()));
        preparedStatement.setDate(3, Date.valueOf(admissionDetail.getDateOfFinish()));

        int result = preparedStatement.executeUpdate();
        return result != 0;
    }

    @Override
    public boolean updateNames(String usn, NameModel name) throws SQLException{
        String query = "UPDATE STUDENT SET FIRST_NAME= ?, LAST_NAME = ?, MIDDLE_NAME = ? WHERE USN = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name.getFirstName());
        preparedStatement.setString(2, name.getLastName());
        preparedStatement.setString(3, name.getMiddleName());

        int result = preparedStatement.executeUpdate();

        return result != 0;
    }

    @Override
    public boolean updateRemarks(String usn, String remark) throws SQLException{
        String query = "INSERT INTO REMARKS VALUES (? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usn);
        preparedStatement.setString(2, remark);

        int result = preparedStatement.executeUpdate();

        return result != 0;
    }

    @Override
    public boolean updateDOB(String usn, LocalDate dob) throws SQLException{
        String query = "UPDATE STUDENT SET DATE_OF_BIRTH= ? WHERE USN = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setDate(1, Date.valueOf(dob));
        preparedStatement.setString(2, usn);

        int result = preparedStatement.executeUpdate();

        return result != 0;
    }

    @Override
    public boolean updateSemester(String usn, Semester semester) throws SQLException{
//        String query = "UPDATE STUDENT SET DATE_OF_BIRTH= ? WHERE USN = ?";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setDate(1, Date.valueOf(dob));
//        preparedStatement.setString(2, usn);
//
//        int result = preparedStatement.executeUpdate();

        return false;
    }

    @Override
    public boolean updateUsn(String usn, String newUsn) throws SQLException {
        String query = "UPDATE STUDENT SET USN= ? WHERE USN = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newUsn);
        preparedStatement.setString(2, usn);

        int result = preparedStatement.executeUpdate();

        return result != 0;
    }

}
