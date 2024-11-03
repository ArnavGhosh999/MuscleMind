import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GymManagementSystem extends JFrame {

    public GymManagementSystem() {
        setTitle("Home");
        setSize(800, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Custom JPanel with scaled background image
        BackgroundPanel backgroundPanel = new BackgroundPanel("Images\\Frontpage.jpg");
        backgroundPanel.setLayout(new BorderLayout());

        // Create toolbar with GridBagLayout for flexible resizing
        JPanel toolBarPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Button size parameters
        Dimension buttonSize = new Dimension(150, 50);

        // Create buttons
        JButton addMemberButton = new JButton("Add Member");
        JButton manageMemberButton = new JButton("Manage Member");
        JButton trainersButton = new JButton("Trainers");
        JButton membersListButton = new JButton("Members List");
        JButton paymentsButton = new JButton("Payments");
        JButton logoutButton = new JButton("Log out");

        // Set background color
        Color lightBlue = new Color(173, 216, 230);
        addMemberButton.setBackground(lightBlue);
        manageMemberButton.setBackground(lightBlue);
        trainersButton.setBackground(lightBlue);
        membersListButton.setBackground(lightBlue);
        paymentsButton.setBackground(lightBlue);
        logoutButton.setBackground(lightBlue);

        // Add buttons to toolbar panel with resizing flexibility
        gbc.gridx = 0;
        toolBarPanel.add(addMemberButton, gbc);
        gbc.gridx = 1;
        toolBarPanel.add(manageMemberButton, gbc);
        gbc.gridx = 2;
        toolBarPanel.add(trainersButton, gbc);
        gbc.gridx = 3;
        toolBarPanel.add(membersListButton, gbc);
        gbc.gridx = 4;
        toolBarPanel.add(paymentsButton, gbc);
        gbc.gridx = 5;
        toolBarPanel.add(logoutButton, gbc);

        // Add toolbar panel to the top of the background panel
        backgroundPanel.add(toolBarPanel, BorderLayout.NORTH);

        // Welcome label
        JLabel welcomeLabel = new JLabel("WELCOME TO MUSCLEMIND! YOUR VERY OWN GYM MANAGEMENT WEBSITE", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
        welcomeLabel.setForeground(Color.WHITE);

        // Center welcome label
        backgroundPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Add background panel to the frame
        setContentPane(backgroundPanel);

        // Button actions
        addMemberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddMemberForm(); // Opens the AddMemberForm window
            }
        });

        manageMemberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageMembers(); // Opens the ManageMembers window
            }
        });

        // Placeholder actions for future features
        trainersButton.addActionListener(e -> System.out.println("Trainers section (future feature)"));
        membersListButton.addActionListener(e -> System.out.println("Members List section (future feature)"));
        paymentsButton.addActionListener(e -> System.out.println("Payments section (future feature)"));
        logoutButton.addActionListener(e -> System.out.println("Logging out..."));

        setVisible(true);
    }

    public static void main(String[] args) {
        new GymManagementSystem();
    }
}

// Custom JPanel class to handle background scaling
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        // Load the background image
        backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Scale the image to fit the entire panel size
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 750); // Preferred size to keep buttons stable
    }
}
