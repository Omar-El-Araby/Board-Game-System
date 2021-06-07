import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Token extends ImageView {
    Sheet sheet;
    private int posX;
    private int posY;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setPos(int x, int y){
        posX = x;
        posY = y;
    }

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
