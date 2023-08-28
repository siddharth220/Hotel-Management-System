import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomsAdd extends JFrame implements ActionListener {

    JTextField roomNoInput, roomPriceInput;
    JComboBox availabilityOptions, cleaningOptions, bedTypeOptions;
    JButton submitButton, cancelButton;

    RoomsAdd() {
        setLayout(null);

        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setBounds(40, 50, 150, 40);
        roomNumber.setFont(new Font("Roboto", Font.BOLD, 16));
        add(roomNumber);

        roomNoInput = new JTextField();
        roomNoInput.setBounds(200, 60, 150, 30);
        add(roomNoInput);

        JLabel availabilityStatus = new JLabel("Room Availability");
        availabilityStatus.setBounds(40, 90, 150, 40);
        availabilityStatus.setFont(new Font("Roboto", Font.BOLD, 16));
        add(availabilityStatus);

        String[] roomAvailability = {
            "Available",
            "Occupied"
        };
        availabilityOptions = new JComboBox(roomAvailability);
        availabilityOptions.setBounds(200, 100, 150, 30);
        availabilityOptions.setBackground(Color.WHITE);
        add(availabilityOptions);

        JLabel cleaningStatus = new JLabel("Cleaning Status");
        cleaningStatus.setBounds(40, 130, 150, 40);
        cleaningStatus.setFont(new Font("Roboto", Font.BOLD, 16));
        add(cleaningStatus);

        String[] cleanStatus = {
                "Clean",
                "Unclean"
        };
        cleaningOptions = new JComboBox(cleanStatus);
        cleaningOptions.setBounds(200, 140, 150, 30);
        cleaningOptions.setBackground(Color.WHITE);
        add(cleaningOptions);

        JLabel roomPrice = new JLabel("Room Price");
        roomPrice.setBounds(40, 170, 150, 40);
        roomPrice.setFont(new Font("Roboto", Font.BOLD, 16));
        add(roomPrice);

        roomPriceInput = new JTextField();
        roomPriceInput.setBounds(200, 180, 150, 30);
        add(roomPriceInput);

        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(40, 210, 150, 40);
        bedType.setFont(new Font("Roboto", Font.BOLD, 16));
        add(bedType);

        String[] bedOptions = {
                "Single Bed",
                "Double Bed"
        };
        bedTypeOptions = new JComboBox(bedOptions);
        bedTypeOptions.setBounds(200, 220, 150, 30);
        bedTypeOptions.setBackground(Color.WHITE);
        add(bedTypeOptions);

        submitButton = new JButton("Add Room");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(50, 300, 120, 30);
        submitButton.setFont(new Font("Roboto", Font.BOLD, 14));
        submitButton.addActionListener(this);
        add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(200, 300, 120, 30);
        cancelButton.setFont(new Font("Roboto", Font.BOLD, 14));
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel roomImg = new JLabel(img);
        roomImg.setBounds(400, 50, 500, 300);
        add(roomImg);

        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 1000, 450);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String roomNo = roomNoInput.getText();
        String roomStatus = (String) availabilityOptions.getSelectedItem();
        String roomCleanStatus = (String) cleaningOptions.getSelectedItem();
        String roomPrice = roomPriceInput.getText();
        String roomBedType = (String) bedTypeOptions.getSelectedItem();

        if (ae.getSource() == submitButton) {
            try {
                ConnectionDB c = new ConnectionDB();
                String query = "INSERT INTO rooms VALUES ("+roomNo+", '"+roomStatus+"', '"+roomCleanStatus+"', "+roomPrice+", '"+roomBedType+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Room Added");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
            new HotelDashboard();
        }
    }
    public static void main(String[] args) {
        new RoomsAdd();
    }
}
