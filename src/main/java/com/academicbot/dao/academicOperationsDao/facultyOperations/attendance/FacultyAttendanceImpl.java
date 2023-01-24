package com.academicbot.dao.academicOperationsDao.facultyOperations.attendance;

import com.academicbot.Helpers.DataBaseConnection;
import com.academicbot.pojo.AttendanceModel;

import java.sql.Connection;
import java.sql.SQLException;

public class FacultyAttendanceImpl implements FacultyAttendanceDao{

    private Connection dataBaseConnection = DataBaseConnection.getDataBaseConnection();

    @Override
    public boolean markAttendance(AttendanceModel attendance, String usn) throws SQLException {
        return false;
    }

    @Override
    public boolean updateAttendance(AttendanceModel newAttendance, String usn) throws SQLException {
        return false;
    }

    @Override
    public boolean fetchAttendanceByUSN(String usn, String courseID) throws SQLException {
        return false;
    }
}
