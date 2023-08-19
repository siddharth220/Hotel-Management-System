import javax.swing.*;
import java.awt.*;

public class HotelManagementSystem extends JFrame {
    HotelManagementSystem() {
        setBounds(100, 100, 1366, 565);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel homeImage = new JLabel(img1);
        homeImage.setBounds(0, 0, 1366, 565);
        add(homeImage);

        JLabel imageText = new JLabel("HOTEL MANAGEMENT SYSTEM");
        imageText.setBounds(380, -25, 800, 100);
        imageText.setForeground(Color.white);
        imageText.setFont(new Font("Roboto", Font.PLAIN, 40));
        homeImage.add(imageText);

        JButton nextPage = new JButton("Next Page");
        nextPage.setBounds(1220, 480, 100, 30);
        nextPage.setFont(new Font("Roboto", Font.BOLD, 12));
        homeImage.add(nextPage);
        setVisible(true);
        }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
