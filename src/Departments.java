import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proteanit.sql.*;

public class Departments extends JFrame implements ActionListener {
    JTable departmentTable;
    JButton backButton;
    Departments () {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 600, 600);

        JLabel departmentName = new JLabel("Department Name");
        departmentName.setBounds(110, 10, 140, 20);
        departmentName.setFont(new Font("Roboto", Font.BOLD, 12));
        add(departmentName);

        JLabel departmentBudget = new JLabel("Department Budget");
        departmentBudget.setBounds(370, 10, 140, 20);
        departmentBudget.setFont(new Font("Roboto", Font.BOLD, 12));
        add(departmentBudget);

        departmentTable = new JTable();
        departmentTable.setBounds(0, 40, 600, 400);
        add(departmentTable);

        ConnectionDB c = new ConnectionDB();
        try {
            String query = "SELECT * FROM department_info";
            ResultSet rs = c.statement.executeQuery(query);
            departmentTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching department information: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (c.connection != null) {
                    c.connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        new Departments();
    }
}
