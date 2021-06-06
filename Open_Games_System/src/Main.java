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
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main extends Application {
    static public int resolution = 800;
    static public Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //JSONArray array = new JSONArray();
       // WebView webView = new WebView();

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
