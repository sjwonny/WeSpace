package cat3.bsns_info.vo;

public class Bsns_InfoVO {
	private int bsns_info_no;
	private int bsns_info_paymethod;
	private String bsns_info_bname;
	private String bsns_info_rname;
	private String bsns_info_bnumber;
	private int bsns_type_no;
	private String bsns_info_mainbsns;
	private String bsns_info_mainevent;
	private String bsns_info_badr;
	private String bsns_info_phone;
	private int account_info_no;
	private int refund_standard_no;
	
	public Bsns_InfoVO(int bsns_info_no, int bsns_info_paymethod, String bsns_info_bname, String bsns_info_rname,
			String bsns_info_bnumber, int bsns_type_no, String bsns_info_mainbsns, String bsns_info_mainevent,
			String bsns_info_badr, String bsns_info_phone, int account_info_no,
			int refund_standard_no) {
		super();
		this.bsns_info_no = bsns_info_no;
		this.bsns_info_paymethod = bsns_info_paymethod;
		this.bsns_info_bname = bsns_info_bname;
		this.bsns_info_rname = bsns_info_rname;
		this.bsns_info_bnumber = bsns_info_bnumber;
		this.bsns_type_no = bsns_type_no;
		this.bsns_info_mainbsns = bsns_info_mainbsns;
		this.bsns_info_mainevent = bsns_info_mainevent;
		this.bsns_info_badr = bsns_info_badr;
		this.bsns_info_phone = bsns_info_phone;
		this.account_info_no = account_info_no;
		this.refund_standard_no = refund_standard_no;
	}
	
	public Bsns_InfoVO() {
		super();
	}
	
	public int getBsns_info_no() {
		return bsns_info_no;
	}
	public void setBsns_info_no(int bsns_info_no) {
		this.bsns_info_no = bsns_info_no;
	}
	public int getBsns_info_paymethod() {
		return bsns_info_paymethod;
	}
	public void setBsns_info_paymethod(int bsns_info_paymethod) {
		this.bsns_info_paymethod = bsns_info_paymethod;
	}
	public String getBsns_info_bname() {
		return bsns_info_bname;
	}
	public void setBsns_info_bname(String bsns_info_bname) {
		this.bsns_info_bname = bsns_info_bname;
	}
	public String getBsns_info_rname() {
		return bsns_info_rname;
	}
	public void setBsns_info_rname(String bsns_info_rname) {
		this.bsns_info_rname = bsns_info_rname;
	}
	public String getBsns_info_bnumber() {
		return bsns_info_bnumber;
	}
	public void setBsns_info_bnumber(String bsns_info_bnumber) {
		this.bsns_info_bnumber = bsns_info_bnumber;
	}
	public int getBsns_type_no() {
		return bsns_type_no;
	}
	public void setBsns_type_no(int bsns_type_no) {
		this.bsns_type_no = bsns_type_no;
	}
	public String getBsns_info_mainbsns() {
		return bsns_info_mainbsns;
	}
	public void setBsns_info_mainbsns(String bsns_info_mainbsns) {
		this.bsns_info_mainbsns = bsns_info_mainbsns;
	}
	public String getBsns_info_mainevent() {
		return bsns_info_mainevent;
	}
	public void setBsns_info_mainevent(String bsns_info_mainevent) {
		this.bsns_info_mainevent = bsns_info_mainevent;
	}
	public String getBsns_info_badr() {
		return bsns_info_badr;
	}
	public void setBsns_info_badr(String bsns_info_badr) {
		this.bsns_info_badr = bsns_info_badr;
	}
	public String getBsns_info_phone() {
		return bsns_info_phone;
	}
	public void setBsns_info_phone(String bsns_info_phone) {
		this.bsns_info_phone = bsns_info_phone;
	}
	public int getAccount_info_no() {
		return account_info_no;
	}
	public void setAccount_info_no(int account_info_no) {
		this.account_info_no = account_info_no;
	}
	public int getRefund_standard_no() {
		return refund_standard_no;
	}
	public void setRefund_standard_no(int refund_standard_no) {
		this.refund_standard_no = refund_standard_no;
	}
	
	
	
	
	
	
}
