package com.academicbot.service.RegisterService;

import com.academicbot.Helpers.ApplicationContext;
import com.academicbot.dao.registerDao.RegisterDao;
import com.academicbot.pojo.Faculty;
import com.academicbot.pojo.Student;

import java.sql.SQLException;

public class RegisterServiceImpl implements RegisterService {
    private final RegisterDao registerDao = (RegisterDao) ApplicationContext.getContext().getBean("registerDao");
    @Override
    public boolean registerStudent(Student student, String userName, String password) throws SQLException {
        return registerDao.registerStudent(student, userName, password);
    }

    @Override
    public boolean registerFaculty(Faculty faculty, String userName, String password) throws SQLException {
        return registerDao.registerFaculty(faculty, userName, password);
    }

    @Override
    public boolean removeUserByUserName(String userName) throws SQLException {
        return registerDao.removeUserByUserName(userName);
    }

    @Override
    public boolean removeUserByUSN(String usn) throws SQLException {
        return registerDao.removeUserByUSN(usn);
    }

    @Override
    public boolean removeFacultyByID(String id) throws SQLException {
        return registerDao.removeFacultyByID(id);
    }
}
