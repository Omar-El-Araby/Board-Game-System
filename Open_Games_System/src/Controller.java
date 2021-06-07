
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class Controller {
    public Button usrBtn;
    public Label usrName;
    boolean rememberme = User.getRememberme();
    boolean btnFlag = false;
    public Stage login = new Stage();
    static public ControllerLogin controllerLogin;
    Token playerO = new Token(0,0,new Image("file:src/assets/O.png"));
    Token playerX = new Token(0,0,new Image("file:src/assets/X.png"));
    SnakeLadderGrid gridO = new SnakeLadderGrid(10,10,Main.resolutionX,Main.resolutionY);
    SnakeLadderGrid gridX = new SnakeLadderGrid(10,10,Main.resolutionX,Main.resolutionY);
    Canvas canvas = new Canvas(Main.resolutionX,Main.resolutionY);
//    MovementSnakeLadder pain = new MovementSnakeLadder(playerO);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    Image bg = new Image("file:src/assets/Snake_ladder_BG.jpg");
    boolean playerFlag = true;
    boolean singlePlayer = true;
    DNDToken test = new DNDToken(0,0,new Image("file:src/assets/O.png"));
    DNDToken test1 = new DNDToken(0,0,new Image("file:src/assets/X.png"));
    BattleMap map = new BattleMap();


    @FXML
    public void initialize() throws IOException {
        login.initStyle(StageStyle.UNDECORATED);
        login.setResizable(false);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        controllerLogin = loader.getController();
        login.setTitle("Login");
        login.setScene(new Scene(root));
        if(!rememberme) {
            User.setCurrentUser("Guest");
        }
        refreshUser();
    }

    public void DND(ActionEvent actionEvent){
        Main.mainStage.hide();
        Stage DNDStage = new Stage();
        test.setFitWidth(Main.resolutionX/10);
        test.setFitHeight(Main.resolutionY/10);
        test.setPosition(map.getTile(4,4));
        test1.setFitWidth(Main.resolutionX/10);
        test1.setFitHeight(Main.resolutionY/10);
        test1.setPosition(map.getTile(4,4));
        test1.toggleSelect();
        MovementDND mover = new MovementDND(test);
        MovementDND mover1 = new MovementDND(test1);
        System.out.println("circX: "+test.getX()+"\tcircY: "+test.getY());
        System.out.println("crossX: "+test1.getX()+"\tcrossY: "+test1.getY());
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

        playerO.setFitWidth(Main.resolutionX/10);
        playerO.setFitHeight(Main.resolutionY/10);
        playerO.setPosition(gridO.getTile(0));
        playerX.setFitWidth( Main.resolutionX/10);
        playerX.setFitHeight( Main.resolutionY/10);
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

                if(singlePlayer) {
                    boolean flag = true;
                    if(event.getCharacter().charAt(0) == ' ') {
                        int roll = Dice.roll(6);
                        JOptionPane.showMessageDialog(null,
                                roll,
                                "Your Roll",
                                JOptionPane.INFORMATION_MESSAGE);
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
                                    "You won!!",
                                    "Congratulations",
                                    JOptionPane.INFORMATION_MESSAGE);
                            Main.mainStage.show();
                            User.incrementWin();
                            snekStage.close();
                            flag = false;
                        }
                        if(flag) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            roll = Dice.roll(6);
                            JOptionPane.showMessageDialog(null,
                                    roll,
                                    "CPU Roll",
                                    JOptionPane.INFORMATION_MESSAGE);
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
                                        "Computer wins!!",
                                        "Sadness ensues",
                                        JOptionPane.INFORMATION_MESSAGE);
                                Main.mainStage.show();
                                User.incrementLoss();
                                snekStage.close();
                            }
                        }
                    }
                }
                else {
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
                    }
                    else if(event.getCharacter().charAt(0) == 'a'){
                        pain.nextTile(gridO.getTile(0));
                        suffering.nextTile(gridX.getTile(0));
                    }
                     //System.out.println(gridO.position);
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

    public void usrChk(ActionEvent actionEvent) {
        if(btnFlag) {
            User.setRememberme(false);
            User.setCurrentUser("Guest");
            refreshUser();
            JOptionPane.showMessageDialog(null,
                    "Logged out successfully!",
                    "Logout",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            login.show();
        }
    }

    public void refreshUser() {
        if(Objects.equals(User.getCurrentUser(), "Guest")) {
            usrBtn.setText("Log in");
            btnFlag = false;
        }
        else {
            usrBtn.setText("Log out");
            btnFlag = true;
        }
        usrName.setText(User.getCurrentUser());
    }

    public void stats(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,
                "Wins: " + User.getWin() + "\nLosses: " + User.getLoss(),
                "Stats",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
