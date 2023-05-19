import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
public class PasswordHashingExample {
    public static void main(String[] args) {
        System.out.println("========================");
        System.out.println("SZYFROWANIE DO SHA HASEŁ");
        System.out.println("========================");
        System.out.println("Podaj Hasło do zaszyfrowania: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println("Podałeś wartość: " + userInput);
        System.out.println("===================================================================================");
        System.out.println("Zaszyfrowana wartość: ");
        System.out.println("===================================================================================");
        String hashedPassword = hashPassword(userInput);
        System.out.println("Hasło: " + userInput);
        System.out.println("Zahashowane hasło: " + hashedPassword);
        // Utworzenie obiektu Clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // Utworzenie obiektu StringSelection z tekstem do skopiowania
        StringSelection selection = new StringSelection(hashedPassword);
        // Umieszczenie obiektu StringSelection w schowku
        clipboard.setContents(selection, null);
        System.out.println("===================================================================================");
        System.out.println("Hash został skopiowany do schowka automatycznie.");
        System.out.println("===================================================================================");

    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            return bytesToHex(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}