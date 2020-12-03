package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Az osztály a névmegváltoztatás hibaoldalán talélható funckiókat valósítja meg
 */

public class UsernameChangeController {
    @FXML
    private Button GoBackButton;

    /**
     * A függvény bezárja az oldalt ha a gombra kattintunk
     */

    @FXML
    public void HandleGoBackButton() {
        Stage stage = (Stage) GoBackButton.getScene().getWindow();
        stage.close();
    }
}
