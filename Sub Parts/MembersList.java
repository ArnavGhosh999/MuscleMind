import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MembersList extends JFrame {
    private JTextField searchField;
    private JTable membersTable;
    private DefaultTableModel tableModel;

    public MembersList() {
        setTitle("Members List");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Gym Members List", JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        JLabel searchLabel = new JLabel("Search by Member ID or Name:");
        searchLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        add(searchPanel, BorderLayout.NORTH);

        // Table Columns
        String[] columnNames = {"ID", "Name", "Age", "Gender", "Phone", "Email", "Join Date", "Payment Amount", "Trainer Assigned"};
        
        // Table Model and Table
        tableModel = new DefaultTableModel(columnNames, 0);
        membersTable = new JTable(tableModel);
        membersTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        membersTable.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        
        JScrollPane scrollPane = new JScrollPane(membersTable);
        add(scrollPane, BorderLayout.CENTER);

        // Sample Data
        addMemberData("001", "John Doe", 25, "Male", "1234567890", "john@example.com", "2024-01-15", "$200", "Trainer A");
        addMemberData("002", "Jane Smith", 30, "Female", "0987654321", "jane@example.com", "2024-02-20", "$250", "Trainer B");

        // Search Button Action
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().trim();
                if (!searchText.isEmpty()) {
                    searchMember(searchText);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a Member ID or Name to search.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Method to add member data to the table
    private void addMemberData(String id, String name, int age, String gender, String phone, String email, String joinDate, String payment, String trainer) {
        tableModel.addRow(new Object[]{id, name, age, gender, phone, email, joinDate, payment, trainer});
    }

    // Method to search member by ID or Name
    private void searchMember(String searchText) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String memberId = tableModel.getValueAt(i, 0).toString();
            String memberName = tableModel.getValueAt(i, 1).toString();
            if (memberId.equalsIgnoreCase(searchText) || memberName.equalsIgnoreCase(searchText)) {
                String details = "Member ID: " + memberId +
                                 "\nName: " + memberName +
                                 "\nAge: " + tableModel.getValueAt(i, 2) +
                                 "\nGender: " + tableModel.getValueAt(i, 3) +
                                 "\nPhone: " + tableModel.getValueAt(i, 4) +
                                 "\nEmail: " + tableModel.getValueAt(i, 5) +
                                 "\nJoin Date: " + tableModel.getValueAt(i, 6) +
                                 "\nPayment Amount: " + tableModel.getValueAt(i, 7) +
                                 "\nTrainer Assigned: " + tableModel.getValueAt(i, 8);
                
                JOptionPane.showMessageDialog(this, details, "Member Details", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No member found with the provided ID or Name.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MembersList frame = new MembersList();
            frame.setVisible(true);
        });
    }
}
