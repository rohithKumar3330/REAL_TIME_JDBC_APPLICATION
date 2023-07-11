package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getDBConnection() {
		Connection conn = null;
		try
		{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public static void closeConnection()
	{
		Connection conn = getDBConnection();
		try {
			conn.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
