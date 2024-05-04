package cat4.pckg.vo;

public class PCKG_ExprdVO { // 패키지예외기간금액

	private int pckg_exprd_no;
	private int pckg_prcst_no;
	private String pckg_exprd_sdate;
	private String pckg_exprd_edate;
	private int pckg_exprd_price;
	
	public PCKG_ExprdVO() {

	}

	public PCKG_ExprdVO(int pckg_exprd_no, int pckg_prcst_no, String pckg_exprd_sdate, String pckg_exprd_edate,
			int pckg_exprd_price) {
		super();
		this.pckg_exprd_no = pckg_exprd_no;
		this.pckg_prcst_no = pckg_prcst_no;
		this.pckg_exprd_sdate = pckg_exprd_sdate;
		this.pckg_exprd_edate = pckg_exprd_edate;
		this.pckg_exprd_price = pckg_exprd_price;
	}

	public int getPckg_exprd_no() {
		return pckg_exprd_no;
	}

	public void setPckg_exprd_no(int pckg_exprd_no) {
		this.pckg_exprd_no = pckg_exprd_no;
	}

	public int getPckg_prcst_no() {
		return pckg_prcst_no;
	}

	public void setPckg_prcst_no(int pckg_prcst_no) {
		this.pckg_prcst_no = pckg_prcst_no;
	}

	public String getPckg_exprd_sdate() {
		return pckg_exprd_sdate;
	}

	public void setPckg_exprd_sdate(String pckg_exprd_sdate) {
		this.pckg_exprd_sdate = pckg_exprd_sdate;
	}

	public String getPckg_exprd_edate() {
		return pckg_exprd_edate;
	}

	public void setPckg_exprd_edate(String pckg_exprd_edate) {
		this.pckg_exprd_edate = pckg_exprd_edate;
	}

	public int getPckg_exprd_price() {
		return pckg_exprd_price;
	}

	public void setPckg_exprd_price(int pckg_exprd_price) {
		this.pckg_exprd_price = pckg_exprd_price;
	}
	
	
}
