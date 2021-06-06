import javafx.scene.image.Image;

public class DNDToken extends Token {
    private boolean selected = true;
    private boolean movable = true;
    double maxMovement = 30; //30 tiles ?
    private double currMovement = 0;
    String status;
    public DNDToken(int x, int y, Image img){
        super(x,y,img);

    }
    public boolean canMove(){
        if(selected && movable)return true;
        return false;
    }
    public void toggleSelect(){
        System.out.println("select toggled to :" + !selected);
        selected = !selected;
    }
    public void resetMovement(){
        currMovement = 0;
    }
    public boolean checkMaxMovement(){
        System.out.println(currMovement);
        if(currMovement< maxMovement && selected) {
            currMovement++;
            return true;
        }
        //System.out.println("Max movement reached");
        return false;
    }
}
