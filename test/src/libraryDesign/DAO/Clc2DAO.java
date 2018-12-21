package libraryDesign.DAO;
import libraryDesign.PO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
public class Clc2DAO extends DAOBase{
	 //添加一个Clc2记录
	public boolean createClc2(Clc2 clc2) throws Exception{
		
		String CREATE_CLC2_SQL = "insert into clc2(clcID1,clcID2,clcname2) values(?,?,?)";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_CLC2_SQL);
			
			pStatement.setString(1, clc2.getClcID1());
			pStatement.setInt(2, clc2.getClcID2());
			pStatement.setString(3, clc2.getClcname2());
			
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
	// 根据联合主键clcID1和clcID2查询一条Clc2记录，并返回该记录
	public Clc2 queryClc2(String clcID1,int clcID2) throws Exception{
		String QUERY_CLC2_SQL = "select * from clc2 where clcID1=? and clcID2=?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_CLC2_SQL);
			
			pStatement.setString(1, clcID1);
			pStatement.setInt(2, clcID2);
			
			//Clc2 clc2 = (Clc2)pStatement.executeQuery();		
			
			Clc2 c=new Clc2();
			ResultSet rs=pStatement.executeQuery();
			while(rs.next())
			{
				c.setClcID1(rs.getString("clcID1"));
				c.setClcID2(rs.getInt("clcID2"));
				c.setClcname2(rs.getString("clcname2"));
				
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
