package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeptDAO {
	public int addDept(Department dept)
	{
		Connection conn = DBUtil.getDBConnection();
		int count =0;
		try {
		PreparedStatement stmt = conn.prepareStatement("insert into dept values(?,?,?)");
		stmt.setInt(1, dept.getDno());
		stmt.setString(2, dept.getDname());
		stmt.setString(3, dept.getLocation());
		count = stmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	public int updateDept(Department dept)
	{
		Connection conn = DBUtil.getDBConnection();
		int count =0;
		try {
		PreparedStatement stmt = conn.prepareStatement("update dept set dname = ?, location = ? where dno = ?");
		stmt.setString(1, dept.getDname());
		stmt.setString(2, dept.getLocation());
		stmt.setInt(3, dept.getDno());
		count = stmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	public void getDeptByNo(int dno) {
		Connection conn = DBUtil.getDBConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from dept where dno = ?");
			stmt.setInt(1,dno);
			ResultSet res = stmt.executeQuery();
			while(res.next())
			{
				System.out.println(res.getInt(1) + " -> " + res.getString(2) + " -> " + res.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void selectAll()
	{
		Connection conn = DBUtil.getDBConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from dept");
			
			ResultSet res = stmt.executeQuery();
			while(res.next())
			{
				System.out.println(res.getInt(1) + " -> " + res.getString(2) + " -> " + res.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public int deleteDeptByNo(int dno) {
		Connection conn = DBUtil.getDBConnection();
		int count = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from dept where dno = ?");
			stmt.setInt(1,dno);
			count = stmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
}
