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

public class createTablesAF {
    //database
    private static final String URL = "jdbc:derby:dbCoffeeStoreData;create=true";
    //create tables method
   public void createTables() {
      Connection conn = null;
      Statement stmt = null;

      try {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

         conn = DriverManager.getConnection(URL);
         stmt = conn.createStatement();

        // Creating Customer table
        String createCustomerTable = "CREATE TABLE Customer ("
                + "customer_number INT PRIMARY KEY,"
                + "first_name VARCHAR(50),"
                + "last_name VARCHAR(50),"
                + "street VARCHAR(100),"
                + "city VARCHAR(50),"
                + "state VARCHAR(2),"
                + "zip VARCHAR(5),"
                + "phone VARCHAR(10),"
                + "email VARCHAR(100),"
                + "credit_limit DOUBLE)";
        stmt.executeUpdate(createCustomerTable);

        // Creating Coffee table
        String createCoffeeTable = "CREATE TABLE Coffee ("
                + "coffee_id INT PRIMARY KEY,"
                + "coffee_name VARCHAR(50),"
                + "coffee_description VARCHAR(200),"
                + "price DOUBLE,"
                + "num_in_stock INT)";
        stmt.executeUpdate(createCoffeeTable);

        // Creating Orders table
        String createOrdersTable = "CREATE TABLE Orders ("
                        + "order_id INT PRIMARY KEY,"
                        + "customer_id INT,"
                        + "coffee_id INT,"
                        + "num_ordered DOUBLE,"
                        + "total DOUBLE)";

        stmt.executeUpdate(createOrdersTable);
        
        System.out.println("Tables created successfully.");
         
      } catch (SQLException | ClassNotFoundException se) {
      } finally {
         try {
            if (stmt != null)
               conn.close();
         } catch (SQLException se) {
             se.printStackTrace();
         }
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
         }
      }
   }
   
   //used to check tables
    public void selectFromTable() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();

        String query = "SELECT * FROM Orders";
        rs = stmt.executeQuery(query);

        while (rs.next()) {
            int orderID = rs.getInt("order_id");
            int customerID = rs.getInt("customer_id");
            int coffeeID = rs.getInt("coffee_id");
            double quant = rs.getDouble("num_ordered");
            double total = rs.getDouble("total");

            System.out.println("Customer Number: " + orderID);
            System.out.println("Name: " + customerID);
            System.out.println("Address: " + coffeeID);
            System.out.println("Phone: " + quant);
            System.out.println("Email: " + total);
            System.out.println("-----------------------------------");
        }

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

public static void main(String[] args) {
    createTablesAF tableCreator = new createTablesAF();
    tableCreator.selectFromTable();
    }
}