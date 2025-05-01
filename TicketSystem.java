import java.util.Scanner;

public class TicketSystem {

    static final int MAX_TICKETS = 5;
    static String[] descriptions = new String[MAX_TICKETS];
    static String[] urgencies = new String[MAX_TICKETS];
    static String[] statuses = new String[MAX_TICKETS];
    static int ticketCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- IT Ticket Processing System ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket Status");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                sc.next(); // discard invalid input
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTicket(sc);
                    break;
                case 2:
                    updateTicketStatus(sc);
                    break;
                case 3:
                    showTickets();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Thank you for using the IT Ticket System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 5);

        sc.close();
    }

    public static void addTicket(Scanner sc) {
        if (ticketCount >= MAX_TICKETS) {
            System.out.println("Ticket limit reached. Cannot add more tickets.");
            return;
        }

        System.out.print("Enter issue description: ");
        descriptions[ticketCount] = sc.nextLine();

        System.out.print("Enter urgency level (Low/Medium/High): ");
        urgencies[ticketCount] = sc.nextLine();

        statuses[ticketCount] = "Pending";
        ticketCount++;

        System.out.println("Ticket added successfully!");
    }

    public static void updateTicketStatus(Scanner sc) {
        if (ticketCount == 0) {
            System.out.println("No tickets to update.");
            return;
        }

        showTickets();

        System.out.print("Enter the ticket number to update (1 to " + ticketCount + "): ");
        int ticketNum = sc.nextInt();
        sc.nextLine(); // consume newline

        if (ticketNum < 1 || ticketNum > ticketCount) {
            System.out.println("Invalid ticket number.");
            return;
        }

        int index = ticketNum - 1;
        if (statuses[index].equals("Resolved")) {
            System.out.println("Cannot update a resolved ticket.");
            return;
        }

        System.out.print("Enter new status (In Progress / Resolved): ");
        String newStatus = sc.nextLine();

        if (newStatus.equalsIgnoreCase("In Progress") || newStatus.equalsIgnoreCase("Resolved")) {
            statuses[index] = newStatus;
            System.out.println("Ticket status updated successfully.");
        } else {
            System.out.println("Invalid status entered.");
        }
    }

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
            System.out.println();
        }
    }

    public static void generateReport() {
        int pendingOrInProgress = 0;
        int resolved = 0;

        for (int i = 0; i < ticketCount; i++) {
            if (statuses[i].equalsIgnoreCase("Resolved")) {
                resolved++;
            } else {
                pendingOrInProgress++;
            }
        }

        System.out.println("\n--- Ticket Report ---");
        System.out.println("Total Tickets: " + ticketCount);
        System.out.println("Pending/In Progress: " + pendingOrInProgress);
        System.out.println("Resolved: " + resolved);
    }
}
