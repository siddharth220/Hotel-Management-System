import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAdd extends JFrame implements ActionListener {

    JTextField empNameInput, empAgeInput, empSalaryInput, empPhoneInput, empAadharInput,  empEmailInput;
    JRadioButton maleButton, femaleButton;
    JComboBox jobOptions;
    JButton submitButton;

    EmployeeAdd() {
        setLayout(null);

        JLabel employeeName = new JLabel("Name");
        employeeName.setBounds(60, 30, 120, 30);
        employeeName.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeName);

        empNameInput = new JTextField();
        empNameInput.setBounds(200, 35, 150, 25);
        add(empNameInput);

        JLabel employeeAge = new JLabel("Age");
        employeeAge.setBounds(60, 65, 120, 30);
        employeeAge.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeAge);

        empAgeInput = new JTextField();
        empAgeInput.setBounds(200, 70, 150, 25);
        add(empAgeInput);

        JLabel employeeGender = new JLabel("Gender");
        employeeGender.setBounds(60, 100, 120, 30);
        employeeGender.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeGender);

        maleButton = new JRadioButton("Male");
        maleButton.setBounds(200, 100, 70, 30);
        maleButton.setFont(new Font("Roboto", Font.BOLD, 12));
        maleButton.setBackground(Color.WHITE);
        add(maleButton);

        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(270, 100, 80, 30);
        femaleButton.setFont(new Font("Roboto", Font.BOLD, 12));
        femaleButton.setBackground(Color.WHITE);
        add(femaleButton);

        ButtonGroup maleFemaleButtons = new ButtonGroup();
        maleFemaleButtons.add(maleButton);
        maleFemaleButtons.add(femaleButton);

        JLabel employeeJob = new JLabel("Job");
        employeeJob.setBounds(60, 140, 120, 30);
        employeeJob.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeJob);

        String jobTitles[] = {
                "Front Desk Clerks",
                "Porters", "HouseKeeping",
                "Kitchen Staff",
                "Room Service",
                "Chef",
                "Waiter/Waitress",
                "Manager",
                "Accountant"
        };
        jobOptions = new JComboBox(jobTitles);
        jobOptions.setBounds(200, 140, 150, 30);
        jobOptions.setBackground(Color.WHITE);
        jobOptions.setBackground(Color.WHITE);
        jobOptions.setFont(new Font("Roboto", Font.BOLD, 12));
        add(jobOptions);

        JLabel employeeSalary = new JLabel("Salary");
        employeeSalary.setBounds(60, 180, 120, 30);
        employeeSalary.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeSalary);

        empSalaryInput = new JTextField();
        empSalaryInput.setBounds(200, 185, 150, 25);
        add(empSalaryInput);

        JLabel employeePhone = new JLabel("Phone Number");
        employeePhone.setBounds(60, 215, 120, 30);
        employeePhone.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeePhone);

        empPhoneInput = new JTextField();
        empPhoneInput.setBounds(200, 220, 150, 25);
        add(empPhoneInput);

        JLabel empAadhar = new JLabel("Aadhar Number");
        empAadhar.setBounds(60, 250, 120, 30);
        empAadhar.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(empAadhar);

        empAadharInput = new JTextField();
        empAadharInput.setBounds(200, 255, 150, 25);
        add(empAadharInput);

        JLabel employeeEmail = new JLabel("E-mail");
        employeeEmail.setBounds(60, 280, 120, 30);
        employeeEmail.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeEmail);

        empEmailInput = new JTextField();
        empEmailInput.setBounds(200, 285, 150, 25);
        add(empEmailInput);

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(110, 320, 150, 25);
        submitButton.setFont(new Font("Roboto", Font.BOLD, 14));
        submitButton.addActionListener(this);
        add(submitButton);

        ImageIcon unscaledImage = new ImageIcon(ClassLoader.getSystemResource("icons/employee-add.jpg"));
        Image scaleImage = unscaledImage.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon resizedImage = new ImageIcon(scaleImage);
        JLabel scaledImage = new JLabel(resizedImage);
        scaledImage.setBounds(380, 10, 450, 380);
        add(scaledImage);

        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 850, 450);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String employeeName = empNameInput.getText().trim();
        String employeeAge = empAgeInput.getText().trim();
        String employeeSalary = empSalaryInput.getText().trim();
        String employeePhone = empPhoneInput.getText().trim();
        String employeeAadhar = empAadharInput.getText().trim();
        String employeeEmail = empEmailInput.getText().trim();
        String employeeGender = null;

        if (maleButton.isSelected()) {
            employeeGender = "Male";
        } else if (femaleButton.isSelected()) {
            employeeGender = "Female";
        }

        String jobTitle = (String) jobOptions.getSelectedItem();

        if (ae.getSource() == submitButton) {
            if (isFieldEmpty(employeeName) || isFieldEmpty(employeeAge) || isFieldEmpty(employeeSalary) ||
                    isFieldEmpty(employeePhone) || isFieldEmpty(employeeAadhar) || isFieldEmpty(employeeEmail) ||
                    employeeGender == null || isFieldEmpty(jobTitle)) {
                JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
            } else if (!isNumeric(employeeAge) || !isNumeric(employeeSalary) || !isNumeric(employeePhone) ||
                    !isNumeric(employeeAadhar)) {
                JOptionPane.showMessageDialog(null, "Age, Salary, Phone, and Aadhar must be valid numbers.");
            } else {
                try {
                    ConnectionDB c = new ConnectionDB();
                    String query = "INSERT INTO employee VALUES ('"+employeeName+"', "+employeeAge+", "+employeeSalary+", "+employeePhone+", "+employeeAadhar+", '"+employeeEmail+"', '"+employeeGender+"', '"+jobTitle+"')";
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Validate if a string input is empty
    public boolean isFieldEmpty(String input) {
        return input.trim().isEmpty();
    }

    // Validate if a numeric input is a valid number
    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new EmployeeAdd();
    }
}
