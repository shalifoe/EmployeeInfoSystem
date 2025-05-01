//Antic, Kacy Lorraine BSCS 1-A
import java.util.Scanner;

public class MyMidtermLabExam {

    // Constants and arrays to store ticket data
    static final int MAX_TICKETS = 5; // Maximum number of tickets allowed
    static String[] descriptions = new String[MAX_TICKETS]; // Stores issue descriptions
    static String[] urgencies = new String[MAX_TICKETS];    // Stores urgency levels (Low, Medium, High)
    static String[] statuses = new String[MAX_TICKETS];     // Stores ticket status (Pending, In Progress, Resolved)
    static int ticketCount = 0; // Tracks the number of tickets added

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        // Loop to repeatedly show menu until user chooses to exit
        do {
            System.out.println("\n--- IT Ticket Processing System ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket Status");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            // Handle invalid non-integer input
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                sc.next(); // Skip invalid input
            }
            choice = sc.nextInt();
            sc.nextLine(); // Consume leftover newline character

            // Use switch-case to handle menu choices
            switch (choice) {
                case 1:
                    addTicket(sc); // Add a new ticket
                    break;
                case 2:
                    updateTicketStatus(sc); // Update existing ticket status
                    break;
                case 3:
                    showTickets(); // Display all tickets
                    break;
                case 4:
                    generateReport(); // Show summary report
                    break;
                case 5:
                    System.out.println("Thank you for using the IT Ticket System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 5); // Exit only if user chooses option 5

        sc.close(); // Close scanner to prevent memory leaks
    }

    // Method to add a new ticket
    public static void addTicket(Scanner sc) {
        if (ticketCount >= MAX_TICKETS) {
            System.out.println("Ticket limit reached. Cannot add more tickets.");
            return;
        }

        // Get issue description and urgency level from user
        System.out.print("Enter issue description: ");
        descriptions[ticketCount] = sc.nextLine();

        System.out.print("Enter urgency level (Low/Medium/High): ");
        urgencies[ticketCount] = sc.nextLine();

        statuses[ticketCount] = "Pending"; // Default status is "Pending"
        ticketCount++; // Increment total ticket count

        System.out.println("Ticket added successfully!");
    }

    // Method to update the status of a selected ticket
    public static void updateTicketStatus(Scanner sc) {
        if (ticketCount == 0) {
            System.out.println("No tickets to update.");
            return;
        }

        showTickets(); // Show current tickets for reference

        System.out.print("Enter the ticket number to update (1 to " + ticketCount + "): ");
        int ticketNum = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        // Check if ticket number is valid
        if (ticketNum < 1 || ticketNum > ticketCount) {
            System.out.println("Invalid ticket number.");
            return;
        }

        int index = ticketNum - 1;

        // Do not allow updating a ticket that's already resolved
        if (statuses[index].equalsIgnoreCase("Resolved")) {
            System.out.println("Cannot update a resolved ticket.");
            return;
        }

        // Get new status from user
        System.out.print("Enter new status (In Progress / Resolved): ");
        String newStatus = sc.nextLine();

        // Allow only valid status values
        if (newStatus.equalsIgnoreCase("In Progress") || newStatus.equalsIgnoreCase("Resolved")) {
            statuses[index] = newStatus; // Update status
            System.out.println("Ticket status updated successfully.");
        } else {
            System.out.println("Invalid status entered.");
        }
    }

    // Method to display all tickets
    public static void showTickets() {
        if (ticketCount == 0) {
            System.out.println("No tickets found.");
            return;
        }

        System.out.println("\n--- All Tickets ---");
        for (int i = 0; i < ticketCount; i++) {
            System.out.printf("Ticket %d:\n", i + 1);
            System.out.println("Issue: " + descriptions[i]);
            System.out.println("Urgency: " + urgencies[i]);
            System.out.println("Status: " + statuses[i]);
            System.out.println(); // Add spacing between tickets
        }
    }

    // Method to generate a report on ticket statistics
    public static void generateReport() {
        int pendingOrInProgress = 0;
        int resolved = 0;

        // Count resolved and pending/in-progress tickets
        for (int i = 0; i < ticketCount; i++) {
            if (statuses[i].equalsIgnoreCase("Resolved")) {
                resolved++;
            } else {
                pendingOrInProgress++;
            }
        }

        // Display summary
        System.out.println("\n--- Ticket Report ---");
        System.out.println("Total Tickets: " + ticketCount);
        System.out.println("Pending/In Progress: " + pendingOrInProgress);
        System.out.println("Resolved: " + resolved);
    }
}
