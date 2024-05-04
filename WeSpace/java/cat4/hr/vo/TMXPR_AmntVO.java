package cat4.hr.vo;

public class TMXPR_AmntVO { // 시간예외기간금액

	private int tmxpr_amnt_no;
	private int set_px_hr_no;
	private String tmxpr_amnt_sdate;
	private String tmxpr_amnt_edate;
	private int tmxpr_amnt_price;
	
	public TMXPR_AmntVO() {

	}

	public TMXPR_AmntVO(int tmxpr_amnt_no, int set_px_hr_no, String tmxpr_amnt_sdate, String tmxpr_amnt_edate,
			int tmxpr_amnt_price) {
		super();
		this.tmxpr_amnt_no = tmxpr_amnt_no;
		this.set_px_hr_no = set_px_hr_no;
		this.tmxpr_amnt_sdate = tmxpr_amnt_sdate;
		this.tmxpr_amnt_edate = tmxpr_amnt_edate;
		this.tmxpr_amnt_price = tmxpr_amnt_price;
	}

	public int getTmxpr_amnt_no() {
		return tmxpr_amnt_no;
	}

	public void setTmxpr_amnt_no(int tmxpr_amnt_no) {
		this.tmxpr_amnt_no = tmxpr_amnt_no;
	}

	public int getSet_px_hr_no() {
		return set_px_hr_no;
	}

	public void setSet_px_hr_no(int set_px_hr_no) {
		this.set_px_hr_no = set_px_hr_no;
	}

	public String getTmxpr_amnt_sdate() {
		return tmxpr_amnt_sdate;
	}

	public void setTmxpr_amnt_sdate(String tmxpr_amnt_sdate) {
		this.tmxpr_amnt_sdate = tmxpr_amnt_sdate;
	}

	public String getTmxpr_amnt_edate() {
		return tmxpr_amnt_edate;
	}

	public void setTmxpr_amnt_edate(String tmxpr_amnt_edate) {
		this.tmxpr_amnt_edate = tmxpr_amnt_edate;
	}

	public int getTmxpr_amnt_price() {
		return tmxpr_amnt_price;
	}

	public void setTmxpr_amnt_price(int tmxpr_amnt_price) {
		this.tmxpr_amnt_price = tmxpr_amnt_price;
	}
	
	
}
