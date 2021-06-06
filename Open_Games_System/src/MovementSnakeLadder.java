public class MovementSnakeLadder extends Movement{
//    public boolean reverseflagX = false;
//    public boolean reverseflagY = true;
//    public int limitX;
//    public int limitY;

    public MovementSnakeLadder(Token token){
        super(token);

//        toggleX = false;
//        toggleY = true;
    }
/*    public double moveDebX(){
            if(currX < 900 && !reverseflagX){
                currX+=10;

            }

            else if((currX > 0) && reverseflagX)
                currX-=10;
            else reverseflagX = !reverseflagX;
        System.out.println(currX);
        return currX;
    }*/
/*    public double moveX(){ //need to modify this to allow single movement conditioned by reaching the end of the board.
        if(currX < toX && !toggleX && currX < limitX)
            currX += this.getIncrement();
        else if(currX > toX && toggleX && currX > 0)
            currX -= this.getIncrement();
        else toggleX = !toggleX;
        return currX;
    }
    public double moveY(){ //need to modify this to allow single movement conditioned by reaching the end of the board.
        if(currY < toY && !toggleY && currY < limitY)
            currY += this.getIncrement();
        else if(currY > toY && toggleY && currY > 0)
            currY -= this.getIncrement();
        else toggleY = !toggleY;
        return currY;
    }*/
/*    public double moveDebY(){
            if(currY < 900 && !reverseflagY){
                currY+=100;

            }

            else if((currY > 0) && reverseflagY)
                currY-=100;
            else reverseflagY = !reverseflagY;
            System.out.println(currY);
        return currY;
    }*/
    public void moveUp() {
        if(currY > 0)
            currY = currY - getIncrementY();
    }
    public void moveDown() {
        if(currY < Main.resolutionY - getIncrementY())
            currY = currY + getIncrementY();
    }
    public void moveRight() {
        if(currX < Main.resolutionX - getIncrementX())
            currX = currX + getIncrementX();
//        toX += 80;
//        Main.wait(150);
    }
    public void moveLeft() {
        if(currX > 0)
            currX = currX - getIncrementX();
    }
    public void nextTile(Tile tile) {
        this.toX = tile.getX();
        this.toY =  tile.getY();
    }
}
