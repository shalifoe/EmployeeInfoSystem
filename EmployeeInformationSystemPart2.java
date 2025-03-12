import java.util.Scanner;

public class EmployeeInformationSystemPart2 { // naming new project
    public static void main(String[] args) { // the start button of the program, everything runs inside this bracket
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Asking user their first name
        System.out.print("Enter Employee's First Name: ");
        String firstName = scanner.nextLine();
          
        // Asking user their last name
        System.out.print("Enter Employee's Last Name: ");
        String lastName = scanner.nextLine();

        // Asking user their age
        System.out.print("Enter Employee's Age: ");
        int age = scanner.nextInt();

        // Asking user their number of hours worked in a day 
        System.out.print("Enter Hours Worked: ");
        double hoursWorked = scanner.nextDouble(); // we used double because hours can have a decimal

        // Asking user their hourly wage
        System.out.print("Enter Hourly Wage: ");
        double hourlyWage = scanner.nextDouble();

        // Compute full name in LASTNAME, FIRSTNAME format
        String fullName = lastName.toUpperCase() + ", " + firstName.toUpperCase(); // Format last name first and uppercase

        // Compute daily salary
        double dailySalary = hoursWorked * hourlyWage; // Multiply hours worked by hourly wage

        // Compute weekly salary (Assuming a 5-day work week)
        double weeklySalary = dailySalary * 5; 

        // Compute monthly salary (Assuming 20 working days per month)
        double monthlySalary = dailySalary * 20; 

        // Compute gross yearly salary (12 months)
        double grossYearlySalary = monthlySalary * 12; 

        // Compute net yearly salary (Assuming 33.5% tax deduction)
        double netYearlySalary = grossYearlySalary * 0.665; 

        // Compute years to retirement (Assuming retirement at 65)
        int yearsToRetirement = 65 - age; 

        // Display computed details
        System.out.println("\n Employee Information ");
        System.out.println("--------------------");
        System.out.println("Full Name:         " + fullName); // Display formatted full name
        System.out.println("Age:               " + age + " years old"); // Display age
        System.out.println("Years to Retirement: " + yearsToRetirement + " years"); // Display years left until retirement
        System.out.printf("Daily Salary:      Php %.2f%n", dailySalary); // Display daily salary with 2 decimal places
        System.out.printf("Weekly Salary:     Php %.2f%n", weeklySalary); // Display weekly salary
        System.out.printf("Monthly Salary:    Php %.2f%n", monthlySalary); // Display monthly salary
        System.out.printf("Gross Yearly Salary: Php %.2f%n", grossYearlySalary); // Display gross yearly salary before tax
        System.out.printf("Net Yearly Salary:   Php %.2f%n", netYearlySalary); // Display net yearly salary after tax

        // Close the scanner
        scanner.close();
    }
}
