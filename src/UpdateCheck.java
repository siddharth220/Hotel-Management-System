import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice customerData;
    JTextField roomNoDisp, custNameDisp, custAmtDisp, custTimeDisp, custRemAmtDisp;
    JButton checkData, updateData, backButton;

    UpdateCheck() {
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

        JLabel custName = new JLabel("Customer Name");
        custName.setBounds(30, 160, 100, 20);
        add(custName);

        custNameDisp = new JTextField();
        custNameDisp.setBounds(200, 160, 150, 25);
        add(custNameDisp);

        JLabel custDepositAmt = new JLabel("Deposit Amount");
        custDepositAmt.setBounds(30, 200, 100, 20);
        add(custDepositAmt);

        custAmtDisp = new JTextField();
        custAmtDisp.setBounds(200, 200, 150, 25);
        add(custAmtDisp);

        JLabel custRemAmt = new JLabel("Remaining Amount");
        custRemAmt.setBounds(30, 240, 150, 20);
        add(custRemAmt);

        custRemAmtDisp = new JTextField();
        custRemAmtDisp.setBounds(200, 240, 150, 25);
        add(custRemAmtDisp);

        JLabel custCheckInTtime = new JLabel("Check-In Time");
        custCheckInTtime.setBounds(30, 280, 100, 20);
        add(custCheckInTtime);

        custTimeDisp = new JTextField();
        custTimeDisp.setBounds(200, 280, 150, 25);
        add(custTimeDisp);

        checkData = new JButton("Check Data");
        checkData.setBounds(60, 350, 150, 25);
        checkData.setBackground(Color.BLACK);
        checkData.setForeground(Color.WHITE);
        checkData.addActionListener(this);
        add(checkData);

        updateData = new JButton("Update Data");
        updateData.setBounds(240, 350, 150, 25);
        updateData.setBackground(Color.BLACK);
        updateData.setForeground(Color.WHITE);
        updateData.addActionListener(this);
        add(updateData);

        backButton = new JButton("Back");
        backButton.setBounds(420, 350, 150, 25);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel checkInOutImg = new JLabel(img);
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
                    custNameDisp.setText(rs.getString("customer_name"));
                    custAmtDisp.setText(rs.getString("deposit_amount"));
                    custTimeDisp.setText(rs.getString("checkin_time"));
                }
                ResultSet amt = c.s.executeQuery("SELECT * FROM rooms WHERE room_number = '"+roomNoDisp.getText()+"' ");
                while (amt.next()) {
                    String price = amt.getString("room_price");
                    int amountRem = Integer.parseInt(price) - Integer.parseInt(custAmtDisp.getText());
                    custRemAmtDisp.setText("" + amountRem);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == updateData) {
            String id = customerData.getSelectedItem();
            String deposit = custAmtDisp.getText();

            try {
                ConnectionDB c = new ConnectionDB();
                c.s.executeUpdate("UPDATE customer_info SET deposit_amount = '"+deposit+"' WHERE document_id = '"+id+"' ");
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
        new UpdateCheck();
    }
}
