package libraryDesign.DAO.MyTest;

import static org.junit.Assert.*;
import libraryDesign.DAO.Clc1DAO;
import libraryDesign.PO.Clc1;

import org.junit.Test;

public class Clc1DAOTest {

	@Test
	public void testCreateClc1() {
		Clc1DAO clc1 = new Clc1DAO();
		try{
			Clc1 clc = new Clc1();
			clc.setClcID1("F");
			clc.setClcname1("≤‚ ‘");
			clc1.createClc1(clc);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
/*
	@Test
	public void testQueryClc1() {
		fail("Not yet implemented");
	}*/

}
