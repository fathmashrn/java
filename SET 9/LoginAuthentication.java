import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginAuthentication extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;

    JButton login, reset, exit;

    LoginAuthentication() {

        setTitle("Login Form");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Username:"));

        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));

        passwordField = new JPasswordField();
        add(passwordField);

        login = new JButton("Login");
        reset = new JButton("Reset");
        exit = new JButton("Exit");

        add(login);
        add(reset);

        add(exit);
        add(new JLabel(""));

        login.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Predefined username and password
            if (username.equals("admin") && password.equals("1234")) {

                JOptionPane.showMessageDialog(this,
                        "Login Successful!");

            } else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password!",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        else if (e.getSource() == reset) {

            usernameField.setText("");
            passwordField.setText("");
        }

        else if (e.getSource() == exit) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LoginAuthentication();
    }
}
