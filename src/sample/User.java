package sample;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Az osztály megvalósítja egy egy felhasználó adatainak tráolását és elérését
 */

public class User implements Serializable {
    private String Name;
    private String Email;
    private String Password;
    private int Age;
    private ArrayList<User> Friends;
    private Feed feed;

    /**
     * A függvény visszaadja, a felhasználó teljes feedjét
     */

    public Feed getFeed() {
        return feed;
    }

    /**
     * Az osztály konstruktora
     */

    public User(String name, String email, String password, int age) {
        Name = name;
        Email = email;
        Password = password;
        Age = age;
        Friends = new ArrayList<>();
        feed = new Feed();
    }

    /**
     * Az osztály paraméter nélkül hívható konstruktora
     */

    public User() {
        Name = "default";
        Email = "default@default.hu";
        Password = "default";
        Age = 10;
        Friends = new ArrayList<>();
        feed = new Feed();

    }

    /**
     * A függvény visszaadja, a user nevét
     */

    public String getName() {
        return Name;
    }

    /**
     * A függvény visszaadja, a user e-mailjét
     */

    public String getEmail() {
        return Email;
    }

    /**
     * A függvény visszaadja, a user kódját
     */

    public String getPassword() {
        return Password;
    }

    /**
     * A függvény visszaadja, a user korát
     */

    public int getAge() {
        return Age;
    }

    /**
     * A függvény visszaadja, a user barátjait (Arraylist)
     */

    public ArrayList<User> getFriends() {
        return Friends;
    }

    /**
     * A függvény beállítja a user nevét
     */

    public void setName(String name) {
        Name = name;
    }

    /**
     * A függvény beállítja a user jelszavát
     */

    public void setPassword(String password) {
        Password = password;
    }

    /**
     * A függvény beállítja a user korát
     */

    public void setAge(int age) {
        Age = age;
    }

    /**
     * A függvény hozzáad egy user típust a user barátainak listájához
     */

    public void AddFriend(User user) {
        Friends.add(user);
    }
}
