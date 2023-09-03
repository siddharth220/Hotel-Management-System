import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class DriverInfo extends JFrame implements ActionListener {
    JTable driverInfoTable;
    JButton backButton, submitButton;
    Choice carOptions;
    DriverInfo () {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 1050, 600);

        JLabel roomBedTypes = new JLabel("Car Type");
        roomBedTypes.setBounds(70, 50, 100, 20);
        roomBedTypes.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomBedTypes);

        carOptions = new Choice();
        carOptions.setBounds(200, 50, 100, 20);
        carOptions.setBackground(Color.WHITE);
        add(carOptions);
        try {
            ConnectionDB c = new ConnectionDB();
            ResultSet rs = c.statement.executeQuery("SELECT * from driver_data");
            while (rs.next()) {
                carOptions.add(rs.getString("car_company"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel driverName = new JLabel("Name");
        driverName.setBounds(50, 150, 100, 20);
        driverName.setFont(new Font("Roboto", Font.BOLD, 12));
        add(driverName);

        JLabel driverAge = new JLabel("Age");
        driverAge.setBounds(220, 150, 100, 20);
        driverAge.setFont(new Font("Roboto", Font.BOLD, 12));
        add(driverAge);

        JLabel driverGender = new JLabel("Gender");
        driverGender.setBounds(350, 150, 100, 20);
        driverGender.setFont(new Font("Roboto", Font.BOLD, 12));
        add(driverGender);

        JLabel carCompany = new JLabel("Car Company");
        carCompany.setBounds(480, 150, 100, 20);
        carCompany.setFont(new Font("Roboto", Font.BOLD, 12));
        add(carCompany);

        JLabel carModel = new JLabel("Car Model");
        carModel.setBounds(640, 150, 100, 20);
        carModel.setFont(new Font("Roboto", Font.BOLD, 12));
        add(carModel);

        JLabel driverStatus = new JLabel("Availability");
        driverStatus.setBounds(790, 150, 100, 20);
        driverStatus.setFont(new Font("Roboto", Font.BOLD, 12));
        add(driverStatus);

        JLabel driverLocation = new JLabel("Location");
        driverLocation.setBounds(940, 150, 100, 20);
        driverLocation.setFont(new Font("Roboto", Font.BOLD, 12));
        add(driverLocation);

        driverInfoTable = new JTable();
        driverInfoTable.setBounds(0, 180, 1050, 300);
        add(driverInfoTable);

        try {
            ConnectionDB c = new ConnectionDB();
            String query = "SELECT * FROM driver_data";
            ResultSet rs = c.statement.executeQuery(query);
            driverInfoTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.black);
        submitButton.setForeground(Color.white);
        submitButton.setBounds(360, 500, 120, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setBounds(520, 500, 120, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            String selectedCarType = carOptions.getSelectedItem();

            if (selectedCarType.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select a car type.");
            } else {
                try {
                    ConnectionDB c = new ConnectionDB();
                    String availableQ = "SELECT * FROM driver_data WHERE car_company = '"+selectedCarType+"'";
                    ResultSet rs = c.statement.executeQuery(availableQ);
                    driverInfoTable.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new HotelReception();
        }
    }

    public static void main(String[] args) {
        new DriverInfo();
    }
}
