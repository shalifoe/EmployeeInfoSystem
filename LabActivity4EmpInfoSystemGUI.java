import java.awt.*; // for GUI stuff
import java.awt.event.*; // for button click events

// Main class — same name as the file!
public class LabActivity4EmpInfoSystemGUI extends Frame implements ActionListener {

    // Declare all the input fields, button, and output area
    TextField firstNameField, lastNameField, ageField, hoursWorkedField, hourlyRateField;
    TextArea outputArea;
    Button submitButton;

    // Constructor — dito nagse-set up ng buong GUI
    public LabActivity4EmpInfoSystemGUI() {
        setTitle("Laboratory Activity 4"); // title nung window
        setLayout(new GridLayout(7, 2)); // layout with 7 rows and 2 columns

        // Add label and input for first name
        add(new Label("First Name"));
        firstNameField = new TextField();
        add(firstNameField);

        // Add label and input for last name
        add(new Label("Last Name"));
        lastNameField = new TextField();
        add(lastNameField);

        // Add label and input for age
        add(new Label("Age"));
        ageField = new TextField();
        add(ageField);

        // Add label and input for hours worked
        add(new Label("Hours Worked"));
        hoursWorkedField = new TextField();
        add(hoursWorkedField);

        // Add label and input for hourly rate
        add(new Label("Hourly Rate"));
        hourlyRateField = new TextField();
        add(hourlyRateField);

        // Add submit button and attach a click event listener to it
        submitButton = new Button("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        // Add output label and the actual area where output will be shown
        add(new Label("Output:"));
        outputArea = new TextArea("", 3, 40, TextArea.SCROLLBARS_NONE);
        outputArea.setEditable(false); // para di ma-edit manually
        add(outputArea);

        // Set the size of the window and make it visible
        setSize(400, 250);
        setVisible(true);

        // Para kapag sinara yung window, magsa-shutdown talaga yung program
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose(); // closes the frame properly
            }
        });
    }

    // Kapag pinindot yung "Submit" button, eto yung tatakbo
    public void actionPerformed(ActionEvent e) {
        try {
            // Get user input from the text fields
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            int age = Integer.parseInt(ageField.getText()); // parse age to int
            double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
            double hourlyRate = Double.parseDouble(hourlyRateField.getText());

            // Concatenate first name and last name to get full name
            String fullName = firstName + " " + lastName;

            // Calculate daily salary = hours * rate
            double dailySalary = hoursWorked * hourlyRate;

            // Display final output
            outputArea.setText("Full Name: " + fullName + "\n" +
                               "Age: " + age + " years old\n" +
                               "Daily Salary: PHP " + String.format("%.2f", dailySalary));
        } catch (NumberFormatException ex) {
            // If user typed invalid numbers, show this error message
            outputArea.setText("Error: Please enter valid numbers for age, hours, and rate.");
        } catch (Exception ex) {
            // Catch any other error just in case
            outputArea.setText("An unexpected error occurred.");
        }
    }

    // Main method — dito tumatakbo yung program mismo
    public static void main(String[] args) {
        new LabActivity4EmpInfoSystemGUI(); // calls the constructor to build GUI
    }
}
