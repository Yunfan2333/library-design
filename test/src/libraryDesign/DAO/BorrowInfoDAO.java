package library.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import library.PO.BorrowInfo;
import library.PO.Document;
import library.PO.Userdetail;

public class BorrowInfoDAO extends DAOBase
{
	// 借阅信息
	// 增
	public void createBorrowInfo(BorrowInfo borrowInfo) throws Exception{
		// SQL语句
		String CREATE_BorrowInfo_SQL = "insert into borrowInfo(userID,bookID,borrowTime,returnTime,borrowID,returnState) values(?,?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_BorrowInfo_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, borrowInfo.getUserID());
			pStatement.setString(1, borrowInfo.getBookID());
			pStatement.setDate(2, (java.sql.Date) borrowInfo.getBorrowTime());
			pStatement.setDate(3,(java.sql.Date) borrowInfo.getReturnTime());
			pStatement.setString(4, borrowInfo.getBorrowID());
			pStatement.setString(5, borrowInfo.getReturnState());
			
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
	// 根据borrowID删除借阅信息
	public void deleteBorrowInfo(BorrowInfo borrowInfo) throws Exception{
		// SQL语句
		String DELETE_BorrowInfo_SQL = "delete from borrowInfo where borrowID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
		
			// 删除证件
			pStatement = connection.prepareStatement(DELETE_BorrowInfo_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, borrowInfo.getBorrowID());
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
	public void updateBorrowInfo(BorrowInfo borrowInfo) throws Exception{
		// SQL语句
		String UPDATE_BorrowInfo_SQL = "update borrowInfo set returnTime=?,returnState=? where borrowID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_BorrowInfo_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setDate(0, (java.sql.Date)borrowInfo.getReturnTime());
			pStatement.setString(1, borrowInfo.getReturnState());
			pStatement.setString(2, borrowInfo.getBookID());
			
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
	public BorrowInfo queryBorrowInfo(String borrowID) throws Exception{
		// SQL语句
		String QUERY_BorrowInfo_SQL = "select * from borrowInfo where borrowID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BorrowInfo_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, borrowID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			BorrowInfo borrowInfo = (BorrowInfo)pStatement.executeQuery();		
			pStatement.close();
			
			return borrowInfo;
					
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
