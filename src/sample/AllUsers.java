package sample;

import java.io.*;
import java.util.ArrayList;

public class AllUsers implements Serializable {
    private ArrayList<User> Users;

    AllUsers() {
        Users = new ArrayList<>();
    }


    public ArrayList<User> getUsers() {
        return Users;
    }

    public void setUsers(ArrayList<User> users) {
        Users = users;
    }

    public void AddUser(User user) {
        Users.add(user);
    }


    public void ReadUsers() {
        sample.User u = null;
        try {
            FileInputStream fileIn = new FileInputStream("");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            u = (sample.User) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("sample.User class not found");
            c.printStackTrace();
            return;
        }
    }

    public void SaveUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Users);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/users.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
