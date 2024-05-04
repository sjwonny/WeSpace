package cat4.detail.vo;

public class DE_SP_ApVO { // 세부공간적용옵션

	private int de_sp_ap_no;
	private int spcrt_optn_no;
	private int de_sp_info_no;
	
	public DE_SP_ApVO() {

	}

	public DE_SP_ApVO(int de_sp_ap_no, int spcrt_optn_no, int de_sp_info_no) {
		super();
		this.de_sp_ap_no = de_sp_ap_no;
		this.spcrt_optn_no = spcrt_optn_no;
		this.de_sp_info_no = de_sp_info_no;
	}

	public int getDe_sp_ap_no() {
		return de_sp_ap_no;
	}

	public void setDe_sp_ap_no(int de_sp_ap_no) {
		this.de_sp_ap_no = de_sp_ap_no;
	}

	public int getSpcrt_optn_no() {
		return spcrt_optn_no;
	}

	public void setSpcrt_optn_no(int spcrt_optn_no) {
		this.spcrt_optn_no = spcrt_optn_no;
	}

	public int getDe_sp_info_no() {
		return de_sp_info_no;
	}

	public void setDe_sp_info_no(int de_sp_info_no) {
		this.de_sp_info_no = de_sp_info_no;
	}
	
	
}
