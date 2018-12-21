package libraryDesign.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import libraryDesign.PO.*;

public class BorrowInfoDAO extends DAOBase
{
	// 借阅信息
	// 增
	public boolean createBorrowInfo(BorrowInfo borrowInfo) throws Exception{
		// SQL语句
		String CREATE_BorrowInfo_SQL = "insert into borrowInfo(userID,bookID,borrowTime,returnTime,returnState) values(?,?,?,?,?)";

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
			pStatement.setString(1, borrowInfo.getUserID());
			pStatement.setString(2, borrowInfo.getBookID());
			pStatement.setDate(3, (java.sql.Date) borrowInfo.getBorrowTime());
			pStatement.setDate(4,(java.sql.Date) borrowInfo.getReturnTime());
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
	
	// 删
	// 根据borrowID删除借阅信息
	public boolean deleteBorrowInfo(BorrowInfo borrowInfo) throws Exception{
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
			pStatement.setInt(1, borrowInfo.getBorrowID());
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
	public boolean updateBorrowInfo(BorrowInfo borrowInfo) throws Exception{
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
			pStatement.setDate(1, (java.sql.Date)borrowInfo.getReturnTime());
			pStatement.setString(2, borrowInfo.getReturnState());
			pStatement.setInt(3, borrowInfo.getBorrowID());
			
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

	// 查
	public BorrowInfo queryBorrowInfo(Integer borrowID) throws Exception{
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
			pStatement.setInt(1, borrowID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			
			ArrayList borrowArray=new ArrayList<BorrowInfo>();
			ResultSet rs=pStatement.executeQuery();	
			while(rs.next()){
				BorrowInfo bi=new BorrowInfo();
				bi.setBorrowID(rs.getInt("borrowID"));
				bi.setBookID(rs.getString("bookID"));
				bi.setBorrowTime(rs.getDate("borrowTime"));
				bi.setReturnTime(rs.getDate("returnTime"));
				bi.setUserID(rs.getString("userID"));
				bi.setReturnState(rs.getString("returnState"));
				borrowArray.add(bi);
			}
			BorrowInfo borrowInfo=(BorrowInfo) borrowArray.get(0);
			pStatement.close();
			
			return borrowInfo;
					
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
