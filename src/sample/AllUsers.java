package sample;

import java.io.*;
import java.util.ArrayList;

/**
 * Az osztály egy felhasználókat tároló listát valósít meg, ezt fogjuk serializálni.
 */

public class AllUsers implements Serializable {

    /**
     * A listában tároljuk a felhasználókat (User)
     */

    private final ArrayList<User> users;

    /**
     * Konstruktor
     */

    AllUsers() {
        users = new ArrayList<>();
    }

    /**
     * Visszaadja a tárolót
     */

    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Hozzáad a listához egy felhasználót
     */

    public void AddUser(User user) {
        users.add(user);
    }
}
