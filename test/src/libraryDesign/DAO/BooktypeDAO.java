package libraryDesign.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import libraryDesign.DAO.DAOBase;
import libraryDesign.PO.Booktype;

public class BooktypeDAO extends DAOBase {
	
	// 增加一个文献类型
	public boolean createBooktype(Booktype booktype) throws Exception{
		
		String CREATE_BOOKTYPE_SQL = "insert into booktype(booktypeID,booktypeName,booktypeInfo) values(?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_BOOKTYPE_SQL);
			
			pStatement.setString(1, booktype.getBooktypeID());
			pStatement.setString(2, booktype.getBooktypeName());
			pStatement.setString(3, booktype.getBooktypeInfo());
			
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
	
	// 根据文献类型ID删除一个文献类型
	public boolean deleteBooktype(String booktypeID) throws Exception{
		
		String DELETE_BOOKTYPE_SQL = "delete from booktype where booktypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BOOKTYPE_SQL);
			
			pStatement.setString(1, booktypeID);

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
	
	
	// 根据文献类型ID查询一个文献类型并返回
	public Booktype queryBooktype(String booktypeID) throws Exception{
		
		String QUERY_BOOKTYPE_SQL = "select * from booktype where booktypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKTYPE_SQL);
			
			pStatement.setString(1, booktypeID);

			
			//Booktype booktype = (Booktype) pStatement.executeQuery();
			Booktype b =new Booktype();
			ResultSet rs=pStatement.executeQuery();
			while(rs.next())
			{
				b.setBooktypeID(rs.getString("booktypeID"));
				b.setBooktypeInfo(rs.getString("booktypeInfo"));
				b.setBooktypeName(rs.getString("booktypeName"));
			}

			pStatement.close();
			
			return b;
					
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
