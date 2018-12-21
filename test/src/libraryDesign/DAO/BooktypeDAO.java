package libraryDesign.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import libraryDesign.DAO.DAOBase;
import libraryDesign.DAO.DAOException;
import libraryDesign.PO.Booktype;

public class BooktypeDAO extends DAOBase {
	
	// 增，增加一个文献类型
	public void createBooktype(Booktype booktype) throws Exception{
		// SQL语句
		String CREATE_BOOKTYPE_SQL = "insert into booktye(booktypeID,booktypeName,booktypeInfo) values(?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_BOOKTYPE_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, booktype.getBooktypeID());
			pStatement.setString(2, booktype.getBooktypeName());
			pStatement.setString(3, booktype.getBooktypeInfo());
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
	public void deleteBooktype(String booktypeID) throws Exception{
		// SQL语句
		String DELETE_BOOKTYPE_SQL = "delete from booktype where booktypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BOOKTYPE_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, booktypeID);

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
	public Booktype queryBooktype(String booktypeID) throws Exception{
		// SQL语句
		String QUERY_BOOKTYPE_SQL = "select * from booktype where booktypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKTYPE_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, booktypeID);

			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			Booktype booktype = (Booktype) pStatement.executeQuery();
			pStatement.close();
			
			return booktype;
					
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
