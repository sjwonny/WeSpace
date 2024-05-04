package cat4.day.vo;

public class DAY_TM_PrVO { // 요일시간가격

	private int day_tm_pr_no;
	private int day_week_no;
	private int tm_no_start;
	private int tm_no_end;
	private int set_px_hr_no;
	private int day_tm_pr_price;
	
	public DAY_TM_PrVO() {

	}

	public DAY_TM_PrVO(int day_tm_pr_no, int day_week_no, int tm_no_start, int tm_no_end,int set_px_hr_no,
			int day_tm_pr_price) {
		super();
		this.day_tm_pr_no = day_tm_pr_no;
		this.day_week_no = day_week_no;
		this.tm_no_start = tm_no_start;
		this.tm_no_end = tm_no_end;
		this.set_px_hr_no = set_px_hr_no;
		this.day_tm_pr_price = day_tm_pr_price;
	}

	public int getDay_tm_pr_no() {
		return day_tm_pr_no;
	}

	public void setDay_tm_pr_no(int day_tm_pr_no) {
		this.day_tm_pr_no = day_tm_pr_no;
	}

	public int getDay_week_no() {
		return day_week_no;
	}

	public void setDay_week_no(int day_week_no) {
		this.day_week_no = day_week_no;
	}

	public int getTm_no_start() {
		return tm_no_start;
	}

	public void setTm_no_start(int tm_no_start) {
		this.tm_no_start = tm_no_start;
	}

	public int getTm_no_end() {
		return tm_no_end;
	}

	public void setTm_no_end(int tm_no_end) {
		this.tm_no_end = tm_no_end;
	}

	public int getDay_tm_pr_price() {
		return day_tm_pr_price;
	}

	public void setDay_tm_pr_price(int day_tm_pr_price) {
		this.day_tm_pr_price = day_tm_pr_price;
	}

	public int getSet_px_hr_no() {
		return set_px_hr_no;
	}

	public void setSet_px_hr_no(int set_px_hr_no) {
		this.set_px_hr_no = set_px_hr_no;
	}
	
	
}
