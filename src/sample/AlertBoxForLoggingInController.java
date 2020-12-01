package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AlertBoxForLoggingInController {

    @FXML
    private Button GoBackButton;

    @FXML
    public void HandleGoBackButton(ActionEvent actionEvent) {
        Stage stage = (Stage) GoBackButton.getScene().getWindow();
        stage.close();
    }
}
