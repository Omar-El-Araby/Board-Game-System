import javax.swing.*;
import java.util.Random;

public final class Dice {
    private static Random seed = new Random();
    public Dice(){
        seed = new Random();
    }
    public Dice(int n){
        seed = new Random(n);
    }
    public static int roll(int d){
        return seed.nextInt(d) + 1;
    }
    public static int addedRoll(int d, int bonus){
        return roll(d) + bonus;
    }
}
