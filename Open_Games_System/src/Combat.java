public final class Combat {
    public static class Weapon{
        private static int damage;
        private static String rolls;
        private static String attackString;
        private static void CalcDamage(PlayerSheet attacker, PlayerSheet attacked){
            for(int i=0; i< attacker.weaponRoll;i++){
                int roll = Dice.roll(6);
                damage+= roll + attacker.strMod;
                rolls += "( " + roll + " + " + attacker.strMod + " ) ";
            }
            rolls += "= " + damage + ".\n";
        }
        private static void AttemptAttack(PlayerSheet attacker, PlayerSheet attacked){
            attackString = attacker.name + " is attacking " + attacked.name + " with his " + attacker.weapon + ".\n";
            int roll = Dice.roll(20);
            attackString += attacker.name + " has rolled ( " + roll + " + " + attacker.strMod + " ) which ";
            if(roll + attacker.strMod >= attacked.AC){
                attackString += "means his attack succeeded!\n";
                CalcDamage(attacker, attacked);
            }
            else {
                attackString += "means his attack failed!\n";
                rolls = "And he took no damage.";
            }
        }
        public static String Attack(PlayerSheet attacker, PlayerSheet attacked){
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
