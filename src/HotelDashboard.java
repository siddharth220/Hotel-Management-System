import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelDashboard extends JFrame implements ActionListener {

    JMenuItem addEmployee, addRooms, addDrivers, reception;

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
        reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        optionHotelMgmt.add(reception);

        JMenu optionAdmin = new JMenu("Admin");
        dashboardMb.add(optionAdmin);
        addEmployee = new JMenuItem("Add Employee");
        addEmployee.addActionListener(this);
        optionAdmin.add(addEmployee);
        addRooms = new JMenuItem("Add Rooms");
        addRooms.addActionListener(this);
        optionAdmin.add(addRooms);
        addDrivers = new JMenuItem("Add Drivers");
        optionAdmin.add(addDrivers);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addEmployee) {
            new EmployeeAdd();
        } else if (ae.getSource() == addRooms) {
            new RoomsAdd();
        } else if (ae.getSource() == addDrivers) {
            new DriverAdd();
        } else if (ae.getSource() == reception) {
            new HotelReception();
        }
    }
    public static void main(String[] args) {
        new HotelDashboard();
    }
}
