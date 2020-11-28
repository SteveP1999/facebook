package sample;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DataChangeController {
    Functions func = new Functions();
    AllUsers users = new AllUsers();
    String logger = new String();
    User sanyi = new User("Kis Sanyi", "halabe@freemail.hu", "asdqwe", 15);
    User peti = new User("Kis Peti", "beni0413@freemail.hu", "Kola", 20);
    User zoli = new User("Kis Zoli", "lali1212@freemail.hu", "Cica", 34);
    @FXML
    TextField Username = new TextField();
    @FXML
    TextField Password = new TextField();
    @FXML
    TextField Age = new TextField();

    public void ChangeLogger(String email) {
        logger = email;
    }

    public void ChangeUsername() {
        users.AddUser(sanyi);
        users.AddUser(peti);
        users.AddUser(zoli);
        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getEmail().equals(logger)) {
                users.getUsers().get(i).setName(Username.getText());
            }
        }
    }

    public void ChangePassword() {
        users.AddUser(sanyi);
        users.AddUser(peti);
        users.AddUser(zoli);
        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getEmail().equals(logger)) {
                users.getUsers().get(i).setPassword(Password.getText());
            }
        }
    }

    public void ChangeAge() {
        users.AddUser(sanyi);
        users.AddUser(peti);
        users.AddUser(zoli);
        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getEmail().equals(logger)) {
                users.getUsers().get(i).setAge(Integer.parseInt(Age.getText()));
            }
        }
    }
}
