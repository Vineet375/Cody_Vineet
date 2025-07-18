
// This program allows the user to check password strength or generate a random password

import java.util.*;

public class Password_Check_and_Generate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Display menu to the user
        System.out.println("Welcome to the Password Checker and Generator!");
        System.out.println("-> Enter 1 Check Password Strength");
        System.out.println("-> Enter 2 Generate Random Password");
        System.out.print("Please choose an option: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        
        // Call the appropriate method based on user choice
        if (choice == 1) {
            checkPasswordStrength();
        } else if (choice == 2) {
            generateRandomPassword();
        } else {
            System.out.println("Invalid choice. Please restart the program.");
        }
    }

    // Method to check the strength of a user-entered password
    static void checkPasswordStrength(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        int length = password.length();
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        // Check for presence of uppercase, lowercase, digit, and special characters
        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        int score = 0;
        // Increase score for each password strength criterion met
        if (length >= 8) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        // Display password strength based on score
        System.out.print("Password strength: ");
        if (score <= 2) System.out.println("Weak");
        else if (score == 3) System.out.println("Moderate");
        else if (score == 4) System.out.println("Strong");
        else System.out.println("Very Strong");

        // Give feedback to help user improve their password
        if (length < 8) System.out.println("- Make your password at least 8 characters long.");
        if (!hasUpper) System.out.println("- Add uppercase letters.");
        if (!hasLower) System.out.println("- Add lowercase letters.");
        if (!hasDigit) System.out.println("- Add numbers.");
        if (!hasSpecial) System.out.println("- Add special characters (e.g., !, @, #, $).");

        sc.close();
    }


    // Method to generate a random password based on user preferences
    static void generateRandomPassword(){
        Scanner sc = new Scanner(System.in);

        // Ask user for password length
        System.out.print("Enter the desired password length: ");
        int length = sc.nextInt();
        sc.nextLine(); // consume newline

        // Ask user for character types to include in the password
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

        // If no character types are selected, cannot generate password
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

        // Generate the rest of the password randomly from the selected character set
        for (int i = 0; i < length; i++) {
            int index = (int)(Math.random() * chars.length());
            password += chars.charAt(index);
        }

        System.out.println("Random Password: " + password);
        sc.close();
    }

}
