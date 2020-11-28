package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterSceneController {
    Functions func = new Functions();
    @FXML
    TextField Email;
    @FXML
    TextField Username;
    @FXML
    TextField Password;
    @FXML
    TextField Age;
    AllUsers users = new AllUsers();

    public void handleRegisterButton(ActionEvent actionEvent) throws IOException {
        Database db = new Database();
        this.users = db.ReadUsers();
        Parent home_page_parent;

        if (func.IsUniqueEmail(Email.getText()) && func.verifyName(Username.getText()) && func.verifyAge(Age.getText()) && func.verifyEmail(Email.getText())) {
            User user = new User(Username.getText(), Email.getText(), Password.getText(), Integer.parseInt(Age.getText()));
            users.AddUser(user);
            for (User user1 : users.getUsers())
                System.out.println(user1.getName());
            db.SaveUsers(users);
            home_page_parent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        } else {
            home_page_parent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        }

        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

}
