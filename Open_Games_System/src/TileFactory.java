public final class TileFactory {
    public Tile getPlan(String type){
        switch (type){
            case "trapped": return new TrappedTile();
            case "teleport": return new TeleportTile();
            case "obstacle": return new ObstacleTile();
            case "contested": return new ContestedTile();
            default: return new Tile();
        }

    }
}
