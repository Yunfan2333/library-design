package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import libraryDesign.DAO.DAOBase;
import libraryDesign.PO.*;

public class LocationDAO extends DAOBase {

	//添加新的位置信息
	public boolean createLocation(Location location) throws Exception{
	
		String CREATE_LOCATION_SQL = "insert into location(findID,room,shelf,level) values(?,?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_LOCATION_SQL);
			
			pStatement.setString(1, location.getFindID());
			pStatement.setString(2, location.getRoom());
			pStatement.setInt(3, location.getShelf());
			pStatement.setInt(4, location.getLevel());
			
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
	
	//根据findID，索书号，删除一个位置信息
	public boolean deleteLocation(String findID) throws Exception{
		
		String DELETE_LOCATION_SQL = "delete from location where findID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_LOCATION_SQL);
			
			pStatement.setString(1, findID);
			
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
	
	
	//根据findID，索书号，查询一个位置并返回该位置信息
	public Location queryLocation(String findID) throws Exception{
		
		String QUERY_LOCATION_SQL = "select * from location where findID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_LOCATION_SQL);
			
			pStatement.setString(1, findID);
			
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
