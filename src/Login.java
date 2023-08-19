import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(330, 120, 1000, 600);
        setVisible(true);

        JLabel usernameField = new JLabel("Username: ");
        usernameField.setBounds(50, 20, 100, 100);
        usernameField.setFont(new Font("Roboto", Font.BOLD, 16));
        add(usernameField);

        JLabel passwordField = new JLabel("Password: ");
        passwordField.setBounds(50, 70, 100, 100);
        passwordField.setFont(new Font("Roboto", Font.BOLD, 16));
        add(passwordField);

        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(100, 20, 300, 100);
        usernameInput.setFont(new Font("Roboto", Font.BOLD, 16));
        add(usernameInput);
        
        JTextField passwordInput = new JTextField();
        passwordInput.setBounds(100, 70, 300, 100);
        passwordInput.setFont(new Font("Roboto", Font.BOLD, 16));
        add(passwordInput);

    }
    public static void main(String[] args) {
        new Login();
    }
}
