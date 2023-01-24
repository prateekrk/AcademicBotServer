package com.academicbot.dao.academicOperationsDao.studentOperations.attendance;

import com.academicbot.pojo.AttendanceModel;

import java.sql.SQLException;
import java.util.List;

public interface StudentAttendanceDao {
    AttendanceModel fetchAttendance(String usn, String courseID) throws SQLException;
    List<AttendanceModel> fetchAttendance(String usn) throws  SQLException;

}
