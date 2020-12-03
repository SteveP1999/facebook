package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage pStage;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * A függvény betölti a kezdőoldalt nem átméretezhetővé teszi ad neki egy nevet.
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        pStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        pStage.setTitle("Fosbook");
        pStage.setScene(new Scene(root));
        pStage.setResizable(false);
        pStage.show();
    }

    /**
     * A függvény visszaadj a primary staget
     */

    public static Stage getpStage() {
        return pStage;
    }
}
