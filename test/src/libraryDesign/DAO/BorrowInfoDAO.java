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
	// 添加一个BorrowInfo借阅信息
	public boolean createBorrowInfo(BorrowInfo borrowInfo) throws Exception{
	
		String CREATE_BorrowInfo_SQL = "insert into borrowInfo(userID,bookID,borrowTime,returnTime,returnState) values(?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_BorrowInfo_SQL);
			
			pStatement.setString(1, borrowInfo.getUserID());
			pStatement.setString(2, borrowInfo.getBookID());
			pStatement.setDate(3, (java.sql.Date) borrowInfo.getBorrowTime());
			pStatement.setDate(4,(java.sql.Date) borrowInfo.getReturnTime());
			pStatement.setString(5, borrowInfo.getReturnState());
			
			
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
	
	
	// 根据borrowID删除借阅信息
	public boolean deleteBorrowInfo(int borrowID) throws Exception{
		
		String DELETE_BorrowInfo_SQL = "delete from borrowInfo where borrowID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
		
			
			pStatement = connection.prepareStatement(DELETE_BorrowInfo_SQL);
			
			pStatement.setInt(1, borrowID);
			
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
		
	// 根据borrowID更新借阅信息
	public boolean updateBorrowInfo(BorrowInfo borrowInfo) throws Exception{
		
		String UPDATE_BorrowInfo_SQL = "update borrowInfo set returnTime=?,returnState=? where borrowID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_BorrowInfo_SQL);
			
			pStatement.setDate(1, (java.sql.Date)borrowInfo.getReturnTime());
			pStatement.setString(2, borrowInfo.getReturnState());
			pStatement.setInt(3, borrowInfo.getBorrowID());
			
			
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

	// 根据borrowID查询一条借阅记录并且返回一条借阅信息
	public BorrowInfo queryBorrowInfo(Integer borrowID) throws Exception{
		
		String QUERY_BorrowInfo_SQL = "select * from borrowInfo where borrowID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BorrowInfo_SQL);

			
			pStatement.setInt(1, borrowID);
			
			
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
