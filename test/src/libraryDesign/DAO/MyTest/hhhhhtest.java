package libraryDesign.DAO.MyTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import libraryDesign.c3p0JdbcUtil;
import libraryDesign.DAO.DAOBase;
import libraryDesign.DAO.DAOException;
import libraryDesign.PO.Book;

public class hhhhhtest {

	public static void main(String[] args) {
		try {
			Connection conn = c3p0JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from book");
			List<Book> books=(List<Book>)ps.executeQuery();
			for(int i=0;i<books.size();i++){
				System.out.println(books.get(i).getBookName());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
