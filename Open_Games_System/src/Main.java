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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main extends Application {
//    static public double resolutionX = Screen.getPrimary().getBounds().getMaxX() * 0.7;
//    static public double resolutionY = Screen.getPrimary().getBounds().getMaxY() * 0.7;
    static public double resolutionX = 800;
    static public double resolutionY = 800;
    static public Stage mainStage;
    static public Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        String musicFile = "src/assets/menumusic.mp3";                    //Worthless failed attempt to add menu music
//        Media sound = new Media(new File(musicFile).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();

        mainStage = primaryStage;
        mainStage.initStyle(StageStyle.UNDECORATED);
        mainStage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        mainStage.setTitle("Main Menu");
        mainStage.setScene(new Scene(root));
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}