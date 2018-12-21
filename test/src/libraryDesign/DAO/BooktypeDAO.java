package libraryDesign.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import libraryDesign.DAO.DAOBase;
import libraryDesign.PO.Booktype;

public class BooktypeDAO extends DAOBase {
	
	// ��������һ����������
	public boolean createBooktype(Booktype booktype) throws Exception{
		// SQL���
		String CREATE_BOOKTYPE_SQL = "insert into booktype(booktypeID,booktypeName,booktypeInfo) values(?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_BOOKTYPE_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, booktype.getBooktypeID());
			pStatement.setString(2, booktype.getBooktypeName());
			pStatement.setString(3, booktype.getBooktypeInfo());
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
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
	
	// ɾ
	public boolean deleteBooktype(String booktypeID) throws Exception{
		// SQL���
		String DELETE_BOOKTYPE_SQL = "delete from booktype where booktypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BOOKTYPE_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, booktypeID);

			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
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
	
	
	// ��
	public Booktype queryBooktype(String booktypeID) throws Exception{
		// SQL���
		String QUERY_BOOKTYPE_SQL = "select * from booktype where booktypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKTYPE_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, booktypeID);

			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
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
