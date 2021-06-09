public class ContestedTile extends Tile{
    private int save = 10;
    private String contestType;
    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public String getContestType() {
        return contestType;
    }

    public void setContestType(String contestType) {
        this.contestType = contestType;
    }

    public ContestedTile(){
        type = "contested";
    }
    public ContestedTile(int x, int y, int position){
        super(x,y,position);
        type = "contested";
    }
    public ContestedTile(Tile tile){
        super(tile);
        type = "contested";
    }
}
