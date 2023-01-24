package com.academicbot.service.academicOperationsService.studentOperationService.marks;

import com.academicbot.Helpers.ApplicationContext;
import com.academicbot.dao.academicOperationsDao.studentOperations.marks.StudentMarksDao;
import com.academicbot.pojo.MarksModel;

import java.sql.SQLException;
import java.util.List;

public class StudentMarksServiceImpl implements  StudentMarksService {
    private final StudentMarksDao studentMarksDao = (StudentMarksDao) ApplicationContext.getContext().getBean("studentMarksDao");

    @Override
    public MarksModel fetchMarksByCourseID(String usn, String courseID) throws SQLException {
        return studentMarksDao.fetchMarksByCourseID(usn, courseID);
    }

    @Override
    public List<MarksModel> fetchMarks(String usn) throws SQLException {
        return studentMarksDao.fetchMarks(usn);
    }
}
