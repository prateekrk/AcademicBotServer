package com.academicbot.dao.academicOperationsDao.facultyOperations.marks;

import com.academicbot.pojo.MarksModel;

import java.sql.SQLException;

public class FacultyMarksImpl implements  FacultyMarksDao{
    @Override
    public boolean uploadMarks(MarksModel marksModel) throws SQLException {
        return false;
    }

    @Override
    public boolean fetchMarks(String usn) throws SQLException {
        return false;
    }

    @Override
    public boolean updateMarks(MarksModel newMarksModel) throws SQLException {
        return false;
    }
}
