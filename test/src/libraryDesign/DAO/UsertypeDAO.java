package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import libraryDesign.PO.Usertype;

public class UsertypeDAO extends DAOBase {
	
	// 增
	public void createUsertype(Usertype usertype) throws Exception{
		// SQL语句
		String CREATE_USERTYPE_SQL = "insert into usertype(usertypeID,usertype,maxbooknum,maxorder,maxentrust) values(?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_USERTYPE_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, usertype.getUsertypeID());
			pStatement.setString(2, usertype.getUsertype());
			pStatement.setInt(3, usertype.getMaxbooknum());
			pStatement.setInt(4, usertype.getMaxorder());
			pStatement.setInt(5, usertype.getMaxentrust());
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
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	
	
	// 查
	public Usertype queryUsertype(String usertypeID) throws Exception{
		// SQL语句
		String QUERY_USERTYPE_SQL = "select * from usertype where usertypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_USERTYPE_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, usertypeID);

			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			Usertype usertype = (Usertype) pStatement.executeQuery();
			pStatement.close();
			
			return usertype;
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
}
