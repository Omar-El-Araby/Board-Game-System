public class PlayerSheet {
    String name;
    public int AC;
    public int HP = 40;
    int str; int strMod;
    int dex; int dexMod;
    int con; int conMod;
    int intl; int intMod;
    int wis; int wisMod;
    int chari; int charMod;
    String weapon;
    int weaponRoll = 2;
    public PlayerSheet(String name,int strMod, String weapon, int AC){
        this.name = name;
        this.strMod = strMod;
        this.weapon = weapon;
        this.AC = AC;
    }
}
