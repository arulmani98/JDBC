package JdbcConnection;

//import ---> java.sql
import java.sql.*;

/*
1. import ---> java.sql
2. load and register the driver (EXTERNAL JAR NEEDED) --> com.mysql.jdbc.Driver
3. Create connection -->  connection object (Interface)
4. create a statement --> statement object (Interface)
5. Execute the query
6. Process the results
7. close the connection
 */

public class BasicConnectionToDB {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/student"; 
		/*
		 * localhost - machine name
		 * 3306 - port of DataBase
		 * student - Database name
		 */
		String userName = "root";  //DB user
		String password = "root";	//DB user password
		String query = "select * from eee";   //eee - table name
		Class.forName("com.mysql.cj.jdbc.Driver"); //Load the driver
		Connection connection = DriverManager.getConnection(url,userName,password);
		/*
		 * Connection is a Interface so we cant create a Object for that
		 * So external class or a method that return a instance (Object) of Connection is needed
		 * get connection returns the instance of Connection interface
		 */
		Statement statement = connection.createStatement();
		/*
		 * create the statement object using the connection object
		 */
		ResultSet result = statement.executeQuery(query);
		/*
		 * ResultSet object is to store the result of the executed query
		 */
		result.next();
		/*
		 * Initially the pointer denotes the Heading row in the table
		 *     +-------------------------+
		 * --> |  Name   | Age |  address|  <-- Pointer initially here
		 *     ---------------------------
		 *     | Arulmani| 23  |  Kallai |
		 *     | Nandhini| 22  |  Gobi   |
		 *     +-------------------------+
		 *     
		 *     after giving result.next() the pointer will move from heading row to first row of data
		 *     +-------------------------+
		 * --> |  Name   | Age |  address|  
		 *     ---------------------------
		 *     | Arulmani| 23  |  Kallai |  <-- Pointer after result.next() method call
		 *     | Nandhini| 22  |  Gobi   |
		 *     +-------------------------+
		 */
		String name = result.getString("name");
		System.out.println(name);
		statement.close();
		connection.close();
	}
}
