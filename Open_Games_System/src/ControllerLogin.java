import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ControllerLogin {
    public TextField usr;
    public TextField pass;
    public CheckBox rememberme;
    public Stage register = new Stage();
    private JSONObject reader = new JSONObject();
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
        boolean flag=false;
        try{
            String File = new String(Files.readAllBytes(Paths.get("userCreds.json")));
            reader = new JSONObject(File);
        }catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        JSONArray usernames=reader.getJSONArray("Usernames");
        JSONArray passwords=reader.getJSONArray("Passwords");
        for(int i=0;i<usernames.length();i++)
        {
            if(usr.getText().equals(usernames.get(i))&&pass.getText().equals(passwords.get(i)))
            {
                JOptionPane.showMessageDialog(null,
                        "Login Successful",
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE);
                User.setCurrentUser(usr.getText());
                Main.controller.refreshUser();
                Main.controller.login.hide();
                flag=true;
            }
            if(usr.getText().equals(reader.getString("Admin"))&&pass.getText().equals(reader.getString("Admin_Passwords")))
            {
                JOptionPane.showMessageDialog(null,
                        "Admin Login Successful",
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE);
                User.setCurrentUser(usr.getText());
                Main.controller.refreshUser();
                Main.controller.login.hide();
                flag=true;
            }
        }
        if(!flag)
            JOptionPane.showMessageDialog(null,
                    "Login failed check password or username",
                    "Login",
                    JOptionPane.INFORMATION_MESSAGE);
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
