//Task4:  Random Password Generator

import java.util.*;

public class Password_generator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for password length
        System.out.print("Enter the desired password length: ");
        int length = sc.nextInt();
        sc.nextLine(); // consume newline

        // Ask user for character types
        System.out.print("Include numbers? (y/n): ");
        boolean useNumbers = sc.nextLine().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLower = sc.nextLine().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUpper = sc.nextLine().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean useSpecial = sc.nextLine().equalsIgnoreCase("y");

        System.out.print("Should the first character be capital? (y/n): ");
        boolean firstCapital = sc.nextLine().equalsIgnoreCase("y");

        // Build character set based on user choices
        String chars = "";
        if (useNumbers) chars += "0123456789";
        if (useLower) chars += "abcdefghijklmnopqrstuvwxyz";
        if (useUpper) chars += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (useSpecial) chars += "!@#$%^&*()-_=+";

        if (chars.isEmpty()) {
            System.out.println("No character types selected. Cannot generate password.");
            sc.close();
            return;
        }

        String password = "";

        // Handle first character if it should be capital
        if (firstCapital && length > 0) {
            String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            password += upper.charAt((int)(Math.random() * upper.length()));
            length--; // Reduce length by 1 as first character is already set
        }

        // Generate the rest of the password
        for (int i = 0; i < length; i++) {
            int index = (int)(Math.random() * chars.length());
            password += chars.charAt(index);
        }

        System.out.println("Random Password: " + password);
        sc.close();
    }
}