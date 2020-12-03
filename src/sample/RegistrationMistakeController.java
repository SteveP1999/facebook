package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Az osztály a regisztrációs hibaoldalon található dolgokat valósítja meg
 */

public class RegistrationMistakeController {
    @FXML
    private Button GoBackButton;

    /**
     * A függvény bezárja az oldalt amin vagyunk
     */

    @FXML
    public void HandleGoBackButton() {
        Stage stage = (Stage) GoBackButton.getScene().getWindow();
        stage.close();
    }
}
