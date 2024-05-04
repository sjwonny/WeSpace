package all.vo;

public class FACILITY_SelVO { // 편의시설선택

	private int facility_sel_no;
	private int de_sp_add_no;
	private int facility_no;
	
	public FACILITY_SelVO() {

	}

	public FACILITY_SelVO(int facility_sel_no, int de_sp_add_no, int facility_no) {
		super();
		this.facility_sel_no = facility_sel_no;
		this.de_sp_add_no = de_sp_add_no;
		this.facility_no = facility_no;
	}

	public int getFacility_sel_no() {
		return facility_sel_no;
	}

	public void setFacility_sel_no(int facility_sel_no) {
		this.facility_sel_no = facility_sel_no;
	}

	public int getDe_sp_add_no() {
		return de_sp_add_no;
	}

	public void setDe_sp_add_no(int de_sp_add_no) {
		this.de_sp_add_no = de_sp_add_no;
	}

	public int getFacility_no() {
		return facility_no;
	}

	public void setFacility_no(int facility_no) {
		this.facility_no = facility_no;
	}
	
	
	
}
