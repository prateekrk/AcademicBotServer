package com.academicbot.service.academicOperationsService.studentOperationService.attendance;

import com.academicbot.pojo.AttendanceModel;

import java.sql.SQLException;
import java.util.List;

public interface StudentAttendanceService {
    AttendanceModel fetchAttendance(String usn, String courseID) throws SQLException;
    List<AttendanceModel> fetchAttendance(String usn) throws  SQLException;
}
