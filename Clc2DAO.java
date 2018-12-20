package library.DAO;
import library.DAO.*;
import library.PO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
public class Clc2DAO extends DAOBase{
	 //中图表1
	 //增
	public void createClc2(Clc2 clc2) throws Exception{
		
		String CREATE_CLC2_SQL = "insert into clc2(clcID1,clcID2,clcname2) values(?,?,?)";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_CLC2_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, clc2.getClcID1());
			pStatement.setString(1, clc2.getClcID2());
			pStatement.setString(1, clc2.getClcname2());
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			pStatement.executeUpdate();
			pStatement.close();
					
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}	
	// 查
	public Clc2 queryClc2(String clcID1,String clcID2) throws Exception{
		// SQL语句
		String QUERY_CLC2_SQL = "select * from clc2 where clcID1=? and clcID2=?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_CLC2_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, clcID1);
			pStatement.setString(1, clcID2);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			Clc2 clc2 = (Clc2)pStatement.executeQuery();		
			pStatement.close();
			return clc2;
					
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}		

}
