package sample;

import java.io.Serializable;

public class Message implements Serializable {
    User Sender;
    User Reciever;
    String Meassage;

    public Message(User sender, User reciever, String meassage) {
        Sender = sender;
        Reciever = reciever;
        Meassage = meassage;
    }

    public User getSender() {
        return Sender;
    }

    public User getReciever() {
        return Reciever;
    }

    public String getMeassage() {
        return Meassage;
    }

    public void setSender(User sender) {
        Sender = sender;
    }

    public void setReciever(User reciever) {
        Reciever = reciever;
    }

    public void setMeassage(String meassage) {
        Meassage = meassage;
    }
}
