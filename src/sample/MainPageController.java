package sample;

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
import java.util.ResourceBundle;

/**
 * Az osztály a bejelentkezett oldalon lévő dolgoakt valósítja meg, követés üzenetek írása, adatmegváltoztatás és még sok minden
 */

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
    final ObservableList<String> list = FXCollections.observableArrayList();
    final ObservableList<String> list2 = FXCollections.observableArrayList();
    AllUsers users = new AllUsers();

    /**
     * A függvény betölti egy listviewba az összes felhasználót akik regisztráltak az oldalra
     */

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

    /**
     * A függvény betölti az összes követett felhasználó feedjét egy listviewba
     */

    public void loadFeed(User usr) {
        setCurrentUser(usr);
        list2.clear();
        list2.addAll(getUserByEmail(currentUser.getEmail()).getFeed().getPost());

        for (User friend : getUserByEmail(currentUser.getEmail()).getFriends()) {
            for (String s : friend.getFeed().getPost()) {
                String pos = friend.getEmail() + ":   \t" + s;
                list2.add(pos);
            }
        }

        ChatBox.getItems().addAll(list2);
    }

    /**
     * A függvény beállítja egy text értékét.
     */

    public void setText(String text) {
        UserLoggedIn.setText(text);
    }

    /**
     * A függvény beállítja a bejelentkezett user nevét kódját és korát 3 különböző textbe
     */

    public void setUserInformation(String name, String password, String age) {
        Username.setText(name);
        Password.setText(password);
        Age.setText(age);
    }

    /**
     * A függvény bezárja a programot
     */

    public void closeApp() {
        System.exit(0);
    }

    /**
     * A függvény betölti az adatok megváltozatásához szükséges oldalt ha egy gombra kattintunk
     */

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

    /**
     * A függvény beállítja az éppen bejelentkezett felhasználót a currenUser változóba
     */

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    /**
     * A függvény felvesz egy postot az összes post listájába
     */

    public void PostButtonClicked() {

        getUserByEmail(currentUser.getEmail()).getFeed().AddFeed(Post.getText());
        new Database().SaveUsers(users);

        System.out.println(currentUser.getFeed().getPost().size());

        int j = ChatBox.getItems().size();
        int k = 0;
        for (int i = 0; i < j; i++) {
            ChatBox.getItems().remove(i - k);
            k = k + 1;
        }

        loadFeed(currentUser);
    }

    /**
     * A függvény megnyitja a chat ablakot azzal a személlyel aki ki lett választva és betölti az üzeneteiket
     */

    public void HandleChatBoxClicked() throws IOException {
        ObservableList<String> receiver;
        receiver = Friends.getSelectionModel().getSelectedItems();
        String a = "";
        for (String m : receiver) {
            a = m;
        }
        if (!a.equals("")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatBox.fxml"));
            Parent root = loader.load();
            ChatBoxController cbc = loader.getController();
            cbc.LoadChat(currentUser.getEmail(), a);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Fosbook");
            stage.show();
        }
    }

    /**
     * A függvény visszaad egy felhasználót User típust egy string alapján(e-mail)
     */

    public User getUserByEmail(String email) {
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    /**
     * A függvény beköveti a listviewben kiválasztott felhasználót, amennyiben már követi feldob egy oldalt hogy ki akarja e követni
     */

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
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(popupRoot));
                stage.setTitle("Unfollow");
                stage.show();
            } else {
                currentUser.AddFriend(getUserByEmail(a));
                getUserByEmail(currentUser.getEmail()).AddFriend(getUserByEmail(a));
                new Database().SaveUsers(users);
                loadFeed(currentUser);
                setAllusers(users);
                setCurrentUser(currentUser);
            }
        } else {
            currentUser.AddFriend(getUserByEmail(a));
            getUserByEmail(currentUser.getEmail()).AddFriend(getUserByEmail(a));
            new Database().SaveUsers(users);
            setAllusers(users);
            setCurrentUser(currentUser);

        }
    }

    /**
     * A függvény kijelentkezik, bezárja az oldalt és megnyitja a kezdőoldalt
     */

    public void LogOut() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        Parent root = loader.load();
        Stage stage = Main.getpStage();
        stage.setScene(new Scene(root));
        stage.setTitle("Fosbook");
        stage.show();
    }

    /**
     * A függvény betölti a Help oldalt ahol pár hasznos tipp van
     */

    public void Help() throws IOException {
        FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("HelpScene.fxml"));
        Parent popupRoot = popupLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(popupRoot));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Help");
        stage.show();
    }

    public void setAllusers(AllUsers users) {
        this.users = users;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.users = new Database().ReadUsers();
    }
}


