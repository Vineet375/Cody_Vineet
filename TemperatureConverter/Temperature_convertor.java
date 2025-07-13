//Task1: Temperature Converter

import java.util.*;

public class Temperature_convertor {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);        // Create a Scanner object to take user input
        System.out.println("Select the temperature unit you want to enter: ");
        System.out.println("1. Press C to enter temperature in Celsius");
        System.out.println("2. Press F to enter temperature in Fahrenheit");
        System.out.println("3. Press K to enter temperature in Kelvin");
        System.out.print("Enter your choice: ");
        String value = sc.nextLine();
        if(value.equalsIgnoreCase("C"))           // Check if the input is Celsius
        {
            double c, f, k;
            String choice;
            System.out.print("Enter temperature in Celsius: ");
            c = sc.nextDouble();
            sc.nextLine(); // consume newline
            System.out.println("Select the unit you want to convert to: ");
            System.out.println("1. Press F to convert to Fahrenheit");
            System.out.println("2. Press K to convert to Kelvin");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine();
            if(choice.equalsIgnoreCase("F")) { 
                f = (c * 9/5) + 32;
                System.out.println("Temperature in Fahrenheit: " + String.format("%.3f", f));
            } else if(choice.equalsIgnoreCase("K")) {
                k = c + 273.15;
                System.out.println("Temperature in Kelvin: " + String.format("%.3f", k));
            } else {
                System.out.println("Invalid choice");
            }
        }
        else if(value.equalsIgnoreCase("F"))          // Check if the input is Fahrenheit
        {
            double c, f, k;
            String choice;
            System.out.print("Enter temperature in Fahrenheit: ");
            f = sc.nextDouble();
            sc.nextLine(); // consume newline
            System.out.println("Select the unit you want to convert to: ");
            System.out.println("1. Press C to convert to Celsius");
            System.out.println("2. Press K to convert to Kelvin");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine();
            if(choice.equalsIgnoreCase("C")) {
                c = (f - 32) * 5/9;
                System.out.println("Temperature in Celsius: " + String.format("%.3f", c));
            } else if(choice.equalsIgnoreCase("K")) {
                k = (f - 32) * 5/9 + 273.15;
                System.out.println("Temperature in Kelvin: " + String.format("%.3f", k));
            } else {
                System.out.println("Invalid choice");
            }
        }
        else if(value.equalsIgnoreCase("K"))          // Check if the input is Kelvin
        {
            double c, f, k;
            String choice;
            System.out.print("Enter temperature in Kelvin: ");
            k = sc.nextDouble();
            sc.nextLine(); // consume newline
            System.out.println("Select the unit you want to convert to: ");
            System.out.println("1. Press C to convert to Celsius");
            System.out.println("2. Press F to convert to Fahrenheit");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine();
            if(choice.equalsIgnoreCase("C")) {
                c = k - 273.15;
                System.out.println("Temperature in Celsius: " + String.format("%.3f", c));
            } else if(choice.equalsIgnoreCase("F")) {
                f = (k - 273.15) * 9/5 + 32;
                System.out.println("Temperature in Fahrenheit: " + String.format("%.3f", f));
            } else {
                System.out.println("Invalid choice");
            }
        }
        else           // If the input is not valid
        {
            System.out.println("Invalid input");
        }

        sc.close();
    }
    
}
