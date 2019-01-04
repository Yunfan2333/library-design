package libraryDesign.PO;

import java.util.Date;

public class Document {
	
	private String docID;		// 证件号
	private Date effdate;		// 生效日期
	private Date expdate;		// 失效日期
	private Date appdate;		// 办证日期
	private float owed;			// 欠费金额
	private Integer violations;	// 违章次数
	private String usertypeID;	// 读者类型ID
	private float deposit;		// 押金
	private Integer credits;	// 总积分
	private Integer counts;		// 累计借阅次数
	
	public String getDocID() {
		return docID;
	}
	public void setDocID(String docID) {
		this.docID = docID;
	}
	public Date getEffdate() {
		return effdate;
	}
	public void setEffdate(Date effdate) {
		this.effdate = effdate;
	}
	public Date getExpdate() {
		return expdate;
	}
	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
	public Date getAppdate() {
		return appdate;
	}
	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}
	public float getOwed() {
		return owed;
	}
	public void setOwed(float owed) {
		this.owed = owed;
	}
	public Integer getViolations() {
		return violations;
	}
	public void setViolations(Integer violations) {
		this.violations = violations;
	}
	public String getUsertypeID() {
		return usertypeID;
	}
	public void setUsertypeID(String usertypeID) {
		this.usertypeID = usertypeID;
	}
	public float getDeposit() {
		return deposit;
	}
	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	
}
