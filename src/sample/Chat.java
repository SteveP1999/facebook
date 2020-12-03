package sample;

import java.io.*;

/**
 * Az osztály az üzenetek lementését valósítja meg továbbá a visszaolvasást a serializált fájlból
 */

public class Chat {

    /**
     * A függvény beolvasssa a chatstream.ser serializált fájlból egy array listbe ami messagekat tárol és ezt visszaadja
     */

    public AllMessages ReadMessages() {
        File f = new File("chatstream.ser");
        if (f.exists()) {
            try {
                AllMessages u;
                FileInputStream fileIn = new FileInputStream("chatstream.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                u = (AllMessages) in.readObject();
                in.close();
                fileIn.close();
                return u;
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }
        return new AllMessages();
    }

    /**
     * A függvény elmenti a chatstream.ser serializált fájlba egy array list tartalmát amiben messageket tárolunk
     */

    public void SaveMessages(AllMessages users) {
        try {
            FileOutputStream fileOut = new FileOutputStream("chatstream.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
