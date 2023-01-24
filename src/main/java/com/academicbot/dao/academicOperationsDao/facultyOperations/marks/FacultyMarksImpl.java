package com.academicbot.dao.academicOperationsDao.facultyOperations.marks;

import com.academicbot.Helpers.DataBaseConnection;
import com.academicbot.Helpers.Tables;
import com.academicbot.pojo.MarksModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<MarksModel> fetchMarks(String usn) throws SQLException {
        String query = String.format("SELECT * FROM %s WHERE USN = ?", Tables.MARKS.getName());

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
        return getMarksModels(preparedStatement);
    }

    private static List<MarksModel> getMarksModels(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        List<MarksModel> marksModelList = new ArrayList<>();
        while(resultSet.next()) {
            MarksModel marksModel = new MarksModel();
            marksModel.setUsn(resultSet.getString("USN"));
            marksModel.setCourseId(resultSet.getString("COURSE_ID"));
            marksModel.setMarks(resultSet.getDouble("MARKS"));
            marksModel.setTotalMarks(resultSet.getDouble("TOTAL_MARKS"));
            marksModelList.add(marksModel);
        }
        return marksModelList;
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

    @Override
    public MarksModel fetchMarks(String usn, String courseId) throws SQLException {
        String query = String.format("SELECT * FROM %s WHERE USN = ?, COURSE_ID = ?", Tables.MARKS.getName());

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
        preparedStatement.setString(1, usn);
        preparedStatement.setString(2, courseId);
       return getMarksModels(preparedStatement).get(0);
    }
}
