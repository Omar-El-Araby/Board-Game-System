public class TeleportTile extends Tile{
    Tile targetTile;

    public Tile getTargetTile() {
        return targetTile;
    }

    public void setTargetTile(Tile targetTile) {
        this.targetTile = targetTile;
    }
    public int getX(){
        if(occupied) return targetTile.getX();
        else return super.getX();
    }
    public int getY(){
        if(occupied)return targetTile.getY();
        else return super.getY();
    }
    public int getPosition(){
        if(occupied){
            this.occupied = false;
            return targetTile.getPosition();
        }
        else return super.getPosition();
    }
    public TeleportTile(){}
    public TeleportTile(int x, int y, int position){
        super(x, y, position);
    }
    public TeleportTile(int x, int y,int position, Tile targetTile){
        super(x, y,position);
        this.targetTile = targetTile;
    }
    public TeleportTile(Tile tile, Tile targetTile){
        super(tile);
        this.targetTile = targetTile;
    }
}
