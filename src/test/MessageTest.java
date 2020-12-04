package test;

import org.junit.Test;
import sample.Message;
import sample.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {

    User user1 = new User("Bence", "halabe@freemail.hu", "asdqwe", 13);
    User user2 = new User("Peti", "peti@gmail.com", "asdqwe", 16);
    Message msg = new Message(user1, user2, "szevasz");

    @Test
    public void getSender() {
        assertEquals(msg.getSender(), user1);
    }

    @Test
    public void getReceiver() {
        assertEquals(msg.getReceiver(), user2);
    }

     @Test
     public void getMessage() {
        assertEquals(msg.getMeassage(), "szevasz");
    }
}
