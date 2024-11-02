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
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load background image
        ImageIcon backgroundImage = new ImageIcon("Images\\Background.gif");
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
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Header
        JLabel headerLabel = new JLabel("ADD MEMBER", SwingConstants.CENTER);
        headerLabel.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 24));
        gbc.gridwidth = 4; 
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(headerLabel, gbc);

        // Member ID
        JLabel memberIdText = new JLabel("Member ID:");
        memberIdLabel = new JLabel(" ", SwingConstants.LEFT);
        memberIdLabel.setForeground(Color.RED);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(memberIdText, gbc);

        gbc.gridx = 1;
        mainPanel.add(memberIdLabel, gbc);

        // Member Type
        JLabel memberTypeLabel = new JLabel("Member Type:");
        memberTypeCombo = new JComboBox<>(new String[]{"Plus", "Regular"});
        gbc.gridx = 2;
        mainPanel.add(memberTypeLabel, gbc);

        gbc.gridx = 3;
        mainPanel.add(memberTypeCombo, gbc);

        // First Name
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(firstNameField, gbc);

        // Last Name
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(15);
        gbc.gridx = 2;
        mainPanel.add(lastNameLabel, gbc);

        gbc.gridx = 3;
        mainPanel.add(lastNameField, gbc);

        // Phone Number
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(phoneLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(phoneNumberField, gbc);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(15);
        gbc.gridx = 2;
        mainPanel.add(emailLabel, gbc);

        gbc.gridx = 3;
        mainPanel.add(emailField, gbc);

        // Address
        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(addressLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        mainPanel.add(addressField, gbc);
        gbc.gridwidth = 1;

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderCombo = new JComboBox<>(new String[]{"Male", "Female"});
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(genderCombo, gbc);

        // Amount Pay
        JLabel amountLabel = new JLabel("Amount Pay:");
        amountField = new JTextField(15);
        gbc.gridx = 2;
        mainPanel.add(amountLabel, gbc);

        gbc.gridx = 3;
        mainPanel.add(amountField, gbc);

        // Trainer
        JLabel trainerLabel = new JLabel("Trainer:");
        trainerCombo = new JComboBox<>(new String[]{"Trainer 1", "Trainer 2", "Trainer 3"});
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(trainerLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(trainerCombo, gbc);

        // Register Date
        JLabel registerDateLabel = new JLabel("Register Date:");
        registerDateField = new JFormattedTextField(new SimpleDateFormat("MMM dd, yyyy"));
        registerDateField.setValue(new Date());
        gbc.gridx = 2;
        mainPanel.add(registerDateLabel, gbc);

        gbc.gridx = 3;
        mainPanel.add(registerDateField, gbc);

        // Save Button
        saveButton = new JButton("Save");
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
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        // Clear Button
        clearButton = new JButton("Clear");
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
