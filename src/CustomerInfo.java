import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable custInfoTable;
    JButton backButton;
    CustomerInfo () {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(100, 200, 1400, 600);

        JLabel custIDType = new JLabel("ID Type");
        custIDType.setBounds(60, 10, 140, 20);
        custIDType.setFont(new Font("Roboto", Font.BOLD, 12));
        add(custIDType);

        JLabel custID = new JLabel("ID Number");
        custID.setBounds(220, 10, 140, 20);
        custID.setFont(new Font("Roboto", Font.BOLD, 12));
        add(custID);

        JLabel custName = new JLabel("Name");
        custName.setBounds(400, 10, 140, 20);
        custName.setFont(new Font("Roboto", Font.BOLD, 12));
        add(custName);

        JLabel custGender = new JLabel("Gender");
        custGender.setBounds(600, 10, 140, 20);
        custGender.setFont(new Font("Roboto", Font.BOLD, 12));
        add(custGender);

        JLabel custCountry = new JLabel("Country");
        custCountry.setBounds(770, 10, 140, 20);
        custCountry.setFont(new Font("Roboto", Font.BOLD, 12));
        add(custCountry);

        JLabel custRoomNo = new JLabel("Room No");
        custRoomNo.setBounds(950, 10, 140, 20);
        custRoomNo.setFont(new Font("Roboto", Font.BOLD, 12));
        add(custRoomNo);

        JLabel custCheckInTime = new JLabel("CheckIn Time");
        custCheckInTime.setBounds(1100, 10, 140, 20);
        custCheckInTime.setFont(new Font("Roboto", Font.BOLD, 12));
        add(custCheckInTime);

        JLabel custDepostiAmount = new JLabel("Deposit Amount");
        custDepostiAmount.setBounds(1250, 10, 140, 20);
        custDepostiAmount.setFont(new Font("Roboto", Font.BOLD, 12));
        add(custDepostiAmount);

        custInfoTable = new JTable();
        custInfoTable.setBounds(0, 40, 1400, 400);
        add(custInfoTable);


        ConnectionDB c = new ConnectionDB();
        try {
            String query = "SELECT * FROM customer_info";
            ResultSet rs = c.statement.executeQuery(query);
            custInfoTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching customer information: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (c.connection != null) {
                    c.connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        backButton = new JButton("Back");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setBounds(640, 500, 120, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae) {
        setVisible(false);
        new HotelReception();
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
