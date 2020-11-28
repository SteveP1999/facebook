package sample;

public class Message {
    String Sender;
    String Reciever;
    String Meassage;

    public Message(String sender, String reciever, String meassage) {
        Sender = sender;
        Reciever = reciever;
        Meassage = meassage;
    }

    public String getSender() {
        return Sender;
    }

    public String getReciever() {
        return Reciever;
    }

    public String getMeassage() {
        return Meassage;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public void setReciever(String reciever) {
        Reciever = reciever;
    }

    public void setMeassage(String meassage) {
        Meassage = meassage;
    }
}
