import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class ResultSetExample {
 
    public static void main(String[] args) {
        // The credentials that we need to have available for the connection to the database.
        String username = "root";
        String password = "MyNewPass";
        String databaseName = "SELECTION_DB";
 
        Connection connect = null;
        Statement statement = null;
 
        try {
            // Load the MySQL driver.
            Class.forName("com.mysql.jdbc.Driver");
 
            // Setup the connection to the database.
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + databaseName + "?"
                    + "user=" + username
                    + "&password=" + password);
 
            // Create the statement to be used to get the results.
            statement = connect.createStatement();
 
            // Create a query to use.
            String query = "SELECT * FROM EMP_SELECTION";
 
            // Execute the query and get all the results returned from the database.
            ResultSet resultSet = statement.executeQuery(query);
 
            // We loop through the rows that were returned, and we can access the information
            // depending on the type of each column
            while (resultSet.next()) {
                System.out.println("Printing result...");
 
                // Now we can fetch the data by column name
                String first_name = resultSet.getString("FIRST_NAME");
                String last_name = resultSet.getString("LAST_NAME");
                int age = resultSet.getInt("AGE");
                String gender = resultSet.getString("GENDER");
                int income = resultSet.getInt("INCOME");
                String address = resultSet.getString("address");
 
                System.out.println("Name: " + first_name + " " + last_name);
                System.out.println("Age: " + age);
                System.out.println("Gender: " + gender);
                System.out.println("Income: " + income);
                System.out.println("Address: " + address);
            }
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close the connection and release the resources used
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
 
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
