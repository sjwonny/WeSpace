package cat4.hr.vo;

public class SET_PX_HrVO { // 시간단위가격설정

	private int set_px_hr_no;
	private int de_sp_add_no;
	private int set_px_hr_select;
	private int set_px_hr_person;
	private int set_px_hr_fee;
	
	public SET_PX_HrVO() {

	}

	public SET_PX_HrVO(int set_px_hr_no, int de_sp_add_no, int set_px_hr_select, int set_px_hr_person,
			int set_px_hr_fee) {
		super();
		this.set_px_hr_no = set_px_hr_no;
		this.de_sp_add_no = de_sp_add_no;
		this.set_px_hr_select = set_px_hr_select;
		this.set_px_hr_person = set_px_hr_person;
		this.set_px_hr_fee = set_px_hr_fee;
	}
	

	public int getSet_px_hr_no() {
		return set_px_hr_no;
	}

	public void setSet_px_hr_no(int set_px_hr_no) {
		this.set_px_hr_no = set_px_hr_no;
	}

	public int getDe_sp_add_no() {
		return de_sp_add_no;
	}

	public void setDe_sp_add_no(int de_sp_add_no) {
		this.de_sp_add_no = de_sp_add_no;
	}

	public int getSet_px_hr_select() {
		return set_px_hr_select;
	}

	public void setSet_px_hr_select(int set_px_hr_select) {
		this.set_px_hr_select = set_px_hr_select;
	}

	public int getSet_px_hr_person() {
		return set_px_hr_person;
	}

	public void setSet_px_hr_person(int set_px_hr_person) {
		this.set_px_hr_person = set_px_hr_person;
	}

	public int getSet_px_hr_fee() {
		return set_px_hr_fee;
	}

	public void setSet_px_hr_fee(int set_px_hr_fee) {
		this.set_px_hr_fee = set_px_hr_fee;
	}
	
	
}
