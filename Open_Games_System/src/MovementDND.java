public class MovementDND extends Movement{
    private Token token; //took the entire token instead of its position to potentially apply status effects.
    static private BattleMap map = new BattleMap();

    public MovementDND(){}
    public MovementDND(Token token){
        super(token);
        this.token = token;
    }

    @Override
    public void moveUp() {
        System.out.printf("currX: %f\tcurrY: %f\n",currX,currY);
        toX = map.getTileUp().getX();
        toY = map.getTileUp().getY();
        map.moveTileUp();
        System.out.printf("toX: %f\ttoY: %f\n",toX,toY);
    }
    public void moveDown(){
        System.out.printf("currX: %f\tcurrY: %f\n",currX,currY);
        toX = map.getTileDown().getX();
        toY = map.getTileDown().getY();
        map.moveTileDown();
        System.out.printf("X: %f\tY: %f\n",toX,toY);
    }
    public void moveLeft(){
        System.out.printf("currX: %f\tcurrY: %f\n",currX,currY);
        toX = map.getTileLeft().getX();
        toY = map.getTileLeft().getY();
        map.moveTileLeft();
        System.out.printf("X: %f\tY: %f\n",toX,toY);
    }
    public void moveRight(){
        System.out.printf("currX: %f\tcurrY: %f\n",currX,currY);
        toX = map.getTileRight().getX();
        toY = map.getTileRight().getY();
        map.moveTileRight();
        System.out.printf("X: %f\tY: %f\n",toX,toY);
    }
}
