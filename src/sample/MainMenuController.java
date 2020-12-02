package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenuController implements Initializable {
    @FXML
    TextField Email;
    @FXML
    TextField Password;

    Functions func = new Functions();
    AllUsers users = new AllUsers();

    public void handleButtonAction(ActionEvent actionEvent) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("RegisterScene.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    public void handleButtonAction2() throws IOException {
        this.users = new Database().ReadUsers();
        if (func.EnteringPossible(Email.getText(), Password.getText())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            Parent root = loader.load();
            MainPageController mpc = loader.getController();
            mpc.setText(Email.getText());
            for (User user : users.getUsers()) {
                if (user.getEmail().equals(Email.getText())) {
                    mpc.loadData(user);
                    String username = user.getName();
                    String password = user.getPassword();
                    int age = user.getAge();
                    mpc.setUserInformation(username, password, Integer.toString(age));
                    Stage stage = Main.getpStage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Fosbook");
                    stage.show();
                    break; //TODO javítsd ki bazdmeg!
                }
            }
        } else {
            FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("AlertBoxForLoggingIn.fxml"));
            Parent popupRoot = popupLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(popupRoot));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Login error");
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //this.users = new Database().ReadUsers();
    }
}
