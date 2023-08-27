import java.sql.*;

public class ConnectionDB {
    Connection c;
    Statement s;
    ConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3307/sunrisehotelmgmt", "root", "2022.Hell_cat*-");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();  // Print the exception's stack trace for debugging purposes
        }

    }
    public static void main(String[] args) {

    }
}