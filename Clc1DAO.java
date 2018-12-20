package library.DAO;
import library.DAO.*;
import library.PO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
public class Clc1DAO extends DAOBase{
	 //中图表1
	 //增
	public void createClc1(Clc1 clc1) throws Exception{
		
		String CREATE_CLC1_SQL = "insert into clc1(clcID1,clcname1) values(?,?)";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_CLC1_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, clc1.getClcID1());
			pStatement.setString(1, clc1.getClcname1());
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
	public Clc1 queryClc1(String clcID1) throws Exception{
		// SQL语句
		String QUERY_CLC1_SQL = "select * from clc1 where clcID1=?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_CLC1_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, clcID1);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			Clc1 clc1 = (Clc1)pStatement.executeQuery();		
			pStatement.close();
			return clc1;
					
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
