package sample;

import java.io.*;

/**
 * Az osztály megvalósítja a felhasználóink mentését egy database.ser serializált fájlba továbbá a beolvasást is megvalósítja
 */

public class Database {

    /**
     * A függvény beolvassa database.ser serializált fájl tartalmát egy Allusers típusú változóba majd visszaadja
     */

    public AllUsers ReadUsers() {
        File f = new File("database.ser");
        if (f.exists()) {
            try {
                AllUsers u;
                FileInputStream fileIn = new FileInputStream("database.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                u = (AllUsers) in.readObject();
                in.close();
                fileIn.close();
                return u;
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }
        return new AllUsers();
    }

    /**
     * A függvény elmenti egy Allusers osztály összes felhasználóját egy database.ser serializált fájlba
     */

    public void SaveUsers(AllUsers users) {
        try {
            FileOutputStream fileOut = new FileOutputStream("database.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
