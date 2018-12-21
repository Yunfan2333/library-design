package libraryDesign.DAO;
import libraryDesign.PO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
public class Clc1DAO extends DAOBase{
	 //娑擃厼娴樼悰锟�1
	 //婢э拷
	public boolean createClc1(Clc1 clc1) throws Exception{
		
		String CREATE_CLC1_SQL = "insert into clc1(clcID1,clcname1) values(?,?)";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_CLC1_SQL);
			/*
			 * 闂囷拷鐟曚礁鐤勯悳鎵畱闁劌鍨�
			 * prepare a statement to insert a record
			 * 閸氭垵鍨伴幍宥呭櫙婢跺洨娈戝Ο鈩冩緲SQL鐠囶厼褰炴稉顓熷絻閸忋儱寮弫甯礉瑜般垺鍨氱�瑰本鏆ｉ惃鍑稱L閸涙垝鎶�
			 */	
			pStatement.setString(1, clc1.getClcID1());
			pStatement.setString(2, clc1.getClcname1());
			/*
			 * 闂囷拷鐟曚礁鐤勯悳鎵畱闁劌鍨庣紒鎾存将
			 */
			
			/*
			 * 閸ュ搫鐣鹃崝銊ょ稊
			 * 鐠嬪啰鏁ら弴瀛樻煀閺傝纭�    executeUpdate()
			 * 閸忔娊妫存潻鐐村复    pStatement.close()
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
	// 閺岋拷
	public Clc1 queryClc1(String clcID1) throws Exception{
		// SQL鐠囶厼褰�
		String QUERY_CLC1_SQL = "select * from clc1 where clcID1=?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_CLC1_SQL);
			/*
			 * 闂囷拷鐟曚礁鐤勯悳鎵畱闁劌鍨�
			 * prepare a statement to insert a record
			 * 閸氭垵鍨伴幍宥呭櫙婢跺洨娈戝Ο鈩冩緲SQL鐠囶厼褰炴稉顓熷絻閸忋儱寮弫甯礉瑜般垺鍨氱�瑰本鏆ｉ惃鍑稱L閸涙垝鎶�
			 */	
			pStatement.setString(1, clcID1);
			/*
			 * 闂囷拷鐟曚礁鐤勯悳鎵畱闁劌鍨庣紒鎾存将
			 */
			
			/*
			 * 閸ュ搫鐣鹃崝銊ょ稊
			 * 鐠嬪啰鏁ら弴瀛樻煀閺傝纭�    executeUpdate()
			 * 閸忔娊妫存潻鐐村复    pStatement.close()
			 */
			//Clc1 clc1 = (Clc1)pStatement.executeQuery();		
			Clc1 c=new Clc1();
			ResultSet rs=pStatement.executeQuery();
			while(rs.next())
			{
				c.setClcID1(rs.getString("clcID1"));
				c.setClcname1(rs.getString("clcname1"));
			}
			
			pStatement.close();
			return c;
					
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
