import javax.swing.*;
import java.awt.*;

public class HotelDashboard extends JFrame {

    HotelDashboard() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon scaledImgIcon = new ImageIcon(scaledImg);

        JLabel dashboardImage = new JLabel(scaledImgIcon);
        dashboardImage.setBounds(0, 0, 1550, 1000);
        add(dashboardImage);

        JLabel dashboardText = new JLabel("SUNRISE HOTEL WELCOMES YOU");
        dashboardText.setBounds(500, 30, 600, 50);
        dashboardText.setFont(new Font("Roboto", Font.BOLD, 34));
        dashboardImage.add(dashboardText);

        JMenuBar dashboardMb = new JMenuBar();
        dashboardMb.setBounds(0, 0, 1550, 25);
        dashboardImage.add(dashboardMb);

        JMenu optionHotelMgmt = new JMenu("Hotel Management");
        dashboardMb.add(optionHotelMgmt);
        JMenuItem reception = new JMenuItem("Reception");
        optionHotelMgmt.add(reception);

        JMenu optionAdmin = new JMenu("Admin");
        dashboardMb.add(optionAdmin);
        JMenuItem addEmployee = new JMenuItem("Add Employee");
        optionAdmin.add(addEmployee);
        JMenuItem addRooms = new JMenuItem("Add Rooms");
        optionAdmin.add(addRooms);
        JMenuItem addDrivers = new JMenuItem("Add Drivers");
        optionAdmin.add(addDrivers);


        setVisible(true);
    }
    public static void main(String[] args) {
        new HotelDashboard();
    }
}
