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

        // Create toolbar
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        Dimension buttonSize = new Dimension(150, 50); // Set preferred button size

        JButton addMemberButton = new JButton("Add Member", new ImageIcon("path/to/add_member_icon.png"));
        addMemberButton.setPreferredSize(buttonSize);
        addMemberButton.setMinimumSize(buttonSize);
        JButton manageMemberButton = new JButton("Manage Member", new ImageIcon("path/to/manage_member_icon.png"));
        manageMemberButton.setPreferredSize(buttonSize);
        manageMemberButton.setMinimumSize(buttonSize);
        JButton trainersButton = new JButton("Trainers", new ImageIcon("path/to/trainers_icon.png"));
        trainersButton.setPreferredSize(buttonSize);
        trainersButton.setMinimumSize(buttonSize);
        JButton membersListButton = new JButton("Members List", new ImageIcon("path/to/members_list_icon.png"));
        membersListButton.setPreferredSize(buttonSize);
        membersListButton.setMinimumSize(buttonSize);
        JButton paymentsButton = new JButton("Payments", new ImageIcon("path/to/payments_icon.png"));
        paymentsButton.setPreferredSize(buttonSize);
        paymentsButton.setMinimumSize(buttonSize);
        JButton logoutButton = new JButton("Log out", new ImageIcon("path/to/logout_icon.png"));
        logoutButton.setPreferredSize(buttonSize);
        logoutButton.setMinimumSize(buttonSize);

        // Set background color to light blue
        Color lightBlue = new Color(173, 216, 230);
        addMemberButton.setBackground(lightBlue);
        manageMemberButton.setBackground(lightBlue);
        trainersButton.setBackground(lightBlue);
        membersListButton.setBackground(lightBlue);
        paymentsButton.setBackground(lightBlue);
        logoutButton.setBackground(lightBlue);

        toolBar.add(addMemberButton);
         
        toolBar.add(manageMemberButton);
         
        toolBar.add(trainersButton);
         
        toolBar.add(membersListButton);
         
        toolBar.add(paymentsButton);
         
        toolBar.add(logoutButton);

        backgroundPanel.add(toolBar, BorderLayout.NORTH);

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
                new AddMemberForm();
            }
        });

        manageMemberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageMembers(); // Opens the ManageMembers window
            }
        });

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
}
