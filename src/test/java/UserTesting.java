import com.academicbot.dao.UserDao.UserDao;
import com.academicbot.dao.UserDao.UserDaoImpl;
import static org.junit.jupiter.api.Assertions.*;

import com.academicbot.example.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.academicbot.pojo.Designation;
import com.academicbot.pojo.User;

import java.sql.SQLException;


public class UserTesting {
    static UserDao userDao;
    @BeforeAll
    static void init() {
        Main.initApplicationContext();
        userDao = (UserDao) Main.getApplicationContext().getBean("userDao");
    }
    @Test
    public void testUserDetails() {

        try {
            User user = userDao.getUser("prateek.17cs@cmr.edu.in");
            assertSame(user.getDesignation(), Designation.STUDENT);
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
    }
    @Test
     public void changePasswordFail() {
        try {
            boolean result = userDao.resetPassword("prk2199", "prateek.17cs@cmr.edu,in");
            assertFalse(result);
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
     }

    @Test
    public void changePasswordSuccess() {
        try {
            boolean result = userDao.resetPassword("prk2199", "prateek.17cs@cmr.edu.in");
            assertTrue(result);
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
    }
}