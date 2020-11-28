package sample;

import java.io.*;
import java.util.ArrayList;

public class AllUsers implements Serializable {
    private ArrayList<User> users;

    AllUsers() {
        users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void AddUser(User user) {
        users.add(user);
    }
}
