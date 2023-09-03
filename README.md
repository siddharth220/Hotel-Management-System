# Hotel Management System

![Java](https://img.shields.io/badge/Java-8%2B-blue)
![Swing](https://img.shields.io/badge/Swing-AWT-yellow)
![MySQL](https://img.shields.io/badge/MySQL-5.7%2B-green)
![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-orange)

A comprehensive Hotel Management System implemented in Java Swing and AWT, with a MySQL database backend. This system is designed to streamline hotel operations, from guest reservations and checkouts to employee and room management. It includes the following features:

## Features

- **Home Page**: A welcoming landing page for guests and staff.

- **Login Page**: Secure user authentication for hotel staff and administrators.

- **Hotel Dashboard**: Centralized control panel for managing hotel operations.

- **New Customer Form**: Easily add new customer details.

- **Room Information**: View and manage room details and availability.

- **Department Information**: Maintain information about hotel departments.

- **Employee Info**: Manage employee profiles and roles.

- **Customer Info**: Maintain guest information and preferences.

- **Manager Info**: Manage manager profiles and responsibilities.

- **Checkout**: Streamlined guest checkout process.

- **Update Customer Status**: Modify guest status (e.g., checked-in, checked-out).

- **Update Room Status**: Manage room statuses (e.g., occupied, vacant).

- **Pickup Services**: Arrange transportation services for guests.

- **Search Rooms**: Quick room search and booking capabilities.

- **Admin Options**:
  - Add Employees: Hire and manage hotel staff.
  - Add Drivers: Employ drivers for guest transportation.
  - Add Rooms: Expand the hotel's room inventory.

- **Logout**: Securely log out from the system.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Database Server 5.7 or higher
- IntelliJ IDEA or any Java IDE of your choice

## Setup

1. Clone the repository to your local machine.

2. Import the project into your IntelliJ IDEA or preferred IDE.

3. Configure the MySQL database connection in `src/main/resources/application.properties`.

4. Create the necessary database schema and tables using the SQL scripts provided in the `database-scripts` folder.

5. Build and run the project.

## Installation

Follow these steps to set up the MySQL database for the Hotel Management System:

1. **Database Setup:**

   - Install and configure MySQL on your system if you haven't already.

   - Create a new database for the Hotel Management System. You can use a MySQL client like phpMyAdmin or run the following command in the MySQL command line, replacing `<your_database_name>`, `<your_username>`, and `<your_password>` with your desired values:

     ```sql
     CREATE DATABASE <your_database_name>;
     ```

   - Make note of the database name as you will need it later.

2. **Edit Connection String:**

   - Open the project in your IntelliJ IDEA or preferred IDE.

   - Locate the following line of code in your project where the database connection is established:

     ```java
     String connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/sunrisehotelmgmt", "root", "2022.Hell_cat*-");
     ```

   - Replace the values in the connection string as follows:
     
     - `<your_database_name>`: Replace with the name of the database you created.
     - `<your_username>`: Replace with your MySQL username.
     - `<your_password>`: Replace with your MySQL password.
     - `<your_port>`: If your MySQL server is running on a different port (default is 3306), replace it accordingly.

   - Save the changes.

3. **Table Creation:**

   - After editing the connection string, run the application.

   - The application should automatically create the necessary tables in your database based on the entity classes in the code. If it doesn't, you can manually create the tables using the provided SQL scripts.

   - Open a MySQL client or the MySQL command line and execute the following SQL scripts, one by one, to create the required tables:

     ```sql
     CREATE TABLE `customer_info` (
       `document` varchar(30) DEFAULT NULL,
       `document_id` varchar(30) DEFAULT NULL,
       `customer_name` varchar(50) DEFAULT NULL,
       `gender` varchar(10) DEFAULT NULL,
       `country` varchar(30) DEFAULT NULL,
       `room_number` int DEFAULT NULL,
       `checkin_time` varchar(80) DEFAULT NULL,
       `deposit_amount` int DEFAULT NULL
     );

     CREATE TABLE `department_info` (
       `department` varchar(40) DEFAULT NULL,
       `budget` int DEFAULT NULL
     );

     CREATE TABLE `driver_data` (
       `name` varchar(50) DEFAULT NULL,
       `age` int DEFAULT NULL,
       `gender` varchar(10) DEFAULT NULL,
       `car_company` varchar(30) DEFAULT NULL,
       `car_model` varchar(30) DEFAULT NULL,
       `driver_availibility` varchar(20) DEFAULT NULL,
       `destination` varchar(50) DEFAULT NULL
     );

     CREATE TABLE `employee` (
       `name` varchar(50) DEFAULT NULL,
       `age` int DEFAULT NULL,
       `salary` int DEFAULT NULL,
       `phone` bigint DEFAULT NULL,
       `aadhar` bigint DEFAULT NULL,
       `email` varchar(30) DEFAULT NULL,
       `gender` varchar(10) DEFAULT NULL,
       `job` varchar(20) DEFAULT NULL
     );

     CREATE TABLE `login_info` (
       `username` varchar(30) DEFAULT NULL,
       `password` varchar(40) DEFAULT NULL
     );

     CREATE TABLE `rooms` (
       `room_number` int DEFAULT NULL,
       `room_status` varchar(20) DEFAULT NULL,
       `room_clean_status` varchar(20) DEFAULT NULL,
       `room_price` int DEFAULT NULL,
       `bed_type` varchar(20) DEFAULT NULL
     );
     ```

4. Build and run the project.

Now, your Hotel Management System should be connected to the MySQL database with the required tables in place.


## Usage

- Launch the application and log in using your credentials.

- Use the intuitive GUI to manage all aspects of hotel operations.

- Leverage the admin options for adding employees, drivers, and rooms.

- Generate reports and gain insights into hotel performance.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.

2. Create a new branch for your feature or bug fix.

3. Make your changes and commit them (`git commit -m 'Add feature'`).

4. Push to your branch (`git push origin your-branch`).

5. Open a pull request to the `main` branch.

## License

This project is licensed under the [MIT License](LICENSE) - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Special thanks to the open-source community for valuable resources and libraries.

- Credits to contributors and collaborators who helped build this comprehensive Hotel Management System.

---

Happy coding!
