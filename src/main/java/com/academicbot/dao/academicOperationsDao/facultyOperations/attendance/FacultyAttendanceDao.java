package com.academicbot.dao.academicOperationsDao.facultyOperations.attendance;

import com.academicbot.pojo.AttendanceModel;

import java.sql.SQLException;

public interface FacultyAttendanceDao {
    boolean markAttendance(AttendanceModel attendance, String usn, String markedBy) throws SQLException;
    boolean updateAttendance(AttendanceModel newAttendance, String usn, String markedBy) throws SQLException;
    AttendanceModel fetchAttendanceByUSN(String usn, String courseID) throws SQLException;
}
