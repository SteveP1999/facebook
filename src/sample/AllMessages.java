package sample;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class egy Arraylistet tárol ami sima üzeneteket tárol. Ezt fogjuk serializálni.
 */

public class AllMessages implements Serializable {

    /**
     * A tárolónk az üzeneteknek
     */

    private final ArrayList<Message> messages;

    /**
     * Konstruktor az  osztályhoz
     */

    public AllMessages() {
        messages = new ArrayList<>();
    }

    /**
     * A függvénnyel üzenetet tudunk a listához adni
     */

    public void addMessage(Message msg) {
        messages.add(msg);
    }

    /**
     * A függvény visszaadja a tárolót
     */

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
