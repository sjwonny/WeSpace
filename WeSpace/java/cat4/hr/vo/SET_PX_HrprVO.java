package cat4.hr.vo;

public class SET_PX_HrprVO { // 시간단위설정금액

	private int set_px_hrpr_no;
	private int day_tm_pr_no;
	private int set_px_hr_no;
	
	public SET_PX_HrprVO() {

	}

	public SET_PX_HrprVO(int set_px_hrpr_no, int day_tm_pr_no, int set_px_hr_no) {
		super();
		this.set_px_hrpr_no = set_px_hrpr_no;
		this.day_tm_pr_no = day_tm_pr_no;
		this.set_px_hr_no = set_px_hr_no;
	}

	public int getSet_px_hrpr_no() {
		return set_px_hrpr_no;
	}

	public void setSet_px_hrpr_no(int set_px_hrpr_no) {
		this.set_px_hrpr_no = set_px_hrpr_no;
	}

	public int getDay_tm_pr_no() {
		return day_tm_pr_no;
	}

	public void setDay_tm_pr_no(int day_tm_pr_no) {
		this.day_tm_pr_no = day_tm_pr_no;
	}

	public int getSet_px_hr_no() {
		return set_px_hr_no;
	}

	public void setSet_px_hr_no(int set_px_hr_no) {
		this.set_px_hr_no = set_px_hr_no;
	}
	
}
