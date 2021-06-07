public class MovementDND extends Movement{
    private DNDToken token; //took the entire token instead of its position to potentially apply status effects.
    private BattleMap map = new BattleMap();
    private int[] position = {4,4};
    public MovementDND(){}
    public MovementDND(DNDToken token){
        super(token);
        this.token = token;
    }

    @Override
    public void moveUp() {
        //System.out.printf("currX: %d\tcurrY: %d\n",map.getPositionX(),map.getPositionY());
        if(token.checkMaxMovement()) {
            toX = map.getTileUp().getX();
            toY = map.getTileUp().getY();
            map.moveTileUp();
        }
        //System.out.printf("toX: %d\ttoY: %d\n",map.getPositionX(),map.getPositionY());
    }
    public void moveDown(){
        //System.out.printf("currX: %d\tcurrY: %d\n",map.getPositionX(),map.getPositionY());
        if(token.checkMaxMovement()) {
            toX = map.getTileDown().getX();
            toY = map.getTileDown().getY();
            map.moveTileDown();
        }
        //System.out.printf("X: %d\tY: %d\n",map.getPositionX(),map.getPositionY());
    }
    public void moveLeft(){
        //System.out.printf("currX: %d\tcurrY: %d\n",map.getPositionX(),map.getPositionY());
        if(token.checkMaxMovement()) {
            toX = map.getTileLeft().getX();
            toY = map.getTileLeft().getY();
            map.moveTileLeft();
        }
        //System.out.printf("X: %d\tY: %d\n",map.getPositionX(),map.getPositionY());
    }
    public void moveRight(){
        //System.out.printf("currX: %d\tcurrY: %d\n",map.getPositionX(),map.getPositionY());
        if(token.checkMaxMovement()) {
            toX = map.getTileRight().getX();
            toY = map.getTileRight().getY();
            map.moveTileRight();
        }
        //System.out.printf("X: %d\tY: %d\n",map.getPositionX(),map.getPositionY());
    }
    public void moveTo(Tile tile){
        double toX = currX;
        double toY = currY;
        double incX = Main.width;
        double incY = Main.height;
        if(token.canMove()){
            toX = tile.getX();
            toY = tile.getY();
            if(toX < currX) incX = -incX;
            if(toY < currY) incY = -incY;
        }
        while(Math.abs(toX - currX) > token.maxMovement*Main.width)toX -= incX;
        while(Math.abs(toY - currY) > token.maxMovement*Main.height)toY -= incY;
        this.toX = toX;
        this.toY = toY;
    }
    public boolean checkSurroundings(String type){
        for(int i = -1;i<2;i++){
            for(int j = -1; j < 2; j++){
                Tile temp = map.getTile(map.getPositionX()+ i,map.getPositionY() + j);
                if(temp.getType() == type && !(i == 0 && j == 0 ))
                    return true;
            }
        }
        return false;
    }
}
