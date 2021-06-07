import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public final class Combat {
    public static class Weapon{
        private static int damage;
        private static String rolls;
        private static String attackString;
        private static void CalcDamage(characterSheet attacker, characterSheet attacked){

            //for(int i=0; i< attacker.weaponRoll;i++){
                int roll = Dice.roll(6);
                damage+= roll + attacker.getStatMod()[0];
                rolls += "( " + roll + " + " + attacker.getStatMod()[0] + " ) ";
            //}
            rolls += "= " + damage + ".\n";
        }
        private static void AttemptAttack(characterSheet attacker, characterSheet attacked){
            attackString = attacker.getPlayerName() + " is attacking " + attacked.getPlayerName() + " with his weapon.\n";
            int roll = Dice.roll(20);
            attackString += attacker.getPlayerName() + " has rolled ( " + roll + " + " + attacker.getStatMod()[0] + " ) which ";
            if(roll + attacker.getStatMod()[0] >= attacked.getAC()){
                attackString += "means his attack succeeded!\n";
                CalcDamage(attacker, attacked);
            }
            else {
                attackString += "means his attack failed!\n";
                rolls = "And he took no damage.";
            }
        }
        public static String Attack(DNDToken attacker, DNDToken attacked){
            damage = 0;
            rolls= "Damage roll = ";
            attackString = null;

            if(attacked.getSheet().getHP() > 0) {
                AttemptAttack(attacker.getSheet(), attacked.getSheet());
                attacked.getSheet().changeHP(-damage);
                return attackString + rolls;
            }
            else return "Target is dead";


        }
    }

    public static void main(String[] args) {
        characterSheet pl = new characterSheet("Dragonborn",new Integer[]{3,4,8,5,1,100},1,"src/stats/charactersheet.json");
        characterSheet pl2 = new characterSheet("DireWolf",new Integer[]{7,3,12,11,5,40},1,"src/stats/charactersheet2.json");
        //Combat.Weapon.CalcDamage(a,b);
        //System.out.println(Weapon.Attack(pl,pl2));
        //System.out.println(Weapon.Attack(b,a));
        System.out.printf("%s HP = %d \n%s HP = %d",pl.getPlayerName(),pl.getHP() ,pl2.getPlayerName(),pl2.getHP());
    }
}
