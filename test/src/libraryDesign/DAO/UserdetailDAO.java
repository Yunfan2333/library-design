package libraryDesign.DAO;

import java.sql.*;

import libraryDesign.PO.Userdetail;

public class UserdetailDAO extends DAOBase {
	
	// 增
	public void createUserdetail(Userdetail userdetail) throws Exception{
		// SQL语句
		String CREATE_USERDETAIL_SQL = "insert into userdetail(userID,userName,docID,college,profession,sex,mail,loginID) values(?,?,?,?,?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_USERDETAIL_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, userdetail.getUserID());
			pStatement.setString(2, userdetail.getUserName());
			pStatement.setString(3, userdetail.getDocID());
			pStatement.setString(4, userdetail.getCollege());
			pStatement.setString(5, userdetail.getProfession());
			pStatement.setString(6, userdetail.getSex());
			pStatement.setString(7, userdetail.getMail());
			pStatement.setString(8, userdetail.getLoginID());
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
			try {
				connection.close();
			}catch(SQLException ee) {
				ee.printStackTrace();
			}
		}
	}
	
	// 删
	// 删除用户详细信息后不应再保留用户登陆信息，一起删除
	// 先删除详细信息，再删除登陆信息
	public void deleteUserdetail(Userdetail userdetail) throws Exception{

		// SQL语句
		String DELETE_USERDETAIL_SQL = "delete from userdetail where userID=?";
		String DELETE_USER_SQL = "delete from user where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, userdetail.getUserID());
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
			
			// 删除登陆信息
			pStatement0 = connection.prepareStatement(DELETE_USER_SQL);
			pStatement0.setString(1, userdetail.getLoginID());
			pStatement0.executeUpdate();
			pStatement0.close();
						
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
	
	// 重载，根据用户名删除用户详细信息
	public void deleteUserdetail(String userID) throws Exception{
		
		// SQL语句
		String DELETE_USERDETAIL_SQL = "delete from userdetail where userID=?";
		String DELETE_USER_SQL = "delete from user where loginID=?";
				
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, userID);
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
			
			// 删除登陆信息
			Userdetail userdetail = queryUserdetail(userID);
			pStatement0 = connection.prepareStatement(DELETE_USER_SQL);
			pStatement0.setString(1, userdetail.getLoginID());
			pStatement0.executeUpdate();			
					
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
	
	
	// 改
	public Userdetail updateUserdetail(Userdetail userdetail) throws Exception{

		// SQL
		String UPDATE_USERDETAIL_SQL = "update userdetail set userName=?,docID=?,college=?,profession=?,sex=?,mail=?,loginID=? where userID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USERDETAIL_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, userdetail.getUserName());
			pStatement.setString(2, userdetail.getDocID());
			pStatement.setString(3, userdetail.getCollege());
			pStatement.setString(4, userdetail.getProfession());
			pStatement.setString(5, userdetail.getSex());
			pStatement.setString(6, userdetail.getMail());
			pStatement.setString(7, userdetail.getLoginID());			
			pStatement.setString(8, userdetail.getUserID());
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
			
			return userdetail;
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userdetail;
	}		
	
	// 查
	// 根据用户名进行查询并返回查询到的Userdetail
	public Userdetail queryUserdetail(String userID) throws Exception{

		// SQL
		String QUERY_USERDETAIL_SQL = "select * from userdetail where userID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_USERDETAIL_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, userID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			Userdetail userdetail = (Userdetail)pStatement.executeQuery();

			pStatement.close();
			
			return userdetail;
					
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
