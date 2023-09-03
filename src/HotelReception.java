import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelReception extends JFrame implements ActionListener {

    JButton newCustomer, roomInfo, departmentInfo, employeeInfo, customerInfo, managerInfo, checkout, updateStatus, updateRooms, pickupService, searchRooms, logout;
    HotelReception() {
        setLayout(null);

        JLabel title = new JLabel("RECEPTION");
        title.setBounds(500, 25, 400, 30);
        title.setFont(new Font("Roboto", Font.BOLD, 28));
        title.setForeground(Color.BLUE);
        add(title);

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
        employeeInfo.addActionListener(this);
        add(employeeInfo);

        customerInfo = new JButton("Customer Information");
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.WHITE);
        customerInfo.setBounds(60, 230, 200, 30);
        customerInfo.addActionListener(this);
        add(customerInfo);

        managerInfo = new JButton("Manager Information");
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.setBounds(60, 280, 200, 30);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(60, 330, 200, 30);
        checkout.addActionListener(this);
        add(checkout);

        updateStatus = new JButton("Update Status");
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.setBounds(60, 380, 200, 30);
        updateStatus.addActionListener(this);
        add(updateStatus);

        updateRooms = new JButton("Update Room Status");
        updateRooms.setBackground(Color.BLACK);
        updateRooms.setForeground(Color.WHITE);
        updateRooms.setBounds(60, 430, 200, 30);
        updateRooms.addActionListener(this);
        add(updateRooms);

        pickupService = new JButton("Pickup Services");
        pickupService.setBackground(Color.BLACK);
        pickupService.setForeground(Color.WHITE);
        pickupService.setBounds(60, 480, 200, 30);
        pickupService.addActionListener(this);
        add(pickupService);

        searchRooms = new JButton("Search Rooms");
        searchRooms.setBackground(Color.BLACK);
        searchRooms.setForeground(Color.WHITE);
        searchRooms.setBounds(60, 530, 200, 30);
        searchRooms.addActionListener(this);
        add(searchRooms);

        logout = new JButton("Logout");
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setBounds(60, 580, 200, 30);
        logout.addActionListener(this);
        add(logout);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
        Image scaleImage = img.getImage().getScaledInstance(612, 383, Image.SCALE_DEFAULT);
        ImageIcon scaledImage = new ImageIcon(scaleImage);
        JLabel receptionImage = new JLabel(scaledImage);
        receptionImage.setBounds(280, 120, 612, 383);
        add(receptionImage);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 150, 900, 680);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == newCustomer) {
            try {
                setVisible(false);
                new NewCustomer();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening New Customer: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == roomInfo) {
            try {
                setVisible(false);
                new Rooms();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Room Information: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == departmentInfo) {
            try {
                setVisible(false);
                new Departments();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Department Information: " + e.getMessage());
                e.printStackTrace();
            }
        }  else if (ae.getSource() == employeeInfo) {
            try {
                setVisible(false);
                new EmployeeInfo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Department Information: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == customerInfo) {
            try {
                setVisible(false);
                new CustomerInfo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Department Information: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == managerInfo) {
            try {
                setVisible(false);
                new ManagerInfo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Department Information: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == searchRooms) {
            try {
                setVisible(false);
                new SearchRooms();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Department Information: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == updateStatus) {
            try {
                setVisible(false);
                new UpdateCheck();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Department Information: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == updateRooms) {
            try {
                setVisible(false);
                new RoomUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Department Information: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == pickupService) {
            try {
                setVisible(false);
                new DriverInfo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Department Information: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == checkout) {
            try {
                setVisible(false);
                new CustomerCheckout();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error opening Department Information: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == logout) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new HotelReception();
    }
}
