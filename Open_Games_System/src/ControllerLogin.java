import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;

public class ControllerLogin {
    public TextField usr;
    public TextField pass;
    public CheckBox rememberme;
    public Stage register = new Stage();

    public void initialize() throws IOException {
        register.initStyle(StageStyle.UNDECORATED);
        register.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        register.setTitle("Login");
        register.setScene(new Scene(root));
    }

    public void register(MouseEvent mouseEvent) {
        register.show();
    }

    public void login(ActionEvent actionEvent) {
        if(usr.getText().isEmpty() || pass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Please enter Username and Password",
                    "Invalid login",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            User.setCurrentUser(usr.getText());
            if (rememberme.isSelected()) User.setRememberme(true);
            else User.setRememberme(false);
            Main.controller.refreshUser();
            Main.controller.login.hide();
        }
    }

    private double xOffset = 0, yOffset = 0;    //For dragging the window.

    public void bgOnMousePressed(MouseEvent mouseEvent) {
        xOffset = Main.controller.login.getX() - mouseEvent.getScreenX();
        yOffset = Main.controller.login.getY() - mouseEvent.getScreenY();
    }

    public void bgOnMouseDragged(MouseEvent mouseEvent) {
        Main.controller.login.setX(mouseEvent.getScreenX() + xOffset);
        Main.controller.login.setY(mouseEvent.getScreenY() + yOffset);
    }

    public void loginClose(MouseEvent mouseEvent) {
        Main.controller.login.close();
    }
}
