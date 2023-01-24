package com.academicbot.service.RegisterService;

import com.academicbot.pojo.Faculty;
import com.academicbot.pojo.Student;

import java.sql.SQLException;

public interface RegisterService {
    boolean registerStudent(Student student, String userName, String password) throws SQLException;
    boolean registerFaculty(Faculty faculty, String userName, String password) throws SQLException;
    boolean removeUserByUserName(String userName) throws SQLException;
    boolean removeUserByUSN(String usn) throws  SQLException;
    boolean removeFacultyByID(String id) throws  SQLException;
}
