public class ObstacleTile extends ContestedTile{
    private int penalty;
    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public ObstacleTile(){
        type = "obstacle";
    }
    public ObstacleTile(int x, int y, int position){
        super(x,y,position);
        type = "obstacle";
    }
    public ObstacleTile(Tile tile){
        super(tile);
        type = "obstacle";
    }
}
