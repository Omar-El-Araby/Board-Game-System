import javafx.scene.image.Image;

public class DNDToken extends Token {
    Sheet playerSheet = new characterSheet("BruhMomento", new Integer[]{1, 5, 2, 6, 5},5);
    Sheet NPCSheet= new NPC_Sheet();
    private boolean selected = true;
    private boolean movable = true;
    double maxMovement = 6; //6 tiles * 5ft = 30, the average movement.
    private double currMovement = 0;
    String status;
    public DNDToken(int x, int y, Image img) throws Exception {
        super(x,y,img);
    }
    public boolean canMove(){
        return (selected && movable);
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
        if(currMovement < maxMovement && selected) {
            currMovement++;
            movable = true;
            return movable;
        }
        System.out.println("Max movement reached");
        movable = false;
        return movable;
    }
}
