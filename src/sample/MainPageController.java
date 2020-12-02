package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    Label UserLoggedIn = new Label();
    @FXML
    Label Username = new Label();
    @FXML
    Label Password = new Label();
    @FXML
    Label Age = new Label();
    @FXML
    Label Timer = new Label();
    @FXML
    ListView<String> Friends = new ListView<>();
    @FXML
    ListView<String> ChatBox = new ListView<>();
    @FXML
    TextField searchFriends = new TextField();
    @FXML
    TextField Post = new TextField();
    @FXML
    MenuItem Exit = new MenuItem();

    User currentUser = new User();
    ObservableList<String> list = FXCollections.observableArrayList();
    AllUsers users = new AllUsers();

    public void initData() {
        Username.setText(currentUser.getName());
    }

    public void loadData(User usr) {
        setCurrentUser(usr);
        list.removeAll();
        for (User friend : users.getUsers()) {
            String a = friend.getEmail();
            list.add(a);
        }
        Friends.getItems().addAll(list);
    }

    public void setText(String text) {
        UserLoggedIn.setText(text);
    }

    public void setUserInformation(String name, String password, String age) {
        Username.setText(name);
        Password.setText(password);
        Age.setText(age);
    }

    public void closeApp() {
        System.exit(0);
    }

    /*public void clock() throws InterruptedException {
        Thread clock = new Thread();
        {
            try {
                while (true) {
                    Calendar calendar = new GregorianCalendar();
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH);
                    int year = calendar.get(Calendar.YEAR);
                    int second = calendar.get(Calendar.SECOND);
                    int minute = calendar.get(Calendar.MINUTE);
                    int hour = calendar.get(Calendar.HOUR);
                    Timer.setText("Time:" + hour + minute + second + "Date" + year + "/" + month + "/" + day);
                    clock.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Hiba");
            }
        }
        clock.start();
    }*/

    public ArrayList<User> searchUsers() {
        ArrayList<User> results = new ArrayList<>();
        for (User user : users.getUsers()) {
            if (user.getName().contains(searchFriends.getText())) {
                results.add(user);
            }
        }
        return results;
    }

    public void HandleDataChangeClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataChange.fxml"));
        Parent root = loader.load();
        DataChangeController dcc = loader.getController();
        dcc.ChangeLogger(UserLoggedIn.getText());
        dcc.SetCurrentUser(currentUser);
        dcc.ChangeAllUsers(users);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Fosbook");
        stage.show();
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public void PostButtonClicked() {
        System.out.println(currentUser.getEmail());
        /*
        currentUser.getFeed().AddFeed(Post.getText());
        new Database().SaveUsers(users);
        System.out.println(currentUser.getFeed());
        */
    }

    public void HandleChatBoxClicked() throws IOException {
        ObservableList<String> receiver;
        receiver = Friends.getSelectionModel().getSelectedItems();
        String a = "";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatBox.fxml"));
        Parent root = loader.load();
        ChatBoxController cbc = loader.getController();
        for(String m : receiver) {
            a = m;
        }
        cbc.LoadChat(currentUser.getEmail(), a, currentUser);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Fosbook");
        stage.show();
    }

    public User getUserByEmail(String email) {
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public void HandleFollowbButtonClcked() {
        ObservableList<String> follow;
        follow = Friends.getSelectionModel().getSelectedItems();
        String a = "";
        for(String m : follow) {
            a = m;
        }
        currentUser.AddFriend(getUserByEmail(a));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.users = new Database().ReadUsers();
    }
}


