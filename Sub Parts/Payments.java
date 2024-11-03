import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Payments extends JFrame {
    private JTextField searchField;
    private JTable paymentTable;
    private DefaultTableModel tableModel;

    public Payments() {
        setTitle("Member Payments");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Payment Status", JLabel.CENTER);
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
        String[] columnNames = {
            "ID", "Name", "Type", "Trainer", "Payment Amount", 
            "Payment Date", "Duration (Days)", "Remaining Days", 
            "Transaction ID", "Status"
        };

        // Table Model and Table
        tableModel = new DefaultTableModel(columnNames, 0);
        paymentTable = new JTable(tableModel);
        paymentTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        paymentTable.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(paymentTable);
        add(scrollPane, BorderLayout.CENTER);

        // Sample Data
        addPaymentData("001", "John Doe", "Basic", "Trainer A", "$100", LocalDate.of(2024, 10, 1), 30);
        addPaymentData("002", "Jane Smith", "Premium", "Trainer B", "$300", LocalDate.of(2024, 9, 15), 60);

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

    // Method to add payment data to the table
    private void addPaymentData(String id, String name, String type, String trainer, String paymentAmount, LocalDate paymentDate, int durationDays) {
        String transactionId = generateTransactionId();
        LocalDate currentDate = LocalDate.now();
        long daysSincePayment = ChronoUnit.DAYS.between(paymentDate, currentDate);
        long remainingDays = durationDays - daysSincePayment;
        String status = remainingDays > 0 ? "Active" : "Expired";

        tableModel.addRow(new Object[]{
            id, name, type, trainer, paymentAmount, paymentDate, durationDays, remainingDays > 0 ? remainingDays : 0, transactionId, status
        });
    }

    // Method to generate a random Transaction ID (10 chars alphanumeric)
    private String generateTransactionId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder transactionId = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            transactionId.append(characters.charAt(random.nextInt(characters.length())));
        }
        return transactionId.toString();
    }

    // Method to search member by ID or Name
    private void searchMember(String searchText) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String memberId = tableModel.getValueAt(i, 0).toString();
            String memberName = tableModel.getValueAt(i, 1).toString();
            if (memberId.equalsIgnoreCase(searchText) || memberName.equalsIgnoreCase(searchText)) {
                String details = "Member ID: " + memberId +
                                 "\nName: " + memberName +
                                 "\nType: " + tableModel.getValueAt(i, 2) +
                                 "\nTrainer: " + tableModel.getValueAt(i, 3) +
                                 "\nPayment Amount: " + tableModel.getValueAt(i, 4) +
                                 "\nPayment Date: " + tableModel.getValueAt(i, 5) +
                                 "\nDuration (Days): " + tableModel.getValueAt(i, 6) +
                                 "\nRemaining Days: " + tableModel.getValueAt(i, 7) +
                                 "\nTransaction ID: " + tableModel.getValueAt(i, 8) +
                                 "\nStatus: " + tableModel.getValueAt(i, 9);
                
                JOptionPane.showMessageDialog(this, details, "Payment Details", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No member found with the provided ID or Name.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Payments frame = new Payments();
            frame.setVisible(true);
        });
    }
}
