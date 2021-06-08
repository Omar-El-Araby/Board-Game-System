import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DNDToken extends Token {
    private characterSheet Sheet;// = new characterSheet("BruhMomento", new Integer[]{1, 5, 2, 6, 5},5);
    //private boolean selected = true;
    private boolean movable = true;
    double maxMovement = 6; //6 tiles * 5ft = 30, the average movement.
    private double currMovement = 0;
    String status;

    public void setSheet(characterSheet sheet) {
        Sheet = sheet;
    }

    public characterSheet getSheet() {
        return Sheet;
    }

    public DNDToken(int x, int y, Image img) {
        super(x,y,img);
    }
    public DNDToken(int x, int y, Image img, characterSheet sheet){
        this.setX(x);
        this.setY(y);
        this.setImage(img);
        this.Sheet = sheet;
    }
    public DNDToken(){}
    public boolean canMove(){
        return (/*selected &&*/ movable);
    }
    /*public void toggleSelect(){
        System.out.println("select toggled to :" + !selected);
        selected = !selected;
    }*/
    public void resetMovement(){
        currMovement = 0;
    }
    public boolean checkMaxMovement(){
        System.out.println(currMovement);
        if(currMovement < maxMovement /*&& selected*/) {
            currMovement++;
            movable = true;
            return movable;
        }
        System.out.println("Max movement reached");
        movable = false;
        return movable;
    }
}
