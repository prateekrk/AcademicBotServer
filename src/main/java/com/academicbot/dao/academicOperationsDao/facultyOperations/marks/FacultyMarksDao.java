package com.academicbot.dao.academicOperationsDao.facultyOperations.marks;

import com.academicbot.pojo.MarksModel;

import java.sql.SQLException;

public interface FacultyMarksDao {
    boolean uploadMarks(MarksModel marksModel, String markedBy) throws SQLException;
    MarksModel fetchMarks(String usn) throws SQLException;
    boolean updateMarks(MarksModel newMarksModel, String markedBy) throws  SQLException;

}
