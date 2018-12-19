package library.PO;

public class Location {
	
	private String findID;	// 索书号
	private String room;	// 馆藏地（房间号）
	private Integer shelf;	// 书架排数
	private Integer level;	// 书架层数
	
	public String getFindID() {
		return findID;
	}
	public void setFindID(String findID) {
		this.findID = findID;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Integer getShelf() {
		return shelf;
	}
	public void setShelf(Integer shelf) {
		this.shelf = shelf;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
}
