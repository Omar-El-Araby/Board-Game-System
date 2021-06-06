import javafx.scene.layout.Pane;

import java.util.Random;
public abstract class Grid extends Pane{
    protected int x;
    protected int y;
    protected Tile[][] tiles;
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }
    public abstract void populateTiles(double height, double width);/*{
        int n = 0;
        int m = 0;
        for (int i = 0; i<x ; i++,n+= width/x, m=0)
            for (int j = 0; j<y ; j++,m += height/y )
                tiles[i][j] = new Tile(n,m,0);
    }*/
    public Grid(){}
    public Grid(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        tiles = new Tile[x][y];
        populateTiles(height,width);
    }
}