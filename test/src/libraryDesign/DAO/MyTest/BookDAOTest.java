package libraryDesign.DAO.MyTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import libraryDesign.DAO.BookDAO;
import libraryDesign.PO.Book;

public class BookDAOTest {
/*
	@Test
	public void testCreateBook() {
		BookDAO bd = new BookDAO();
		try {
			
			Book book = new Book();
			book.setBookID("101");
			book.setBooktypeID("001");
			book.setClcID1("C");
			book.setClcID2(3);
			book.setFindID("20111");
			book.setBookName("测试书名");
			book.setAuthorName("测试作者名");
			book.setIsbn("测试ISBN编号");
			book.setPrice(12);
			book.setInfo("测试书籍内容简介");
			book.setStocknum(100);
						
			assertTrue(String.valueOf(bd.createBook(book)),true);
			
		}catch(Exception e) {
				e.printStackTrace();
			}
	}
	*/

	
/*
	
	// 库存量加一
	@Test
	public void testAddBook() {
		BookDAO bd = new BookDAO();
		try {
			assertTrue(String.valueOf(bd.addBook("001")),true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	// 库存量减一
	@Test
	public void testRemoveBook() {
		BookDAO bd = new BookDAO();
		try {
			assertTrue(String.valueOf(bd.removeBook("001")),true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void testQueryBook() {
		BookDAO bd = new BookDAO();
		try {
			Book book = bd.queryBook("001");
			assertEquals(book.getBookName(),"共产党宣言");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
/*
	// 该方法需要输出到控制台手动查看
	@Test
	public void testQueryBookByBooktypeID() {
		BookDAO bd = new BookDAO();
		try {
			List<Book> books = bd.queryBookByBooktypeID("001");// 文献类型ID
			for(int i=0;i<books.size();i++) {
				System.out.println(books.get(i).getBookName() + " " + books.get(i).getBooktypeID());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
/*
	@Test
	public void testQueryBookByClcID1() {
		BookDAO bd = new BookDAO();
		try {
			List<Book> books = bd.queryBookByClcID1("A"); // 中图法类型ID1
			for(int i=0;i<books.size();i++) {
				System.out.println(books.get(i).getBookName() + " " + books.get(i).getClcID1());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/*
	@Test
	public void testQueryBookByClcID2() {
		BookDAO bd = new BookDAO();
		try {
			List<Book> books = bd.queryBookByClcID2(3); // 中图法类型ID2
			for(int i=0;i<books.size();i++) {
				System.out.println(books.get(i).getBookName() + " " + books.get(i).getClcID2());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
/*
	// 模糊查询，需要输出到控制台查看
	@Test
	public void testQueryBookByBookName() {
		BookDAO bd = new BookDAO();
		try {
			List<Book> books = bd.queryBookByBookName("测试"); // 书名
			for(int i=0;i<books.size();i++) {
				System.out.println(books.get(i).getBookName());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/*
	// 模糊查询，需要输出到控制台查看
	@Test
	public void testQueryBookByAuthorName() {
		BookDAO bd = new BookDAO();
		try {
			List<Book> books = bd.queryBookByAuthorName("测试"); // 责任者名
			for(int i=0;i<books.size();i++) {
				System.out.println(books.get(i).getBookName() + " " + books.get(i).getAuthorName());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/

	// 模糊查询，需要输出到控制台查看	
	@Test
	public void testQueryBookByInfo() {
		BookDAO bd = new BookDAO();
		try {
			List<Book> books = bd.queryBookByInfo("测试"); // 内容简介
			for(int i=0;i<books.size();i++) {
				System.out.println(books.get(i).getBookName() + " " + books.get(i).getInfo());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	// 需最后一个测试（删除101）
		@Test
		public void testDeleteBook() {
			BookDAO bd = new BookDAO();
			try {
				assertTrue(String.valueOf(bd.deleteBook("101")),true);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		*/
}
