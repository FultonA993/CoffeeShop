/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalprojectaf;

/**
 *
 * @author Adam
 */
import java.sql.*;

public class dropTablesAF {
    //database
    private static final String URL = "jdbc:derby:dbCoffeeStoreData;create=true";

   //drop tables method
   public void dropTables() {
      Connection conn = null;
      Statement stmt = null;

    try {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

        conn = DriverManager.getConnection(URL);
        stmt = conn.createStatement();

        // Dropping the tables
        String dropCustomerTable = "DROP TABLE Customer";
        stmt.executeUpdate(dropCustomerTable);

        String dropCoffeeTable = "DROP TABLE Coffee";
        stmt.executeUpdate(dropCoffeeTable);

        String dropOrdersTable = "DROP TABLE Orders";
        stmt.executeUpdate(dropOrdersTable);

        System.out.println("Tables and constraints have been dropped successfully.");
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   }
   public boolean isDatabaseEmpty() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    boolean isEmpty = true;

    try {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        conn = DriverManager.getConnection(URL);
        stmt = conn.createStatement();

        // Check if Customer table is empty
        String query = "SELECT * FROM Customer";
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            isEmpty = false;
        }

        // Check if Coffee table is empty
        query = "SELECT * FROM Coffee";
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            isEmpty = false;
        }

        // Check if Orders table is empty
        query = "SELECT * FROM Orders";
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            isEmpty = false;
        }

    } catch (SQLException | ClassNotFoundException se) {
        // Handle errors for JDBC
    } finally {
        // finally block used to close resources
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
        } // end finally try
    } // end try

    return isEmpty;
}
public static void main(String[] args) {
    dropTablesAF tableCreator = new dropTablesAF();
    tableCreator.dropTables();
    boolean isEmpty = tableCreator.isDatabaseEmpty();
    System.out.println("Is the database empty? " + isEmpty);
    }
}


