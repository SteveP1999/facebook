package sample;

/**
 * Az osztály az alap általánosan használt függvényeket valósítja meg
 */

public class Functions {

    /**
     * A függvény ellenőrzi, hogy a megadott e-mail ...@...hu formátumban van-e
     */

    public boolean verifyEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    /**
     * A függvény ellenőrzi, hogy egy megadott név szintaktikailag helyes e
     */

    public boolean verifyName(String name) {
        name = name.trim();
        if (name.equals(""))
            return false;
        return name.matches("[a-zA-Z]*");
    }

    /**
     * A függvény ellenőrzi, hogy egy megadott string tényleg szám e
     */

    public boolean verifyAge(String Age) {
        try {
            Integer.parseInt(Age);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * A függvény ellenőrzi, hogy egy megadott string megtalálható-e már a létező felhasználók e-mailjei között
     */

    public boolean IsUniqueEmail(String email) {
        AllUsers users = new Database().ReadUsers();
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    /**
     * A függvény megnézi, hogy a beírt felhasználónév, jelszó páros létezik e és ha igen igaz értékkel tér vissza, bejelntkezésnél használom
     */

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
