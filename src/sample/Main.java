package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    AllUsers users = new AllUsers();
    Functions func = new Functions();
    String logger = new String();
    User sanyi = new User("Kis Sanyi", "halabe@freemail.hu", "asdqwe", 15);
    User peti = new User("Kis Peti", "beni0413@freemail.hu", "Kola", 20);
    User zoli = new User("Kis Zoli", "lali1212@freemail.hu", "Cica", 34);


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        primaryStage.setTitle("Fosbook");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        root = loader.load();
        MainPageController mpg = loader.getController();
        mpg.initMPC(sanyi);

        /*
        users.ReadUsers();
        for(User user : users.getUsers()) {
            System.out.println(user.getEmail()+ " " + user.getName() + " " + user.getAge());
            System.out.println("");
        }
        users.SaveUsers();
        */
        //MainPageController mpg = new MainPageController();
        //mpg.clock();
    }



    public static void main(String[] args) {
        launch(args);
    }




}
