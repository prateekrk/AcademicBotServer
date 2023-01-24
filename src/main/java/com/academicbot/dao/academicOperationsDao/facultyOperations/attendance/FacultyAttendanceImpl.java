package com.academicbot.dao.academicOperationsDao.facultyOperations.attendance;

import com.academicbot.Helpers.DataBaseConnection;
import com.academicbot.pojo.AttendanceModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyAttendanceImpl implements FacultyAttendanceDao{

    private Connection dataBaseConnection = DataBaseConnection.getDataBaseConnection();

    @Override
    public boolean markAttendance(AttendanceModel attendance, String usn, String markedBy) throws SQLException {
        String query = "INSERT INTO ATTENDANCE(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
        preparedStatement.setString(1, usn);
        preparedStatement.setString(2, attendance.getCourseID());
        preparedStatement.setInt(3, attendance.getTotalClassPresent());
        preparedStatement.setInt(4, attendance.getTotalClassConducted());
        preparedStatement.setString(5, markedBy);

        int result = preparedStatement.executeUpdate();
        return result != 0;
    }

    @Override
    public boolean updateAttendance(AttendanceModel newAttendance, String usn,  String markedBy) throws SQLException {
        String query = "UPDATE ATTENDANCE set COURSE_ID = ?, TOTAL_CLASSES_CONDUCTED = ?, TOTAL_CLASS_ATTENDED = ?, MARKED_BY = ? WHERE USN = ?";
        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
        preparedStatement.setString(1, newAttendance.getCourseID());
        preparedStatement.setInt(2, newAttendance.getTotalClassConducted());
        preparedStatement.setInt(3, newAttendance.getTotalClassPresent());
        preparedStatement.setString(4, markedBy);

        int result = preparedStatement.executeUpdate();
        return result != 0;
    }

    @Override
    public AttendanceModel fetchAttendanceByUSN(String usn, String courseID) throws SQLException {
        String query = "SELECT * FROM ATTENDANCE WHERE USN = ?, COURSE_ID = ?";
        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(query);
        preparedStatement.setString(1, usn);
        preparedStatement.setString(2, courseID);

        AttendanceModel attendanceModel = new AttendanceModel();
        ResultSet result = preparedStatement.executeQuery();
        while(result.next()) {
            attendanceModel.setCourseID(result.getString(2));
            attendanceModel.setTotalClassPresent(result.getInt(3));
            attendanceModel.setTotalClassConducted(result.getInt(4));
        }

        return attendanceModel;
    }
}
