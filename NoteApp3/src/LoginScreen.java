//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class LoginScreen extends JFrame {
//
//    JPanel mainPanel;
//    JLabel userLabel, passLabel, registerLabel;
//    JTextField userText;
//    JPasswordField passText;
//    JButton loginButton;
//    //User currUser;
//    UserManager usermg;
//
//    public LoginScreen() {
//        usermg = new UserManager();
//        // Set JFrame properties
//        setTitle("Login Screen");
//        setSize(400, 300);
////        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null); // Center the window
//        setResizable(false);
//        ImageIcon appIcon = new ImageIcon("D:/Notes/notes.png");
//        this.setIconImage(appIcon.getImage());
//
//        // Create JPanel with green background
//        mainPanel = new JPanel();
//        mainPanel.setBackground(new Color(173, 216, 130)); // Light green background
//        mainPanel.setLayout(null); // Absolute layout for positioning
//
//        // Username Label
//        userLabel = new JLabel("Username:");
//        userLabel.setBounds(50, 50, 80, 25);
//        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
//        userLabel.setForeground(Color.BLACK);
//        mainPanel.add(userLabel);
//
//        // Username TextField
//        userText = new JTextField(20);
//        userText.setBounds(150, 50, 165, 25);
//        mainPanel.add(userText);
//
//        // Password Label
//        passLabel = new JLabel("Password:");
//        passLabel.setBounds(50, 100, 80, 25);
//        passLabel.setFont(new Font("Arial", Font.BOLD, 14));
//        passLabel.setForeground(Color.BLACK);
//        mainPanel.add(passLabel);
//
//        // Password Field
//        passText = new JPasswordField(20);
//        passText.setBounds(150, 100, 165, 25);
//        mainPanel.add(passText);
//
//        // Login Button
//        loginButton = new JButton("Login");
//        loginButton.setBounds(150, 150, 80, 25);
//        loginButton.setForeground(Color.WHITE);
//        loginButton.setBackground(new Color(34, 139, 34)); // Dark green button
//        mainPanel.add(loginButton);
//
//        // Register Link
//        registerLabel = new JLabel("Don't have an account? Register");
//        registerLabel.setBounds(100, 200, 250, 25);
//        registerLabel.setForeground(Color.BLUE);
//        registerLabel.setFont(new Font("Arial", Font.BOLD, 12));
//        mainPanel.add(registerLabel);
//
//
//        registerLabel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                new SignUpScreen();
//                dispose();
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                registerLabel.setForeground(Color.BLACK);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                registerLabel.setForeground(Color.BLUE);
//            }
//        });
//
//
//        // Action Listener for Login Button
//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                String username = userText.getText();
//                String password = new String(passText.getPassword());
//                User currUser = new User(username, password);
//                if (usermg.checkValidityOfUser(currUser)) {
//                    dispose();
//                    new NoteApp(currUser);
//                } else {
//                    JOptionPane.showMessageDialog(null, "username doesn't exist or password is wrong", "Warning", JOptionPane.INFORMATION_MESSAGE);
//                    //dispose();
//                    //new SignUpScreen();
//                }
//            }
//        });
//
//        // Add panel to frame
//        add(mainPanel);
//        setVisible(true);
//    }
//
//
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame {
    private JPanel mainPanel;
    private JLabel userLabel, passLabel, registerLabel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton;
    private UserManager usermg;

    public LoginScreen() {
        usermg = new UserManager();
        setTitle("Login Screen");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon appIcon = new ImageIcon("D:/Notes/notes.png");
        this.setIconImage(appIcon.getImage());

        mainPanel = new JPanel();
        mainPanel.setBackground(StyleUtils.BACKGROUND_COLOR);
        mainPanel.setLayout(null);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 80, 25);
        userLabel.setFont(StyleUtils.LABEL_FONT);
        userLabel.setForeground(StyleUtils.TEXT_COLOR);
        mainPanel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(150, 50, 165, 25);
        mainPanel.add(userText);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 80, 25);
        passLabel.setFont(StyleUtils.LABEL_FONT);
        passLabel.setForeground(StyleUtils.TEXT_COLOR);
        mainPanel.add(passLabel);

        passText = new JPasswordField(20);
        passText.setBounds(150, 100, 165, 25);
        mainPanel.add(passText);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 80, 25);
        StyleUtils.styleButton(loginButton);
        mainPanel.add(loginButton);

        registerLabel = new JLabel("Don't have an account? Register");
        registerLabel.setBounds(100, 200, 250, 25);
        registerLabel.setForeground(Color.BLUE);
        registerLabel.setFont(StyleUtils.LINK_FONT);
        mainPanel.add(registerLabel);

        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SignUpScreen();
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                registerLabel.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerLabel.setForeground(Color.BLUE);
            }
        });

        loginButton.addActionListener(e -> attemptLogin());

        add(mainPanel);
        setVisible(true);
    }

    private void attemptLogin() {
        String username = userText.getText();
        String password = new String(passText.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            User currUser = new User(username, password);
            if (usermg.checkValidityOfUser(currUser)) {
                dispose();
                new NoteApp(currUser);
            } else {
                JOptionPane.showMessageDialog(this, "Username doesn't exist or password is wrong.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginScreen::new);
    }
}
