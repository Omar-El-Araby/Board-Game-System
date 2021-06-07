import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main extends Application {
//    static public double resolutionX = Screen.getPrimary().getBounds().getMaxX() * 0.7;
//    static public double resolutionY = Screen.getPrimary().getBounds().getMaxY() * 0.7;
    static public int divX = 30;
    static public int divY = 30;
    static public double resolutionX = 960;
    static public double resolutionY = 960;
    static public double width = resolutionX/divX;
    static public double height = resolutionY/divY;
    static public Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;
        mainStage.initStyle(StageStyle.UNDECORATED);
        mainStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainStage.setTitle("Main Menu");
        mainStage.setScene(new Scene(root));
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}