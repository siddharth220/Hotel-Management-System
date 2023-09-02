import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RoomUpdate extends JFrame implements ActionListener {

    Choice customerData;
    JTextField roomNoDisp, roomAvlDisp, roomClnStatus;
    JButton checkData, updateData, backButton;

    RoomUpdate() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 980, 500);

        JLabel custID = new JLabel("Customer ID");
        custID.setBounds(30, 80, 100, 20);
        add(custID);

        customerData = new Choice();
        customerData.setBounds(200, 80, 150, 25);
        add(customerData);

        JLabel custRoom = new JLabel("Room No");
        custRoom.setBounds(30, 120, 100, 20);
        add(custRoom);

        roomNoDisp = new JTextField();
        roomNoDisp.setBounds(200, 120, 150, 25);
        add(roomNoDisp);

        JLabel roomAvl = new JLabel("Availability");
        roomAvl.setBounds(30, 160, 100, 20);
        add(roomAvl);

        roomAvlDisp = new JTextField();
        roomAvlDisp.setBounds(200, 160, 150, 25);
        add(roomAvlDisp);

        JLabel custDepositAmt = new JLabel("Cleaning Status");
        custDepositAmt.setBounds(30, 200, 100, 20);
        add(custDepositAmt);

        roomClnStatus = new JTextField();
        roomClnStatus.setBounds(200, 200, 150, 25);
        add(roomClnStatus);

        checkData = new JButton("Check Data");
        checkData.setBounds(30, 270, 110, 25);
        checkData.setBackground(Color.BLACK);
        checkData.setForeground(Color.WHITE);
        checkData.addActionListener(this);
        add(checkData);

        updateData = new JButton("Update Data");
        updateData.setBounds(150, 270, 110, 25);
        updateData.setBackground(Color.BLACK);
        updateData.setForeground(Color.WHITE);
        updateData.addActionListener(this);
        add(updateData);

        backButton = new JButton("Back");
        backButton.setBounds(270, 270, 110, 25);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image scaleImg = img.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon scaledImg = new ImageIcon(scaleImg);
        JLabel checkInOutImg = new JLabel(scaledImg);
        checkInOutImg.setBounds(400, 50, 500, 300);
        add(checkInOutImg);

        try {
            ConnectionDB c = new ConnectionDB();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer_info");
            while (rs.next()) {
                customerData.add(rs.getString("document_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == checkData) {
            try {
                String id = customerData.getSelectedItem();
                String dataQ = "SELECT * FROM customer_info WHERE document_id = '"+id+"'";

                ConnectionDB c = new ConnectionDB();

                ResultSet rs = c.s.executeQuery(dataQ);
                while (rs.next()) {
                    roomNoDisp.setText(rs.getString("room_number"));
                }
                ResultSet status = c.s.executeQuery("SELECT * FROM rooms WHERE room_number = '"+roomNoDisp.getText()+"' ");
                while (status.next()) {
                    roomAvlDisp.setText(status.getString("room_status"));
                    roomClnStatus.setText(status.getString("room_clean_status"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == updateData) {
            String id = customerData.getSelectedItem();
            String roomNum = roomNoDisp.getText();
            String avlStatus = roomAvlDisp.getText();
            String clnStatus = roomClnStatus.getText();

            try {
                ConnectionDB c = new ConnectionDB();
                c.s.executeUpdate("UPDATE rooms SET room_status = '"+avlStatus+"', room_clean_status = '"+clnStatus+"' WHERE room_number = '"+roomNum+"' ");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new HotelReception();
        }
    }

    public static void main(String[] args) {
        new RoomUpdate();
    }
}
