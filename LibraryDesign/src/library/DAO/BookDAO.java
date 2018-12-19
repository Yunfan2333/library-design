package library.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import library.PO.*;

public class BookDAO extends DAOBase {
	
	// 增，添加一类书，每一类有多本库存
	public void createBook(Book book) throws Exception{
		// SQL语句
		String CREATE_BOOK_SQL = "insert into book(bookID,booktypeID,clcID1,clcID2,findID,bookName,authorName,isbn,price,info,stocknum) values(?,?,?,?,?,?,?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_BOOK_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, book.getBookID());
			pStatement.setString(1, book.getBooktypeID());
			pStatement.setString(2, book.getClcID1());
			pStatement.setInt(3, book.getClcID2());
			pStatement.setString(4, book.getFindID());
			pStatement.setString(5, book.getBookName());
			pStatement.setString(6, book.getAuthorName());
			pStatement.setString(7, book.getIsbn());
			pStatement.setFloat(8, book.getPrice());
			pStatement.setString(9, book.getInfo());
			pStatement.setInt(10, book.getStocknum());
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			pStatement.executeUpdate();
			pStatement.close();
					
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}	
	
	
	// 删，删除一类书
	public void deleteBook(String bookID) throws Exception{
		// SQL语句
		String DELETE_BOOK_SQL = "delete from book where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BOOK_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, bookID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			pStatement.executeUpdate();
			pStatement.close();
					
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}		
	
	// 改，添加一本书，库存量加一
	public void addBook(String bookID) throws Exception{
		// SQL语句
		String ADD_BOOK_SQL = "update book set stocknum=? where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			
			// 先查询，在返回结果中取库存量		 
			Integer stocknum = queryBook(bookID).getStocknum()+1;
			
			// 更新库存量
			pStatement = connection.prepareStatement(ADD_BOOK_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setInt(0, stocknum);
			pStatement.setString(1, bookID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			pStatement.executeUpdate();
			pStatement.close();
					
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}		
	
	// 删，删除一本书，本质是更改库存量这个属性（与改库存量的操作合并了）
	// 改，更改库存量
	public void removeBook(String bookID) throws Exception{
		// SQL语句
		String REMOVE_BOOK_SQL = "update book set stocknum=? where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			
			// 先查询，在返回结果中取库存量		 
			Integer stocknum = queryBook(bookID).getStocknum()-1;
			
			// 更新库存量
			pStatement = connection.prepareStatement(REMOVE_BOOK_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setInt(0, stocknum);
			pStatement.setString(1, bookID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			pStatement.executeUpdate();
			pStatement.close();
					
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}		
		
	
	// 查，根据条码号查找指定的一类书，返回一类书
	public Book queryBook(String bookID) throws Exception{
		// SQL语句
		String QUERY_BOOK_SQL = "select * from book where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOK_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, bookID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			Book book = (Book)pStatement.executeQuery();	
			pStatement.close();
			
			return book;
			
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}		
	
	
	// 查，根据文献类型查找，返回多种书
	public List<Book> queryBookByBooktypeID(String booktypeID) throws Exception{
		// SQL语句
		String QUERY_BOOKBYBOOKTYPEID_SQL = "select * from book where booktypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYBOOKTYPEID_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, booktypeID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}	
	
	
	// 查，根据中图法分类1查找，返回多种书
	public List<Book> queryBookByClcID1(String clcID1) throws Exception{
		// SQL语句
		String QUERY_BOOKBYCLCID1_SQL = "select * from book where clcID1=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYCLCID1_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, clcID1);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}		
	
	
	// 查，根据中图法分类2查找，返回多种书
	public List<Book> queryBookByClcID2(String clcID2) throws Exception{
		// SQL语句
		String QUERY_BOOKBYCLCID2_SQL = "select * from book where clcID2=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYCLCID2_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, clcID2);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}
	
	
	// 查，根据题名模糊查询，返回多种书
	public List<Book> queryBookByBookName(String bookName) throws Exception{
		// SQL语句
		String QUERY_BOOKBYBOOKNAME_SQL = "select * from book where bookName like ?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYBOOKNAME_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, "%"+bookName+"%");
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}	
	
	
	// 查，根据责任者模糊查询，返回多种书	
	public List<Book> queryBookByAuthorName(String authorName) throws Exception{
		// SQL语句
		String QUERY_BOOKBYAUTHORNAME_SQL = "select * from book where authorName like ?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYAUTHORNAME_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, "%" + authorName + "%");
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}	
	
	
	// 查，根据内容简介进行模糊查询，返回多种书
	public List<Book> queryBookByInfo(String info) throws Exception{
		// SQL语句
		String QUERY_BOOKBYINFO_SQL = "select * from book where info like ?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYINFO_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, "%" + info + "%");
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}		

}
