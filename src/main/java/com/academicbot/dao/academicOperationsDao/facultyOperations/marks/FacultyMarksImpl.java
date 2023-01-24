package com.academicbot.dao.academicOperationsDao.facultyOperations.marks;

import com.academicbot.Helpers.DataBaseConnection;
import com.academicbot.Helpers.Tables;
import com.academicbot.pojo.MarksModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyMarksImpl implements  FacultyMarksDao{
   private final Connection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
    @Override
    public boolean uploadMarks(MarksModel marksModel, String markedBy) throws SQLException {
        String query = "INSERT INTO MARKS (? , ?, ?, ?, ?)";
        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
        preparedStatement.setString(1, marksModel.getCourseId());
        preparedStatement.setDouble(2, marksModel.getMarks());
        preparedStatement.setDouble(3, marksModel.getTotalMarks());
        preparedStatement.setString(4, marksModel.getUsn());
        preparedStatement.setString(5, markedBy);

        int result = preparedStatement.executeUpdate();

        return result != 0;
    }

    @Override
    public MarksModel fetchMarks(String usn) throws SQLException {
        String query = String.format("SELECT * FROM %s WHERE USN = ?", Tables.MARKS.getName());

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        MarksModel marksModel = new MarksModel();
        while(resultSet.next()) {
            marksModel.setUsn(resultSet.getString("USN"));
            marksModel.setCourseId(resultSet.getString("COURSE_ID"));
            marksModel.setMarks(resultSet.getDouble("MARKS"));
            marksModel.setTotalMarks(resultSet.getDouble("TOTAL_MARKS"));
        }
        return marksModel;
    }

    @Override
    public boolean updateMarks(MarksModel newMarksModel, String markedBy) throws SQLException {
        String query = String.format("UPDATE %s COURSE_ID = ?, TOTAL_MARKS = ?, GRADE = ?, MARKS = ?, MARKED_BY = ?", Tables.MARKS.getName());

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
        preparedStatement.setString(1, newMarksModel.getCourseId());
        preparedStatement.setDouble(2, newMarksModel.getTotalMarks());
        preparedStatement.setString(3, newMarksModel.getGrade());
        preparedStatement.setDouble(4, newMarksModel.getMarks());
        preparedStatement.setString(5, markedBy);

        return preparedStatement.executeUpdate() != 0;
    }
}
