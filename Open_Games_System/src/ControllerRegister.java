import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControllerRegister {
    public TextField usr;
    public TextField pass;

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
    }
}
