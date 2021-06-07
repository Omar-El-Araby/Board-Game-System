public class TrappedTile extends ContestedTile{
    private int damage = 3;
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public TrappedTile(){
        type = "trapped";
    }
    public TrappedTile(int x, int y, int position){
        super(x,y,position);
        type = "trapped";
    }
    public TrappedTile(Tile tile){
        super(tile);
        type = "trapped";
    }
}
