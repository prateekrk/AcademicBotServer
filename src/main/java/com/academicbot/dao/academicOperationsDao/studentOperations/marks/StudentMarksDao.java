package com.academicbot.dao.academicOperationsDao.studentOperations.marks;

import com.academicbot.pojo.MarksModel;

import java.sql.SQLException;
import java.util.List;

public interface StudentMarksDao {
    MarksModel fetchMarksByCourseID(String usn, String courseID) throws SQLException;
    List<MarksModel> fetchMarks(String usn) throws SQLException;

}
