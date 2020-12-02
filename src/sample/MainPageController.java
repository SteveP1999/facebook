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
import javafx.stage.Modality;
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
    ListView<String> Friends = new ListView<>();
    @FXML
    ListView<String> ChatBox = new ListView<>();
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
            if (!friend.getEmail().equals(currentUser.getEmail())) {
                String a = friend.getEmail();
                list.add(a);
            }
        }
        Friends.getItems().addAll(list);
    }

    public void loadData2(User usr) {
        setCurrentUser(usr);
        list.removeAll();
        for(User friend : currentUser.getFriends()) {
            for(String s : friend.getFeed().getPost()) {
                String pos = friend.getEmail() + s;
                list.add(pos);
            }
        }
        ChatBox.getItems().addAll(list);
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
        for (String m : receiver) {
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

    public void HandleFollowButtonClicked() throws IOException {
        ObservableList<String> follow;
        follow = Friends.getSelectionModel().getSelectedItems();
        String a = follow.get(0);
        if (!currentUser.getFriends().isEmpty()) {
            boolean shouldFollow = true;
            for (User user : currentUser.getFriends()) {
                if (user.getEmail().equals(a)) {
                    shouldFollow = false;
                    break;
                }
            }
            if (!shouldFollow) {
                FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("UnfollowScene.fxml"));
                Parent popupRoot = popupLoader.load();
                UnfollowSceneController usc = popupLoader.getController();
                usc.setCurrentUser(currentUser);
                usc.setFollowUser(getUserByEmail(a));
                Stage stage = new Stage();
                stage.setScene(new Scene(popupRoot));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Unfollow");
                stage.show();
            } else {
                currentUser.AddFriend(getUserByEmail(a));
                new Database().SaveUsers(users);
            }
        }
        else {
            currentUser.AddFriend(getUserByEmail(a));
            new Database().SaveUsers(users);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.users = new Database().ReadUsers();
    }
}


