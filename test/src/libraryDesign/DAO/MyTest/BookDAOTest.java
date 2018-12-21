package libraryDesign.DAO.MyTest;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import libraryDesign.DAO.BookDAO;
import libraryDesign.PO.Book;

import org.junit.Test;

public class BookDAOTest {

	@Test
	public void testQueryBook() {
		BookDAO bd = new BookDAO();
		try{
			ResultSet rs=bd.queryBook("001");
			while(rs.next()){
			System.out.println(rs.getString("bookName"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testCreateBook() {
		BookDAO bd = new BookDAO();
		try{
			ResultSet rs=bd.queryBook("001");
			while(rs.next()){
			System.out.println(rs.getString("bookName"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
