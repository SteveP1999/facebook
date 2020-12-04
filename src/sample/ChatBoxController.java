package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Az osztály a chat ablak funkcióit valósítja meg.
 */

public class ChatBoxController implements Initializable {

    /**
     *
     */

    AllUsers users;
    User currentUser;
    User receiver;
    AllMessages messages = new Chat().ReadMessages();
    @FXML
    ListView<String> ChatWindow = new ListView<>();
    @FXML
    TextField msg = new TextField();

    final ObservableList<String> list = FXCollections.observableArrayList();


    /**
     * A függvény beállítja, hogy melyik felhasználó van éppen bejelentkezve
     */

    public void setCurrentUser(User usr) {
        currentUser = usr;
    }

    /**
     * A függvény beölti az összes üzenetet ami vagy a küldött b-nek vagy b küldött a-nak
     */

    public void LoadChat(String currentUser, String receiver) {
        messages = new Chat().ReadMessages();
        setCurrentUser(getUserByEmail(currentUser));
        setReceiver(getUserByEmail(receiver));
        list.clear();
        for (Message msg : messages.getMessages()) {
            if (msg.getSender().getEmail().equals(currentUser) && msg.getReceiver().getEmail().equals(receiver)) {
                String a = currentUser.length() < receiver.length() ? currentUser + ":\t" + nameDiff(currentUser, receiver) : currentUser + ":\t";
                a += msg.getMeassage();
                list.add(a);
            } else if (msg.getSender().getEmail().equals(receiver) && msg.getReceiver().getEmail().equals(currentUser)) {
                String a = receiver.length() < currentUser.length() ? receiver + ":\t" + nameDiff(receiver, currentUser) : receiver + ":\t";
                a += msg.getMeassage();
                list.add(a);
            }
        }
        ChatWindow.getItems().addAll(list);
    }


    /**
     * A függvény két string hosszának különbségéből csinál egy azonos hosszúságú stringet és ezt adja vissza
     */

    public String nameDiff(String a, String b) {
        return " ".repeat(Math.abs(a.length() - b.length()));
    }

    /**
     * A függvény visszaad egy User típust string alapján
     */

    public User getUserByEmail(String email) {
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    /**
     * A függvény felveszi az üzenetek közé az elküldött üzenetet
     */

    public void HandleMessageSent() {
        messages.addMessage(new Message(currentUser, receiver, msg.getText()));
        new Chat().SaveMessages(messages);

        int j = ChatWindow.getItems().size();
        int k = 0;
        for (int i = 0; i < j; i++) {
            ChatWindow.getItems().remove(i - k);
            k = k + 1;
        }

        LoadChat(currentUser.getEmail(), receiver.getEmail());
    }

    /**
     * A függvény beállítja a fogadó felhasználót akinek írunk
     */

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }


    /**
     * A függvény alapból beolvasssa a users változóba az elmentett felhasználóinkat
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.users = new Database().ReadUsers();
    }
}
