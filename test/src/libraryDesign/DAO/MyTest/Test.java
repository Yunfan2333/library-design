package libraryDesign.DAO.MyTest;
import java.sql.*;
import java.util.ArrayList;

import libraryDesign.c3p0JdbcUtil;

public class Test {
	public static void main(String[] args){
		try{
			
			Connection conn=c3p0JdbcUtil.getConnection();
			Statement stmt=conn.createStatement();
			String sql="select * from book";
			ResultSet resSet=stmt.executeQuery(sql);
			while(resSet.next()){
				String sna=resSet.getString("bookName");
				System.out.println(sna);
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	
	/*
	static public Connection getDbConn(){
		Connection con=null;
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=EDUCATION";
		try{ 
		Class.forName(driverName);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
		con=DriverManager.getConnection(dbURL,"sa","123456");
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	static public void Insert(Student s){
		Connection conn=null;
		Statement statement=null;
		int SNO=s.getSNO();
		String SNA=s.getSNA();
		String SSEX=s.getSSEX();
		String SBIR=s.getSBIR();
		int SCLA=s.getSCLA();
		int SAGE=s.getSAGE();
		try {
			conn=getDbConn();
			statement=conn.createStatement();
			statement.executeUpdate("insert into student(SNO,SNA,SSEX,SBIR,SCLA,SAGE) values("+String.valueOf(SNO)+",\'"+SNA+"\',\'"+SSEX+"\',\'"
					+SBIR+"\',"+String.valueOf(SCLA)+","+String.valueOf(SAGE)+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static public void InsertP(Student s){
		int SNO=s.getSNO();
		String SNA=s.getSNA();
		String SSEX=s.getSSEX();
		String SBIR=s.getSBIR();
		int SCLA=s.getSCLA();
		int SAGE=s.getSAGE();
		PreparedStatement pStatement=null;
		Connection conn=null;
		try{
			conn=getDbConn();
			pStatement=conn.prepareStatement("insert into student(SNO,SNA,SSEX,SBIR,SCLA,SAGE) values("+String.valueOf(SNO)+",\'"+SNA+"\',\'"+SSEX+"\',\'"
					+SBIR+"\',"+String.valueOf(SCLA)+","+String.valueOf(SAGE)+")");
			pStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	static public ResultSet Search(String sql){
		Connection conn=null;
		Statement statement=null;
		ResultSet resSet=null;
		//String sql;
		//ArrayList students=new ArrayList<Student>();
		try{
			
			conn=getDbConn();
			statement=conn.createStatement();
			resSet=statement.executeQuery(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return resSet;
	}
	static public boolean Update(String sql){
		Connection conn=null;
		Statement statement=null;
		boolean bo=false;
		try{
			conn=getDbConn();
			statement=conn.createStatement();
			bo=statement.execute(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bo;
	}
	public static void main(String[] args) {
		
		
		
		
		/*
		Student st1=new Student(1001,"张三","男","2018-11-16",2222,25);
		Insert(st1);
		
		Student st2=new Student(1002,"李四","男","2017-11-17",3333,26);
		Insert(st2);
		*/
		/*
		Student st3=new Student(1003,"王五","男","2016-11-18",4444,27);
		InsertP(st3);
		*/
		/*
		ResultSet resSet=null;
		String sql="select SNO,SNA from student where SNO in( select SNO from score group by SNO having COUNT(CNO)>=2);";
		resSet=Search(sql);
		try{
		while(resSet.next()){
			int sno=resSet.getInt("SNO");
			String sna=resSet.getString("SNA");
			System.out.println(sno+"\t"+sna+'\n');
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
	/*
		boolean ans=false;
		Student st1=new Student(1001,"张三","男","2018-11-16",2222,25);
		Student st2=new Student(1002,"李四","男","2017-11-17",3333,26);
		Student st3=new Student(1003,"王五","男","2016-11-18",4444,27);
		String sql="delete from student where SNA='"+st1.getSNA()+"\' OR SNA='"+st2.getSNA()+"\' OR SNA='"+st3.getSNA()+"\'";
		ans=Update(sql);
		System.out.println(ans);
		
		
	}
	*/

}
