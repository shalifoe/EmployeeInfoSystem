// Antic Kacy Lorraine BSCS 1-A
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LabActivity6SwingToDoList extends JFrame {
    private DefaultTableModel tableModel;
    private JTable todoTable;
    private JFrame formWindow;

    public LabActivity6SwingToDoList() {
        setTitle("To-Do List Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table setup
        String[] columns = {"Task Name", "Task Description", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        todoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(todoTable);
        add(scrollPane, BorderLayout.CENTER);

        // Add Task button
        JButton addTaskBtn = new JButton("Add Task");
        addTaskBtn.setBackground(new Color(255, 182, 193)); 
        addTaskBtn.setForeground(Color.BLACK);

        addTaskBtn.addActionListener(e -> openTaskForm());

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(255, 228, 235)); 
        topPanel.add(addTaskBtn);
        add(topPanel, BorderLayout.NORTH);

        getContentPane().setBackground(new Color(255, 240, 245)); 

        setVisible(true);
    }

    private void openTaskForm() {
        if (formWindow != null && formWindow.isVisible()) {
            formWindow.toFront();
            return;
        }

        formWindow = new JFrame("Add New Task");
        formWindow.setSize(500, 350);
        formWindow.setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(255, 240, 245)); 
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;

        JLabel nameLabel = new JLabel("Task Name:");
        nameLabel.setForeground(new Color(199, 21, 133)); 
        formPanel.add(nameLabel, gbc);

        gbc.gridy++;
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(400, 30));
        formPanel.add(nameField, gbc);

        gbc.gridy++;
        JLabel descLabel = new JLabel("Task Description:");
        descLabel.setForeground(new Color(199, 21, 133));
        formPanel.add(descLabel, gbc);

        gbc.gridy++;
        JTextField descField = new JTextField();
        descField.setPreferredSize(new Dimension(400, 30));
        formPanel.add(descField, gbc);

        gbc.gridy++;
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setForeground(new Color(199, 21, 133));
        formPanel.add(statusLabel, gbc);

        gbc.gridy++;
        String[] statuses = {"", "Not Started", "Ongoing", "Completed"};
        JComboBox<String> statusBox = new JComboBox<>(statuses);
        statusBox.setPreferredSize(new Dimension(400, 30));
        formPanel.add(statusBox, gbc);

        gbc.gridy++;
        JButton saveBtn = new JButton("Save");
        saveBtn.setBackground(new Color(255, 182, 193));
        saveBtn.setForeground(Color.BLACK);
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(saveBtn, gbc);

        formWindow.add(formPanel);
        formWindow.setVisible(true);

        // Save logic
        saveBtn.addActionListener(e -> {
            String taskName = nameField.getText().trim();
            String taskDesc = descField.getText().trim();
            String taskStatus = (String) statusBox.getSelectedItem();

            if (taskName.isEmpty() || taskStatus == null || taskStatus.isEmpty()) {
                JOptionPane.showMessageDialog(formWindow,
                        "Please Fill in Task Name and Status",
                        "Missing Info",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            tableModel.addRow(new Object[]{taskName, taskDesc, taskStatus});
            formWindow.dispose();
        });
    }

    public static void main(String[] args) {
        new LabActivity6SwingToDoList();
    }
}
