package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class Functions {

    public static boolean verifyEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public boolean verifyName(String name) {
        name = name.trim();
        if (name == null || name.equals(""))
            return false;
        return name.matches("[a-zA-Z]*");
    }

    public boolean verifyAge(String Age) {
        try {
            Integer.parseInt(Age);
            System.out.println(Age + " is a valid integer number");
            return true;
        } catch (NumberFormatException e) {
            System.out.println(Age + " is not a valid integer number");
            return false;
        }
    }

    public boolean IsUniqueEmail(String email, AllUsers list) {
        for (int i = 0; i < list.getUsers().size(); i++) {
            if (list.getUsers().get(i).getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public boolean EnteringPossible(AllUsers users, String Email, String Password) {
        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getEmail().equals(Email)) {
                if (users.getUsers().get(i).getPassword().equals(Password))
                    return true;
            }
        }
        return false;
    }
}
