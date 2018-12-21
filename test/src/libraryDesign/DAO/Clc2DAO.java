package libraryDesign.DAO;
import libraryDesign.PO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
public class Clc2DAO extends DAOBase{
	 //娑擃厼娴樼悰锟�1
	 //婢э拷
	public boolean createClc2(Clc2 clc2) throws Exception{
		
		String CREATE_CLC2_SQL = "insert into clc2(clcID1,clcID2,clcname2) values(?,?,?)";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_CLC2_SQL);
			/*
			 * 闂囷拷鐟曚礁鐤勯悳鎵畱闁劌鍨�
			 * prepare a statement to insert a record
			 * 閸氭垵鍨伴幍宥呭櫙婢跺洨娈戝Ο鈩冩緲SQL鐠囶厼褰炴稉顓熷絻閸忋儱寮弫甯礉瑜般垺鍨氱�瑰本鏆ｉ惃鍑稱L閸涙垝鎶�
			 */	
			pStatement.setString(1, clc2.getClcID1());
			pStatement.setInt(2, clc2.getClcID2());
			pStatement.setString(3, clc2.getClcname2());
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
	public Clc2 queryClc2(String clcID1,int clcID2) throws Exception{
		// SQL鐠囶厼褰�
		String QUERY_CLC2_SQL = "select * from clc2 where clcID1=? and clcID2=?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_CLC2_SQL);
			/*
			 * 闂囷拷鐟曚礁鐤勯悳鎵畱闁劌鍨�
			 * prepare a statement to insert a record
			 * 閸氭垵鍨伴幍宥呭櫙婢跺洨娈戝Ο鈩冩緲SQL鐠囶厼褰炴稉顓熷絻閸忋儱寮弫甯礉瑜般垺鍨氱�瑰本鏆ｉ惃鍑稱L閸涙垝鎶�
			 */	
			pStatement.setString(1, clcID1);
			pStatement.setInt(2, clcID2);
			/*
			 * 闂囷拷鐟曚礁鐤勯悳鎵畱闁劌鍨庣紒鎾存将
			 */
			
			/*
			 * 閸ュ搫鐣鹃崝銊ょ稊
			 * 鐠嬪啰鏁ら弴瀛樻煀閺傝纭�    executeUpdate()
			 * 閸忔娊妫存潻鐐村复    pStatement.close()
			 */
			//Clc2 clc2 = (Clc2)pStatement.executeQuery();		
			
			Clc2 c=new Clc2();
			ResultSet rs=pStatement.executeQuery();
			while(rs.next())
			{
				c.setClcID1(rs.getString("clcID1"));
				c.setClcID2(rs.getInt("clcID2"));
				c.setClcname2(rs.getString("clcname2"));
				
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
