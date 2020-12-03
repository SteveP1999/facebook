package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Ez a class végzi, hogy a hibás bejelentkezés oldalról vissza tudjunk menni a go back buttonre kattintva
 */

public class AlertBoxForLoggingInController {

    @FXML
    private Button GoBackButton;

    /**
     * Ha megnyomjuk a gombot ami az oldalon van bezárja az adott oldalt, ezt valósítja meg ez a függvény.
     */

    @FXML
    public void HandleGoBackButton() {
        Stage stage = (Stage) GoBackButton.getScene().getWindow();
        stage.close();
    }
}
