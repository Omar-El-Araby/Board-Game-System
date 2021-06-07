import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

public class User {
    static final File currentUser = new File("src/currentuser.txt");
    static final File rememberme = new File("src/rememberme.txt");

    public User() {

    }

    static public String getCurrentUser() {
        Scanner scanner = null;
        try {
            currentUser.createNewFile();
            scanner = new Scanner(currentUser);
            return scanner.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static public void setCurrentUser(String user) {
        PrintWriter printWriter = null;
        try {
            currentUser.createNewFile();
            printWriter = new PrintWriter(currentUser);
            printWriter.flush();
            printWriter.print(user);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public boolean getRememberme() {
        Scanner scanner = null;
        PrintWriter printWriter = null;
        try {
            rememberme.createNewFile();
            scanner = new Scanner(rememberme);
            if(scanner.hasNext())
                return scanner.nextBoolean();
            else {
                printWriter = new PrintWriter(rememberme);
                printWriter.print(false);
                printWriter.close();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    static public void setRememberme(boolean memory) {
            PrintWriter printWriter = null;
            try {
                rememberme.createNewFile();
                printWriter = new PrintWriter(rememberme);
                printWriter.flush();
                printWriter.print(memory);
                printWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    static public void incrementWin() {
        saveFile(true); //increment the win counter in the file
    }
    static public void incrementLoss() {
        saveFile(false); //increment the loss counter in the file
    }
    static public int getWin() {
        return readFile(true); //read the win counter from the file
    }
    static public int getLoss() {
        return readFile(false); //read the loss counter from the file
    }
    static private void saveFile(boolean win) {
        if(Objects.equals(getCurrentUser(), "Guest")) return;
        File stats = new File("src/stats/" + getCurrentUser() + ".txt");
        Scanner scanner = null;
        PrintWriter printWriter = null;
        try {
            if(stats.createNewFile()) {
                printWriter = new PrintWriter(stats);
                printWriter.print("0 0");
                printWriter.close();
            }
            scanner = new Scanner(stats);
            int wins = scanner.nextInt();
            int losses = scanner.nextInt();
            if(win) ++wins;
            else ++losses;
            printWriter = new PrintWriter(stats);
            printWriter.flush();
            printWriter.print(wins + " " + losses);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static private int readFile(boolean win) {
        if(Objects.equals(getCurrentUser(), "Guest")) return 0;
        File stats = new File("src/stats/" + getCurrentUser() + ".txt");
        Scanner scanner = null;
        PrintWriter printWriter = null;
        try {
            if(stats.createNewFile()) {
                printWriter = new PrintWriter(stats);
                printWriter.print("0 0");
                printWriter.close();
            }
            scanner = new Scanner(stats);
            int wins = scanner.nextInt();
            int losses = scanner.nextInt();
            if(win) return wins;
            else return losses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
