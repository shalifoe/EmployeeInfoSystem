//Antic Kacy Lorraine BSCS 1-A 
import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT extends Frame implements ActionListener {
    Label questionLabel;
    Label messageLabel;
    CheckboxGroup choicesGroup;
    Checkbox[] options;
    Button nextButton;
    Panel panel;

    String[] questions = {
        "Which data structure uses LIFO (Last In First Out)?",
        "What does CPU stand for?",
        "Which keyword is used to create a subclass in Java?"
    };

    String[][] choices = {
        {"Queue", "Stack", "Array", "LinkedList"},
        {"Central Processing Unit", "Central Performance Unit", "Computer Primary Unit", "Control Processing Unit"},
        {"implement", "inherits", "extends", "super"}
    };

    int[] correctAnswers = {1, 0, 2};
    String[] choiceLetters = {"A. ", "B. ", "C. ", "D. "};

    int currentQuestion = 0;
    int score = 0;

    public LabActivity5QuizAppAWT() {
        setTitle("Quiz App");
        setSize(500, 300);
        setLayout(new BorderLayout());

        // Top panel for question
        Panel topPanel = new Panel();
        topPanel.setBackground(Color.WHITE);
        questionLabel = new Label("", Label.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(questionLabel);
        add(topPanel, BorderLayout.NORTH);

        // Center panel for choices
        panel = new Panel();
        panel.setLayout(new GridLayout(2, 2, 10, 10)); // 2 rows × 2 columns with spacing
        panel.setBackground(Color.WHITE); // <- make the background white
        add(panel, BorderLayout.CENTER);

        // Bottom panel (for message + button)
        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new GridLayout(2, 1));
        bottomPanel.setBackground(Color.WHITE);

        messageLabel = new Label("", Label.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        messageLabel.setForeground(Color.BLACK);

        nextButton = new Button("Next");
        nextButton.addActionListener(this);

        bottomPanel.add(messageLabel);
        bottomPanel.add(nextButton);

        add(bottomPanel, BorderLayout.SOUTH);

        loadQuestion();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    void loadQuestion() {
        questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);
        messageLabel.setText("");

        panel.removeAll(); // Clear previous checkboxes

        choicesGroup = new CheckboxGroup();
        options = new Checkbox[4];

        for (int i = 0; i < 4; i++) {
            options[i] = new Checkbox(choiceLetters[i] + choices[currentQuestion][i], false, choicesGroup);
            options[i].setForeground(Color.BLUE);
            options[i].setBackground(Color.WHITE); // <- checkbox background
            panel.add(options[i]);
        }

        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Checkbox selected = choicesGroup.getSelectedCheckbox();

        if (selected == null) {
            messageLabel.setText("Please select an answer");
            return;
        }

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
            loadQuestion();
        } else {
            questionLabel.setText("Quiz Completed! Your Score: " + score + " out of " + questions.length);
            questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
            for (Checkbox opt : options) {
                opt.setVisible(false);
            }
            nextButton.setVisible(false);
            messageLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new LabActivity5QuizAppAWT();
    }
}
