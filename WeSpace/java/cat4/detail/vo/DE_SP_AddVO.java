package cat4.detail.vo;

public class DE_SP_AddVO { //세부공간추가

	private int de_sp_add_no;
	private int de_sp_info_no;
	private int basic_info_no;
	private int status;
	
	public DE_SP_AddVO() {

	}

	public DE_SP_AddVO(int de_sp_add_no, int de_sp_info_no, int basic_info_no, int status) {
		super();
		this.de_sp_add_no = de_sp_add_no;
		this.de_sp_info_no = de_sp_info_no;
		this.basic_info_no = basic_info_no;
		this.status = status;
	}

	public int getDe_sp_add_no() {
		return de_sp_add_no;
	}

	public void setDe_sp_add_no(int de_sp_add_no) {
		this.de_sp_add_no = de_sp_add_no;
	}

	public int getDe_sp_info_no() {
		return de_sp_info_no;
	}

	public void setDe_sp_info_no(int de_sp_info_no) {
		this.de_sp_info_no = de_sp_info_no;
	}

	public int getBasic_info_no() {
		return basic_info_no;
	}

	public void setBasic_info_no(int basic_info_no) {
		this.basic_info_no = basic_info_no;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
