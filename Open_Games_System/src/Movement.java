public abstract class Movement {
    protected double currX;
    protected double currY;
    protected double toX;
    protected double toY;
    protected boolean toggleX = true;
    protected boolean toggleY = true;
    private double increment = 10;  //(double) Main.resolution/10;
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
    public double getIncrement() {
        return increment;
    }
    public void setIncrement(double increment) {
        this.increment = increment;
    }
    public Movement(){}
    public  Movement(Token token){
        currX = token.getX();
        currY = token.getY();
    }
    public double moveX(){
        if(currX < toX)
            currX += increment;
        else if(currX > toX)
            currX -= increment;
        return currX;
    }
    public double moveY(){
        if(currY < toY)
            currY += increment;
        else if(currY > toY)
            currY -= increment;
        return currY;
    }
    public boolean isDoneX(){
        return (!(currX < toX + increment) || !(currX <= toX - increment)) && (!(currX >= toX - increment) || !(currX > toX + increment));
    }
    public boolean isDoneY(){
        return (!(currY < toY + increment) || !(currY <= toY - increment)) && (!(currY >= toY - increment) || !(currY > toY + increment));
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
