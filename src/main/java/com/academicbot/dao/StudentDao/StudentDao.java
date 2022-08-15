package com.academicbot.dao.StudentDao;

import com.academicbot.pojo.AdmissionDetail;

public interface StudentDao {
    boolean addAdmissionDetail(String usn, AdmissionDetail admissionDetail);

}
