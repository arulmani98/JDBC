package JdbcConnection;

import java.sql.*;

public class JdbcWhereClause {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/student"; 
		String userName = "root";
		String password = "root";
		String query = "select * from eee where age > 30";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url,userName,password);
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		result.next();
		String name = result.getString("address");
		System.out.println(name);
		statement.close();
		connection.close();

	}

}
