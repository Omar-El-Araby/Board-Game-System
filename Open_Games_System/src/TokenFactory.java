public class TokenFactory {
    public Token getToken(String type){
        switch (type){
            case "dnd": return new DNDToken();
            default: return new Token();
        }
    }
}
