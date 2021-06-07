import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class DNDController {
    DNDToken test = new DNDToken(0,0,new Image("file:src/assets/O.png"));
    BattleMap map = new BattleMap();
    Canvas canvas = new Canvas(Main.resolutionX,Main.resolutionY);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    Image bg = new Image("file:src/assets/Snake_ladder_BG.jpg");

    public DNDController() throws Exception {
    }

    public void DND(ActionEvent actionEvent){
        Main.mainStage.hide();
        Stage DNDStage = new Stage();
        test.setFitWidth(Main.width);
        test.setFitHeight(Main.height);
        test.setPosition(map.getTile(4,4));
        MovementDND mover = new MovementDND(test);
        System.out.println("X: "+test.getX()+"\tY: "+test.getY());
        EventHandler<KeyEvent> movent = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().charAt(0) == 'w')
                    mover.moveUp();
                else if(event.getCharacter().charAt(0) == 's')
                    mover.moveDown();
                else if(event.getCharacter().charAt(0) == 'a')
                    mover.moveLeft();
                else if(event.getCharacter().charAt(0) == 'd')
                    mover.moveRight();
            }
        };
        Thread animation = new Thread(new Animator(gc, bg, test,mover));
        animation.start();
        Group root = new Group(canvas);
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_TYPED, movent);
        DNDStage.setTitle("Main Menu");
        DNDStage.setScene(scene);
        DNDStage.show();
    }
/*    public void mainExit(javafx.event.ActionEvent actionEvent) {
        Main.mainStage.close();
    }

    private double xOffset = 0, yOffset = 0;    //For dragging the window.

    public void bgOnMousePressed(MouseEvent mouseEvent) {
        xOffset = Main.mainStage.getX() - mouseEvent.getScreenX();
        yOffset = Main.mainStage.getY() - mouseEvent.getScreenY();
    }

    public void bgOnMouseDragged(MouseEvent mouseEvent) {
        Main.mainStage.setX(mouseEvent.getScreenX() + xOffset);
        Main.mainStage.setY(mouseEvent.getScreenY() + yOffset);
    }*/
}
