package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import libraryDesign.PO.Location;

public class LocationDAO extends DAOBase {

	// 增，添加一个位置
	public void createLocation(Location location) throws Exception{
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
	
	// 删，删除一个位置
	
	// 查，根据索书号查询一个位置
	
}
