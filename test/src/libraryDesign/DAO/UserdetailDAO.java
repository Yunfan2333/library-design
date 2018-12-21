package libraryDesign.DAO;

import java.sql.*;

import libraryDesign.PO.Userdetail;

public class UserdetailDAO extends DAOBase {
	
	//添加新的Userdetail（详细信息）
	//需要先有登陆信息
	public boolean createUserdetail(Userdetail userdetail) throws Exception{
		
		String CREATE_USERDETAIL_SQL = "insert into userdetail(userID,userName,docID,college,profession,sex,mail,loginID) values(?,?,?,?,?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_USERDETAIL_SQL);
			
			pStatement.setString(1, userdetail.getUserID());
			pStatement.setString(2, userdetail.getUserName());
			pStatement.setString(3, userdetail.getDocID());
			pStatement.setString(4, userdetail.getCollege());
			pStatement.setString(5, userdetail.getProfession());
			pStatement.setString(6, userdetail.getSex());
			pStatement.setString(7, userdetail.getMail());
			pStatement.setString(8, userdetail.getLoginID());
			
			pStatement.executeUpdate();
			pStatement.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			
			try {
				connection.close();
				
			}catch(SQLException ee) {
				ee.printStackTrace();
				
			}
			return false;
		}
	}
	
	//根据Userdetail删除userdetail表中对应的userdetail详细信息
	//需要同时删除登陆信息
	public boolean deleteUserdetail(Userdetail userdetail) throws Exception{

		
		String DELETE_USERDETAIL_SQL = "delete from userdetail where userID=?";
		String DELETE_USER_SQL = "delete from userlogin where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			
			pStatement.setString(1, userdetail.getUserID());
			
			pStatement.executeUpdate();
			pStatement.close();
			
			
			pStatement0 = connection.prepareStatement(DELETE_USER_SQL);
			pStatement0.setString(1, userdetail.getLoginID());
			pStatement0.executeUpdate();
			pStatement0.close();
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
	
	//根据userID删除userdetail表中对应的userdetail详细信息
	//需要同时删除登陆信息
	public boolean deleteUserdetail(String userID) throws Exception{
		
		
		String DELETE_USERDETAIL_SQL = "delete from userdetail where userID=?";
		String DELETE_USER_SQL = "delete from userlogin where loginID=?";
				
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			
			pStatement.setString(1, userID);
			
			pStatement.executeUpdate();
			pStatement.close();
			
			
			Userdetail userdetail = queryUserdetail(userID);
			pStatement0 = connection.prepareStatement(DELETE_USER_SQL);
			pStatement0.setString(1, userdetail.getLoginID());
			pStatement0.executeUpdate();			
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
	
	
	//更新userdetail表，根据userID更新其他信息
	public boolean updateUserdetail(Userdetail userdetail) throws Exception{

		// SQL
		String UPDATE_USERDETAIL_SQL = "update userdetail set userName=?,docID=?,college=?,profession=?,sex=?,mail=?,loginID=? where userID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USERDETAIL_SQL);
			
			pStatement.setString(1, userdetail.getUserName());
			pStatement.setString(2, userdetail.getDocID());
			pStatement.setString(3, userdetail.getCollege());
			pStatement.setString(4, userdetail.getProfession());
			pStatement.setString(5, userdetail.getSex());
			pStatement.setString(6, userdetail.getMail());
			pStatement.setString(7, userdetail.getLoginID());			
			pStatement.setString(8, userdetail.getUserID());
			
			
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
	
	// 根据userID进行查询，并返回查询到的userdetail的结果
	public Userdetail queryUserdetail(String userID) throws Exception{

		// SQL
		String QUERY_USERDETAIL_SQL = "select * from userdetail where userID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_USERDETAIL_SQL);
			
			pStatement.setString(1, userID);
			
			//Userdetail userdetail = (Userdetail)pStatement.executeQuery();
			Userdetail u = new Userdetail();
			ResultSet rs=pStatement.executeQuery();
			while(rs.next())
			{
				u.setCollege(rs.getString("college"));
				u.setDocID(rs.getString("docID"));
				u.setLoginID(rs.getString("loginID"));
				u.setMail(rs.getString("mail"));
				u.setProfession(rs.getString("profession"));
				u.setSex(rs.getString("sex"));
				u.setUserID(rs.getString("userID"));
				u.setUserName(rs.getString("userName"));
			}

			pStatement.close();
			
			return u;
					
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	

}
