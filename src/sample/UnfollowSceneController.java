package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Az osztály a kikövetési oldalon található funkciókat valósítja meg
 */

public class UnfollowSceneController {
    @FXML
    private Button NoButton;
    private User currentUser;
    private User followUser;
    private AllUsers users = new Database().ReadUsers();

    /**
     * A függvény bezárja az oldalt
     */

    @FXML
    public void HandleNoButton() {
        Stage stage = (Stage) NoButton.getScene().getWindow();
        stage.close();
    }

    /**
     * A függvény bezárja az oldalt és kiköveti az adott felhasználót
     */

    public void HandleYesButton() {
        currentUser.getFriends().remove(followUser);
        getUserByEmail(currentUser.getEmail()).AddFriend(getUserByEmail(followUser.getEmail()));
        new Database().SaveUsers(users);
        Stage stage = (Stage) NoButton.getScene().getWindow();
        stage.close();
    }

    /**
     * A függvény beállítja az éppen bejelentkezett felhasználót
     */

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * A függvény visszaad egy felhasználó (User) típust egy string alapján (e-mail)
     */

    public User getUserByEmail(String email) {
        for (User user : users.getUsers()) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    /**
     * A függvény beállítja, hogy melyik usert akarjuk éppen kikövetni
     */

    public void setFollowUser(User followUser) {
        this.followUser = followUser;
    }
}