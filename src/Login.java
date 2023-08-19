import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(330, 120, 800, 300);

        JLabel usernameField = new JLabel("Username: ");
        usernameField.setBounds(50, 50, 100, 30);
        usernameField.setFont(new Font("Roboto", Font.BOLD, 16));
        add(usernameField);

        JLabel passwordField = new JLabel("Password: ");
        passwordField.setBounds(50, 100, 100, 30);
        passwordField.setFont(new Font("Roboto", Font.BOLD, 16));
        add(passwordField);

        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(150, 50, 300, 30);
        add(usernameInput);

        JPasswordField passwordInput = new JPasswordField();
        passwordInput.setBounds(150, 100, 300, 30);
        add(passwordInput);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(80, 180, 150, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.white);
        loginButton.setFont(new Font("Roboto", Font.BOLD, 18));
        add(loginButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 180, 150, 30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.white);
        cancelButton.setFont(new Font("Roboto", Font.BOLD, 18));
        add(cancelButton);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image imgCrop = img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imgCropConv = new ImageIcon(imgCrop);
        JLabel loginImage = new JLabel(imgCropConv);
        loginImage.setBounds(500, 30, 200, 200);
        add(loginImage);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
}
