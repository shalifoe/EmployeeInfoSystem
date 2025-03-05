// Antic, Kacy Lorraine BSCS 1-A

import java.util.Scanner;

public class EmployeeInfoSystem { // naming new project
    public static void main(String[] args) { // the start button of the program, everything runs inside this bracket
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // asking user their name
        System.out.print("Enter Employee's First Name: ");
        String firstName = scanner.nextLine();
          
        // asking user their last name
        System.out.print("Enter Employee's Last Name: ");
        String lastName = scanner.nextLine();

        // asking user their age
        System.out.print("Enter Employee's Age: ");
        int age = scanner.nextInt();

        // asking user their number of hours worked in a day 
        System.out.print("Enter Number of Hours Worked in a Day: ");
        double hoursWorked = scanner.nextDouble(); // we used double because hours can have a decimal

        // asking user their hourly wage
        System.out.print("Enter Hourly Wage: ");
        double hourlyWage = scanner.nextDouble();

        // Compute full name and daily wage
        String fullName = firstName + " " + lastName; // we combine firstName, "" (stands for space), and lastName
        double dailySalary = hoursWorked * hourlyWage; // we multiply hours worked by hourly wage

        // Display computed details
        System.out.println(" Employee Information ");
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.printf("Daily salary: %.2f%n", dailySalary); //  makes sure the daily salary always shows 2 decimal places

        // Closes the scanner
        scanner.close();
    }
}
