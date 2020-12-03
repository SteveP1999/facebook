package sample;

import java.io.Serializable;

public class Message implements Serializable {
    User Sender;
    User Receiver;
    String Message;

    public Message(User sender, User receiver, String message) {
        Sender = sender;
        Receiver = receiver;
        Message = message;
    }

    public User getSender() {
        return Sender;
    }

    public User getReceiver() {
        return Receiver;
    }

    public String getMeassage() {
        return Message;
    }
}
