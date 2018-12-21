package library;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// 测试函数
		
//		Search();
		Update();
		
//		try {
////		Connection conn = JdbcUtil.getConnetion();
////		Connection conn = DbcpJdbcUtil.getConnection();
//		Connection conn = C3p0JdbcUtil.getConnection();
//		Statement stmt = conn.createStatement();
////		String sql = "select * from s";//连通性测试
////		String sql = "select * from student ";//连通性测试
////		String sql = "select x.Sno,x.SN from student x,score y where x.Sno=y.sno group by x.SNo,x.SN having count(*)>1";//test1
//		String sql = "delete from test_student";//test2
//		
//		ResultSet rs = stmt.executeQuery(sql);
////		int i;
////		System.out.println("学号    姓名");
//		System.out.println("删除成功！");
////		while(rs.next()) {
////			System.out.println(rs.getString(1) + " " + rs.getString(2) ); // test1
////			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
//
////		}
//		
////		JdbcUtil.release(conn, stmt, rs);
////		DbcpJdbcUtil.release(conn,stmt,rs);
//		C3p0JdbcUtil.release(conn, stmt, rs);
//				
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	public static void Search() {
		
		try {
			Connection conn = C3p0JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select x.Sno,x.SN from student x,score y where x.Sno=y.sno group by x.SNo,x.SN having count(*)>1";//test1
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("学号    姓名");
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) ); // test1
			}
			C3p0JdbcUtil.release(conn, stmt, rs);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void Update() {
		
		try {
			Connection conn = C3p0JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from test_student";//test2
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("删除成功");
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}

