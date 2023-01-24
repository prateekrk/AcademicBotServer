package com.academicbot.service.StudentService;

import com.academicbot.Helpers.ApplicationContext;
import com.academicbot.dao.studentDao.StudentDao;
import com.academicbot.pojo.AdmissionDetail;
import com.academicbot.pojo.NameModel;
import com.academicbot.pojo.Semester;

import java.sql.SQLException;
import java.time.LocalDate;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = (StudentDao) ApplicationContext.getContext().getBean("studentDao");
    @Override
    public boolean addAdmissionDetail(String usn, AdmissionDetail admissionDetail) throws SQLException {
        return studentDao.addAdmissionDetail(usn, admissionDetail);
    }

    @Override
    public boolean updateNames(String usn, NameModel name) throws SQLException {
        return studentDao.updateNames(usn, name);
    }

    @Override
    public boolean updateRemarks(String usn, String remark) throws SQLException {
        return studentDao.updateRemarks(usn, remark);
    }

    @Override
    public boolean updateDOB(String usn, LocalDate dob) throws SQLException {
        return studentDao.updateDOB(usn, dob);
    }

    @Override
    public boolean updateSemester(String usn, Semester semester) throws SQLException {
        return studentDao.updateSemester(usn, semester);
    }

    @Override
    public boolean updateUsn(String usn, String newUsn) throws SQLException {
        return studentDao.updateUsn(usn, newUsn);
    }
}
