package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Az osztály a Help oldalon lévő dolgokat valósítja meg
 */

public class HelpSceneController {
    @FXML
    private Button GoBackButton;

    /**
     * A függvénnyel vissza lehet menni az oldalról arra az oldalra ahonnan jöttünk
     */

    @FXML
    public void HandleGoBackButton() {
        Stage stage = (Stage) GoBackButton.getScene().getWindow();
        stage.close();
    }
}
