package test;

import org.junit.jupiter.api.Test;
import sample.AllMessages;
import sample.Message;
import sample.User;

import static org.junit.Assert.assertEquals;

public class AllMessagesTest {
    AllMessages messages = new AllMessages();
    User user1 = new User("Bence", "halabe@freemail.hu", "asdqwe", 13);
    User user2 = new User("Peti", "peti@gmail.com", "asdqwe", 16);
    Message msg = new Message(user1, user2, "hello");

    @Test
    void addMessagse() {
        messages.addMessage(msg);
        assertEquals(messages.getMessages().get(0).getReceiver().getEmail(), "peti@gmail.com");
    }
}
