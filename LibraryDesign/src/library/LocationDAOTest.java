package library.DAO.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import library.PO.Location;

class LocationDAOTest {

	@Test
	void testCreateLocation() {
		Location l=new Location();
		l.setFindID("00001");
		l.setLevel(1);
		l.setRoom("中文阅览室");
		l.setShelf(101);
		createLocation(l);
		
		Location l2=new Location();
		l2.setFindID("00002");
		l2.setLevel(2);
		l2.setRoom("中文阅览室");
		l2.setShelf(101);
		createLocation(l2);
	}

	@Test
	void testDeleteLocation() {
		fail("Not yet implemented");
	}

	@Test
	void testQueryLocation() {
		fail("Not yet implemented");
	}

}
