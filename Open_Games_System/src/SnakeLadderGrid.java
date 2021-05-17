public class SnakeLadderGrid extends Grid{
    private Tile[] tiles;
    boolean toggle = true;
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public SnakeLadderGrid(){}
    public SnakeLadderGrid(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        tiles = new Tile[x*y];
        populateTiles(height,width);
    }
    @Override
    public void populateTiles(int height, int width) {
        int inc = width/x;
        int n = - inc; //starting point of x at the left
        int m = height - height/y; //last point at y - 1 tile
        int count = 0; // will always be x * y
        /*for (int i = 0; i<x ; i++,n+= width/x, m=0)
            for (int j = 0; j<y ; j++,m += height/y )
                tiles[i][j] = new Tile(n,m,0);*/
        for(int i = 0; i < y ; i++,m -= height/y,inc = -inc) {
            for (int j = 0; j < x; j++) {
                if(toggle){
                    n += inc;
                }
                else toggle = !toggle;
                tiles[count] = new Tile(n, m, count++);

            }
            toggle = !toggle;
        }
    }

    public Tile getTile(int num) {
        return tiles[num];
    }
    public void setTile(int num, Tile tile){ tiles[num] = tile;}
    public Tile nextPosition() {
        if(position < x*y - 1)
            position++;
        position = getTile(position).getPosition();
        return getTile(position);
    }
    public void togglePosition(int i)
    {
        getTile(position+i).toggleOccupation();
    }
    public void toggleCurrTile(){
        getTile(position).toggleOccupation();
    }
    public void toggleFutureTile(int i){
        getTile(position+i).toggleOccupation();
    }
    public void setLadder(){
        int[] posA = {7,20,49,42,53,61,65,79};
        int[] posB = {25,81,90,76,92,95,86,99};
        for(int i = 0 ; i < 8 ; i++)
            tiles[posA[i]] = new TeleportTile(tiles[posA[i]],tiles[posB[i]]);
    }
    public void setSnake(){
        int[] posA = {72,45,54,47,51,58,82,43,94,91};
        int[] posB = {0,4,6,8,10,16,18,21,23,50};
        for(int i = 0 ; i < 10 ; i++)
            tiles[posA[i]] = new TeleportTile(tiles[posA[i]],tiles[posB[i]]);
    }
    /*public static void main(String[] args) {
        SnakeLadderGrid grid = new SnakeLadderGrid(3,3,300,300);
        for(int i =0 ; i < 9; i++)
            System.out.printf("iter: %d\tX: %d\tY: %d\n",i,grid.getTile(i).getX(),grid.getTile(i).getY());
    }*/
}