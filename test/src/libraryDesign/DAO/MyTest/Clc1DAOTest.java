package libraryDesign.DAO.MyTest;

import static org.junit.Assert.*;
import libraryDesign.DAO.Clc1DAO;
import libraryDesign.PO.Clc1;

import org.junit.Test;

public class Clc1DAOTest {
	/*
	@Test
	public void testCreateClc1() {
		Clc1DAO clc1 = new Clc1DAO();
		try{
			Clc1 clc = new Clc1();
			clc.setClcID1("G");
			clc.setClcname1("历史");
			assertTrue(String.valueOf(clc1.createClc1(clc)),true);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	*/

	@Test
	public void testQueryClc1() {
		Clc1DAO clc1 = new Clc1DAO();
		try{
			Clc1 clc = new Clc1();
			assertEquals(clc1.queryClc1("G").getClcname1(),"历史");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
