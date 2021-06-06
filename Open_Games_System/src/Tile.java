public class Tile {
    private int x;
    private int y;
    protected String type;
    private String prompt;
    private int position;
    protected boolean occupied = false;
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getPosition() {
        toggleOccupation();
        return position;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void toggleOccupation(){
        occupied = !occupied;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Tile(){
        type = "default";
    }
    public Tile(int x, int y){
        this.x = x;
        this.y = y;
        type = "default";
    }
    public Tile(int x, int y, int position){
        type = "default";
        this.x = x;
        this.y = y;
        this.position = position;
    }
    public Tile(Tile tile){
        x = tile.x;
        y = tile.y;
        type = tile.type;
        position = tile.position;
        occupied = tile.occupied;
    }
    public Tile(int x, int y,int position, String prompt){
        type = "default";
        this.x = x;
        this.y = y;
        this.position = position;
        this.prompt = prompt;
    }
}
