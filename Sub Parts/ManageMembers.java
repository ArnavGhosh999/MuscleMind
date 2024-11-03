import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManageMembers extends JFrame {
    private JTextField memberIdField, firstNameField, lastNameField, emailField, phoneField, addressField, payDateField;
    private JComboBox<String> memberTypeCombo, genderCombo, trainerListCombo;
    private JButton resetButton, updateButton, deleteButton, searchButton, viewBenefitsButton;
    private JLabel memberIdLabel;
    private JFormattedTextField registerDateField;
    private JTable memberTable;
    private DefaultTableModel tableModel;
    private int memberIdCounter = 1;

    public ManageMembers() {
        setTitle("Manage Members");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Load background image
        ImageIcon backgroundImage = new ImageIcon("Images\\Managebg.jpg"); // Update path to your image
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel);

        Font defaultFont = new Font("Times New Roman", Font.BOLD, 18); // Increased font size
        Color whiteColor = Color.WHITE;

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Header
        JLabel headerLabel = new JLabel("MANAGE MEMBERS", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 28)); // Increased font size
        headerLabel.setForeground(whiteColor);
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(headerLabel, gbc);

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setOpaque(false);
        JLabel searchInfoLabel = new JLabel("Enter the valid ID to get the information");
        searchInfoLabel.setFont(defaultFont);
        searchInfoLabel.setForeground(whiteColor);
        searchPanel.add(searchInfoLabel);
        JLabel memberIdTextLabel = new JLabel("Member ID:");
        memberIdTextLabel.setFont(defaultFont);
        memberIdTextLabel.setForeground(whiteColor);
        searchPanel.add(memberIdTextLabel);
        memberIdField = new JTextField(10);
        memberIdField.setFont(defaultFont);
        memberIdField.setForeground(whiteColor);
        memberIdField.setBackground(Color.BLACK);
        searchButton = new JButton("Search");
        searchButton.setFont(defaultFont);
        searchButton.setForeground(whiteColor);
        searchButton.setBackground(Color.BLACK);
        searchPanel.add(memberIdField);
        searchPanel.add(searchButton);

        gbc.gridy = 1;
        mainPanel.add(searchPanel, gbc);

        // Member Details Fields
        JLabel memberIdText = new JLabel("Member ID:");
        memberIdText.setFont(defaultFont);
        memberIdText.setForeground(whiteColor);
        memberIdLabel = new JLabel(" - ");
        memberIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 18)); // Increased font size
        memberIdLabel.setForeground(whiteColor);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(memberIdText, gbc);
        gbc.gridx = 1;
        mainPanel.add(memberIdLabel, gbc);

        // Gender Combo Box
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(defaultFont);
        genderLabel.setForeground(whiteColor);
        genderCombo = new JComboBox<>(new String[]{"Male", "Female"});
        genderCombo.setFont(defaultFont);
        genderCombo.setForeground(whiteColor);
        genderCombo.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(genderLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(genderCombo, gbc);

        // Member Type
        JLabel memberTypeLabel = new JLabel("Member Type:");
        memberTypeLabel.setFont(defaultFont);
        memberTypeLabel.setForeground(whiteColor);
        memberTypeCombo = new JComboBox<>(new String[]{"Basic", "Plus"});
        memberTypeCombo.setFont(defaultFont);
        memberTypeCombo.setForeground(whiteColor);
        memberTypeCombo.setBackground(Color.BLACK);
        gbc.gridx = 2;
        mainPanel.add(memberTypeLabel, gbc);
        gbc.gridx = 3;
        mainPanel.add(memberTypeCombo, gbc);

        // Register Date
        JLabel registerDateLabel = new JLabel("Registered Date:");
        registerDateLabel.setFont(defaultFont);
        registerDateLabel.setForeground(whiteColor);
        registerDateField = new JFormattedTextField(new SimpleDateFormat("MMM dd, yyyy"));
        registerDateField.setValue(new Date());
        registerDateField.setFont(defaultFont);
        registerDateField.setForeground(whiteColor);
        registerDateField.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Center the field
        mainPanel.add(registerDateLabel, gbc);
        gbc.gridx = 2;
        gbc.gridwidth = 2;
        mainPanel.add(registerDateField, gbc);

        // First Name
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(defaultFont);
        firstNameLabel.setForeground(whiteColor);
        firstNameField = new JTextField(10);
        firstNameField.setFont(defaultFont);
        firstNameField.setForeground(whiteColor);
        firstNameField.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST; // Align to the left
        mainPanel.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(firstNameField, gbc);

        // Last Name
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(defaultFont);
        lastNameLabel.setForeground(whiteColor);
        lastNameField = new JTextField(10);
        lastNameField.setFont(defaultFont);
        lastNameField.setForeground(whiteColor);
        lastNameField.setBackground(Color.BLACK);
        gbc.gridx = 2;
        mainPanel.add(lastNameLabel, gbc);
        gbc.gridx = 3;
        mainPanel.add(lastNameField, gbc);

        // Email
        JLabel emailLabel = new JLabel("Email address:");
        emailLabel.setFont(defaultFont);
        emailLabel.setForeground(whiteColor);
        emailField = new JTextField(10);
        emailField.setFont(defaultFont);
        emailField.setForeground(whiteColor);
        emailField.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        // Phone Number
        JLabel phoneLabel = new JLabel("Phone number:");
        phoneLabel.setFont(defaultFont);
        phoneLabel.setForeground(whiteColor);
        phoneField = new JTextField(10);
        phoneField.setFont(defaultFont);
        phoneField.setForeground(whiteColor);
        phoneField.setBackground(Color.BLACK);
        gbc.gridx = 2;
        mainPanel.add(phoneLabel, gbc);
        gbc.gridx = 3;
        mainPanel.add(phoneField, gbc);

        // Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(defaultFont);
        addressLabel.setForeground(whiteColor);
        addressField = new JTextField(20);
        addressField.setFont(defaultFont);
        addressField.setForeground(whiteColor);
        addressField.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        mainPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        mainPanel.add(addressField, gbc);

        // Trainer List
        JLabel trainerLabel = new JLabel("Trainer List:");
        trainerLabel.setFont(defaultFont);
        trainerLabel.setForeground(whiteColor);
        trainerListCombo = new JComboBox<>(new String[]{"Trainer 1", "Trainer 2", "Trainer 3"});
        trainerListCombo.setFont(defaultFont);
        trainerListCombo.setForeground(whiteColor);
        trainerListCombo.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        mainPanel.add(trainerLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(trainerListCombo, gbc);

        // Pay Date
        JLabel payDateLabel = new JLabel("Pay Date:");
        payDateLabel.setFont(defaultFont);
        payDateLabel.setForeground(whiteColor);
        payDateField = new JTextField(10);
        payDateField.setFont(defaultFont);
        payDateField.setForeground(whiteColor);
        payDateField.setBackground(Color.BLACK);
        gbc.gridx = 2;
        mainPanel.add(payDateLabel, gbc);
        gbc.gridx = 3;
        mainPanel.add(payDateField, gbc);

        // Buttons
        resetButton = new JButton("Reset");
        resetButton.setFont(defaultFont);
        resetButton.setForeground(whiteColor);
        resetButton.setBackground(Color.BLACK);
        updateButton = new JButton("Update");
        updateButton.setFont(defaultFont);
        updateButton.setForeground(whiteColor);
        updateButton.setBackground(Color.BLACK);
        deleteButton = new JButton("Delete");
        deleteButton.setFont(defaultFont);
        deleteButton.setForeground(whiteColor);
        deleteButton.setBackground(Color.BLACK);

        gbc.gridx = 0;
        gbc.gridy = 9;
        mainPanel.add(resetButton, gbc);
        gbc.gridx = 1;
        mainPanel.add(updateButton, gbc);
        gbc.gridx = 2;
        mainPanel.add(deleteButton, gbc);

        // Table for displaying members
        tableModel = new DefaultTableModel(new Object[]{"ID", "First Name", "Last Name"}, 0);
        memberTable = new JTable(tableModel);
        memberTable.setFont(defaultFont);
        memberTable.setForeground(whiteColor);
        memberTable.setBackground(Color.BLACK);
        JScrollPane tableScrollPane = new JScrollPane(memberTable);
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 9;
        mainPanel.add(tableScrollPane, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // Event Listeners
        resetButton.addActionListener(e -> clearForm());
        deleteButton.addActionListener(e -> deleteMember());
        updateButton.addActionListener(e -> updateMember());

        setVisible(true);
    }

    private void clearForm() {
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        addressField.setText("");
        payDateField.setText("");
        memberIdLabel.setText(" - ");
    }

    private void deleteMember() {
        int selectedRow = memberTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        }
    }

    private void updateMember() {
        // Add code to update member
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ManageMembers::new);
    }
}
