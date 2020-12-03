package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Az osztály a kód hibaoldalon található dolgokat valósítja meg
 */

public class PasswordChangeController {
    @FXML
    private Button GoBackButton;

    /**
     * A függvény bezárja az adott oldalt amin vagyunk ha a gombra kattintunk
     */

    @FXML
    public void HandleGoBackButton() {
        Stage stage = (Stage) GoBackButton.getScene().getWindow();
        stage.close();
    }
}
