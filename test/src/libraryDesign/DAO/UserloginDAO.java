package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import libraryDesign.PO.Userlogin;

public class UserloginDAO extends DAOBase {
	
	// 增
	public void createUserlogin(Userlogin user) throws Exception{

		// SQL语句模板
		String CREATE_USER_SQL = "insert into userlogin (loginID,password) values(?,?)";
		
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
			pStatement.setString(1, user.getLoginID());
			pStatement.setString(2, user.getPassword());
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
	
	
	// 删
	// 删除用户登陆信息，因外键约束，需要先删除用户详细信息（Userdetail）
	// 用户登陆信息与用户详细信息为一对一关系
	public boolean deleteUser(Userlogin user) throws Exception{
		// SQL语句
		String DELETE_USER_SQL = "delete from userlogin where loginID=?";
		String DELETE_USERDETAIL_SQL = "delete from userdetail where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			pStatement0 = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			pStatement0.setString(1, user.getLoginID());
			pStatement0.executeUpdate();
			pStatement0.close();			
			
			pStatement = connection.prepareStatement(DELETE_USER_SQL);
			/*
			 * 需要实现的部分开始
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, user.getLoginID());
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

	// 重构，用loginID直接删除
	public boolean deleteUser(String loginID) throws Exception{

		// SQL语句
		String DELETE_USER_SQL = "delete from userlogin where loginID=?";
		String DELETE_USERDETAIL_SQL = "delete from userdetail where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			pStatement0 = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			pStatement0.setString(1, loginID);
			pStatement0.executeUpdate();
			pStatement0.close();			
						
			pStatement = connection.prepareStatement(DELETE_USER_SQL);
			/*
			 * 需要实现的部分开始
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, loginID);
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
	
	
	// 改
	// 修改指定登陆名的用户的密码 
	public void updateUserlogin(Userlogin user) throws Exception{
		// SQL语句
		String UPDATE_USER_SQL = "update userlogin set password=? where loginID=?";
		
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
			pStatement.setString(2, user.getLoginID());
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
	public Userlogin queryUserlogin(String loginID) throws Exception{
		
		//SQL语句
		String QUERY_USER_SQL = "select * from userlogin where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_USER_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, loginID);
			Userlogin ul=new Userlogin();
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()){
				
				ul.setLoginID(rs.getString(1));
				ul.setPassword(rs.getString(2));
			}
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			pStatement.close();
			
			return ul;
					
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
