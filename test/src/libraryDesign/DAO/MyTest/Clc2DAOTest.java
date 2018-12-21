package libraryDesign.DAO.MyTest;

import static org.junit.Assert.*;
import libraryDesign.DAO.Clc1DAO;
import libraryDesign.DAO.Clc2DAO;
import libraryDesign.PO.Clc1;
import libraryDesign.PO.Clc2;

import org.junit.Test;

public class Clc2DAOTest {
	/*
	@Test
	public void testCreateClc2() {
		Clc2DAO clc2 = new Clc2DAO();
		try{
			Clc2 clc = new Clc2();
			clc.setClcID1("G");
			clc.setClcID2(1);
			clc.setClcname2("中国历史");
			assertTrue(String.valueOf(clc2.createClc2(clc)),true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testQueryClc2() {
		Clc2DAO clc2 = new Clc2DAO();
		try{
			assertEquals(clc2.queryClc2("G", 1).getClcname2(),"中国历史");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
