import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CustomerCheckout extends JFrame implements ActionListener {
    Choice idChoice;
    JLabel roomNumDisp, checkInTimeDisp, checkOutTimeDisp;
    JButton checkoutButton, backButton;

    public CustomerCheckout() {
        setLayout(null);
        setBounds(300, 200, 800, 400);
        getContentPane().setBackground(Color.WHITE);

        // Labels and UI components for selecting Customer ID
        JLabel custID = new JLabel("Customer ID");
        custID.setBounds(30, 80, 100, 25);
        add(custID);

        idChoice = new Choice();
        idChoice.setBounds(150, 80, 150, 25);
        add(idChoice);

        if (idChoice != null && idChoice.getSelectedItem() != null) {
            // Fetch and populate the Choice box with customer IDs from the database
            try {
                ConnectionDB c = new ConnectionDB();
                ResultSet rs = c.statement.executeQuery("SELECT * FROM customer_info");
                while (rs.next()) {
                    idChoice.add(rs.getString("document_id"));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error fetching data from the database: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a valid Customer ID.");
        }

        // Icon for indicating customer selection
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image scaleImg = img.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon scaledImage = new ImageIcon(scaleImg);
        JLabel checkImage = new JLabel(scaledImage);
        checkImage.setBounds(310, 80, 20, 20);
        add(checkImage);

        // Labels and UI components for displaying room number and check-in time
        JLabel roomNum = new JLabel("Room Number");
        roomNum.setBounds(30, 130, 100, 30);
        add(roomNum);

        roomNumDisp = new JLabel();
        roomNumDisp.setBounds(150, 130, 100, 30);
        add(roomNumDisp);

        // Fetch and display room number from the database based on customer selection
        try {
            ConnectionDB c = new ConnectionDB();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM customer_info");
            while (rs.next()) {
                roomNumDisp.setText(rs.getString("room_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Labels and UI components for displaying check-in time
        JLabel checkInTime = new JLabel("Check-in Time");
        checkInTime.setBounds(30, 180, 100, 30);
        add(checkInTime);

        checkInTimeDisp = new JLabel();
        checkInTimeDisp.setBounds(150, 180, 180, 30);
        add(checkInTimeDisp);

        // Fetch and display check-in time from the database based on customer selection
        try {
            ConnectionDB c = new ConnectionDB();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM customer_info");
            while (rs.next()) {
                checkInTimeDisp.setText(rs.getString("checkin_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Label and UI component for displaying the current check-out time
        JLabel checkOutTime = new JLabel("Check-out Time");
        checkOutTime.setBounds(30, 230, 100, 30);
        add(checkOutTime);

        Date date = new Date();

        checkOutTimeDisp = new JLabel("" + date);
        checkOutTimeDisp.setBounds(150, 230, 170, 30);
        add(checkOutTimeDisp);

        // Button for checking out a customer
        checkoutButton = new JButton("Check-out");
        checkoutButton.setBackground(Color.BLACK);
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setBounds(30, 280, 120, 30);
        checkoutButton.addActionListener(this);
        add(checkoutButton);

        // Button for going back to the main menu
        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(180, 280, 120, 30);
        backButton.addActionListener(this);
        add(backButton);

        // Image for visual appeal
        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout-main.jpg"));
        Image scaleImg2 = img2.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon scaledImage2 = new ImageIcon(scaleImg2);
        JLabel checkImage2 = new JLabel(scaledImage2);
        checkImage2.setBounds(350, 50, 400, 250);
        add(checkImage2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkoutButton) {
            // Perform customer check-out
            ConnectionDB c = new ConnectionDB();
            String deleteQ = "DELETE FROM customer_info WHERE document_id = '" + idChoice.getSelectedItem() + "'";
            String updateQ = "UPDATE rooms SET room_status = 'AVAILABLE' WHERE room_number = '" + roomNumDisp.getText() + "'";

            try (PreparedStatement deleteStatement = c.connection.prepareStatement(deleteQ);
                 PreparedStatement updateStatement = c.connection.prepareStatement(updateQ)) {
                deleteStatement.setString(1, idChoice.getSelectedItem());
                updateStatement.setString(1, roomNumDisp.getText());

                deleteStatement.executeUpdate();
                updateStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Customer Checked Out");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error during check-out: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == backButton) {
            // Go back to the main menu
            setVisible(false);
            new HotelReception();
        }
    }

    public static void main(String[] args) {
        // Entry point for the application
        new CustomerCheckout();
    }
}
