package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String Name;
    private String Email;
    private String Password;
    private int Age;
    private ArrayList<User> Friends;
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public User(String name, String email, String password, int age) {
        Name = name;
        Email = email;
        Password = password;
        Age = age;
        Friends = new ArrayList<>();
        feed = new Feed();
    }

    public User() {
        Name = "default";
        Email = "default@default.hu";
        Password = "default";
        Age = 10;
        Friends = new ArrayList<>();
        feed = new Feed();

    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public int getAge() {
        return Age;
    }

    public ArrayList<User> getFriends() {
        return Friends;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setFriends(ArrayList<User> friends) {
        Friends = friends;
    }

    public void AddFriend(User user) {
        Friends.add(user);
    }

    public void RemoveFriend(User user) { Friends.remove(user); }
}
