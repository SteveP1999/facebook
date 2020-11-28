package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    AllUsers users = new AllUsers();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        primaryStage.setTitle("Fosbook");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

        //
        /*users.AddUser(new User("Kis Sanyi", "halabe@freemail.hu", "asdqwe", 15));
        users.AddUser(new User("Kis Peti", "beni0413@freemail.hu", "Kola", 20));
        users.AddUser(new User("Kis Zoli", "lali1212@freemail.hu", "Cica", 34));
        new Database().SaveUsers(users);*/
        for (User user:users.getUsers())
            System.out.println(user.getName());
        //

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        root = loader.load();
        MainMenuController mmc = loader.getController();
    }
}
