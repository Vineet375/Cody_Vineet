//Task2: Password Strength Checker

import java.util.Scanner;

public class Password_checker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        int length = password.length();
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        int score = 0;
        if (length >= 8) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        System.out.print("Password strength: ");
        if (score <= 2) System.out.println("Weak");
        else if (score == 3) System.out.println("Moderate");
        else if (score == 4) System.out.println("Strong");
        else System.out.println("Very Strong");

        // Feedback
        if (length < 8) System.out.println("- Make your password at least 8 characters long.");
        if (!hasUpper) System.out.println("- Add uppercase letters.");
        if (!hasLower) System.out.println("- Add lowercase letters.");
        if (!hasDigit) System.out.println("- Add numbers.");
        if (!hasSpecial) System.out.println("- Add special characters (e.g., !, @, #, $).");

        sc.close();
    }
}
