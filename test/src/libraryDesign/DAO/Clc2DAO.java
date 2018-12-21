package libraryDesign.DAO;
import libraryDesign.PO.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
public class Clc2DAO extends DAOBase{
	 //涓浘琛�1
	 //澧�
	public void createClc2(Clc2 clc2) throws Exception{
		
		String CREATE_CLC2_SQL = "insert into clc2(clcID1,clcID2,clcname2) values(?,?,?)";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_CLC2_SQL);
			/*
			 * 闇�瑕佸疄鐜扮殑閮ㄥ垎
			 * prepare a statement to insert a record
			 * 鍚戝垰鎵嶅噯澶囩殑妯℃澘SQL璇彞涓彃鍏ュ弬鏁帮紝褰㈡垚瀹屾暣鐨凷QL鍛戒护
			 */	
			pStatement.setString(1, clc2.getClcID1());
			pStatement.setString(2, clc2.getClcID2());
			pStatement.setString(3, clc2.getClcname2());
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
	public Clc2 queryClc2(String clcID1,String clcID2) throws Exception{
		// SQL璇彞
		String QUERY_CLC2_SQL = "select * from clc2 where clcID1=? and clcID2=?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_CLC2_SQL);
			/*
			 * 闇�瑕佸疄鐜扮殑閮ㄥ垎
			 * prepare a statement to insert a record
			 * 鍚戝垰鎵嶅噯澶囩殑妯℃澘SQL璇彞涓彃鍏ュ弬鏁帮紝褰㈡垚瀹屾暣鐨凷QL鍛戒护
			 */	
			pStatement.setString(1, clcID1);
			pStatement.setString(2, clcID2);
			/*
			 * 闇�瑕佸疄鐜扮殑閮ㄥ垎缁撴潫
			 */
			
			/*
			 * 鍥哄畾鍔ㄤ綔
			 * 璋冪敤鏇存柊鏂规硶    executeUpdate()
			 * 鍏抽棴杩炴帴    pStatement.close()
			 */
			Clc2 clc2 = (Clc2)pStatement.executeQuery();		
			pStatement.close();
			return clc2;
					
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
