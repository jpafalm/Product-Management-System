package dbutil;

//This statement will import all the interfaces and classes related to our DB operations
import java.sql.*;

public class DBUtil {

	// Method to get connection
	public static Connection getConnection() 
	{
		Connection conn = null;
		try 
		{
			// This next statement loads the oracle driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// This statement creates connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Jop.aff-91");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	// Method to close the connection
	public static void closeConnection(Connection conn)
	{
		try
		{
			// This statement just close the connection
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}

