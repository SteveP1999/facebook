package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class AllMessages implements Serializable {
    private ArrayList<Message> messages;

    public AllMessages() {
        messages = new ArrayList<>();
    }

    public void addMessage(Message msg) {
        messages.add(msg);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
