package sample;

public class Functions {

    public boolean verifyEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public boolean verifyName(String name) {
        name = name.trim();
        if (name.equals(""))
            return false;
        return name.matches("[a-zA-Z]*");
    }

    public boolean verifyAge(String Age) {
        try {
            Integer.parseInt(Age);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean IsUniqueEmail(String email) {
        AllUsers users = new Database().ReadUsers();
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public boolean EnteringPossible(String Email, String Password) {
        AllUsers users = new Database().ReadUsers();
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(Email)) {
                if (user.getPassword().equals(Password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
