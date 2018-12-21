package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import libraryDesign.PO.Userlogin;

public class UserloginDAO extends DAOBase {
	
	//添加新的Userlogin（登陆信息）
	public boolean createUserlogin(Userlogin user) throws Exception{

		
		String CREATE_USER_SQL = "insert into userlogin (loginID,password) values(?,?)";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_USER_SQL);
					
			pStatement.setString(1, user.getLoginID());
			pStatement.setString(2, user.getPassword());
			
			pStatement.executeUpdate();
			pStatement.close();
			return true;
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	
	//根据Userlogin删除userlogin表中对应的user登陆信息
	//需要先删除用户详细信息
	public boolean deleteUser(Userlogin user) throws Exception{
		
		String DELETE_USER_SQL = "delete from userlogin where loginID=?";
		String DELETE_USERDETAIL_SQL = "delete from userdetail where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			pStatement0 = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			pStatement0.setString(1, user.getLoginID());
			pStatement0.executeUpdate();
			pStatement0.close();			
			
			pStatement = connection.prepareStatement(DELETE_USER_SQL);
			
			pStatement.setString(1, user.getLoginID());
			
			pStatement.executeUpdate();
			pStatement.close();
			return true;
					
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}	

	//需要先删除用户详细信息
	//根据loginID删除user表中对应的userlogin登陆信息
	public boolean deleteUser(String loginID) throws Exception{

		
		String DELETE_USER_SQL = "delete from userlogin where loginID=?";
		String DELETE_USERDETAIL_SQL = "delete from userdetail where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			pStatement0 = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			pStatement0.setString(1, loginID);
			pStatement0.executeUpdate();
			pStatement0.close();			
						
			pStatement = connection.prepareStatement(DELETE_USER_SQL);
			
			pStatement.setString(1, loginID);
			
			pStatement.executeUpdate();
			pStatement.close();	
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}		
	
	
	//根据Userlogin更新userlogin表中内容，根据loginID更新password
	public boolean updateUserlogin(Userlogin user) throws Exception{
	
		String UPDATE_USER_SQL = "update userlogin set password=? where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_SQL);
							
			pStatement.setString(1, user.getPassword());
			pStatement.setString(2, user.getLoginID());
			
			pStatement.executeUpdate();
			pStatement.close();
			return true;
					
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}		
	
	//根据loginID查找userlogin表中的userlogin登陆信息，并返回
	public Userlogin queryUserlogin(String loginID) throws Exception{
		
		
		String QUERY_USER_SQL = "select * from userlogin where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_USER_SQL);
			
			pStatement.setString(1, loginID);
			Userlogin ul=new Userlogin();
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()){
				
				ul.setLoginID(rs.getString(1));
				ul.setPassword(rs.getString(2));
			}
			
			pStatement.close();
			
			return ul;
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}	

}
