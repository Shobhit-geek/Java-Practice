package DataLayer;

/**
 * JDBC (Java Database Connectivity) Theory:
 * -----------------------------------------
 * JDBC is an API in Java that allows Java programs to connect and interact with
 * databases.
 * It provides methods to query and update data in a database using SQL.
 *
 * Key Steps in JDBC:
 * 1. Load the JDBC driver.
 * 2. Establish a connection to the database.
 * 3. Create a Statement or PreparedStatement.
 * 4. Execute SQL queries (SELECT, INSERT, UPDATE, DELETE).
 * 5. Process the results (ResultSet).
 * 6. Close the connection and resources.
 * 
    * JDBC Flow
    * Load Driver
    * ↓
    * Create Connection
    * ↓
    * Prepare SQL Statement
    * ↓
    * Execute Query
    * ↓
    * Process ResultSet
    * ↓
    * Close Resources

    * Limitations of JDBC
    
    * Too much boilerplate
    * Manual object mapping
    * Error-prone resource handling
    * Tight coupling between SQL and Java code
    * 📌 This pain led to ORM frameworks
    
 * Example: Connecting to a MySQL database and executing a query
 * ------------------------------------------------------------
 * import java.sql.*;
 *
 * public class JdbcExample {
 * public static void main(String[] args) {
 * String url = "jdbc:mysql://localhost:3306/mydb";
 * String user = "root";
 * String password = "password";
 * try {
 * // 1. Load the JDBC driver (optional for newer JDBC versions)
 * Class.forName("com.mysql.cj.jdbc.Driver");
 *
 * // 2. Establish connection
 * Connection con = DriverManager.getConnection(url, user, password);
 *
 * // 3. Create a statement
 * Statement stmt = con.createStatement();
 *
 * // 4. Execute a query
 * ResultSet rs = stmt.executeQuery("SELECT * FROM students");
 *
 * // 5. Process the results
 * while (rs.next()) {
 * System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
 * }
 *
 * // 6. Close resources
 * rs.close();
 * stmt.close();
 * con.close();
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * }
 * }
 */
public class jdbctheory {
	// See the comments above for JDBC theory and example.
}
