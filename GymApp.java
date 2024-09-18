import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GymApp extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTabbedPane tabbedPane;

    // Store member information in a map for simplicity
    private Map<String, Member> members = new HashMap<>();

    public GymApp() {
        // Set up the frame
        setTitle("Gym Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize CardLayout and JPanel for login and registration
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add login and registration panels
        cardPanel.add(createLoginPanel(), "Login");
        cardPanel.add(createRegisterPanel(), "Register");

        // Create and add tabbedPane for member management and booking
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Add Member", createAddMemberPanel());
        tabbedPane.addTab("Update Member", createUpdateMemberPanel());
        tabbedPane.addTab("Booking", createBookingPanel());

        // Add cardPanel and tabbedPane to the frame
        add(cardPanel);

        // Show login panel by default
        cardLayout.show(cardPanel, "Login");
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Username
        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(userLabel, gbc);

        JTextField userField = new JTextField(20);
        gbc.gridx = 1;
        loginPanel.add(userField, gbc);

        // Password
        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField(20);
        gbc.gridx = 1;
        loginPanel.add(passField, gbc);

        // Login button
        JButton loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Login clicked");
                // Switch to the tabbedPane after login
                remove(cardPanel);
                add(tabbedPane);
                revalidate();
                repaint();
            }
        });
        loginPanel.add(loginButton, gbc);

        // Register button
        JButton registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 3;
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Register");
            }
        });
        loginPanel.add(registerButton, gbc);

        return loginPanel;
    }

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Username
        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        registerPanel.add(userLabel, gbc);

        JTextField userField = new JTextField(20);
        gbc.gridx = 1;
        registerPanel.add(userField, gbc);

        // Password
        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        registerPanel.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField(20);
        gbc.gridx = 1;
        registerPanel.add(passField, gbc);

        // Confirm Password
        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(confirmPassLabel, gbc);

        JPasswordField confirmPassField = new JPasswordField(20);
        gbc.gridx = 1;
        registerPanel.add(confirmPassField, gbc);

        // Register button
        JButton registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 3;
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Register clicked");
                // Add actual registration logic here
            }
        });
        registerPanel.add(registerButton, gbc);

        // Back to Login button
        JButton backButton = new JButton("Back to Login");
        gbc.gridx = 1;
        gbc.gridy = 4;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Login");
            }
        });
        registerPanel.add(backButton, gbc);

        return registerPanel;
    }

    // Panel for adding a new member
    private JPanel createAddMemberPanel() {
        JPanel addMemberPanel = new JPanel(new GridLayout(7, 2, 10, 10));

        // Create fields and labels for member details
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel weightLabel = new JLabel("Weight (kg):");
        JTextField weightField = new JTextField(20);

        JLabel heightLabel = new JLabel("Height (cm):");
        JTextField heightField = new JTextField(20);

        JLabel bloodGroupLabel = new JLabel("Blood Group:");
        JTextField bloodGroupField = new JTextField(20);

        JLabel bmiLabel = new JLabel("BMI:");
        JTextField bmiField = new JTextField(20);

        JLabel contactLabel = new JLabel("Contact Number:");
        JTextField contactField = new JTextField(20);

        JLabel aadharLabel = new JLabel("Aadhar Number:");
        JTextField aadharField = new JTextField(20);

        JButton addButton = new JButton("Add Member");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = "ID" + new Random().nextInt(1000); // Random ID for demo

                // Store member info in a member object
                Member newMember = new Member(nameField.getText(), weightField.getText(), heightField.getText(),
                        bloodGroupField.getText(), bmiField.getText(), contactField.getText(), aadharField.getText());

                // Store in the member map
                members.put(memberId, newMember);
                JOptionPane.showMessageDialog(null, "Member added with ID: " + memberId);

                // Clear fields after adding
                nameField.setText("");
                weightField.setText("");
                heightField.setText("");
                bloodGroupField.setText("");
                bmiField.setText("");
                contactField.setText("");
                aadharField.setText("");
            }
        });

        // Add all components to the panel
        addMemberPanel.add(nameLabel);
        addMemberPanel.add(nameField);

        addMemberPanel.add(weightLabel);
        addMemberPanel.add(weightField);

        addMemberPanel.add(heightLabel);
        addMemberPanel.add(heightField);

        addMemberPanel.add(bloodGroupLabel);
        addMemberPanel.add(bloodGroupField);

        addMemberPanel.add(bmiLabel);
        addMemberPanel.add(bmiField);

        addMemberPanel.add(contactLabel);
        addMemberPanel.add(contactField);

        addMemberPanel.add(aadharLabel);
        addMemberPanel.add(aadharField);

        addMemberPanel.add(new JLabel()); // Empty for spacing
        addMemberPanel.add(addButton);

        return addMemberPanel;
    }

    // Panel for updating an existing member
    private JPanel createUpdateMemberPanel() {
        JPanel updateMemberPanel = new JPanel(new GridLayout(8, 2, 10, 10));

        // Member ID field to search for the member
        JLabel idLabel = new JLabel("Member ID:");
        JTextField idField = new JTextField(20);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel weightLabel = new JLabel("Weight (kg):");
        JTextField weightField = new JTextField(20);

        JLabel heightLabel = new JLabel("Height (cm):");
        JTextField heightField = new JTextField(20);

        JLabel bloodGroupLabel = new JLabel("Blood Group:");
        JTextField bloodGroupField = new JTextField(20);

        JLabel bmiLabel = new JLabel("BMI:");
        JTextField bmiField = new JTextField(20);

        JLabel contactLabel = new JLabel("Contact Number:");
        JTextField contactField = new JTextField(20);

        JLabel aadharLabel = new JLabel("Aadhar Number:");
        JTextField aadharField = new JTextField(20);

        JButton updateButton = new JButton("Update Member");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = idField.getText();
                if (members.containsKey(memberId)) {
                    Member member = members.get(memberId);
                    member.setName(nameField.getText());
                    member.setWeight(weightField.getText());
                    member.setHeight(heightField.getText());
                    member.setBloodGroup(bloodGroupField.getText());
                    member.setBmi(bmiField.getText());
                    member.setContact(contactField.getText());
                    member.setAadhar(aadharField.getText());
                    JOptionPane.showMessageDialog(null, "Member updated: " + memberId);
                } else {
                    JOptionPane.showMessageDialog(null, "Member not found");
                }
            }
        });

        // Add components to the update panel
        updateMemberPanel.add(idLabel);
        updateMemberPanel.add(idField);

        updateMemberPanel.add(nameLabel);
        updateMemberPanel.add(nameField);

        updateMemberPanel.add(weightLabel);
        updateMemberPanel.add(weightField);

        updateMemberPanel.add(heightLabel);
        updateMemberPanel.add(heightField);

        updateMemberPanel.add(bloodGroupLabel);
        updateMemberPanel.add(bloodGroupField);

        updateMemberPanel.add(bmiLabel);
        updateMemberPanel.add(bmiField);

        updateMemberPanel.add(contactLabel);
        updateMemberPanel.add(contactField);

        updateMemberPanel.add(aadharLabel);
        updateMemberPanel.add(aadharField);

        updateMemberPanel.add(new JLabel()); // Empty for spacing
        updateMemberPanel.add(updateButton);

        return updateMemberPanel;
    }

    // Panel for booking gym slots
    private JPanel createBookingPanel() {
        JPanel bookingPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        // Gym Timings dropdown
        JLabel timingLabel = new JLabel("Select Gym Timing:");
        String[] timings = {"06:00 - 07:00", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00"};
        JComboBox<String> timingComboBox = new JComboBox<>(timings);

        JButton confirmButton = new JButton("Confirm Booking");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTime = (String) timingComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Booking confirmed for: " + selectedTime);
            }
        });

        // Add components to the booking panel
        bookingPanel.add(timingLabel);
        bookingPanel.add(timingComboBox);
        bookingPanel.add(new JLabel()); // Empty for spacing
        bookingPanel.add(confirmButton);

        return bookingPanel;
    }

    // Helper class to store member information
    private class Member {
        private String name;
        private String weight;
        private String height;
        private String bloodGroup;
        private String bmi;
        private String contact;
        private String aadhar;

        public Member(String name, String weight, String height, String bloodGroup, String bmi, String contact, String aadhar) {
            this.name = name;
            this.weight = weight;
            this.height = height;
            this.bloodGroup = bloodGroup;
            this.bmi = bmi;
            this.contact = contact;
            this.aadhar = aadhar;
        }

        // Getters and setters for the member fields
        public void setName(String name) {
            this.name = name;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public void setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
        }

        public void setBmi(String bmi) {
            this.bmi = bmi;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public void setAadhar(String aadhar) {
            this.aadhar = aadhar;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GymApp app = new GymApp();
            app.setVisible(true);
        });
    }
}