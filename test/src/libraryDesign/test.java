package libraryDesign;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static void main(String[] args) {
try{
			
			Connection conn=c3p0JdbcUtil.getConnection();
			Statement stmt=conn.createStatement();
			String sql="select * from book";
			ResultSet resSet=stmt.executeQuery(sql);
			while(resSet.next()){
				String sna=resSet.getString("bookName");
				System.out.println(sna);
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}

	

}
