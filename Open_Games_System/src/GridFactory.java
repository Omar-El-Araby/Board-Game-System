public final class GridFactory {
    public Grid getGrid(String type){
        switch (type){
            case "snake": return new SnakeLadderGrid();
            case "dnd": return new BattleMap();
            default:return null;
        }

    }
}
