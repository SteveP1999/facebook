package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterSceneController {
    Functions func = new Functions();
    AllUsers users = new AllUsers();
    @FXML
    TextField Email;
    @FXML
    TextField Username;
    @FXML
    TextField Password;
    @FXML
    TextField Age;


    public void handleRegisterButton(ActionEvent actionEvent) throws IOException {
        this.users = new Database().ReadUsers();
        Parent home_page_parent;

        if (func.IsUniqueEmail(Email.getText()) && func.verifyName(Username.getText()) && func.verifyAge(Age.getText()) && func.verifyEmail(Email.getText())) {
            User user = new User(Username.getText(), Email.getText(), Password.getText(), Integer.parseInt(Age.getText()));
            users.AddUser(user);
            new Database().SaveUsers(users);
            home_page_parent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        } else {
            FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("RegistrationMistake.fxml"));
            Parent popupRoot = popupLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(popupRoot));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Registration error");
            stage.show();
        }
    }

    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

}
