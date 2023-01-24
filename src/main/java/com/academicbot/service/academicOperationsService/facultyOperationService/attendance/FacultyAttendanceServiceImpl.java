package com.academicbot.service.academicOperationsService.facultyOperationService.attendance;

import com.academicbot.Helpers.ApplicationContext;
import com.academicbot.dao.academicOperationsDao.facultyOperations.attendance.FacultyAttendanceDao;
import com.academicbot.pojo.AttendanceModel;

import java.sql.SQLException;

public class FacultyAttendanceServiceImpl implements FacultyAttendanceService {
    private final FacultyAttendanceDao facultyAttendanceDao = (FacultyAttendanceDao) ApplicationContext.getContext().getBean("facultyAttendanceDao");
    @Override
    public boolean markAttendance(AttendanceModel attendance, String usn, String markedBy) throws SQLException {
        return facultyAttendanceDao.markAttendance(attendance, usn, markedBy);
    }

    @Override
    public boolean updateAttendance(AttendanceModel newAttendance, String usn, String markedBy) throws SQLException {
        return facultyAttendanceDao.updateAttendance(newAttendance, usn, markedBy);
    }

    @Override
    public AttendanceModel fetchAttendanceByUSN(String usn, String courseID) throws SQLException {
        return facultyAttendanceDao.fetchAttendanceByUSN(usn, courseID);
    }
}
