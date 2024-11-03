import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddMemberForm extends JFrame {
    private JTextField firstNameField, lastNameField, phoneNumberField, emailField, addressField, amountField;
    private JComboBox<String> genderCombo, memberTypeCombo, trainerCombo;
    private JLabel memberIdLabel;
    private JButton saveButton, resetButton, clearButton;
    private JFormattedTextField registerDateField;
    private int memberIdCounter = 1;

    public AddMemberForm() {
        setTitle("Add Member");
        setSize(800, 800);  // Increased size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load background image
        ImageIcon backgroundImage = new ImageIcon("Images\\download (32).jpeg.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel);

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(0, 0, 0, 0));  // Transparent background for the panel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);  // Increased insets
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font font = new Font("TIMES NEW ROMAN", Font.BOLD, 24);  // Increased font size

        // Header
        JLabel headerLabel = new JLabel("ADD MEMBER", SwingConstants.CENTER);
        headerLabel.setFont(font);
        headerLabel.setForeground(Color.WHITE);
        gbc.gridwidth = 4; 
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(headerLabel, gbc);

        // Member ID
        JLabel memberIdText = new JLabel("Member ID:");
        memberIdText.setFont(font);
        memberIdText.setForeground(Color.WHITE);
        memberIdLabel = new JLabel(" ", SwingConstants.LEFT);
        memberIdLabel.setFont(font);
        memberIdLabel.setForeground(Color.RED);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(memberIdText, gbc);

        gbc.gridx = 1;
        mainPanel.add(memberIdLabel, gbc);

        // Member Type
        JLabel memberTypeLabel = new JLabel("Member Type:");
        memberTypeLabel.setFont(font);
        memberTypeLabel.setForeground(Color.WHITE);
        memberTypeCombo = new JComboBox<>(new String[]{"Plus", "Regular"});
        memberTypeCombo.setFont(font);
        gbc.gridx = 2;
        mainPanel.add(memberTypeLabel, gbc);

        gbc.gridx = 3;
        mainPanel.add(memberTypeCombo, gbc);

        // First Name
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(font);
        firstNameLabel.setForeground(Color.WHITE);
        firstNameField = new JTextField(15);
        firstNameField.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(firstNameField, gbc);

        // Last Name
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(font);
        lastNameLabel.setForeground(Color.WHITE);
        lastNameField = new JTextField(15);
        lastNameField.setFont(font);
        gbc.gridx = 2;
        mainPanel.add(lastNameLabel, gbc);

        gbc.gridx = 3;
        mainPanel.add(lastNameField, gbc);

        // Phone Number
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(font);
        phoneLabel.setForeground(Color.WHITE);
        phoneNumberField = new JTextField(15);
        phoneNumberField.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(phoneLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(phoneNumberField, gbc);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(font);
        emailLabel.setForeground(Color.WHITE);
        emailField = new JTextField(15);
        emailField.setFont(font);
        gbc.gridx = 2;
        mainPanel.add(emailLabel, gbc);

        gbc.gridx = 3;
        mainPanel.add(emailField, gbc);

        // Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(font);
        addressLabel.setForeground(Color.WHITE);
        addressField = new JTextField(15);
        addressField.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(addressLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        mainPanel.add(addressField, gbc);
        gbc.gridwidth = 1;

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(font);
        genderLabel.setForeground(Color.WHITE);
        genderCombo = new JComboBox<>(new String[]{"Male", "Female"});
        genderCombo.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(genderCombo, gbc);

        // Amount Pay
        JLabel amountLabel = new JLabel("Amount Pay:");
        amountLabel.setFont(font);
        amountLabel.setForeground(Color.WHITE);
        amountField = new JTextField(15);
        amountField.setFont(font);
        gbc.gridx = 2;
        mainPanel.add(amountLabel, gbc);

        gbc.gridx = 3;
        mainPanel.add(amountField, gbc);

        // Trainer
        JLabel trainerLabel = new JLabel("Trainer:");
        trainerLabel.setFont(font);
        trainerLabel.setForeground(Color.WHITE);
        trainerCombo = new JComboBox<>(new String[]{"Trainer 1", "Trainer 2", "Trainer 3"});
        trainerCombo.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(trainerLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(trainerCombo, gbc);

        // Register Date
        JLabel registerDateLabel = new JLabel("Register Date:");
        registerDateLabel.setFont(font);
        registerDateLabel.setForeground(Color.WHITE);
        registerDateField = new JFormattedTextField(new SimpleDateFormat("MMM dd, yyyy"));
        registerDateField.setFont(font);
        registerDateField.setValue(new Date());
        gbc.gridx = 2;
        mainPanel.add(registerDateLabel, gbc);

        gbc.gridx = 3;
        mainPanel.add(registerDateField, gbc);

        // Save Button
        saveButton = new JButton("Save");
        saveButton.setFont(font);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (areFieldsFilled()) {
                    memberIdLabel.setText(String.format("%03d", memberIdCounter++));
                    JOptionPane.showMessageDialog(null, "Member Saved Successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all fields before saving.");
                }
            }
        });

        // Reset Button
        resetButton = new JButton("Reset");
        resetButton.setFont(font);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        // Clear Button
        clearButton = new JButton("Clear");
        clearButton.setFont(font);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(saveButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);

        backgroundLabel.add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private boolean areFieldsFilled() {
        return !firstNameField.getText().trim().isEmpty() &&
                !lastNameField.getText().trim().isEmpty() &&
                !phoneNumberField.getText().trim().isEmpty() &&
                !emailField.getText().trim().isEmpty() &&
                !addressField.getText().trim().isEmpty() &&
                !amountField.getText().trim().isEmpty();
    }

    private void resetFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        phoneNumberField.setText("");
        emailField.setText("");
        addressField.setText("");
        amountField.setText("");
        memberIdLabel.setText(" ");
    }

    private void clearFields() {
        resetFields();
        registerDateField.setValue(new Date());
        memberIdLabel.setText(" ");
    }

    public static void main(String[] args) {
        new AddMemberForm();
    }
}
