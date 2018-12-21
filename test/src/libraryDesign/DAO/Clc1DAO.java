package libraryDesign.DAO;
import libraryDesign.PO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
public class Clc1DAO extends DAOBase{
	 //涓浘琛�1
	 //澧�
	public void createClc1(Clc1 clc1) throws Exception{
		
		String CREATE_CLC1_SQL = "insert into clc1(clcID1,clcname1) values(?,?)";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_CLC1_SQL);
			/*
			 * 闇�瑕佸疄鐜扮殑閮ㄥ垎
			 * prepare a statement to insert a record
			 * 鍚戝垰鎵嶅噯澶囩殑妯℃澘SQL璇彞涓彃鍏ュ弬鏁帮紝褰㈡垚瀹屾暣鐨凷QL鍛戒护
			 */	
			pStatement.setString(1, clc1.getClcID1());
			pStatement.setString(2, clc1.getClcname1());
			/*
			 * 闇�瑕佸疄鐜扮殑閮ㄥ垎缁撴潫
			 */
			
			/*
			 * 鍥哄畾鍔ㄤ綔
			 * 璋冪敤鏇存柊鏂规硶    executeUpdate()
			 * 鍏抽棴杩炴帴    pStatement.close()
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
	// 鏌�
	public Clc1 queryClc1(String clcID1) throws Exception{
		// SQL璇彞
		String QUERY_CLC1_SQL = "select * from clc1 where clcID1=?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_CLC1_SQL);
			/*
			 * 闇�瑕佸疄鐜扮殑閮ㄥ垎
			 * prepare a statement to insert a record
			 * 鍚戝垰鎵嶅噯澶囩殑妯℃澘SQL璇彞涓彃鍏ュ弬鏁帮紝褰㈡垚瀹屾暣鐨凷QL鍛戒护
			 */	
			pStatement.setString(1, clcID1);
			/*
			 * 闇�瑕佸疄鐜扮殑閮ㄥ垎缁撴潫
			 */
			
			/*
			 * 鍥哄畾鍔ㄤ綔
			 * 璋冪敤鏇存柊鏂规硶    executeUpdate()
			 * 鍏抽棴杩炴帴    pStatement.close()
			 */
			Clc1 clc1 = (Clc1)pStatement.executeQuery();		
			pStatement.close();
			return clc1;
					
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
