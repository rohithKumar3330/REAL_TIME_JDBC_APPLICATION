package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JdbcDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("delete from dept where dno = 80");
			ResultSet res = stmt.executeQuery("select * from dept");
			while(res.next())
			{
				System.out.println(res.getInt(1)+ "--" +res.getString(2) + "--" + res.getString(3));
			}
			conn.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
