package libraryDesign.PO;

public class Book {
	
	private String bookID;		// 条码号，数据ID
	private String booktypeID;	// 文献类型ID
	private String clcID1;		// 中图法编号1
	private Integer clcID2;		// 中图法编号2
	private String findID;		// 索书号
	private String bookName;	// 题名，书名
	private String authorName;	// 责任者，作者
	private String isbn;		// ISBN编号
	private float price;		// 定价
	private String info;		// 内容简介
	private Integer stocknum;	// 库存数量【在借书、还书时需要改变】
	
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBooktypeID() {
		return booktypeID;
	}
	public void setBooktypeID(String booktypeID) {
		this.booktypeID = booktypeID;
	}
	public String getClcID1() {
		return clcID1;
	}
	public void setClcID1(String clcID1) {
		this.clcID1 = clcID1;
	}
	public Integer getClcID2() {
		return clcID2;
	}
	public void setClcID2(Integer clcID2) {
		this.clcID2 = clcID2;
	}
	public String getFindID() {
		return findID;
	}
	public void setFindID(String findID) {
		this.findID = findID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getStocknum() {
		return stocknum;
	}
	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}

}
