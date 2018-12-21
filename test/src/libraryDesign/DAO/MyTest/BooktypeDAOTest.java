package libraryDesign.DAO.MyTest;
import static org.junit.Assert.*;
import org.junit.Test;
import libraryDesign.DAO.*;
import libraryDesign.PO.*;

import org.junit.Test;

public class BooktypeDAOTest {
/*
	// 需第一个测试
	@Test
	public void testCreateBooktype() {
		
		BooktypeDAO bd = new BooktypeDAO();
		try {
			
			Booktype bt = new Booktype();
			bt.setBooktypeID("1001");
			bt.setBooktypeName("测试文献类名");
			bt.setBooktypeInfo("测试书籍类型信息");
			
			assertTrue(String.valueOf(bd.createBooktype(bt)),true);
			
		}catch(Exception e) {
			e.printStackTrace();
		}


	}
	*/

	// 需第三个测试
	@Test
	public void testDeleteBooktype() {
		BooktypeDAO bd = new BooktypeDAO();
		try {
			
			assertTrue((String.valueOf(bd.deleteBooktype("1001"))),true);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	// 需第二个测试
	@Test
	public void testQueryBooktype() {
		BooktypeDAO bd = new BooktypeDAO();
		try {
			
			Booktype bt = bd.queryBooktype("1001");
			
			assertEquals(bt.getBooktypeName(),"测试文献类名");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	*/

}
