package com.academicbot.service.academicOperationsService.studentOperationService.attendance;

import com.academicbot.Helpers.ApplicationContext;
import com.academicbot.dao.academicOperationsDao.studentOperations.attendance.StudentAttendanceDao;
import com.academicbot.pojo.AttendanceModel;

import java.sql.SQLException;
import java.util.List;

public class StudentAttendanceServiceImpl implements StudentAttendanceService {
    private final StudentAttendanceDao studentAttendanceDao = (StudentAttendanceDao) ApplicationContext.getContext().getBean("studentAttendanceDao");
    @Override
    public AttendanceModel fetchAttendance(String usn, String courseID) throws SQLException {
        return studentAttendanceDao.fetchAttendance(usn, courseID);
    }

    @Override
    public List<AttendanceModel> fetchAttendance(String usn) throws SQLException {
        return studentAttendanceDao.fetchAttendance(usn);
    }
}
