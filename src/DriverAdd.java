import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverAdd extends JFrame implements ActionListener {

    JTextField driverName, driverAge, driverCarCompany, driverCarModel, driverLocation;
    JComboBox driverGender, driverAvailability;

    JButton addDriver, cancelButton;
    DriverAdd() {
        setLayout(null);

        JLabel driverNameLabel = new JLabel("Name");
        driverNameLabel.setBounds(60, 20, 150, 30);
        driverNameLabel.setFont(new Font("Roboto", Font.BOLD, 16));
        add(driverNameLabel);

        driverName = new JTextField();
        driverName.setBounds(220, 30, 150, 20);
        add(driverName);

        JLabel driverAgeLabel = new JLabel("Age");
        driverAgeLabel.setBounds(60, 70, 150, 30);
        driverAgeLabel.setFont(new Font("Roboto", Font.BOLD, 16));
        add(driverAgeLabel);

        driverAge = new JTextField();
        driverAge.setBounds(220, 80, 150, 20);
        add(driverAge);

        JLabel driverGenderLabel = new JLabel("Age");
        driverGenderLabel.setBounds(60, 120, 150, 30);
        driverGenderLabel.setFont(new Font("Roboto", Font.BOLD, 16));
        add(driverGenderLabel);

        String[] driverGenderOptions = {
                "Male",
                "Female"
        };
        driverGender = new JComboBox(driverGenderOptions);
        driverGender.setBounds(220, 130, 150, 20);
        driverGender.setBackground(Color.WHITE);
        add(driverGender);

        JLabel driverCarCompanyLabel = new JLabel("Car Company");
        driverCarCompanyLabel.setBounds(60, 170, 150, 30);
        driverCarCompanyLabel.setFont(new Font("Roboto", Font.BOLD, 16));
        add(driverCarCompanyLabel);

        driverCarCompany = new JTextField();
        driverCarCompany.setBounds(220, 180, 150, 20);
        add(driverCarCompany);

        JLabel driverCarModelLabel = new JLabel("Car Model");
        driverCarModelLabel.setBounds(60, 220, 150, 30);
        driverCarModelLabel.setFont(new Font("Roboto", Font.BOLD, 16));
        add(driverCarModelLabel);

        driverCarModel = new JTextField();
        driverCarModel.setBounds(220, 230, 150, 20);
        add(driverCarModel);

        JLabel driverAvailabilityLabel = new JLabel("Availability");
        driverAvailabilityLabel.setBounds(60, 270, 150, 30);
        driverAvailabilityLabel.setFont(new Font("Roboto", Font.BOLD, 16));
        add(driverAvailabilityLabel);

        String[] driverAvailableStatus = {
                "Available",
                "Unavailable"
        };
        driverAvailability = new JComboBox(driverAvailableStatus);
        driverAvailability.setBounds(220, 280, 150, 20);
        driverAvailability.setBackground(Color.WHITE);
        add(driverAvailability);

        JLabel driverLocationLabel = new JLabel("Location");
        driverLocationLabel.setBounds(60, 320, 150, 30);
        driverLocationLabel.setFont(new Font("Roboto", Font.BOLD, 16));
        add(driverLocationLabel);

        driverLocation = new JTextField();
        driverLocation.setBounds(220, 330, 150, 20);
        add(driverLocation);

        addDriver = new JButton("Add Driver");
        addDriver.setBounds(80, 380, 120, 30);
        addDriver.setBackground(Color.BLACK);
        addDriver.setForeground(Color.WHITE);
        addDriver.addActionListener(this);
        add(addDriver);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(230, 380, 120, 30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image scaleImage = img.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon scaledImage = new ImageIcon(scaleImage);
        JLabel driverImage = new JLabel(scaledImage);
        driverImage.setBounds(430, 70, 500, 300);
        add(driverImage);

        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 980, 470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String dName = driverName.getText();
        String dAge = driverAge.getText();
        String dGender = (String) driverGender.getSelectedItem();
        String dCarCompany = driverCarCompany.getText();
        String dCarModel = driverCarModel.getText();
        String dAvailability = (String) driverAvailability.getSelectedItem();
        String dLocation = driverLocation.getText();

        if (ae.getSource() == addDriver) {
            try {
                ConnectionDB c = new ConnectionDB();
                String query = "INSERT INTO driver_data VALUES ('"+dName+"', "+dAge+", '"+dGender+"', '"+dCarCompany+"', '"+dCarModel+"', '"+dAvailability+"', '"+dLocation+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver Added");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
            new HotelDashboard();
        }
    }

    public static void main(String[] args) {
        new DriverAdd();
    }
}
