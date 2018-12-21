package libraryDesign.DAO.MyTest;
import static org.junit.Assert.*;
import org.junit.Test;
import libraryDesign.DAO.*;
import libraryDesign.PO.*;


public class UserloginDAOTest {
	
	@Test
	public void testCreateUserlogin() {
		UserloginDAO ud = new UserloginDAO();
		try{
			Userlogin u=new Userlogin();
			u.setLoginID("S5");
			u.setPassword("12345678");
			assertTrue(String.valueOf(ud.createUserlogin(u)),true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testUpdateUser() {
		UserloginDAO ud = new UserloginDAO();
		try{
			Userlogin u=new Userlogin();
			u.setLoginID("S4");
			u.setPassword("123");
			assertTrue(String.valueOf(ud.updateUserlogin(u)),true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testQueryUserlogin() {
		UserloginDAO ud = new UserloginDAO();
		try{
			Userlogin ul=ud.queryUserlogin("S4");
			assertEquals(ul.getPassword(),"123");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	@Test
	public void testDeleteUserUser() {
		UserloginDAO ud = new UserloginDAO();
		try{
			Userlogin u=new Userlogin();
			u.setLoginID("S4");
			u.setPassword("12345678");
			String temp=String.valueOf(ud.deleteUser(u));
			assertTrue(temp,true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testDeleteUserString() {
		UserloginDAO ud = new UserloginDAO();
		try{
			Userlogin u=new Userlogin();
			String temp=String.valueOf(ud.deleteUser("S4"));
			assertTrue(temp,true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
