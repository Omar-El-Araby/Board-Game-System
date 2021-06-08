import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ControllerAttack {
    DNDToken sheet1;
    DNDToken sheet2;
    public Label tknName;

    public int tknHP;
    public Label tknTHP;
    public ImageView tknImg;
    public Label targetName;

    public int targetHP;
    public Label targetTHP;
    public ImageView targetImg;
    public void initAttacker(){
        sheet1 = Controller.gamer[Controller.selectedToken];
        tknName = new Label(sheet1.getSheet().getPlayerName());
        tknImg = new ImageView(sheet1.getImage());
        tknHP = sheet1.getSheet().getHP();
        tknTHP = new Label(sheet1.getSheet().getHP() + "/" + tknHP);
    }
    public void initTarget(){
        sheet2 = Controller.gamer[Controller.notSelected];


        targetName = new Label(sheet2.getSheet().getPlayerName());

        targetHP = sheet2.getSheet().getHP();
        targetTHP = new Label(sheet2.getSheet().getHP() + "/" + targetHP);
        targetImg = new ImageView(sheet2.getSheet().getPlayerName());
    }
    @FXML
    public void initialize() {
        initAttacker();
        initTarget();
    }
    @FXML
    public void Attack(){
        Combat.Weapon.Attack(sheet1,sheet2);
        initialize();
    }
    @FXML
    public void Switch(){
        Controller.DNDSwitchTokens();
        initialize();
    }
}
