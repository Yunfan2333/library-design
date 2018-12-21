package libraryDesign.DAO.MyTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import libraryDesign.DAO.*;
import libraryDesign.PO.*;

public class DocumentDAOTest {

	@Test
	public void testCreateDocument() {
		DocumentDAO dd=new DocumentDAO();
		
		try {
			Document d=new Document();
			java.util.Date utilDate1 = new java.util.Date();
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			d.setAppdate(sqlDate1);
			
			d.setCounts(0);
			d.setCredits(00001);
			d.setDeposit((float) 0.0);
			d.setDocID("000000001");
			
			java.util.Date utilDate2 = new java.util.Date();
			java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
			d.setEffdate(sqlDate2);
			
			java.util.Date utilDate3 = new java.util.Date();
			java.sql.Date sqlDate3 = new java.sql.Date(utilDate3.getTime());
			d.setExpdate(sqlDate3);
			
			d.setOwed((float)0.0);
			d.setUsertypeID("1");
			d.setViolations(5);
			
			assertTrue(String.valueOf(dd.createDocument(d)),true);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	

	@Test
	public void testUpdateDocumentDocument() {
		DocumentDAO dd=new DocumentDAO();
		
		try {
			Document d=new Document();
			java.util.Date utilDate1 = new java.util.Date();
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			d.setAppdate(sqlDate1);
			
			d.setCounts(0);
			d.setCredits(00001);
			d.setDeposit((float) 0.0);
			d.setDocID("000000001");
			
			java.util.Date utilDate2 = new java.util.Date();
			java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
			d.setEffdate(sqlDate2);
			
			java.util.Date utilDate3 = new java.util.Date();
			java.sql.Date sqlDate3 = new java.sql.Date(utilDate3.getTime());
			d.setExpdate(sqlDate3);
			
			d.setOwed((float)0.0);
			d.setUsertypeID("1");
			d.setViolations(6);
			
			assertTrue(String.valueOf(dd.updateDocument(d)),true);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	

	@Test
	public void testUpdateDocumentStringFloatIntegerIntegerInteger() {
		DocumentDAO dd=new DocumentDAO();
		
		try {
			String docID="000000001";
			float owed=(float)0.0;
			Integer violation=0;
			Integer credits=0;
			Integer counts=1;
			
			assertTrue(String.valueOf(dd.updateDocument(docID,owed,violation,credits,counts)),true);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

	@Test
	public void testQueryDocument() {
		DocumentDAO dd=new DocumentDAO();
		
		try {
			String s="161001001";
			
			boolean b = (dd.queryDocument(s).getUsertypeID().equals("Type1"));
			assertTrue(String.valueOf(b),true);
			
			//assertEquals(dd.queryDocument(s).getOwed(),(float)0.0);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/*
	@Test
	void testDeleteDocumentDocument() {
		DocumentDAO dd=new DocumentDAO();
		
		try {
			Document d=new Document();
			java.util.Date utilDate1 = new java.util.Date();
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			d.setAppdate(sqlDate1);
			
			d.setCounts(0);
			d.setCredits(00001);
			d.setDeposit((float) 0.0);
			d.setDocID("000000001");
			
			java.util.Date utilDate2 = new java.util.Date();
			java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
			d.setEffdate(sqlDate2);
			
			java.util.Date utilDate3 = new java.util.Date();
			java.sql.Date sqlDate3 = new java.sql.Date(utilDate3.getTime());
			d.setExpdate(sqlDate3);
			
			d.setOwed((float)0.0);
			d.setUsertypeID("1");
			d.setViolations(5);
			
			assertTrue(String.valueOf(dd.deleteDocument(d)),true);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	*/

	@Test
	public void testDeleteDocumentString() {
		DocumentDAO dd=new DocumentDAO();
		
		try {
			String s="000000001";
			assertTrue(String.valueOf(dd.deleteDocument(s)),true);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
