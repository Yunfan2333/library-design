package library.DAO.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import library.PO.Document;

class DocumentDAOTest {

	@Test
	void testCreateDocument() {
		Document d=new Document();
		Date date1=new Date();
		d.setAppdate(date1);
		
		d.setCounts(0);
		d.setCredits(00001);
		d.setDeposit((float) 0.0);
		d.setDocID("000000001");
		
		Date date2=new Date();
		d.setEffdate(date2);
		
		Date date3=new Date();
		d.setExpdate(date3);
		
		d.setOwed((float)0.0);
		d.setUsertypeID("本科生");
		d.setViolations(5);
		createDocument(d);
		
		
		Document d2=new Document();
		Date date11=new Date();
		d2.setAppdate(date11);
		
		d2.setCounts(0);
		d2.setCredits(00002);
		d2.setDeposit((float) 0.0);
		d2.setDocID("000000002");
		
		Date date22=new Date();
		d2.setEffdate(date22);
		
		Date date33=new Date();
		d2.setExpdate(date33);
		
		d2.setOwed((float)0.0);
		d2.setUsertypeID("本科生");
		d2.setViolations(5);
		createDocument(d2);
		}

	

	@Test
	void testUpdateDocumentDocument() {
		Document d=new Document();
		Date date1=new Date();
		d.setAppdate(date1);
		
		d.setCounts(0);
		d.setCredits(00001);
		d.setDeposit((float) 0.0);
		d.setDocID("000000001");
		
		Date date2=new Date();
		d.setEffdate(date2);
		
		Date date3=new Date();
		d.setExpdate(date3);
		
		d.setOwed((float)0.0);
		d.setUsertypeID("本科生");
		d.setViolations(6);
		updateDocument(d);
		
	}

	@Test
	void testUpdateDocumentStringFloatIntegerIntegerInteger() {
		//这是啥？这样的DAO有什么意义？
	}

	@Test
	void testQueryDocument() {
		String s="000000001";
		queryDocument(s);
	}
	
	@Test
	void testDeleteDocumentDocument() {
		Document d=new Document();
		Date date1=new Date();
		d.setAppdate(date1);
		
		d.setCounts(0);
		d.setCredits(00001);
		d.setDeposit((float) 0.0);
		d.setDocID("000000001");
		
		Date date2=new Date();
		d.setEffdate(date2);
		
		Date date3=new Date();
		d.setExpdate(date3);
		
		d.setOwed((float)0.0);
		d.setUsertypeID("本科生");
		d.setViolations(6);
		
		deleteDocument(d);
	}

	@Test
	void testDeleteDocumentString() {
		String s="000000002";
		deleteDocument(s);
	}

}
