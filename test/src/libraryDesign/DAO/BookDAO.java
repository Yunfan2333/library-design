package libraryDesign.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryDesign.PO.*;

public class BookDAO extends DAOBase {
	
	// 添加一类新的书籍，需要先建好文献类型表和中图法表一表二
	public boolean createBook(Book book) throws Exception{
		String CREATE_BOOK_SQL = "insert into book(bookID,booktypeID,clcID1,clcID2,findID,bookName,authorName,isbn,price,info,stocknum) values(?,?,?,?,?,?,?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_BOOK_SQL);
			pStatement.setString(1, book.getBookID());
			pStatement.setString(2, book.getBooktypeID());
			pStatement.setString(3, book.getClcID1());
			pStatement.setInt(4, book.getClcID2());
			pStatement.setString(5, book.getFindID());
			pStatement.setString(6, book.getBookName());
			pStatement.setString(7, book.getAuthorName());
			pStatement.setString(8, book.getIsbn());
			pStatement.setFloat(9, book.getPrice());
			pStatement.setString(10, book.getInfo());
			pStatement.setInt(11, book.getStocknum());
			
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
	
	
	// 根据bookID删除book表中的一类书
	public boolean deleteBook(String bookID) throws Exception{
		String DELETE_BOOK_SQL = "delete from book where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BOOK_SQL);
			pStatement.setString(1, bookID);
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
	
	// 根据bookID更新库存量，库存量加一（适用于还书时）
	public boolean addBook(String bookID) throws Exception{
		// SQL���
		String ADD_BOOK_SQL = "update book set stocknum=? where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();	 
			Integer stocknum = queryBook(bookID).getStocknum() + 1;
			
			pStatement = connection.prepareStatement(ADD_BOOK_SQL);
			
			pStatement.setInt(1, stocknum);
			pStatement.setString(2, bookID);
			
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
	
	//根据bookID，更新库存量，库存量减一（适用于借书时）
	public boolean removeBook(String bookID) throws Exception{
		
		String REMOVE_BOOK_SQL = "update book set stocknum=? where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
				 
			Integer stocknum = queryBook(bookID).getStocknum() - 1;
			
			pStatement = connection.prepareStatement(REMOVE_BOOK_SQL);
			
			pStatement.setInt(1, stocknum);
			pStatement.setString(2, bookID);
			
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
		
	
	// 根据条码号查询某一类书，并返回Book book
	public Book queryBook(String bookID) throws Exception{
		
		String QUERY_BOOK_SQL = "select * from book where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOK_SQL);
			
			pStatement.setString(1, bookID);
			
			ResultSet rs=pStatement.executeQuery();	
			
			Book book = new Book();
			while(rs.next()) {
				// To do
				book.setBookID(rs.getString("bookID"));
				book.setBooktypeID(rs.getString("booktypeID"));
				book.setClcID1(rs.getString("clcID1"));
				book.setClcID2(rs.getInt("clcID2"));
				book.setFindID(rs.getString("findID"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getFloat("price"));
				book.setInfo(rs.getString("info"));
				book.setStocknum(rs.getInt("stocknum"));				
			}			
			
			pStatement.close();
			
			return book;
			
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
	
	
	// 根据文献类型查找多种书，并返回List<Book>类型的books
	public List<Book> queryBookByBooktypeID(String booktypeID) throws Exception{
		
		String QUERY_BOOKBYBOOKTYPEID_SQL = "select * from book where booktypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYBOOKTYPEID_SQL);
			
			pStatement.setString(1, booktypeID);
			
			ResultSet rs = pStatement.executeQuery();	
			ArrayList<Book> books = new ArrayList<Book>(); 

			while(rs.next()) {
				// To do
				Book book = new Book();
				book.setBookID(rs.getString("bookID"));
				book.setBooktypeID(rs.getString("booktypeID"));
				book.setClcID1(rs.getString("clcID1"));
				book.setClcID2(rs.getInt("clcID2"));
				book.setFindID(rs.getString("findID"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getFloat("price"));
				book.setInfo(rs.getString("info"));
				book.setStocknum(rs.getInt("stocknum"));
				
				books.add(book);
			}
			
			pStatement.close();
			
			return books;
			
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
	
	
	// 根据中图法1查找多种书，并返回List<Book>类型的books
	public List<Book> queryBookByClcID1(String clcID1) throws Exception{
		
		String QUERY_BOOKBYCLCID1_SQL = "select * from book where clcID1=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYCLCID1_SQL);
			
			pStatement.setString(1, clcID1);
			
			ArrayList<Book> books = new ArrayList<Book>(); 
			
			ResultSet rs = pStatement.executeQuery();	
			
			while(rs.next()) {
				// To do
				Book book = new Book();
				book.setBookID(rs.getString("bookID"));
				book.setBooktypeID(rs.getString("booktypeID"));
				book.setClcID1(rs.getString("clcID1"));
				book.setClcID2(rs.getInt("clcID2"));
				book.setFindID(rs.getString("findID"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getFloat("price"));
				book.setInfo(rs.getString("info"));
				book.setStocknum(rs.getInt("stocknum"));
				
				books.add(book);
			}
			pStatement.close();
			
			return books;
			
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
	
	
	// 根据中图法2查找多种书，并返回List<Book>类型的books
	public List<Book> queryBookByClcID2(int i) throws Exception{
		
		String QUERY_BOOKBYCLCID2_SQL = "select * from book where clcID2=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYCLCID2_SQL);
			
			pStatement.setInt(1, i);
			
			ArrayList<Book> books = new ArrayList<Book>(); 
			ResultSet rs = pStatement.executeQuery();	
			
			while(rs.next()) {
				// To do
				Book book = new Book();
				book.setBookID(rs.getString("bookID"));
				book.setBooktypeID(rs.getString("booktypeID"));
				book.setClcID1(rs.getString("clcID1"));
				book.setClcID2(rs.getInt("clcID2"));
				book.setFindID(rs.getString("findID"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getFloat("price"));
				book.setInfo(rs.getString("info"));
				book.setStocknum(rs.getInt("stocknum"));
				
				books.add(book);
			}			
			
			pStatement.close();
			
			return books;
			
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
	
	
	// 根据题名进行模糊查询，并返回符合条件的List<Book>类型的books
	public List<Book> queryBookByBookName(String bookName) throws Exception{
		
		String QUERY_BOOKBYBOOKNAME_SQL = "select * from book where bookName like ?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYBOOKNAME_SQL);
			
			pStatement.setString(1, "%"+bookName+"%");
			
			List<Book> books = new ArrayList<Book>();
			ResultSet rs = pStatement.executeQuery();	
			
			while(rs.next()) {
				// To do
				Book book = new Book();
				book.setBookID(rs.getString("bookID"));
				book.setBooktypeID(rs.getString("booktypeID"));
				book.setClcID1(rs.getString("clcID1"));
				book.setClcID2(rs.getInt("clcID2"));
				book.setFindID(rs.getString("findID"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getFloat("price"));
				book.setInfo(rs.getString("info"));
				book.setStocknum(rs.getInt("stocknum"));
				
				books.add(book);
			}			
			
			pStatement.close();
			
			return books;
			
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
	
	
	// 根据责任者进行模糊查询，并返回符合条件的List<Book>类型的books
	public List<Book> queryBookByAuthorName(String authorName) throws Exception{
		
		String QUERY_BOOKBYAUTHORNAME_SQL = "select * from book where authorName like ?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYAUTHORNAME_SQL);
			
			pStatement.setString(1, "%" + authorName + "%");
			
			List<Book> books = new ArrayList<Book>();
			ResultSet rs = pStatement.executeQuery();	
			
			while(rs.next()) {
				// To do
				Book book = new Book();
				book.setBookID(rs.getString("bookID"));
				book.setBooktypeID(rs.getString("booktypeID"));
				book.setClcID1(rs.getString("clcID1"));
				book.setClcID2(rs.getInt("clcID2"));
				book.setFindID(rs.getString("findID"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getFloat("price"));
				book.setInfo(rs.getString("info"));
				book.setStocknum(rs.getInt("stocknum"));
				
				books.add(book);
			}	
			pStatement.close();
			
			return books;
			
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
	
	
	// 根据内容简介进行模糊查询，并返回符合条件的List<Book>类型的books
	public List<Book> queryBookByInfo(String info) throws Exception{
		
		String QUERY_BOOKBYINFO_SQL = "select * from book where info like ?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYINFO_SQL);
				
			pStatement.setString(1, "%" + info + "%");
			
			List<Book> books = new ArrayList<Book>();
			ResultSet rs = pStatement.executeQuery();	
			
			while(rs.next()) {
				// To do
				Book book = new Book();
				book.setBookID(rs.getString("bookID"));
				book.setBooktypeID(rs.getString("booktypeID"));
				book.setClcID1(rs.getString("clcID1"));
				book.setClcID2(rs.getInt("clcID2"));
				book.setFindID(rs.getString("findID"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthorName(rs.getString("authorName"));
				book.setIsbn(rs.getString("isbn"));
				book.setPrice(rs.getFloat("price"));
				book.setInfo(rs.getString("info"));
				book.setStocknum(rs.getInt("stocknum"));
				
				books.add(book);
			}	
			pStatement.close();
			
			return books;
			
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
