package com.academicbot.dao.academicOperationsDao.studentOperations.marks;

import com.academicbot.Helpers.DataBaseConnection;
import com.academicbot.Helpers.Tables;
import com.academicbot.pojo.MarksModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMarksDaoImpl implements  StudentMarksDao{

    private final Connection databaseConnection = DataBaseConnection.getDataBaseConnection();

    @Override
    public List<MarksModel> fetchMarks(String usn) throws SQLException {
        String query = String.format("SELECT * FROM %s WHERE USN = ?, COURSE_ID = ?", Tables.MARKS.getName());

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, usn);
        return getMarksModel(preparedStatement);
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
    public MarksModel fetchMarksByCourseID(String usn, String courseID) throws SQLException {
        String query = String.format("SELECT * FROM %s WHERE USN = ?, COURSE_ID = ?", Tables.MARKS.getName());

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, usn);
        preparedStatement.setString(2, courseID);
        return getMarksModel(preparedStatement).get(0);
    }

    public static List<MarksModel> getMarksModel(PreparedStatement preparedStatement) throws SQLException {
        return getMarksModels(preparedStatement);
    }
}
