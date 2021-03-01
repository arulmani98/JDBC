package JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IteratingTableRows {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/student"; 
		String userName = "root";
		String password = "root";
		String query = "select * from eee";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url,userName,password);
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		//Iterate through the table
		while(result.next()) {
			//String data = result.getString("name")+" - "+result.getInt("age")+" - "+result.getString("address");  //Getting data using column name
			String data = result.getString(1)+" - "+result.getInt(2)+" - "+result.getString(3);   //Getting data using the index of the column name (Note: Index starts from 1)
			System.out.println(data);
		}
		statement.close();
		connection.close();
	}

}
