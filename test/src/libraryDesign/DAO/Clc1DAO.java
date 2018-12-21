package libraryDesign.DAO;
import libraryDesign.PO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
public class Clc1DAO extends DAOBase{
	 //添加一个Clc1记录
	public boolean createClc1(Clc1 clc1) throws Exception{
		
		String CREATE_CLC1_SQL = "insert into clc1(clcID1,clcname1) values(?,?)";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_CLC1_SQL);
			
			pStatement.setString(1, clc1.getClcID1());
			pStatement.setString(2, clc1.getClcname1());
			
			pStatement.executeUpdate();
			pStatement.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	// 根据clcID1查询Clc1记录，并返回一条Clc1记录
	public Clc1 queryClc1(String clcID1) throws Exception{
		
		String QUERY_CLC1_SQL = "select * from clc1 where clcID1=?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_CLC1_SQL);
			
			pStatement.setString(1, clcID1);
			
			//Clc1 clc1 = (Clc1)pStatement.executeQuery();		
			Clc1 c=new Clc1();
			ResultSet rs=pStatement.executeQuery();
			while(rs.next())
			{
				c.setClcID1(rs.getString("clcID1"));
				c.setClcname1(rs.getString("clcname1"));
			}
			
			pStatement.close();
			return c;
					
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}		

}
