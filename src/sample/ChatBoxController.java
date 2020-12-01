package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatBoxController implements Initializable {
    AllUsers users;
    User currentUser;
    User receiver;
    AllMessages messages;
    @FXML
    ListView<String> ChatWindow = new ListView<>();
    @FXML
    TextField msg = new TextField();

    ObservableList<String> list = FXCollections.observableArrayList();

    public void setCurrentUser(User usr) {
        currentUser = usr;
    }

    public void LoadChat(String sender, String receiver, User usr) {
        setCurrentUser(usr);
        setReceiver(getUserByEmail(receiver));
        list.removeAll();
        messages = new Chat().ReadMessages();
        for (Message msg : messages.getMessages()) {
            if (msg.getSender().getEmail().equals(sender) || msg.getReceiver().getEmail().equals(receiver)) {
                String a = sender.length() < receiver.length() ? sender + ":\t" + nameDiff(sender, receiver) : sender + ":\t";
                a += msg.getMeassage();
                list.add(a);
            } else if (msg.getSender().getEmail().equals(receiver) || msg.getReceiver().getEmail().equals(sender)) {
                String a = receiver.length() < sender.length() ? receiver + ":\t" + nameDiff(receiver, sender) : receiver + ":\t";
                a += msg.getMeassage();
                list.add(a);
            }
        }
        ChatWindow.getItems().addAll(list);
    }

    public String nameDiff(String a, String b) {
        return " ".repeat(Math.abs(a.length() - b.length()));
    }

    public User getUserByEmail(String email) {
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public void HandleMessageSent() {
        Message mess = new Message(currentUser, receiver, msg.getText());
        messages.addMessage(mess);
        new Chat().SaveMessages(messages);
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.users = new Database().ReadUsers();
    }
}
