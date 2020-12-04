package test;

import org.junit.Test;
import sample.Functions;

import static org.junit.Assert.*;

public class FunctionsTest {
    final Functions func = new Functions();

    @Test
    public void verifyEmail() {
        String email = "halabe@freemail.hu";
        String email2 = "halasz.hu";
        assertTrue(func.verifyEmail(email));
        assertFalse(func.verifyEmail(email2));
    }

    @Test
    public void verifyName() {
        String name = "Karcsi";
        assertTrue(func.verifyName(name));
    }

    @Test
    public void verifyAge() {
        int age = 10;
        assertTrue(func.verifyAge(Integer.toString(age)));
    }
}
