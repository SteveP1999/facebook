package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DataChangeController {
    @FXML
    TextField Username = new TextField();
    @FXML
    TextField Password = new TextField();
    @FXML
    TextField Age = new TextField();

    Functions func = new Functions();
    String logger = new String();
    AllUsers users = new AllUsers();
    User CurrentUser = new User();

    public void SetCurrentUser(User usr) {
        CurrentUser = usr;
    }

    public void ChangeLogger(String email) {
        logger = email;
    }

    public void ChangeUsername() throws IOException {
        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getEmail().equals(logger)) {
                if (func.verifyName(Username.getText())) {
                    users.getUsers().get(i).setName(Username.getText());
                    new Database().SaveUsers(users);
                }
                else {
                    FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("UsernameChange.fxml"));
                    Parent popupRoot = popupLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(popupRoot));
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Username error");
                    stage.show();
                }
            }
        }
    }

    public void ChangePassword() throws IOException {
        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getEmail().equals(logger)) {
                if (!Password.getText().equals("")) {
                    users.getUsers().get(i).setPassword(Password.getText());
                    new Database().SaveUsers(users);
                }
                else {
                    FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("PasswordChange.fxml"));
                    Parent popupRoot = popupLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(popupRoot));
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Password error");
                    stage.show();
                }
            }
        }
    }

    public void ChangeAge() throws IOException {
        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getEmail().equals(logger)) {
                if (func.verifyAge(Age.getText())) {
                    users.getUsers().get(i).setAge(Integer.parseInt(Age.getText()));
                    new Database().SaveUsers(users);
                }
                else {
                    FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("AgeChange.fxml"));
                    Parent popupRoot = popupLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(popupRoot));
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Age error");
                    stage.show();
                }
            }
        }
    }

    public void ChangeAllUsers(AllUsers users) {
        this.users = users;
    }

    public void GoBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        MainPageController mpc = loader.getController();
        mpc.setText(logger);
        mpc.loadData(CurrentUser);
        mpc.setUserInformation(CurrentUser.getName(), CurrentUser.getPassword(), Integer.toString(CurrentUser.getAge()));
        Stage stage = Main.getpStage();
        stage.setScene(new Scene(root));
        stage.setTitle("Fos");
        stage.show();
    }
}
