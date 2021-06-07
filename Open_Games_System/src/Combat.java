public final class Combat {
    public static class Weapon{
        private static int damage;
        private static String rolls;
        private static String attackString;
        private static void CalcDamage(characterSheet attacker, characterSheet attacked){

            for(int i=0; i< attacker.weaponRoll;i++){
                int roll = Dice.roll(6);
                damage+= roll + attacker.strMod;
                rolls += "( " + roll + " + " + attacker.strMod + " ) ";
            }
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
        public static String Attack(characterSheet attacker, characterSheet attacked){
            damage = 0;
            rolls= "Damage roll = ";
            attackString = null;
            AttemptAttack(attacker, attacked);
            attacked.HP -= damage;
            return attackString + rolls;
        }
    }

    public static void main(String[] args) {
        PlayerSheet a = new PlayerSheet("dolf",2,"knife",13);
        PlayerSheet b = new PlayerSheet("rolf",3, "sword",15);
        //Combat.Weapon.CalcDamage(a,b);
        System.out.println(Weapon.Attack(a,b));
        System.out.println(Weapon.Attack(b,a));
        System.out.printf("%s HP = %d \n%s HP = %d",a.name,a.HP, b.name, b.HP);
    }
}
