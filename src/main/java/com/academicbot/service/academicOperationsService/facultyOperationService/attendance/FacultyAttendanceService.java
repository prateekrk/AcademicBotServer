package com.academicbot.service.academicOperationsService.facultyOperationService.attendance;

import com.academicbot.pojo.AttendanceModel;

import java.sql.SQLException;

public interface FacultyAttendanceService {
    boolean markAttendance(AttendanceModel attendance, String usn, String markedBy) throws SQLException;
    boolean updateAttendance(AttendanceModel newAttendance, String usn, String markedBy) throws SQLException;
    AttendanceModel fetchAttendanceByUSN(String usn, String courseID) throws SQLException;
}
