//Task3:  File Encryption/Decryption

import java.io.*;
import java.util.*;

public class File_encrypt_and_decrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object for user input

        System.out.println("Choose: 1. Encrypt  2. Decrypt");
        int choice = sc.nextInt();            // Read user's choice (1 for encrypt, 2 for decrypt)
        sc.nextLine(); // consume newline      // Consume the leftover newline character

        System.out.print("Enter input file path: ");
        String inputFile = sc.nextLine();     // Read the input file path

        System.out.print("Enter output file path: ");
        String outputFile = sc.nextLine();    // Read the output file path

        System.out.print("Enter a numeric key (e.g., 5): ");
        int key = sc.nextInt();               // Read the numeric key for encryption/decryption

        try {
            FileInputStream fis = new FileInputStream(inputFile);   // Open input file for reading
            FileOutputStream fos = new FileOutputStream(outputFile);// Open output file for writing

            int data;
            while ((data = fis.read()) != -1) { // Read each byte from input file until end
                if (choice == 1) { // Encrypt
                    fos.write(data + key);      // Add key to byte and write to output file
                } else if (choice == 2) { // Decrypt
                    fos.write(data - key);      // Subtract key from byte and write to output file
                }
            }
            fis.close();                        // Close input file stream
            fos.close();                        // Close output file stream
            System.out.println("Operation completed. Check the output file.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage()); // Handle file errors
        }
        sc.close();                             // Close the Scanner
    }
}
