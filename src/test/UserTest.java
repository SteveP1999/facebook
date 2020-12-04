package test;

import org.junit.*;
import sample.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    User user = new User("Bence", "halabe@freemail.hu", "asdqwe", 13);

    @Test
    public void getName() {
        assertEquals(user.getName(), "Bence");
    }

    @Test
    public void getEmail() {
        assertEquals(user.getEmail(), "halabe@freemail.hu");
    }

    @Test
    public void getPassword() {
        assertEquals(user.getPassword(), "asdqwe");
    }

    @Test
    public void getAge() {
        assertEquals(user.getAge(), 13);
    }
}
