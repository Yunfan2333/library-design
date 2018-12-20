package com.itcast.junit4.test

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import library.PO.Usertype;

class UsertypeDAOTest {

	@Test
	void testCreateUsertype() {
		Usertype u=new Usertype();
		u.setUsertypeID("1");
		u.setUsertype("±¾¿ÆÉú");
		u.setMaxorder(20);
		u.setMaxentrust(5);
		u.setMaxbooknum(10);
		createUsertype(u);
		
	}

	@Test
	void testQueryUsertype() {
		Integer a=5;
		queryUsertype(5);
	}

}
