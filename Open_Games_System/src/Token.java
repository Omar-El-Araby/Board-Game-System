import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Token extends ImageView {
    public void setPosition(double x, double y){
        this.setX(x);
        this.setY(y);
    }
    public void setPosition(Tile z){
        this.setX(z.getX());
        this.setY(z.getY());
    }
    public Token(){}
    public Token(double x, double y, Image image){
        this.setX(x);
        this.setY(y);
        this.setImage(image);
    }

}
