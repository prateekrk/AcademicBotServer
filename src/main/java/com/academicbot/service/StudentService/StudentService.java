package com.academicbot.service.StudentService;

import com.academicbot.pojo.AdmissionDetail;
import com.academicbot.pojo.NameModel;
import com.academicbot.pojo.Semester;

import java.sql.SQLException;
import java.time.LocalDate;

public interface StudentService {
    boolean addAdmissionDetail(String usn, AdmissionDetail admissionDetail) throws SQLException;
    boolean updateNames(String usn, NameModel name) throws SQLException;
    boolean updateRemarks(String usn, String remark) throws SQLException;
    boolean updateDOB(String usn, LocalDate dob) throws SQLException;
    boolean updateSemester(String usn, Semester semester) throws SQLException;
    boolean updateUsn(String usn, String newUsn) throws SQLException;
}
