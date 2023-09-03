import java.sql.*;

public class ConnectionDB {
    Connection connection;
    Statement statement;

    // Constructor to initialize the database connection and statement
    public ConnectionDB() {
        try {
            // Load the MySQL JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/sunrisehotelmgmt", "root", "2022.Hell_cat*-");

            // Create a statement for executing SQL queries
            statement = connection.createStatement();
        } catch (Exception e) {
            // Print the exception's stack trace for debugging purposes
            e.printStackTrace();
        }
    }

    // Method to validate the database connection
    public boolean isConnectionValid() {
        try {
            // Check if the connection is not null and is still valid
            return (connection != null) && (!connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // This is the main method, which is currently empty
        // You can add code here for testing the database connection
        ConnectionDB dbConnection = new ConnectionDB();

        if (dbConnection.isConnectionValid()) {
            System.out.println("Database connection is valid.");
        } else {
            System.out.println("Database connection is not valid.");
        }
    }
}