package library.DAO;

import java.sql.*;

import library.PO.Userdetail;

public class UserdetailDAO extends DAOBase {
	
	// 增
	// SQL语句写为 private static final String
	private static final String CREATE_USERDETAIL_SQL = "insert into userdetail(userID,userName,usertypeID,college,profession,sex,mail,loginID) values(?,?,?,?,?,?,?,?)";
	public void updateUser(Userdetail userdetail) throws Exception{
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
			pStatement.setString(0, userdetail.getUserID());
			pStatement.setString(1, userdetail.getUserName());
			pStatement.setString(2, userdetail.getUsertypeID());
			pStatement.setString(3, userdetail.getCollege());
			pStatement.setString(4, userdetail.getProfession());
			pStatement.setString(5, userdetail.getSex());
			pStatement.setString(6, userdetail.getMail());
			pStatement.setString(7, userdetail.getLoginID());

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
	// 删除用户详细信息后不应再保留用户登陆信息，一起删除
	// SQL语句写为 private static final String
	private static final String DELETE_USERDETAIL_SQL = "delete from userdetail where userID=?";
	public void deleteUserdetail(Userdetail userdetail) throws Exception{
		Connection connection = null;
		PreparedStatement pStatement = null;
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
	
	// 重载，根据用户名删除用户详细信息
	public void deleteUserdetail(String userID) throws Exception{
		Connection connection = null;
		PreparedStatement pStatement = null;
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
	
	// 查

}
