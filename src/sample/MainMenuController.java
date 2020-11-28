package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
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
    public void handleButtonAction2(ActionEvent actionEvent) throws IOException {
        if (func.EnteringPossible(Email.getText(), Password.getText())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            Parent root = loader.load();
            MainPageController mpc = loader.getController();
            mpc.setText(Email.getText());

            for (User user : users.getUsers()) {
                if (user.getEmail().equals(Email.getText())) {
                    mpc.setCurrentUser(user);
                    /*String username = user.getName();
                    String password = user.getPassword();
                    int age = user.getAge();
                    mpg.setUserInformation(username, password, Integer.toString(age));*/
                    break;
                }
            }

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Fosbook");
            stage.show();

            /*Parent home_page_parent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.show();*/

        } else {
            System.out.println("Nem megfelelő Email vagy jelszó!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database db = new Database();
        this.users = db.ReadUsers();
    }
}
