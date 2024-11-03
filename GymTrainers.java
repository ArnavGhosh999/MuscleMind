import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class GymTrainers extends JFrame {
    private static final int MAX_TRAINERS = 5; // Maximum number of trainers allowed
    private DefaultTableModel tableModel;

    public GymTrainers() {
        setTitle("Trainer");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Background Panel
        BackgroundPanel backgroundPanel = new BackgroundPanel("path/to/background/image.png");
        backgroundPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title Section
        JLabel titleLabel = new JLabel("Trainer");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        titleLabel.setIcon(new ImageIcon("path/to/trainer/icon.png")); // Placeholder for icon
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        backgroundPanel.add(titleLabel, gbc);

        // Trainer ID Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setOpaque(false);

        JLabel searchLabel = new JLabel("Enter the valid ID to get the information");
        searchLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        searchPanel.add(searchLabel);

        JTextField searchField = new JTextField(10);
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        gbc.gridy = 1;
        gbc.gridwidth = 2;
        backgroundPanel.add(searchPanel, gbc);

        // Display Trainer ID
        JLabel trainerIdLabel = new JLabel("Trainer ID: ");
        trainerIdLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        JLabel trainerIdValueLabel = new JLabel("003");
        trainerIdValueLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        trainerIdValueLabel.setForeground(Color.RED);

        JPanel trainerIdPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        trainerIdPanel.setOpaque(false);
        trainerIdPanel.add(trainerIdLabel);
        trainerIdPanel.add(trainerIdValueLabel);

        gbc.gridy = 2;
        gbc.gridwidth = 2;
        backgroundPanel.add(trainerIdPanel, gbc);

        // Form Fields
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);

        JLabel nameLabel = new JLabel("Trainer Name");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        JTextField nameField = new JTextField(15);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        JTextField ageField = new JTextField(15);

        JLabel mobileLabel = new JLabel("Mobile");
        mobileLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        JTextField mobileField = new JTextField(15);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        JTextField addressField = new JTextField(15);

        JLabel joinDateLabel = new JLabel("Join date");
        joinDateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        JTextField joinDateField = new JTextField(10);
        JButton dateButton = new JButton(new ImageIcon("path/to/calendar/icon.png")); // Placeholder for calendar icon

        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.gridx = 0;
        formPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        formPanel.add(ageLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(ageField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        formPanel.add(mobileLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(mobileField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        formPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(addressField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        formPanel.add(joinDateLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(joinDateField, gbc);
        gbc.gridx = 2;
        formPanel.add(dateButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        backgroundPanel.add(formPanel, gbc);

        // Buttons for operations
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);

        JButton addButton = new JButton("Add");
        addButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addButton.setIcon(new ImageIcon("path/to/add/icon.png")); // Placeholder for add icon

        JButton updateButton = new JButton("Update");
        updateButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateButton.setIcon(new ImageIcon("path/to/update/icon.png")); // Placeholder for update icon

        JButton deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        deleteButton.setIcon(new ImageIcon("path/to/delete/icon.png")); // Placeholder for delete icon

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        resetButton.setIcon(new ImageIcon("path/to/reset/icon.png")); // Placeholder for reset icon

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(resetButton);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        backgroundPanel.add(buttonPanel, gbc);

        // Table for displaying trainers
        String[] columnNames = {"ID", "Name", "Age", "Address", "Join Date", "Mobile"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        table.setRowHeight(25);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(800, 200));

        gbc.gridy = 5;
        gbc.gridwidth = 2;
        backgroundPanel.add(tableScrollPane, gbc);

        // Add Action Listener for Add Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableModel.getRowCount() < MAX_TRAINERS) {
                    String name = nameField.getText();
                    String age = ageField.getText();
                    String mobile = mobileField.getText();
                    String address = addressField.getText();
                    String joinDate = joinDateField.getText();

                    Object[] row = {tableModel.getRowCount() + 1, name, age, address, joinDate, mobile};
                    tableModel.addRow(row);
                    
                    // Clear fields after adding
                    nameField.setText("");
                    ageField.setText("");
                    mobileField.setText("");
                    addressField.setText("");
                    joinDateField.setText("");
                } else {
                    JOptionPane.showMessageDialog(GymTrainers.this,
                            "LIKE THE ENTHUSIASM BUT WE ARE RECRUITING ONLY 5, AT THIS POINT! " +
                            "BUT DON'T LOSE HOPE KEEP ON MOTIVATING AND TRAINING",
                            "Limit Reached",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Add background panel to the frame
        setContentPane(backgroundPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GymTrainers();
    }
}

// Custom JPanel class to handle background scaling
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
