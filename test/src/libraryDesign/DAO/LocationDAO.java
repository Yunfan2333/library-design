package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import libraryDesign.DAO.DAOBase;
import libraryDesign.PO.*;

public class LocationDAO extends DAOBase {

	// 增，添加一个位置
	public boolean createLocation(Location location) throws Exception{
		// SQL语句
		String CREATE_LOCATION_SQL = "insert into location(findID,room,shelf,level) values(?,?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_LOCATION_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, location.getFindID());
			pStatement.setString(2, location.getRoom());
			pStatement.setInt(3, location.getShelf());
			pStatement.setInt(4, location.getLevel());
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
	
	// 删，删除一个位置
	public boolean deleteLocation(String findID) throws Exception{
		// SQL语句
		String DELETE_LOCATION_SQL = "delete from location where findID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_LOCATION_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, findID);
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
	
	
	// 查，根据索书号查询一个位置，并返回
	public Location queryLocation(String findID) throws Exception{
		// SQL语句
		String QUERY_LOCATION_SQL = "select * from location where findID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_LOCATION_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, findID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			//Location location = (Location) pStatement.executeQuery();
			Location l=new Location();
			ResultSet rs=pStatement.executeQuery();
			while(rs.next())
			{
				l.setFindID(rs.getString("findID"));
				l.setLevel(rs.getInt("level"));
				l.setRoom(rs.getString("room"));
				l.setShelf(rs.getInt("shelf"));
			}
			pStatement.close();
			
			return l;
			
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
