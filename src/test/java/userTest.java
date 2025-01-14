import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.user.model.UserLogin;

class UserLoginTest {

    UserLogin user = new UserLogin("ANAND PREM", "APrem@gmail.com", "A123");

    @Test
    void getName_test() {
        String expectedName = "ANAND PREM";
        String actualName = user.getName();
        assertEquals(expectedName, actualName, "Name should match the expected value.");
    }

    @Test
    void getEmail_test() {
        String expectedEmail = "APrem@gmail.com";
        String actualEmail = user.getEmail();
        assertEquals(expectedEmail, actualEmail, "Email should match the expected value.");
    }

    @Test
    void getPassword_test() {
        String expectedPassword = "A123";
        String actualPassword = user.getPassword();
        assertEquals(expectedPassword, actualPassword, "Password should match the expected value.");
    }
}
