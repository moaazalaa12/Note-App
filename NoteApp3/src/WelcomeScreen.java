import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JFrame {

    public WelcomeScreen() {
        // Remove window borders
        setUndecorated(true);

        // Set the size of the welcome screen
        setSize(500, 300);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Create a Panel with Green Background
        JPanel splashPanel = new JPanel();
        splashPanel.setBackground(new Color(173, 216, 130)); // Light green color
        splashPanel.setLayout(new BorderLayout());

        // Add a Welcome Label in the Center
        JLabel welcomeLabel = new JLabel("WELCOME", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Large, bold font
        welcomeLabel.setForeground(Color.WHITE); // White text color

        splashPanel.add(welcomeLabel, BorderLayout.CENTER);
        add(splashPanel); // Add panel to the JFrame

        // Show the Welcome Screen
        setVisible(true);

        // Display for 4 seconds
        try {
            Thread.sleep(1000); // 4000 milliseconds = 4 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the Welcome Screen
        dispose();

        // Navigate to the Login Screen
        new LoginScreen();
    }


}