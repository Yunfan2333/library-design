package library.PO;

import java.util.Date;

public class BorrowInfo {
	public String userID;
	public String bookID;
	public Date borrowTime;
	public Date returnTime;
	public String borrowID;
	public String returnState;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public String getBorrowID() {
		return borrowID;
	}
	public void setBorrowID(String borrowID) {
		this.borrowID = borrowID;
	}
	public String getReturnState() {
		return returnState;
	}
	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}
	
}
