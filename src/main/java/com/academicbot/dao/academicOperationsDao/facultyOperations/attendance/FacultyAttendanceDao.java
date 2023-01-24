package com.academicbot.dao.academicOperationsDao.facultyOperations.attendance;

import com.academicbot.pojo.AttendanceModel;

import java.sql.SQLException;

public interface FacultyAttendanceDao {
    boolean markAttendance(AttendanceModel attendance, String usn) throws SQLException;
    boolean updateAttendance(AttendanceModel newAttendance, String usn) throws SQLException;
    boolean fetchAttendanceByUSN(String usn, String courseID) throws SQLException;
}
