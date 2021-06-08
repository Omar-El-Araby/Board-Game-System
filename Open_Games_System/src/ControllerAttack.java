import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerAttack {
    DNDToken sheet1;
    DNDToken sheet2;
    public Label tknName = new Label();
    public Label tknStats= new Label();
    public int tknHP;
    public Label tknTHP= new Label();
    public ImageView tknImg;
    public Label targetName= new Label();
    public Label targetStats= new Label();
    public int targetHP;
    public Label targetTHP= new Label();
    public ImageView targetImg = new ImageView();
    public void initAttacker(){
        sheet1 = Controller.gamer[Controller.selectedToken];
        tknName.setText(sheet1.getSheet().getPlayerName());
        tknStats.setText("Your stats: " + sheet1.getSheet().getStats().toString() + "\nAC: " + sheet1.getSheet().getAC());
        tknImg = new ImageView(sheet1.getImage());
        tknHP = sheet1.getSheet().getHP();
        tknTHP.setText(sheet1.getSheet().getHP() + "/" + tknHP);
    }
    public void initTarget(){
        sheet2 = Controller.gamer[Controller.notSelected];
        targetName.setText(sheet2.getSheet().getPlayerName());
        targetStats.setText("Target stats: " + sheet2.getSheet().getStats().toString()+ "\nAC: " + sheet2.getSheet().getAC());
        targetHP = sheet2.getSheet().getHP();
        targetTHP.setText(sheet2.getSheet().getHP() + "/" + targetHP);
        targetImg = new ImageView(sheet2.getImage());
    }
    @FXML
    public void initialize() {
        init();
    }
    @FXML
    public void Attack() {
        Combat.Weapon.Attack(sheet1,sheet2);
        init();
    }
    @FXML
    public void Switch() {
        Controller.DNDSwitchTokens();
        init();
    }

    public void init() {
        initAttacker();
        initTarget();
    }

    private double xOffset = 0, yOffset = 0;    //For dragging the window.

    public void bgOnMousePressed(MouseEvent mouseEvent) {
        xOffset = Main.controller.attackStage.getX() - mouseEvent.getScreenX();
        yOffset = Main.controller.attackStage.getY() - mouseEvent.getScreenY();
    }

    public void bgOnMouseDragged(MouseEvent mouseEvent) {
        Main.controller.attackStage.setX(mouseEvent.getScreenX() + xOffset);
        Main.controller.attackStage.setY(mouseEvent.getScreenY() + yOffset);
    }

    public void attackClose(MouseEvent mouseEvent) {
        Main.controller.attackStage.hide();
    }
}
