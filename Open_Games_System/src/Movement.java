public abstract class Movement {
    protected double currX;
    protected double currY;
    protected double toX;
    protected double toY;
    protected boolean toggleX = true;
    protected boolean toggleY = true;
    private double incrementX = Main.resolutionX/100;//10;  //(double) Main.resolution/10;
    private double incrementY = Main.resolutionY/100;
    public double getCurrX() {
        return (currX);
    }
    public double getCurrY() {
        return (currY);
    }
    public double getToX() {
        return toX;
    }
    public double getToY() {
        return toY;
    }
    public double getIncrementX() {
        return incrementX;
    } //come back and set one for y
    public void setIncrementX(double incrementX) {
        this.incrementX = incrementX;
    }
    public double getIncrementY(){return incrementY;}
    public void setIncrementY(double incrementY){this.incrementY = incrementY;}
    public Movement(){}
    public  Movement(Token token){
        setPosition(token);
    }
    public void setPosition(Token token){
        currX = token.getX();
        currY = token.getY();
        toX = token.getX();
        toY = token.getY();
    }
    public double moveX(){
        if(currX < toX - incrementX)
            currX += incrementX;
        else if(currX > toX + incrementX)
            currX -= incrementX;
        return currX;
    }
    public double moveY(){
        if(currY < toY - incrementY)
            currY += incrementY;
        else if(currY > toY + incrementY)
            currY -= incrementY;
        return currY;
    }
    public boolean isDoneX(){
        return (!(currX < toX + incrementX) || !(currX <= toX - incrementX)) && (!(currX >= toX - incrementX) || !(currX > toX + incrementX));
    }
    public boolean isDoneY(){
        return (!(currY < toY + incrementY) || !(currY <= toY - incrementY)) && (!(currY >= toY - incrementY) || !(currY > toY + incrementY));
    }
    public boolean isDone(){
        return isDoneX() && isDoneY();
    }
    public void stopX(){
        toggleX = false;
    }
    public void startX(){
        toggleX = true;
    }
    public void stopY(){
        toggleY = false;
    }
    public void startY(){
        toggleY = true;
    }
    public void moveTo(Tile tile){
        toX = tile.getX();
        toY = tile.getY();
        System.out.println("toX: "+toX+"\ttoY: "+ toY);
    }
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();
}
