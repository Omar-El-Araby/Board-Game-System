public final class MovementFactory {
    public Movement getMovement(String type){
        switch (type){
            case "snake":return new MovementSnakeLadder();
            case "dnd": return new MovementDND();
            default: return null;
        }
    }
}
