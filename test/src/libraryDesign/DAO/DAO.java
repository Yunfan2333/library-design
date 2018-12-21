package libraryDesign.DAO;

import java.sql.Connection;

public interface DAO {
	
	public Connection getConnection() throws DAOException;

}
