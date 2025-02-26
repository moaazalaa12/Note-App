//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class SignUpScreen extends JFrame implements ActionListener {
//    private JPanel mainPanel;
//    JButton signUpButton;
//    JPanel formPanel;
//    JTextField firstNameField, lastNameField, usernameField;
//    JPasswordField passwordField;
//    JLabel loginLabel, loginLink;
//    UserManager usmg;
//    User currUser;
//
//    public SignUpScreen() {
//        usmg = new UserManager();
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(400, 500);
//        this.setResizable(false);
//        this.setLocationRelativeTo(null);
//        //ImageIcon appIcon = new ImageIcon("D:/Faculty/Second Year/1st Semester/OOP/Note Taking App/icon.jpg");
//        //this.setIconImage(appIcon.getImage());
//
//        mainPanel = new JPanel();
//        mainPanel.setBackground(new Color(173, 216, 130)); // Light Green
//        mainPanel.setLayout(new GridBagLayout());
//
//        formPanel = new JPanel();
//        formPanel.setPreferredSize(new Dimension(300, 400));
//        formPanel.setBackground(Color.WHITE);
//        formPanel.setLayout(null);
//
//        firstNameField = new JTextField();
//        firstNameField.setBounds(20, 20, 260, 35);
//        firstNameField.setText("First Name");
//        firstNameField.setBackground(new Color(241, 238, 237));
//
//        lastNameField = new JTextField();
//        lastNameField.setBounds(20, 70, 260, 35);
//        lastNameField.setText("Last Name");
//        lastNameField.setBackground(new Color(241, 238, 237));
//
//        usernameField = new JTextField();
//        usernameField.setBounds(20, 120, 260, 35);
//        usernameField.setText("Username");
//        usernameField.setBackground(new Color(241, 238, 237));
//
//        passwordField = new JPasswordField();
//        passwordField.setBounds(20, 170, 260, 35);
//        passwordField.setText("Password");
//        passwordField.setBackground(new Color(241, 238, 237));
//
//        signUpButton = new JButton("SIGN UP");
//        signUpButton.setBounds(20, 270, 260, 40);
//        signUpButton.setBackground(new Color(173, 216, 130));
//        signUpButton.setForeground(Color.WHITE);
//        signUpButton.setFocusPainted(false);
//        signUpButton.addActionListener(this);
//
//        loginLabel = new JLabel("Already have an account?");
//        loginLabel.setBounds(70, 330, 200, 20);
//
//        loginLink = new JLabel("Login");
//        loginLink.setBounds(230, 330, 50, 20);
//        loginLink.setForeground(new Color(173, 216, 130));
//
//        loginLink.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                // Open the Login screen
//                dispose();
//                new LoginScreen();
//
//            }
//        });
//
//        formPanel.add(firstNameField);
//        formPanel.add(lastNameField);
//        formPanel.add(usernameField);
//        formPanel.add(passwordField);
//        formPanel.add(signUpButton);
//        formPanel.add(loginLabel);
//        formPanel.add(loginLink);
//
//        mainPanel.add(formPanel);
//        this.add(mainPanel);
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == signUpButton) {
//            String firstNames = firstNameField.getText();
//            String lastNames = lastNameField.getText();
//            String usernames = usernameField.getText();
//            char[] pass = passwordField.getPassword();
//            String passwords = new String(pass);
//            if (passwords.length() < 8) {
//                JOptionPane.showMessageDialog(null, "Password length must be at least 8 characters.", "Warning", JOptionPane.WARNING_MESSAGE);
//                return; // Stop execution if password is invalid
//            }
//            currUser = new User(firstNames, lastNames, usernames, passwords);
//            if (usmg.checkValidityOfUser(currUser)) {
//                JOptionPane.showMessageDialog(null, "This account is exist you can login", "Warning", JOptionPane.INFORMATION_MESSAGE);
//                dispose();
//                new LoginScreen();
//            } else {
//                dispose();
//                usmg.addUser(currUser);
//                new NoteApp(currUser);
//            }
//        }
//    }
//
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpScreen extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton signUpButton;
    private JPanel formPanel;
    private JTextField firstNameField, lastNameField, usernameField;
    private JPasswordField passwordField;
    private JLabel loginLabel, loginLink;
    private UserManager usmg;

    public SignUpScreen() {
        usmg = new UserManager();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setBackground(StyleUtils.BACKGROUND_COLOR);
        mainPanel.setLayout(new GridBagLayout());

        formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(300, 400));
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(null);

        firstNameField = new JTextField("First Name");
        firstNameField.setBounds(20, 20, 260, 35);
        firstNameField.setBackground(new Color(241, 238, 237));

        lastNameField = new JTextField("Last Name");
        lastNameField.setBounds(20, 70, 260, 35);
        lastNameField.setBackground(new Color(241, 238, 237));

        usernameField = new JTextField("Username");
        usernameField.setBounds(20, 120, 260, 35);
        usernameField.setBackground(new Color(241, 238, 237));

        passwordField = new JPasswordField("Password");
        passwordField.setBounds(20, 170, 260, 35);
        passwordField.setBackground(new Color(241, 238, 237));

        signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(20, 270, 260, 40);
        StyleUtils.styleButton(signUpButton);
        signUpButton.addActionListener(this);

        loginLabel = new JLabel("Already have an account?");
        loginLabel.setBounds(70, 330, 200, 20);

        loginLink = new JLabel("Login");
        loginLink.setBounds(230, 330, 50, 20);
        loginLink.setForeground(StyleUtils.BACKGROUND_COLOR);

        loginLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginScreen();
            }
        });

        formPanel.add(firstNameField);
        formPanel.add(lastNameField);
        formPanel.add(usernameField);
        formPanel.add(passwordField);
        formPanel.add(signUpButton);
        formPanel.add(loginLabel);
        formPanel.add(loginLink);

        mainPanel.add(formPanel);
        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            String firstNames = firstNameField.getText();
            String lastNames = lastNameField.getText();
            String usernames = usernameField.getText();
            char[] pass = passwordField.getPassword();
            String passwords = new String(pass);

            if (firstNames.isEmpty() || lastNames.isEmpty() || usernames.isEmpty() || passwords.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (passwords.length() < 8) {
                JOptionPane.showMessageDialog(this, "Password must be at least 8 characters.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            User currUser = new User(firstNames, lastNames, usernames, passwords);
            if (usmg.checkValidityOfUser(currUser)) {
                JOptionPane.showMessageDialog(this, "Account already exists. Please login.", "Warning", JOptionPane.WARNING_MESSAGE);
                dispose();
                new LoginScreen();
            } else {
                usmg.addUser(currUser);
                dispose();
                new NoteApp(currUser);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SignUpScreen::new);
    }
}