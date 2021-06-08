import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ControllerRegister {
    public TextField usr;
    public TextField pass;
    private final String currentFileLocation = "userCreds.json";
    private final File file = new File(currentFileLocation);
    private double xOffset = 0, yOffset = 0;    //For dragging the window.

    public void bgOnMousePressed(MouseEvent mouseEvent) {
        xOffset = Controller.controllerLogin.register.getX() - mouseEvent.getScreenX();
        yOffset = Controller.controllerLogin.register.getY() - mouseEvent.getScreenY();
    }

    public void bgOnMouseDragged(MouseEvent mouseEvent) {
        Controller.controllerLogin.register.setX(mouseEvent.getScreenX() + xOffset);
        Controller.controllerLogin.register.setY(mouseEvent.getScreenY() + yOffset);
    }
    public void registerClose(MouseEvent mouseEvent) {
        Controller.controllerLogin.register.close();
    }

    public void register(ActionEvent actionEvent) {
        String username = usr.getText();
        String password = pass.getText();
        try {
            String File = new String(Files.readAllBytes(Paths.get("userCreds.json")));
            JSONObject reader = new JSONObject(File);
            JSONArray usernames= reader.getJSONArray("Usernames");
            JSONArray passwords= reader.getJSONArray("Passwords");
            usernames.put(username);
            passwords.put(password);
            System.out.println(reader.toString());
            PrintWriter wrt = new PrintWriter(file);
            wrt.write(reader.toString()+" ");
            wrt.close();
        }catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        JOptionPane.showMessageDialog(null,
                "Registered Succesfully",
                "Register",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
