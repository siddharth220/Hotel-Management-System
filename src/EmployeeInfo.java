import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    JTable empInfoTable;
    JButton backButton;
    EmployeeInfo () {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 1000, 600);

        JLabel empName = new JLabel("Name");
        empName.setBounds(50, 10, 140, 20);
        empName.setFont(new Font("Roboto", Font.BOLD, 12));
        add(empName);

        JLabel empAge = new JLabel("Age");
        empAge.setBounds(170, 10, 140, 20);
        empAge.setFont(new Font("Roboto", Font.BOLD, 12));
        add(empAge);

        JLabel empPhone = new JLabel("Salary");
        empPhone.setBounds(290, 10, 140, 20);
        empPhone.setFont(new Font("Roboto", Font.BOLD, 12));
        add(empPhone);

        JLabel empSalary = new JLabel("Phone No");
        empSalary.setBounds(410, 10, 140, 20);
        empSalary.setFont(new Font("Roboto", Font.BOLD, 12));
        add(empSalary);

        JLabel empID = new JLabel("ID");
        empID.setBounds(530, 10, 140, 20);
        empID.setFont(new Font("Roboto", Font.BOLD, 12));
        add(empID);

        JLabel empMail = new JLabel("E-mail");
        empMail.setBounds(660, 10, 140, 20);
        empMail.setFont(new Font("Roboto", Font.BOLD, 12));
        add(empMail);

        JLabel empGender = new JLabel("Gender");
        empGender.setBounds(780, 10, 140, 20);
        empGender.setFont(new Font("Roboto", Font.BOLD, 12));
        add(empGender);

        JLabel empRole = new JLabel("Role");
        empRole.setBounds(900, 10, 140, 20);
        empRole.setFont(new Font("Roboto", Font.BOLD, 12));
        add(empRole);

        empInfoTable = new JTable();
        empInfoTable.setBounds(0, 40, 1000, 400);
        add(empInfoTable);


        try {
            ConnectionDB c = new ConnectionDB();
            String query = "SELECT * FROM employee";
            ResultSet rs = c.s.executeQuery(query);
            empInfoTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        backButton = new JButton("Back");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setBounds(440, 500, 120, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae) {
        setVisible(false);
        new HotelReception();
    }
    public static void main(String[] args) {
        new EmployeeInfo();
    }
}
