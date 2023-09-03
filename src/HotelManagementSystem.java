import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    JButton nextPage;

    HotelManagementSystem() {
        setBounds(100, 150, 1366, 565);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        JLabel homeImage = new JLabel(img1);
        homeImage.setBounds(0, 0, 1366, 565);
        add(homeImage);

        JLabel imageText = new JLabel("HOTEL MANAGEMENT SYSTEM");
        imageText.setBounds(380, -25, 800, 100);
        imageText.setForeground(Color.white);
        imageText.setFont(new Font("Roboto", Font.PLAIN, 40));
        homeImage.add(imageText);

        nextPage = new JButton("Next Page");
        nextPage.setBounds(1220, 480, 100, 30);
        nextPage.setFont(new Font("Roboto", Font.BOLD, 12));
        nextPage.addActionListener(this);
        homeImage.add(nextPage);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nextPage) {
            try {
                setVisible(false);
                new Login();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Login: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
