import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener {
    JTable roomsTable;
    JButton backButton;

    Rooms () {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 1050, 600);

        JLabel title = new JLabel("ROOM INFORMATION");
        title.setBounds(130, 20, 400, 30);
        title.setFont(new Font("Roboto", Font.BOLD, 20));
        title.setForeground(Color.BLUE);
        add(title);

        JLabel roomNumber = new JLabel("Room No.");
        roomNumber.setBounds(10, 90, 100, 20);
        roomNumber.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomNumber);

        JLabel roomStatus = new JLabel("Availability");
        roomStatus.setBounds(100, 90, 100, 20);
        roomStatus.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomStatus);

        JLabel roomCleanStatus = new JLabel("Clean Status");
        roomCleanStatus.setBounds(210, 90, 100, 20);
        roomCleanStatus.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomCleanStatus);

        JLabel roomPrice = new JLabel("Price");
        roomPrice.setBounds(340, 90, 100, 20);
        roomPrice.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomPrice);

        JLabel roomBedType = new JLabel("Bed Type");
        roomBedType.setBounds(420, 90, 100, 20);
        roomBedType.setFont(new Font("Roboto", Font.BOLD, 12));
        add(roomBedType);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/room-info.jpg"));
        Image scaleImg = img.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledImg = new ImageIcon(scaleImg);
        JLabel roomsImg = new JLabel(scaledImg);
        roomsImg.setBounds(500, 0, 600, 600);
        add(roomsImg);

        roomsTable = new JTable();
        roomsTable.setBounds(0, 120, 500, 380);
        add(roomsTable);

        try {
            ConnectionDB c = new ConnectionDB();
            String query = "SELECT * FROM rooms";
            ResultSet rs = c.statement.executeQuery(query);

            // Validate the data retrieved from the database
            if (rs != null) {
                roomsTable.setModel(DbUtils.resultSetToTableModel(rs));
            } else {
                JOptionPane.showMessageDialog(null, "No room data found.");
            }
        } catch (Exception e) {
            // Handle any exceptions gracefully
            JOptionPane.showMessageDialog(null, "An error occurred while fetching room data.");
            e.printStackTrace();
        }

        backButton = new JButton("Back");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setBounds(200, 500, 120, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        setVisible(false);
        new HotelReception();
    }

    public static void main(String[] args) {
        new Rooms();
    }
}
