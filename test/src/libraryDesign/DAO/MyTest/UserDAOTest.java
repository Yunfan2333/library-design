package libraryDesign.DAO.MyTest;
import static org.junit.Assert.*;
import org.junit.Test;
import libraryDesign.DAO.*;
import libraryDesign.PO.*;

class UserDAOTest {

	@Test
	void testCreateUser() throws Exception {
		UserloginDAO ud = new UserloginDAO();
		Userlogin u=new Userlogin();
		u.setLoginID("1");
		u.setPassword("123456");
		ud.createUserlogin(u);
		
		Userlogin u2=new Userlogin();
		u2.setLoginID("2");
		u2.setPassword("123456");
		ud.createUserlogin(u2);
	}

	@Test
	void testUpdateUser() throws Exception {
		UserloginDAO ud = new UserloginDAO();
		Userlogin u=new Userlogin();
		u.setLoginID("1");
		u.setPassword("12345678");
		ud.updateUserlogin(u);
	}

	@Test
	void testQueryUser() throws Exception {
		UserloginDAO ud = new UserloginDAO();
		String s="2";
		ud.queryUserlogin(s);
	}
	
	@Test
	void testDeleteUserUser() throws Exception {
		UserloginDAO ud = new UserloginDAO();
		Userlogin u=new Userlogin();
		u.setLoginID("1");
		u.setPassword("123456");
		ud.deleteUser(u);
	}

	@Test
	void testDeleteUserString() throws Exception {
		UserloginDAO ud = new UserloginDAO();
		String s="2";
		ud.deleteUser(s);
	}

}
