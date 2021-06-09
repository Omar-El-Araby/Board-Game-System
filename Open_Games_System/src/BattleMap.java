import javafx.stage.Screen;

public final class BattleMap extends Grid{
    private static int x = Main.divX; //all movements that use battlemap should have the same grid
    private static int y = Main.divY;
    private int[] position = {4,4};

    public BattleMap(){
        super.tiles = new Tile[x][y];
        populateTiles(Main.resolutionX,Main.resolutionY);
    }
    public BattleMap(int x, int y){
        tiles = new Tile[this.x][this.y];
        populateTiles(x,y);
    }
    public int getPositionX(){
        return position[0];
    }
    public int getPositionY(){
        return position[1];
    }
    @Override
    public void populateTiles(double height,double width) {
        int n = 0;
        int m = 0;
        for (int i = 0; i<x ; i++,n+= width/x, m=0)
            for (int j = 0; j<y ; j++,m += height/y )
                tiles[i][j] = new Tile(n,m,0); //TODO replace with TileFactory
    }
    public void checkTiles(){
        for(int i=0;i<10;i++){
            for(int j = 0; j<10;j++){
                System.out.printf("(%d,%d),\t",getTile(i,j).getX(),getTile(i,j).getY());
            }
            System.out.println();
        }
    }

    public Tile getTileUp(){
        return tiles[position[0]][position[1]-1];
    }
    public Tile getTileDown(){
        return tiles[position[0]][position[1]+1];
    }
    public Tile getTileLeft(){
        return tiles[position[0]-1][position[1]];
    }
    public Tile getTileRight(){
        return tiles[position[0]+1][position[1]];
    }
    public void moveTileX(int inc){
        if(position[0]+inc < x && position[0]+inc >= 0)position[0] += inc;
    }
    public void moveTileY(int inc){
        if(position[1]+inc < y && position[1]+inc >= 0)position[1] += inc;
    }
    public void moveTileUp(){
        //System.out.printf("pre-PositionY: %d\t",position[1]);
        tiles[position[0]][position[1]].moveToken(getTileUp());
        moveTileY(-1);
        //System.out.printf("post-PositionY: %d\t",position[1]);
    }
    public void moveTileDown(){
        //System.out.printf("pre-PositionY: %d\t",position[1]);
        tiles[position[0]][position[1]].moveToken(getTileDown());
        moveTileY(1);
        //System.out.printf("post-PositionY: %d\t",position[1]);
    }
    public void moveTileLeft(){ //correct
        //System.out.printf("pre-PositionX: %d\t",position[0]);
        tiles[position[0]][position[1]].moveToken(getTileLeft());
        moveTileX(-1);
        //System.out.printf("post-PositionX: %d\t",position[0]);
    }
    public void moveTileRight(){ //correct
        //System.out.printf("pre-PositionX: %d\t",position[0]);
        tiles[position[0]][position[1]].moveToken(getTileRight());
        moveTileX(1);
        //System.out.printf("post-PositionX: %d\t",position[0]);
    }
//    public static void main(String[] args) {
//        BattleMap map = new BattleMap(1920,1080);
//        System.out.printf("positionX: %d\tpositionY: %d",map.position[0],map.position[1]);
//        System.out.printf("up: %d,%d\tdown: %d,%d\tleft: %d,%d\tright: %d,%d\n",map.getTileUp().getX(),map.getTileUp().getY(),map.getTileDown().getX(),map.getTileDown().getY(),map.getTileLeft().getX(),map.getTileLeft().getY(),map.getTileRight().getX(),map.getTileRight().getY());
//        map.checkTiles();
//    }
}
