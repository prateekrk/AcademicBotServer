package com.academicbot.dao.academicOperationsDao.studentOperations.attendance;

import java.sql.SQLException;

public interface StudentAttendanceDao {
    boolean fetchAttendance(String usn, String courseID) throws SQLException;

}
