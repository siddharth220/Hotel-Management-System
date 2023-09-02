import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField usernameInput, passwordInput;
    JButton loginButton, cancelButton;
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

        usernameInput = new JTextField();
        usernameInput.setBounds(150, 50, 300, 30);
        add(usernameInput);

        passwordInput = new JTextField();
        passwordInput.setBounds(150, 100, 300, 30);
        add(passwordInput);

        loginButton = new JButton("Login");
        loginButton.setBounds(80, 180, 150, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.white);
        loginButton.setFont(new Font("Roboto", Font.BOLD, 18));
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 180, 150, 30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.white);
        cancelButton.setFont(new Font("Roboto", Font.BOLD, 18));
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image imgCrop = img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imgCropConv = new ImageIcon(imgCrop);
        JLabel loginImage = new JLabel(imgCropConv);
        loginImage.setBounds(500, 30, 200, 200);
        add(loginImage);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            String username = usernameInput.getText();
            String password = passwordInput.getText();

            try  {
                ConnectionDB c = new ConnectionDB();
                String query = "SELECT * FROM login_info WHERE username = '" +username+ "' AND password = " + password;
                ResultSet rSet = c.statement.executeQuery(query);

                if (rSet.next()) {
                    setVisible(false);
                    new HotelDashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "The Username or Password input is invalid");
                }
            } catch (Exception e) {
                e.printStackTrace();  // Print the exception's stack trace for debugging purposes
            }
        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
