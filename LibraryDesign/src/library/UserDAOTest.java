package library.DAO.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import library.PO.User;

class UserDAOTest {

	@Test
	void testCreateUser() {
		User u=new User();
		u.setLoginID("1");
		u.setPassword("123456");
		createUser(u);
		
		User u2=new User();
		u2.setLoginID("2");
		u2.setPassword("123456");
		createUser(u2);
	}

	@Test
	void testUpdateUser() {
		User u=new User();
		u.setLoginID("1");
		u.setPassword("12345678");
		queryUser(u);
	}

	@Test
	void testQueryUser() {
		String s="2";
		deleteUser(s);	}
	
	@Test
	void testDeleteUserUser() {
		User u=new User();
		u.setLoginID("1");
		u.setPassword("123456");
		deleteUser(u);
	}

	@Test
	void testDeleteUserString() {
		String s="2";
		deleteUser(s);
	}

}
