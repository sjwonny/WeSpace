package cat4.pckg.vo;

public class PCKG_PrcstVO { // 패키지단위가격설정

	private int pckg_prcst_no;
	private int de_sp_add_no;
	private int pckg_prcst_person;
	private int pckg_prcst_fee;
	
	public PCKG_PrcstVO() {

	}

	public PCKG_PrcstVO(int pckg_prcst_no, int de_sp_add_no, int pckg_prcst_person, int pckg_prcst_fee) {
		super();
		this.pckg_prcst_no = pckg_prcst_no;
		this.de_sp_add_no = de_sp_add_no;
		this.pckg_prcst_person = pckg_prcst_person;
		this.pckg_prcst_fee = pckg_prcst_fee;
	}

	public int getPckg_prcst_no() {
		return pckg_prcst_no;
	}

	public void setPckg_prcst_no(int pckg_prcst_no) {
		this.pckg_prcst_no = pckg_prcst_no;
	}

	public int getDe_sp_add_no() {
		return de_sp_add_no;
	}

	public void setDe_sp_add_no(int de_sp_add_no) {
		this.de_sp_add_no = de_sp_add_no;
	}

	public int getPckg_prcst_person() {
		return pckg_prcst_person;
	}

	public void setPckg_prcst_person(int pckg_prcst_person) {
		this.pckg_prcst_person = pckg_prcst_person;
	}

	public int getPckg_prcst_fee() {
		return pckg_prcst_fee;
	}

	public void setPckg_prcst_fee(int pckg_prcst_fee) {
		this.pckg_prcst_fee = pckg_prcst_fee;
	}
	
	
}
