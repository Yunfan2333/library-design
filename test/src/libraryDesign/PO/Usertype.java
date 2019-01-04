package libraryDesign.PO;

public class Usertype {
	
	private String usertypeID;	// 读者类型ID
	private String usertype;	// 读者类型名
	private Integer maxbooknum;	// 最大可借图书数目
	private Integer maxorder;	// 最多可预约
	private Integer maxentrust;	// 最多可委托
	
	public String getUsertypeID() {
		return usertypeID;
	}
	public void setUsertypeID(String usertypeID) {
		this.usertypeID = usertypeID;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Integer getMaxbooknum() {
		return maxbooknum;
	}
	public void setMaxbooknum(Integer maxbooknum) {
		this.maxbooknum = maxbooknum;
	}
	public Integer getMaxorder() {
		return maxorder;
	}
	public void setMaxorder(Integer maxorder) {
		this.maxorder = maxorder;
	}
	public Integer getMaxentrust() {
		return maxentrust;
	}
	public void setMaxentrust(Integer maxentrust) {
		this.maxentrust = maxentrust;
	}
	
}
