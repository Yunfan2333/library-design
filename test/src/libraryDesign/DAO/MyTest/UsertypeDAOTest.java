package libraryDesign.DAO.MyTest;
import static org.junit.Assert.*;
import org.junit.Test;
import libraryDesign.DAO.*;
import libraryDesign.PO.*;

public class UsertypeDAOTest {
	
	@Test
	public void testCreateUsertype() {
		UsertypeDAO ud = new UsertypeDAO();
		try{
			Usertype u=new Usertype();
			u.setUsertypeID("1");
			u.setUsertype("本科生");
			u.setMaxorder(20);
			u.setMaxentrust(5);
			u.setMaxbooknum(10);
			assertTrue(String.valueOf(ud.createUsertype(u)),true);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	

	@Test
	public void testQueryUsertype() {
		UsertypeDAO ud = new UsertypeDAO();
		try{
			Usertype u=new Usertype();
			assertEquals(ud.queryUsertype("Type1").getUsertype(),"本科生");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
