package sample;

import java.io.Serializable;

/**
 * Az osztály megvalósítja, hogy üzeneteket tudjunk tárolni, aminek van küldője fogadója és tartalma (string)
 */

public class Message implements Serializable {
    final User Sender;
    final User Receiver;
    final String Message;

    /**
     * Az osztály konstruktora
     */

    public Message(User sender, User receiver, String message) {
        Sender = sender;
        Receiver = receiver;
        Message = message;
    }

    /**
     * A függvény visszaadja, hogy ki írta az üzenetet
     */

    public User getSender() {
        return Sender;
    }

    /**
     * A függvény visszaadja, hogy kinek küldték az üzenetet
     */

    public User getReceiver() {
        return Receiver;
    }

    /**
     * A függvény visszaadja az üzenet tartalmát
     */

    public String getMeassage() {
        return Message;
    }
}
