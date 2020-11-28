package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    AllUsers users = new AllUsers();
    private static Stage pStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        pStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        pStage.setTitle("Fosbook");
        pStage.setScene(new Scene(root));
        pStage.setResizable(false);
        pStage.show();

        users = new Database().ReadUsers();
        users.getUsers().get(0).AddFriend(users.getUsers().get(1));
        new Database().SaveUsers(users);
        for (User user:users.getUsers())
            System.out.println(user.getName());
        //

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        root = loader.load();
        MainMenuController mmc = loader.getController();
    }

    public static Stage getpStage() {
        return pStage;
    }
}
