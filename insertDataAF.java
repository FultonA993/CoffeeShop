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

public class insertDataAF {
    //database
    private static final String URL = "jdbc:derby:dbCoffeeStoreData;create=true";

   //insert tables method
   public void insertData() {
      Connection conn = null;
      Statement stmt = null;

      try {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

         conn = DriverManager.getConnection(URL);
         stmt = conn.createStatement();

         // Inserting data into Customer table
         String insertCustomerData = "INSERT INTO Customer (customer_number, first_name, last_name, street, city, state, zip, phone, email, credit_limit) VALUES "
                 + "(1, 'John', 'Doe', '123 Main St', 'Pfafftown', 'NC', '27023', '5551234567', 'johndoe@email.com', 1000),"
                 + "(2, 'Jane', 'Smith', '796 Big Tree', 'Yadkinville', 'NC', '27104', '5559876543', 'janesmith@email.com', 2000),"
                 + "(3, 'Bob', 'Barker', '789 Market St', 'Lewisville', 'NC', '27103', '5555551212', 'bobbarker@email.com', 500),"
                 + "(4, 'Katie', 'South', '321 Melrose', 'Clemmons', 'NC', '27012', '5555552424', 'katiesouth@email.com', 1500),"
                 + "(5, 'Adam', 'Fulton', '999 Elm St', 'Winston-Salem', 'NC', '27023', '5555553636', 'adamfulton@email.com', 200)";
         stmt.executeUpdate(insertCustomerData);

         // Inserting data into Coffee table
         String insertCoffeeData = "INSERT INTO Coffee (coffee_id, coffee_name, coffee_description, price, num_in_stock) VALUES "
                 + "(1, 'Colombian', 'Dark Roast', 4.99, 50),"
                 + "(2, 'French Roast', 'Medium Roast', 4.99, 25),"
                 + "(3, 'Italian Roast', 'Dark Roast', 5.99, 30),"
                 + "(4, 'Irish', 'Light Roast', 3.99, 40),"
                 + "(5, 'Iced Coffee', 'Medium Roast', 4.99, 20)";
         stmt.executeUpdate(insertCoffeeData);

         // Inserting data into Orders table
         String insertOrdersData = "INSERT INTO Orders (order_id, customer_id, coffee_id, num_ordered, total) VALUES "
                 + "(1, 1, 1, 2.0, 9.98),"
                 + "(2, 1, 2, 1.0, 4.99),"
                 + "(3, 2, 3, 3.0, 15.97),"
                 + "(4, 2, 4, 2.0, 7.98),"
                 + "(5, 3, 2, 4.0, 31.96),"
                 + "(6, 3, 4, 1.0, 3.99),"
                 + "(7, 4, 1, 3.0, 12.97),"
                 + "(8, 4, 1, 2.0, 11.98),"
                 + "(9, 2, 2, 1.0, 4.99),"
                 + "(10, 2, 3, 3.0, 15.97),"
                 + "(11, 1, 4, 2.0, 7.98),"
                 + "(12, 1, 2, 4.0, 21.96),"
                 + "(13, 5, 4, 1.0, 3.99),"
                 + "(14, 5, 1, 3.0, 15.97)";
         
         stmt.executeUpdate(insertOrdersData);
         
      } catch (SQLException | ClassNotFoundException se) {
      } finally {
         try {
            if (stmt != null)
               conn.close();
         } catch (SQLException se) {
         }
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
         }
      }
   }
}