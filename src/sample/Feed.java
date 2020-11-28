package sample;

import java.util.ArrayList;

public class Feed {
    private ArrayList<String> post;

    public ArrayList<String> getPost() {
        return post;
    }

    public void setPost(ArrayList<String> post) {
        this.post = post;
    }

    public void AddFeed(String feed) {
        post.add(feed);
    }
}
