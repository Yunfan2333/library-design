package library.DAO.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import library.PO.Userdetail;
import library.PO.Usertype;

class UserdetailDAOTest {

	@Test
	void testCreateUserdetail() {
		Userdetail u=new Userdetail();
		u.setCollege("北林");
		u.setDocID("00");;
		u.setLoginID("1");
		u.setMail("1842281812@qq.com");
		u.setProfession("本科生");
		u.setSex("男");
		u.setUserID("1");
		u.setUserName("张三");
		createUserdetail(u);
		
		Userdetail u2=new Userdetail();
		u2.setCollege("北林");
		u2.setDocID("01");;
		u2.setLoginID("2");
		u2.setMail("1842281812@qq.com");
		u2.setProfession("本科生");
		u2.setSex("男");
		u2.setUserID("2");
		u2.setUserName("张四");
		createUserdetail(u2);

		}

	@Test
	void testUpdateUserdetail() {
		Userdetail u=new Userdetail();
		u.setCollege("北京林业大学");
		u.setDocID("00");;
		u.setLoginID("1");
		u.setMail("1842281812@qq.com");
		u.setProfession("本科生");
		u.setSex("男");
		u.setUserID("1");
		u.setUserName("张三");
		updateUserdetail(u);
	}

	@Test
	void testQueryUserdetail() {
		String s="2"
		queryUserdetail(s);
	}
	

	@Test
	void testDeleteUserdetailUserdetail() {
		Userdetail u=new Userdetail();
		u.setCollege("北林");
		u.setDocID("00");
		u.setLoginID("1");
		u.setMail("1842281812@qq.com");
		u.setProfession("本科生");
		u.setSex("男");
		u.setUserID("1");
		u.setUserName("张三");
		deleteUserdetail(u);
	}

	@Test
	void testDeleteUserdetailString() {
		String s="1";
		deleteUserdetail(s);
	}


}
