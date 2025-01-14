import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.user.dao.UserDAO;
import com.user.model.UserLogin;
import com.user.utility.DBConnection;

class UserDAOTest {
    private static UserDAO dao;

    @BeforeAll
    static void setUp() {
        // Initialize a connection from DBConnection
        Connection connection = DBConnection.getConnection();
        assertNotNull(connection, "Failed to establish database connection.");
        dao = new UserDAO(connection);
    }

    @Test
    void selectAllUsers_test() {
        List<User> users = dao.selectAllUsers();
        assertNotNull(users, "Users list should not be null.");
        assertTrue(users.size() > 0, "Users list should contain at least one user.");
    }

    @Test
    void checkUser_test() {
        boolean status = dao.checkUser("akshatraj879@gmail.com");
        assertFalse(status, "User check should return false for non-existing user.");
    }

    @Test
    void validateUser_test() {
        boolean status = dao.validateUser("akshatraj879@gmail.com", "123");
        assertTrue(status, "Validation should return true for valid user credentials.");
    }
}
