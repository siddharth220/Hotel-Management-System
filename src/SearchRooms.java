import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class SearchRooms extends JFrame implements ActionListener {
    JTable roomsTable;
    JButton backButton, applyButton;
    JComboBox bedOptions;

    JCheckBox availableRooms;
    SearchRooms () {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 1050, 600);

        JLabel roomBedTypes = new JLabel("Room Bed Type");
        roomBedTypes.setBounds(70, 50, 100, 20);
        roomBedTypes.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomBedTypes);

        String[] bedTypes = {"Single Bed", "Double Bed"};
        bedOptions = new JComboBox(bedTypes);
        bedOptions.setBounds(200, 50, 100, 20);
        bedOptions.setBackground(Color.WHITE);
        add(bedOptions);

        availableRooms = new JCheckBox("Show Available Rooms");
        availableRooms.setBounds(750, 50, 200, 20);
        availableRooms.setBackground(Color.WHITE);
        add(availableRooms);

        JLabel roomNumber = new JLabel("Room No.");
        roomNumber.setBounds(70, 150, 100, 20);
        roomNumber.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomNumber);

        JLabel roomStatus = new JLabel("Availability");
        roomStatus.setBounds(280, 150, 100, 20);
        roomStatus.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomStatus);

        JLabel roomCleanStatus = new JLabel("Clean Status");
        roomCleanStatus.setBounds(500, 150, 100, 20);
        roomCleanStatus.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomCleanStatus);

        JLabel roomPrice = new JLabel("Price");
        roomPrice.setBounds(720, 150, 100, 20);
        roomPrice.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomPrice);

        JLabel roomBedType = new JLabel("Bed Type");
        roomBedType.setBounds(900, 150, 100, 20);
        roomBedType.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomBedType);

        roomsTable = new JTable();
        roomsTable.setBounds(0, 180, 1050, 300);
        add(roomsTable);

        try {
            ConnectionDB c = new ConnectionDB();
            String query = "SELECT * FROM rooms";
            ResultSet rs = c.s.executeQuery(query);
            roomsTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        applyButton = new JButton("Apply");
        applyButton.setBackground(Color.black);
        applyButton.setForeground(Color.white);
        applyButton.setBounds(360, 500, 120, 30);
        applyButton.addActionListener(this);
        add(applyButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setBounds(520, 500, 120, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == applyButton) {
            try {
                String typeOfBed = (String) bedOptions.getSelectedItem();
                String bedQ = "SELECT * FROM rooms WHERE bed_type = '"+typeOfBed+"' ";
                String availableQ = "SELECT * FROM rooms WHERE room_status = 'Available'";
                ResultSet rs;
                ConnectionDB c = new ConnectionDB();
                if (availableRooms.isSelected()) {
                    rs = c.s.executeQuery(availableQ);
                } else {
                    rs = c.s.executeQuery(bedQ);
                }
                roomsTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new HotelReception();
        }
    }
    public static void main(String[] args) {
        new SearchRooms();
    }
}
