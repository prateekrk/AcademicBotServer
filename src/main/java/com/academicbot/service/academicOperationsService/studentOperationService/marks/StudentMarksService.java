package com.academicbot.service.academicOperationsService.studentOperationService.marks;

import com.academicbot.pojo.MarksModel;

import java.sql.SQLException;
import java.util.List;

public interface StudentMarksService {
    MarksModel fetchMarksByCourseID(String usn, String courseID) throws SQLException;
    List<MarksModel> fetchMarks(String usn) throws SQLException;
}
