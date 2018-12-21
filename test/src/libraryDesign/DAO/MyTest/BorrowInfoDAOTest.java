package libraryDesign.DAO.MyTest;


import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import libraryDesign.DAO.BorrowInfoDAO;
import libraryDesign.PO.BorrowInfo;

public class BorrowInfoDAOTest {

	@Test
	public void testCreateBorrowInfo() {
		
		BorrowInfoDAO bd=new BorrowInfoDAO();
		try{
		
		BorrowInfo b=new BorrowInfo();
		b.setBookID("001");
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		b.setBorrowTime(sqlDate);
		
		
		b.setReturnState("未归还");
		
		b.setUserID("161001001");
		
		bd.createBorrowInfo(b);
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	@Test
	public void testUpdateBorrowInfo() {
		BorrowInfoDAO bd=new BorrowInfoDAO();
		try{
		BorrowInfo b=new BorrowInfo();
		
		
		b.setReturnState("已归还");
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		b.setReturnTime(sqlDate);
		
		b.setBorrowID(7);
		
		bd.updateBorrowInfo(b);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	@Test
	public void testQueryBorrowInfo() {
		BorrowInfoDAO bd=new BorrowInfoDAO();
		try{
		int s=6;
		BorrowInfo bi=bd.queryBorrowInfo(s);
//		System.out.println(bi.getBookID());
		
		assertEquals("001",bi.getBookID());
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	@Test
	public void testDeleteBorrowInfo() {
		BorrowInfoDAO bd=new BorrowInfoDAO();
		try{
			assertTrue(String.valueOf(bd.deleteBorrowInfo(7)),true);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
}
