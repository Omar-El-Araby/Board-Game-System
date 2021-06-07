
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;

public class Controller {
    Token playerO = new Token(0,0,new Image("file:src/assets/O.png"));
    Token playerX = new Token(0,0,new Image("file:src/assets/X.png"));
    SnakeLadderGrid gridO = new SnakeLadderGrid(10,10,Main.resolutionX,Main.resolutionY);
    SnakeLadderGrid gridX = new SnakeLadderGrid(10,10,Main.resolutionX,Main.resolutionY);
    Canvas canvas = new Canvas(Main.resolutionX,Main.resolutionY);
//    MovementSnakeLadder pain = new MovementSnakeLadder(playerO);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    Image bg = new Image("file:src/assets/Snake_ladder_BG.jpg");
    boolean playerFlag = true;
    DNDToken test = new DNDToken(0,0,new Image("file:src/assets/O.png"));
    DNDToken test1 = new DNDToken(0,0,new Image("file:src/assets/X.png"));
    BattleMap map = new BattleMap();
    @FXML
    public void initialize() {

    }

    public void DND(ActionEvent actionEvent){
        Main.mainStage.hide();
        Stage DNDStage = new Stage();
        test.setFitWidth(Main.width);
        test.setFitHeight(Main.height);
        test.setPosition(map.getTile(4,4));
        test1.setFitWidth(Main.width);
        test1.setFitHeight(Main.height);
        test1.setPosition(map.getTile(4,4));
        test1.toggleSelect();
        MovementDND mover = new MovementDND(test);
        MovementDND mover1 = new MovementDND(test1);
        //System.out.println("circX: "+test.getX()+"\tcircY: "+test.getY());
        //System.out.println("crossX: "+test1.getX()+"\tcrossY: "+test1.getY());
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseMonitor.getPos(event);
                //System.out.printf("tileX : %d\n",MouseMonitor.calcX());
                //System.out.printf("tileY : %d\n",MouseMonitor.calcY());
                mover.moveTo(map.getTile(MouseMonitor.calcX(),MouseMonitor.calcY()));
            }
        });
        EventHandler<KeyEvent> movent = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().charAt(0) == 'w'){
                    System.out.printf("token: %b\ttoken1: %b\n",test.checkMaxMovement(),test1.checkMaxMovement());
                    mover.moveUp();
                    mover1.moveUp();
                }
                else if(event.getCharacter().charAt(0) == 's') {
                    mover.moveDown();
                    mover1.moveDown();
                }
                else if(event.getCharacter().charAt(0) == 'a') {
                    mover.moveLeft();
                    mover1.moveLeft();
                }
                else if(event.getCharacter().charAt(0) == 'd') {
                    mover.moveRight();
                    mover1.moveRight();
                }
                else if(event.getCharacter().charAt(0) == ' ')
                {
                    test1.toggleSelect();
                    test.toggleSelect();
                }
                else if(event.getCharacter().charAt(0) == 'p'){
                    test.resetMovement();
                    test1.resetMovement();
                }
            }
        };

        //Thread animation = new Thread(new Animator(gc, bg, test,mover));
        Thread animation = new Thread(new Animator(gc, bg, test, test1, mover, mover1));
        animation.start();
        Group root = new Group(canvas);
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_TYPED, movent);
        DNDStage.setTitle("Main Menu");
        DNDStage.setScene(scene);
        DNDStage.show();
    }


    public void snek(ActionEvent actionEvent) {
        Main.mainStage.hide();
        Stage snekStage = new Stage();

        playerO.setFitWidth(Main.width);
        playerO.setFitHeight(Main.height);
        playerO.setPosition(gridO.getTile(0));
        playerX.setFitWidth( Main.width);
        playerX.setFitHeight( Main.height);
        playerX.setPosition(gridO.getTile(0));
        MovementSnakeLadder pain = new MovementSnakeLadder(playerO);
        MovementSnakeLadder suffering = new MovementSnakeLadder(playerX);
        System.out.println("X: "+playerO.getX()+"\tY: "+playerO.getY());
        System.out.println("X: "+playerX.getX()+"\tY: "+playerX.getY());
        /*gridO.setTile(7,new TeleportTile(gridO.getTile(7), gridO.getTile(13)));
        gridX.setTile(7,new TeleportTile(gridO.getTile(7), gridO.getTile(13)));
        gridO.setTile(15,new TeleportTile(gridO.getTile(15), gridO.getTile(1)));
        gridX.setTile(15,new TeleportTile(gridO.getTile(15), gridO.getTile(1)));*/
        gridO.setLadder();
        gridO.setSnake();
        gridX.setLadder();
        gridX.setSnake();
        EventHandler<KeyEvent> movent = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
               // if(event.getCharacter().charAt(0) == 'w')
                    //pain.moveUp();

                //else if(event.getCharacter().charAt(0) == 's')
                    //pain.moveDown();

              //  else if(event.getCharacter().charAt(0) == 'a')
                    //pain.moveLeft();

             //   else if(event.getCharacter().charAt(0) == 'd')
                    //pain.moveRight();

                 if(event.getCharacter().charAt(0) == ' ') {
                     int roll = Dice.roll(6);
                     if(playerFlag) {
                         gridO.toggleFutureTile(roll);
                         for(int i = 0; i < roll; ++i) {
                             pain.nextTile(gridO.nextPosition());
//                             try {
//                                 Thread.sleep(150);
//                             } catch (InterruptedException e) {
//                                 e.printStackTrace();
//                             }
                         }
                         if(gridO.getPosition() == 99) {
                             JOptionPane.showMessageDialog(null,
                                     "YOU WON!!",
                                     "congeration",
                                     JOptionPane.INFORMATION_MESSAGE);
                             Main.mainStage.show();
                             snekStage.hide();
                         }
                         playerFlag = !playerFlag;
                     }
                     else {
                         gridX.toggleFutureTile(roll);
                         for(int i = 0; i < roll; ++i) {
                             suffering.nextTile(gridX.nextPosition());
//                             try {
//                                 Thread.sleep(150);
//                             } catch (InterruptedException e) {
//                                 e.printStackTrace();
//                             }
                         }
                         if(gridX.getPosition() == 99) {
                             JOptionPane.showMessageDialog(null,
                                     "YOU WON!!",
                                     "congeration",
                                     JOptionPane.INFORMATION_MESSAGE);
                             Main.mainStage.show();
                             snekStage.hide();
                         }
                         playerFlag = !playerFlag;
                     }
                     //System.out.println(gridO.position);
                }
                 else if(event.getCharacter().charAt(0) == 'a'){
                     pain.nextTile(gridO.getTile(0));
                     suffering.nextTile(gridX.getTile(0));
                 }
//                    boolean flag = true;
//                    int roll = Dice.roll(6) + 1;
//                    for(int i = 0; i < roll; ++i) {
//                        if(pain.getCurrX() < 0.9 * Main.resolution && flag) pain.moveRight();
//                        else if (pain.getCurrX() > 0 && !flag) pain.moveLeft();
//                        else {
//                            pain.moveUp();
//                            flag = !flag;
//                        }
//                    }
//                }
            }
        };

        Thread animation = new Thread(new Animator(gc, bg, playerO, playerX, pain, suffering));
        animation.start();

        Group root = new Group(canvas);
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_TYPED, movent);
        snekStage.setTitle("Main Menu");
        snekStage.setScene(scene);
        snekStage.show();
    }

    public void mainExit(ActionEvent actionEvent) {
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
    }
}
