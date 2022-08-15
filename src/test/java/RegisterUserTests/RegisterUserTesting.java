package RegisterUserTests;

import com.academicbot.dao.RegisterDao.RegisterDao;
import com.academicbot.dao.RegisterDao.RegisterDaoImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegisterUserTesting {
    static RegisterDao registerDao;
    @BeforeAll
    public static void init() {
        registerDao = new RegisterDaoImpl();
    }

    @Test
    public void registerTest() {
    }
}
