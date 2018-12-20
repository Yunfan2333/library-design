package com.itcast.junit4.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import library.PO.BorrowInfo;

public class BorrowInfoDAOTest {

	@Test
	public void testCreateBorrowInfo() {
		BorrowInfo b=new BorrowInfo();
		b.setBookID("10001");
		b.setBorrowID("20001");
		
		Date date1=new Date();
		b.setBorrowTime(date1);
		
		b.setReturnState("未归还");
		
		Date date2=new Date();
		b.setReturnTime(date2);
		
		b.setUserID("00001");
		createBorrowInfo(b);
	}

	
	@Test
	public void testUpdateBorrowInfo() {
		BorrowInfo b=new BorrowInfo();
		b.setBookID("10001");
		b.setBorrowID("20001");
		
		Date date1=new Date();
		b.setBorrowTime(date1);
		
		b.setReturnState("已归还");
		
		Date date2=new Date();
		b.setReturnTime(date2);
		
		b.setUserID("00001");
		
		updateBorrowInfo(b);
	}

	@Test
	public void testQueryBorrowInfo() {
		String s="20001";
		queryBorrowInfo(s);
	}
	
	@Test
	public void testDeleteBorrowInfo() {
		BorrowInfo b=new BorrowInfo();
		b.setBookID("10001");
		b.setBorrowID("20001");
		
		Date date1=new Date();
		b.setBorrowTime(date1);
		
		b.setReturnState("已归还");
		
		Date date2=new Date();
		b.setReturnTime(date2);
		
		b.setUserID("00001");
		
		deleteBorrowInfo(b);
	}
}
