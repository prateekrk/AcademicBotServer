package com.academicbot.dao.academicOperationsDao.studentOperations.marks;

import java.sql.SQLException;

public interface StudentMarksDao {
    boolean fetchMarks(String usn, String courseID) throws SQLException;
}
