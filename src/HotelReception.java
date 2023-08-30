import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelReception extends JFrame implements ActionListener {

    JButton newCustomer, roomInfo, departmentInfo, employeeInfo, customerInfo, managerInfo, checkout, updateStatus, updateRooms, pickupService, searchRooms, logout;
    HotelReception() {
        setLayout(null);

        newCustomer = new JButton("New Customer");
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setBounds(60, 30, 200, 30);
        newCustomer.addActionListener(this);
        add(newCustomer);

        roomInfo = new JButton("Room Information");
        roomInfo.setBackground(Color.BLACK);
        roomInfo.setForeground(Color.WHITE);
        roomInfo.setBounds(60, 80, 200, 30);
        roomInfo.addActionListener(this);
        add(roomInfo);

        departmentInfo = new JButton("Department Information");
        departmentInfo.setBackground(Color.BLACK);
        departmentInfo.setForeground(Color.WHITE);
        departmentInfo.setBounds(60, 130, 200, 30);
        departmentInfo.addActionListener(this);
        add(departmentInfo);

        employeeInfo = new JButton("Employee Information");
        employeeInfo.setBackground(Color.BLACK);
        employeeInfo.setForeground(Color.WHITE);
        employeeInfo.setBounds(60, 180, 200, 30);
        add(employeeInfo);

        customerInfo = new JButton("Customer Information");
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.WHITE);
        customerInfo.setBounds(60, 230, 200, 30);
        add(customerInfo);

        managerInfo = new JButton("Manager Information");
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.setBounds(60, 280, 200, 30);
        add(managerInfo);

        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(60, 330, 200, 30);
        add(checkout);

        updateStatus = new JButton("Update Status");
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.setBounds(60, 380, 200, 30);
        add(updateStatus);

        updateRooms = new JButton("Update Room Status");
        updateRooms.setBackground(Color.BLACK);
        updateRooms.setForeground(Color.WHITE);
        updateRooms.setBounds(60, 430, 200, 30);
        add(updateRooms);

        pickupService = new JButton("Pickup Services");
        pickupService.setBackground(Color.BLACK);
        pickupService.setForeground(Color.WHITE);
        pickupService.setBounds(60, 480, 200, 30);
        add(pickupService);

        searchRooms = new JButton("Search Rooms");
        searchRooms.setBackground(Color.BLACK);
        searchRooms.setForeground(Color.WHITE);
        searchRooms.setBounds(60, 530, 200, 30);
        add(searchRooms);

        logout = new JButton("Logout");
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setBounds(60, 580, 200, 30);
        add(logout);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image scaleImage = img.getImage().getScaledInstance(500, 470, Image.SCALE_DEFAULT);
        ImageIcon scaledImage = new ImageIcon(scaleImage);
        JLabel receptionImage = new JLabel(scaledImage);
        receptionImage.setBounds(350, 100, 500, 470);
        add(receptionImage);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 150, 900, 680);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == newCustomer) {
            setVisible(false);
            new NewCustomer();
        } else if (ae.getSource() == roomInfo) {
            setVisible(false);
            new Rooms();
        } else if (ae.getSource() == departmentInfo) {
            setVisible(false);
            new Departments();
        }
    }

    public static void main(String[] args) {
        new HotelReception();
    }
}
