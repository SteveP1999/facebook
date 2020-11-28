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
import java.util.ArrayList;

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
    User sanyi = new User("Kis Sanyi", "halabe@freemail.hu", "Futyike", 15);
    User peti = new User("Kis Peti", "beni0413@freemail.hu", "Kola", 20);
    User zoli = new User("Kis Zoli", "lali1212@freemail.hu", "Cica", 34);


    public void handleRegisterButton(ActionEvent actionEvent) throws IOException {
        Parent home_page_parent;
        users.AddUser(sanyi);
        users.AddUser(peti);
        users.AddUser(zoli);
        if(func.IsUniqueEmail(Email.getText(), users) && func.verifyName(Username.getText()) && func.verifyAge(Age.getText()) && func.verifyEmail(Email.getText())) {
            User user = new User(Username.getText(), Email.getText(), Password.getText(), Integer.parseInt(Age.getText()));
            users.AddUser(user);
            for (int i = 0; i < users.getUsers().size(); i++) {
                System.out.println(users.getUsers().get(i));
            }
            home_page_parent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        }
        else {
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
