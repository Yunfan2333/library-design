package libraryDesign.DAO.MyTest;
import static org.junit.Assert.*;
import org.junit.Test;
import libraryDesign.DAO.*;
import libraryDesign.PO.*;
public class LocationDAOTest {
	
	@Test
	public void testCreateLocation() {
		LocationDAO ld=new LocationDAO();
		try{
			Location l=new Location();
			l.setFindID("20311");
			l.setLevel(1);
			l.setRoom("301");
			l.setShelf(5);
			assertTrue(String.valueOf(ld.createLocation(l)),true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testQueryLocation() {
		LocationDAO ld=new LocationDAO();
		try{
			assertEquals(ld.queryLocation("20222").getRoom(),"202");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testDeleteLocation() {
		LocationDAO ld=new LocationDAO();
		try{
			assertTrue(String.valueOf(ld.deleteLocation("20311")),true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
