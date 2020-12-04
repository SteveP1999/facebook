package sample;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Az osztály egy listát valósít meg ami tárolja a postokat
 */

public class Feed implements Serializable {

    private final ArrayList<String> post = new ArrayList<>();

    /**
     * A függvény visszaadja a tárolót
     */

    public ArrayList<String> getPost() {
        return post;
    }

    /**
     * A függvény hozzáad egy String típust a tárolóhoz
     */

    public void AddFeed(String feed) {
        post.add(feed);
    }
}
