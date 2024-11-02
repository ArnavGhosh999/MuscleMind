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
        ImageIcon backgroundImage = new ImageIcon("path/to/your/background.jpg"); // Update path to your image
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel);

        Font defaultFont = new Font("Times New Roman", Font.PLAIN, 14);

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
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(headerLabel, gbc);

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setOpaque(false);
        searchPanel.add(new JLabel("Enter the valid ID to get the information"));
        searchPanel.add(new JLabel("Member ID:"));
        memberIdField = new JTextField(10);
        searchButton = new JButton("Search");
        searchPanel.add(memberIdField);
        searchPanel.add(searchButton);

        gbc.gridy = 1;
        mainPanel.add(searchPanel, gbc);

        // Member Details Fields
        JLabel memberIdText = new JLabel("Member ID:");
        memberIdText.setFont(defaultFont);
        memberIdLabel = new JLabel(" - ");
        memberIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(memberIdText, gbc);
        gbc.gridx = 1;
        mainPanel.add(memberIdLabel, gbc);

        // Gender Combo Box
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(defaultFont);
        genderCombo = new JComboBox<>(new String[]{"Male", "Female"});
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(genderLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(genderCombo, gbc);

        // Member Type
        JLabel memberTypeLabel = new JLabel("Member Type:");
        memberTypeLabel.setFont(defaultFont);
        memberTypeCombo = new JComboBox<>(new String[]{"Basic", "Plus"});
        gbc.gridx = 2;
        mainPanel.add(memberTypeLabel, gbc);
        gbc.gridx = 3;
        mainPanel.add(memberTypeCombo, gbc);

        // Register Date
        JLabel registerDateLabel = new JLabel("Registered Date:");
        registerDateLabel.setFont(defaultFont);
        registerDateField = new JFormattedTextField(new SimpleDateFormat("MMM dd, yyyy"));
        registerDateField.setValue(new Date());
        gbc.gridx = 4;
        mainPanel.add(registerDateLabel, gbc);
        gbc.gridx = 5;
        mainPanel.add(registerDateField, gbc);

        // First Name
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(defaultFont);
        firstNameField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(firstNameField, gbc);

        // Last Name
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(defaultFont);
        lastNameField = new JTextField(10);
        gbc.gridx = 2;
        mainPanel.add(lastNameLabel, gbc);
        gbc.gridx = 3;
        mainPanel.add(lastNameField, gbc);

        // Email
        JLabel emailLabel = new JLabel("Email address:");
        emailLabel.setFont(defaultFont);
        emailField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        // Phone Number
        JLabel phoneLabel = new JLabel("Phone number:");
        phoneLabel.setFont(defaultFont);
        phoneField = new JTextField(10);
        gbc.gridx = 2;
        mainPanel.add(phoneLabel, gbc);
        gbc.gridx = 3;
        mainPanel.add(phoneField, gbc);

        // Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(defaultFont);
        addressField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        mainPanel.add(addressField, gbc);

        // Trainer List
        JLabel trainerLabel = new JLabel("Trainer List:");
        trainerLabel.setFont(defaultFont);
        trainerListCombo = new JComboBox<>(new String[]{"Trainer 1", "Trainer 2", "Trainer 3"});
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        mainPanel.add(trainerLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(trainerListCombo, gbc);

        // Pay Date
        JLabel payDateLabel = new JLabel("Pay Date:");
        payDateLabel.setFont(defaultFont);
        payDateField = new JTextField(10);
        gbc.gridx = 2;
        mainPanel.add(payDateLabel, gbc);
        gbc.gridx = 3;
        mainPanel.add(payDateField, gbc);

        // Buttons
        resetButton = new JButton("Reset");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(resetButton, gbc);
        gbc.gridx = 1;
        mainPanel.add(updateButton, gbc);
        gbc.gridx = 2;
        mainPanel.add(deleteButton, gbc);

        // Table for displaying members
        tableModel = new DefaultTableModel(new Object[]{"ID", "First Name", "Last Name"}, 0);
        memberTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(memberTable);
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 8;
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
