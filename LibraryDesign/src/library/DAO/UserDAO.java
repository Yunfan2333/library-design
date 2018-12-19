package library.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import library.PO.User;

public class UserDAO extends DAOBase {
	
	// 增
	public void createUser(User user) throws Exception{

		// SQL语句模板
		String CREATE_USER_SQL = "insert into user (loginID,password) values(?,?)";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_USER_SQL);
			/*
			 * 需要实现的部分开始
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */			
			pStatement.setString(0, user.getLoginID());
			pStatement.setString(1, user.getPassword());
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
	
	
	// 删
	// 删除用户登陆信息，因外键约束，需要先删除用户详细信息（Userdetail）
	// 用户登陆信息与用户详细信息为一对一关系
	public void deleteUser(User user) throws Exception{
		// SQL语句
		String DELETE_USER_SQL = "delete from user where loginID=?";
		String DELETE_USERDETAIL_SQL = "delete from userdetail where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			pStatement0 = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			pStatement0.setString(0, user.getLoginID());
			pStatement0.executeUpdate();
			pStatement0.close();			
			
			pStatement = connection.prepareStatement(DELETE_USER_SQL);
			/*
			 * 需要实现的部分开始
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, user.getLoginID());
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

	// 重构，用loginID直接删除
	public void deleteUser(String loginID) throws Exception{

		// SQL语句
		String DELETE_USER_SQL = "delete from user where loginID=?";
		String DELETE_USERDETAIL_SQL = "delete from userdetail where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			pStatement0 = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			pStatement0.setString(0, loginID);
			pStatement0.executeUpdate();
			pStatement0.close();			
						
			pStatement = connection.prepareStatement(DELETE_USER_SQL);
			/*
			 * 需要实现的部分开始
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, loginID);
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
	
	
	// 改
	// 修改指定登陆名的用户的密码
	// SQL语句写为 private static final String
	private static final String UPDATE_USER_SQL = "update user set password=? where loginID=?";
	public void updateUser(User user) throws Exception{
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, user.getLoginID());
			pStatement.setString(0, user.getPassword());
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
	// SQL语句写为 private static final String
	private static final String GET_USER_SQL = "select * from user where loginID=?";
	public User getUser(String loginID) throws Exception{
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, loginID);
			User user = (User)pStatement.executeQuery();
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			pStatement.close();
			
			return user;
					
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
