import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
        try {
            rememberme.createNewFile();
            scanner = new Scanner(rememberme);
            return scanner.nextBoolean();
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
}
