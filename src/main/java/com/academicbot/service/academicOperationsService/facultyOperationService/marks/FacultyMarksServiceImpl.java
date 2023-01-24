package com.academicbot.service.academicOperationsService.facultyOperationService.marks;

import com.academicbot.Helpers.ApplicationContext;
import com.academicbot.dao.academicOperationsDao.facultyOperations.marks.FacultyMarksDao;
import com.academicbot.pojo.MarksModel;

import java.sql.SQLException;
import java.util.List;

public class FacultyMarksServiceImpl implements FacultyMarksService {
    private final FacultyMarksDao facultyMarksDao = (FacultyMarksDao) ApplicationContext.getContext().getBean("facultyMarksDao");

    @Override
    public boolean uploadMarks(MarksModel marksModel, String markedBy) throws SQLException {
        return facultyMarksDao.uploadMarks(marksModel, markedBy);
    }

    @Override
    public List<MarksModel> fetchMarks(String usn) throws SQLException {
        return facultyMarksDao.fetchMarks(usn);
    }

    @Override
    public MarksModel fetchMarks(String usn, String courseId) throws SQLException {
        return facultyMarksDao.fetchMarks(usn, courseId);
    }

    @Override
    public boolean updateMarks(MarksModel newMarksModel, String markedBy) throws SQLException {
        return facultyMarksDao.updateMarks(newMarksModel, markedBy);
    }
}
