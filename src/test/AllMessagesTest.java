package test;

import org.junit.jupiter.api.Test;
import sample.AllMessages;
import sample.Message;
import sample.User;

import static org.junit.Assert.assertEquals;

public class AllMessagesTest {
    final AllMessages messages = new AllMessages();
    final User user1 = new User("Bence", "halabe@freemail.hu", "asdqwe", 13);
    final User user2 = new User("Peti", "peti@gmail.com", "asdqwe", 16);
    final Message msg = new Message(user1, user2, "hello");

    @Test
    void addMessagse() {
        messages.addMessage(msg);
        assertEquals(messages.getMessages().get(0).getReceiver().getEmail(), "peti@gmail.com");
    }
}
