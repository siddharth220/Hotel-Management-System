import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox idBox;
    JLabel timeDisplay;
    JTextField idNumberInput, customerNameInput, countryInput, depositAmountInput;
    JRadioButton maleButton, femaleButton;
    Choice roomNumberBox;
    JButton addButton, cancelButton;
    NewCustomer() {
        setLayout(null);
        setBounds(350, 70, 980, 600);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("NEW CUSTOMER");
        title.setBounds(640, 20, 400, 30);
        title.setFont(new Font("Roboto", Font.BOLD, 20));
        title.setForeground(Color.BLUE);
        add(title);

        JLabel customerID = new JLabel("Customer ID");
        customerID.setBounds(60, 50, 200, 30);
        customerID.setFont(new Font("Roboto", Font.BOLD, 16));
        String[] idBoxOptions = {
                "Passport",
                "Aadhaar Card",
                "Driving License",
                "Pan Card"
        };
        idBox = new JComboBox(idBoxOptions);
        idBox.setBounds(300, 50, 180, 30);
        idBox.setBackground(Color.WHITE);

        JLabel idNumber = new JLabel("ID Number");
        idNumber.setBounds(60, 100, 200, 30);
        idNumber.setFont(new Font("Roboto", Font.BOLD, 16));

        idNumberInput = new JTextField();
        idNumberInput.setBounds(300, 100, 180, 30);

        JLabel customerName = new JLabel("Name");
        customerName.setBounds(60, 150, 200, 30);
        customerName.setFont(new Font("Roboto", Font.BOLD, 16));

        customerNameInput = new JTextField();
        customerNameInput.setBounds(300, 150, 180, 30);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(60, 200, 200, 30);
        gender.setFont(new Font("Roboto", Font.BOLD, 16));

        maleButton = new JRadioButton("Male");
        maleButton.setBounds(300, 200, 80, 30);
        maleButton.setBackground(Color.WHITE);

        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(380, 200, 100, 30);
        femaleButton.setBackground(Color.WHITE);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(maleButton);
        buttonGroup.add(femaleButton);

        JLabel country = new JLabel("Country");
        country.setBounds(60, 250, 200, 30);
        country.setFont(new Font("Roboto", Font.BOLD, 16));

        countryInput = new JTextField();
        countryInput.setBounds(300, 250, 180, 30);

        JLabel roomNumber = new JLabel("Room Number Allocated");
        roomNumber.setBounds(60, 300, 200, 30);
        roomNumber.setFont(new Font("Roboto", Font.BOLD, 16));

        roomNumberBox = new Choice();
        try {
            ConnectionDB c = new ConnectionDB();
            String query = "SELECT * from rooms WHERE room_status = 'Available'";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()) {
                roomNumberBox.add(rs.getString("room_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        roomNumberBox.setBounds(300, 310, 180, 30);

        JLabel checkInTime = new JLabel("Check-in Time");
        checkInTime.setBounds(60, 350, 200, 30);
        checkInTime.setFont(new Font("Roboto", Font.BOLD, 16));

        Date currentDate = new Date();
        timeDisplay = new JLabel(""+currentDate);
        timeDisplay.setBounds(300, 350, 200, 30);
        timeDisplay.setFont(new Font("Roboto", Font.BOLD, 12));

        JLabel depositAmount = new JLabel("Deposit Amount");
        depositAmount.setBounds(60, 400, 200, 30);
        depositAmount.setFont(new Font("Roboto", Font.BOLD, 16));

        depositAmountInput = new JTextField();
        depositAmountInput.setBounds(300, 400, 180, 30);

        addButton = new JButton("Add");
        addButton.setBounds(120, 480, 120, 30);
        addButton.setFont(new Font("Roboto", Font.BOLD, 14));
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(this);

        cancelButton = new JButton("Back");
        cancelButton.setBounds(250, 480, 120, 30);
        cancelButton.setFont(new Font("Roboto", Font.BOLD, 14));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.addActionListener(this);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/new-cust.png"));
        Image scaleImg = img.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon scaledImg = new ImageIcon(scaleImg);
        JLabel customerAddImg = new JLabel(scaledImg);
        customerAddImg.setBounds(600, 80, 300, 400);

        add(customerID);
        add(gender);
        add(idNumber);
        add(customerName);
        add(gender);
        add(country);
        add(roomNumber);
        add(checkInTime);
        add(depositAmount);
        add(idBox);
        add(idNumberInput);
        add(customerNameInput);
        add(maleButton);
        add(femaleButton);
        add(countryInput);
        add(depositAmountInput);
        add(roomNumberBox);
        add(timeDisplay);
        add(addButton);
        add(cancelButton);
        add(customerAddImg);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String customerIdType = (String) idBox.getSelectedItem();
        String customerID = idNumberInput.getText();
        String customerName = customerNameInput.getText();
        String gender = null;
        String country = countryInput.getText();
        String roomNumber = roomNumberBox.getSelectedItem();
        String checkInTime = timeDisplay.getText();
        String amount = depositAmountInput.getText();

        if (maleButton.isSelected()) {
            gender = "Male";
        } else if (femaleButton.isSelected()) {
            gender = "Female";
        }

        if (ae.getSource() == addButton) {
            if (validateFields()) { // Validate input fields
                try {
                    ConnectionDB c = new ConnectionDB();
                    String addCustomerQ = "INSERT INTO customer_info VALUES ('"+customerIdType+"', '"+customerID+"', '"+customerName+"', '"+gender+"', '"+country+"', "+roomNumber+", '"+checkInTime+"', "+amount+")";
                    String updateQ = "UPDATE rooms SET room_status = 'Occupied' WHERE room_number = "+roomNumber+" ";
                    c.statement.executeUpdate(addCustomerQ);
                    c.statement.executeUpdate(updateQ);
                    JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
            new HotelReception();
        }
    }

    private boolean validateFields() {
        if (idNumberInput.getText().isEmpty() || customerNameInput.getText().isEmpty() || countryInput.getText().isEmpty() || depositAmountInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return false;
        }

        // Check if deposit amount is a valid numeric value
        try {
            double deposit = Double.parseDouble(depositAmountInput.getText());
            if (deposit <= 0) {
                JOptionPane.showMessageDialog(null, "Deposit amount should be a positive number.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount. Please enter a numeric value.");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}