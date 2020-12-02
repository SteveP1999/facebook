package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Feed implements Serializable {

    private ArrayList<String> post = new ArrayList<>();

    public ArrayList<String> getPost() {
        return post;
    }
    
    public void AddFeed(String feed) {
        post.add(feed);
    }
}
