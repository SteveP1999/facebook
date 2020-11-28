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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.awt.image.DataBuffer;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

    User currentUser = new User();
    ObservableList<String> list = FXCollections.observableArrayList();

    AllUsers users = new AllUsers();
    User sanyi = new User("Kis Sanyi", "halabe@freemail.hu", "asdqwe", 15);
    User peti = new User("Kis Peti", "beni0413@freemail.hu", "Kola", 20);
    User zoli = new User("Kis Zoli", "lali1212@freemail.hu", "Cica", 34);


    public void loadData() {
        list.removeAll();
        //
        users.AddUser(sanyi);
        users.AddUser(peti);
        users.AddUser(zoli);
        sanyi.AddFriend(peti);
        sanyi.AddFriend(zoli);
        //

        for (User user : users.getUsers()) {
            if(user.getEmail().equals(currentUser.getEmail())) {
                System.out.println(user.getEmail());
                for (User friend : user.getFriends()) {
                    String a = friend.getName();
                    System.out.println(friend);
                    list.add(a);
                }
            }
            Friends.getItems().addAll(list);
        }
    }

    public void initData() {
        Username.setText(currentUser.getName());
    }

    public void setText(String text) {
        UserLoggedIn.setText(text);
    }

    public void setUserInformation(String name, String password, String age) {
        Username.setText(name);
        Password.setText(password);
        Age.setText(age);
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

    public void HandleDataChangeClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataChange.fxml"));
        Parent root = loader.load();
        DataChangeController dcc = loader.getController();
        dcc.ChangeLogger(UserLoggedIn.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Fosbook");
        stage.show();
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        loadData();
        Database db = new Database();
        this.users = db.ReadUsers();
    }
}


