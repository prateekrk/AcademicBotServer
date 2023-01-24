package com.academicbot.service.academicOperationsService.facultyOperationService.marks;

import com.academicbot.pojo.MarksModel;

import java.sql.SQLException;
import java.util.List;

public interface FacultyMarksService {
    boolean uploadMarks(MarksModel marksModel, String markedBy) throws SQLException;
    List<MarksModel> fetchMarks(String usn) throws SQLException;
    MarksModel fetchMarks(String usn, String courseId) throws  SQLException;
    boolean updateMarks(MarksModel newMarksModel, String markedBy) throws  SQLException;
}
