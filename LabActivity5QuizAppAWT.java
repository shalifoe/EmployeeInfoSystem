// Antic Kacy Lorraine BSCS 1-A 
import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT extends Frame implements ActionListener {
    // Labels for the question and warning message
    Label questionLabel;
    Label messageLabel;

    // Group for making only one checkbox selectable at a time
    CheckboxGroup choicesGroup;

    // Array to hold the 4 answer options per question
    Checkbox[] options;

    // Button to go to the next question
    Button nextButton;

    // Panel where the checkboxes (choices) will be placed
    Panel panel;

    // Questions in the quiz
    String[] questions = {
        "Which data structure uses LIFO (Last In First Out)?",
        "What does CPU stand for?",
        "Which keyword is used to create a subclass in Java?"
    };

    // Corresponding choices for each question
    String[][] choices = {
        {"Queue", "Stack", "Array", "LinkedList"},
        {"Central Processing Unit", "Central Performance Unit", "Computer Primary Unit", "Control Processing Unit"},
        {"implement", "inherits", "extends", "super"}
    };

    // Index of correct answers for checking later
    int[] correctAnswers = {1, 0, 2};

    // Labels for A, B, C, D options
    String[] choiceLetters = {"A. ", "B. ", "C. ", "D. "};

    // Keeps track of which question we're on
    int currentQuestion = 0;

    // Score counter
    int score = 0;

    // Constructor – dito yung UI setup
    public LabActivity5QuizAppAWT() {
        setTitle("Quiz App");
        setSize(500, 300);
        setLayout(new BorderLayout());

        // Top panel para sa tanong
        Panel topPanel = new Panel();
        topPanel.setBackground(Color.WHITE);
        questionLabel = new Label("", Label.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(questionLabel);
        add(topPanel, BorderLayout.NORTH);

        // Center panel para sa choices (2x2 layout na ngayon)
        panel = new Panel();
        panel.setLayout(new GridLayout(2, 2, 10, 10)); 
        panel.setBackground(Color.WHITE); 
        add(panel, BorderLayout.CENTER);

        // Bottom panel for warning message and next button
        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new GridLayout(2, 1));
        bottomPanel.setBackground(Color.WHITE);

        messageLabel = new Label("", Label.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        messageLabel.setForeground(Color.BLACK); // just plain black

        nextButton = new Button("Next");
        nextButton.addActionListener(this); // para gumana yung button

        bottomPanel.add(messageLabel);
        bottomPanel.add(nextButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Load the first question
        loadQuestion();

        // Para mag-close pag pinindot yung X button
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // Method to show current question and reset choices
    void loadQuestion() {
        questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);
        messageLabel.setText("");

        panel.removeAll(); // Clear previous checkboxes

        choicesGroup = new CheckboxGroup(); // Reset group for new question
        options = new Checkbox[4]; // Recreate checkbox array

        for (int i = 0; i < 4; i++) {
            // Create new checkboxes and add to panel
            options[i] = new Checkbox(choiceLetters[i] + choices[currentQuestion][i], false, choicesGroup);
            options[i].setForeground(Color.BLUE);
            options[i].setBackground(Color.WHITE); 
            panel.add(options[i]);
        }

        panel.revalidate(); // Refresh layout
        panel.repaint();
    }

    // Called when "Next" button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        Checkbox selected = choicesGroup.getSelectedCheckbox();

        // Kung walang napili, show message
        if (selected == null) {
            messageLabel.setText("Please select an answer");
            return;
        }

        // Check kung tama sagot
        for (int i = 0; i < 4; i++) {
            if (options[i].getState()) {
                if (i == correctAnswers[currentQuestion]) {
                    score++;
                }
                break;
            }
        }

        currentQuestion++;

        if (currentQuestion < questions.length) {
            // Load next question
            loadQuestion();
        } else {
            // Pag tapos na quiz, show result
            questionLabel.setText("Quiz Completed! Your Score: " + score + " out of " + questions.length);
            questionLabel.setFont(new Font("Arial", Font.BOLD, 18));

            // Hide all choices and button
            for (Checkbox opt : options) {
                opt.setVisible(false);
            }
            nextButton.setVisible(false);
            messageLabel.setText(""); // clear message
        }
    }

    public static void main(String[] args) {
        new LabActivity5QuizAppAWT(); // run the app
    }
}
