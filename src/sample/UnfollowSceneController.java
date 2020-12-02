package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UnfollowSceneController {
    @FXML
    private Button NoButton;
    @FXML
    private Button YesButton;
    private User currentUser;
    private User followUser;
    private AllUsers users = new Database().ReadUsers();

    @FXML
    public void HandleNoButton() {
        Stage stage = (Stage) NoButton.getScene().getWindow();
        stage.close();
    }

    public void HandleYesButton() {
        currentUser.getFriends().remove(followUser);
        getUserByEmail(currentUser.getEmail()).AddFriend(getUserByEmail(followUser.getEmail()));
        new Database().SaveUsers(users);
        Stage stage = (Stage) NoButton.getScene().getWindow();
        stage.close();
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getUserByEmail(String email) {
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public void setFollowUser(User followUser) {
        this.followUser = followUser;
    }
}