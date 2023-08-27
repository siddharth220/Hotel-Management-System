import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAdd extends JFrame implements ActionListener {

    EmployeeAdd() {
        setLayout(null);

        JLabel employeeName = new JLabel("Name");
        employeeName.setBounds(60, 30, 120, 30);
        employeeName.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeName);

        JTextField empNameInput = new JTextField();
        empNameInput.setBounds(180, 35, 150, 25);
        add(empNameInput);

        JLabel employeeAge = new JLabel("Age");
        employeeAge.setBounds(60, 65, 120, 30);
        employeeAge.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeAge);

        JTextField empAgeInput = new JTextField();
        empAgeInput.setBounds(180, 70, 150, 25);
        add(empAgeInput);

        JLabel employeeGender = new JLabel("Gender");
        employeeGender.setBounds(60, 100, 120, 30);
        employeeGender.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeGender);

        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setBounds(180, 100, 70, 30);
        maleButton.setFont(new Font("Roboto", Font.BOLD, 12));
        maleButton.setBackground(Color.WHITE);
        add(maleButton);

        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(220, 100, 80, 30);
        femaleButton.setFont(new Font("Roboto", Font.BOLD, 12));
        femaleButton.setBackground(Color.WHITE);
        add(femaleButton);

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
        JComboBox jobOptions = new JComboBox(jobTitles);
        jobOptions.setBounds(180, 140, 150, 30);
        jobOptions.setBackground(Color.WHITE);
        jobOptions.setBackground(Color.WHITE);
        jobOptions.setFont(new Font("Roboto", Font.BOLD, 12));
        add(jobOptions);

        JLabel employeeSalary = new JLabel("Salary");
        employeeSalary.setBounds(60, 180, 120, 30);
        employeeSalary.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeSalary);

        JTextField empSalaryInput = new JTextField();
        empSalaryInput.setBounds(180, 185, 150, 25);
        add(empSalaryInput);

        JLabel employeePhone = new JLabel("Phone Number");
        employeePhone.setBounds(60, 215, 120, 30);
        employeePhone.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeePhone);

        JTextField empPhoneInput = new JTextField();
        empPhoneInput.setBounds(180, 220, 150, 25);
        add(empPhoneInput);

        JLabel employeeEmail = new JLabel("E-mail");
        employeeEmail.setBounds(60, 250, 120, 30);
        employeeEmail.setFont(new Font("Roboto", Font.PLAIN, 17));
        add(employeeEmail);

        JTextField empEmailInput = new JTextField();
        empEmailInput.setBounds(180, 255, 150, 25);
        add(empEmailInput);

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(110, 300, 150, 25);
        submitButton.setFont(new Font("Roboto", Font.BOLD, 14));
        add(submitButton);

        ImageIcon unscaledImage = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
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

    }
    public static void main(String[] args) {
        new EmployeeAdd();
    }
}
