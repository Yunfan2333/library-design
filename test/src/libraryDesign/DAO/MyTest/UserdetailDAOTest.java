package libraryDesign.DAO.MyTest;
import static org.junit.Assert.*;
import org.junit.Test;
import libraryDesign.DAO.*;
import libraryDesign.PO.*;

public class UserdetailDAOTest {
	
	@Test
	public void testCreateUserdetail() {
		UserdetailDAO ud=new UserdetailDAO();
		
		try {
			Userdetail u=new Userdetail();
			u.setCollege("马克思主义学院");
			u.setDocID("161005005");
			u.setLoginID("S4");
			u.setMail("1842281812@qq.com");
			u.setProfession("共产党学");
			u.setSex("男");
			u.setUserID("161005005");
			u.setUserName("测试");
			assertTrue(String.valueOf(ud.createUserdetail(u)),true);
			}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}
	
	
	@Test
	public void testUpdateUserdetail() {
		UserdetailDAO ud=new UserdetailDAO();

		try {
			Userdetail u=new Userdetail();
			u.setCollege("马克思主义学院");
			u.setDocID("161005005");
			u.setLoginID("S4");
			u.setMail("1842281812@qq.com");
			u.setProfession("共产党学");
			u.setSex("男");
			u.setUserID("161005005");
			u.setUserName("更新测试");
			assertTrue(String.valueOf(ud.updateUserdetail(u)),true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testQueryUserdetail() {
		UserdetailDAO ud=new UserdetailDAO();
		try {
			String s="161001001";
			assertEquals(ud.queryUserdetail(s).getUserName(),"张三");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}
	
	
	/*
	@Test
	public void testDeleteUserdetailUserdetail() {
		UserdetailDAO ud=new UserdetailDAO();
		
		try {
			Userdetail u=new Userdetail();
			u.setCollege("马克思主义学院");
			u.setDocID("161005005");
			u.setLoginID("S4");
			u.setMail("1842281812@qq.com");
			u.setProfession("共产党学");
			u.setSex("男");
			u.setUserID("161005005");
			u.setUserName("更新测试");
			assertTrue(String.valueOf(ud.deleteUserdetail(u)),true);
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	*/
	
	@Test
	public void testDeleteUserdetailString() {
		UserdetailDAO ud=new UserdetailDAO();

		try {
			String s="S4";
			assertTrue(String.valueOf(ud.deleteUserdetail(s)),true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}


}
