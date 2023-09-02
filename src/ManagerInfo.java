import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {
    JTable manInfoTable;
    JButton backButton;
    ManagerInfo () {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 1000, 600);

        JLabel manName = new JLabel("Name");
        manName.setBounds(50, 10, 140, 20);
        manName.setFont(new Font("Roboto", Font.BOLD, 12));
        add(manName);

        JLabel manAge = new JLabel("Age");
        manAge.setBounds(170, 10, 140, 20);
        manAge.setFont(new Font("Roboto", Font.BOLD, 12));
        add(manAge);

        JLabel manPhone = new JLabel("Salary");
        manPhone.setBounds(290, 10, 140, 20);
        manPhone.setFont(new Font("Roboto", Font.BOLD, 12));
        add(manPhone);

        JLabel manSalary = new JLabel("Phone No");
        manSalary.setBounds(410, 10, 140, 20);
        manSalary.setFont(new Font("Roboto", Font.BOLD, 12));
        add(manSalary);

        JLabel manID = new JLabel("ID");
        manID.setBounds(530, 10, 140, 20);
        manID.setFont(new Font("Roboto", Font.BOLD, 12));
        add(manID);

        JLabel manMail = new JLabel("E-mail");
        manMail.setBounds(660, 10, 140, 20);
        manMail.setFont(new Font("Roboto", Font.BOLD, 12));
        add(manMail);

        JLabel manGender = new JLabel("Gender");
        manGender.setBounds(780, 10, 140, 20);
        manGender.setFont(new Font("Roboto", Font.BOLD, 12));
        add(manGender);

        JLabel manRole = new JLabel("Role");
        manRole.setBounds(900, 10, 140, 20);
        manRole.setFont(new Font("Roboto", Font.BOLD, 12));
        add(manRole);

        manInfoTable = new JTable();
        manInfoTable.setBounds(0, 40, 1000, 400);
        add(manInfoTable);


        try {
            ConnectionDB c = new ConnectionDB();
            String query = "SELECT * FROM employee WHERE job = 'Manager'";
            ResultSet rs = c.statement.executeQuery(query);
            manInfoTable.setModel(DbUtils.resultSetToTableModel(rs));
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
        new ManagerInfo();
    }
}
