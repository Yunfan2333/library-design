package library.DAO;


import java.sql.Connection;
import java.sql.SQLException;

import library.C3p0JdbcUtil;

public class DAOBase implements DAO {

	@Override
	public Connection getConnection() throws DAOException {
		// getConnection
		try {
			Connection connection = C3p0JdbcUtil.getConnection();
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
