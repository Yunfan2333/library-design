package libraryDesign.DAO;


import java.sql.Connection;
import java.sql.SQLException;
import libraryDesign.*;

public class DAOBase implements DAO {

	@Override
	public Connection getConnection() throws DAOException {
		// getConnection
		try {
			Connection connection = c3p0JdbcUtil.getConnection();
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
