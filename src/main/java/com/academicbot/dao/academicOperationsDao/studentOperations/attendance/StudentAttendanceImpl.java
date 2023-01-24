package com.academicbot.dao.academicOperationsDao.studentOperations.attendance;

import com.academicbot.Helpers.DataBaseConnection;
import com.academicbot.pojo.AttendanceModel;
import com.academicbot.pojo.MarksModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceImpl implements StudentAttendanceDao{
    private final Connection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
    @Override
    public AttendanceModel fetchAttendance(String usn, String courseID) throws SQLException {
        String query = "SELECT * FROM ATTENDANCE WHERE USN = ?, COURSE_ID = ?";
        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
        preparedStatement.setString(1, usn);
        preparedStatement.setString(2, courseID);
        return getAttendance(preparedStatement).get(0);
    }

    private List<AttendanceModel> getAttendance(PreparedStatement preparedStatement) throws  SQLException {
        ResultSet set = preparedStatement.executeQuery();
        List<AttendanceModel> attendanceList = new ArrayList<>();
        while(set.next()) {
            AttendanceModel attendanceModel = new AttendanceModel();
            attendanceModel.setTotalClassConducted(set.getInt("TOTAL_CLASSES_CONDUCTED"));
            attendanceModel.setTotalClassPresent(set.getInt("TOTAL_CLASS_ATTENDED"));
            attendanceModel.setCourseID(set.getString("COURSE_ID"));
            attendanceList.add(attendanceModel);
        }
        return attendanceList;
    }

    @Override
    public List<AttendanceModel> fetchAttendance(String usn) throws SQLException {
        String query = "SELECT * FROM ATTENDANCE WHERE USN = ?";
        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
        preparedStatement.setString(1, usn);
        return getAttendance(preparedStatement);
    }
}
