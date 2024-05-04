package cat4.detail.vo;

public class DE_SP_TyseVO { // 세부공간유형선택

	private int de_sp_tyse_no;
	private int de_sp_info_no;
	private int select_use_no;
	
	
	
	public DE_SP_TyseVO() {
		super();
	}
	public DE_SP_TyseVO(int de_sp_tyse_no, int de_sp_info_no, int select_use_no) {
		super();
		this.de_sp_tyse_no = de_sp_tyse_no;
		this.de_sp_info_no = de_sp_info_no;
		this.select_use_no = select_use_no;
	}
	public int getDe_sp_tyse_no() {
		return de_sp_tyse_no;
	}
	public void setDe_sp_tyse_no(int de_sp_tyse_no) {
		this.de_sp_tyse_no = de_sp_tyse_no;
	}
	public int getDe_sp_info_no() {
		return de_sp_info_no;
	}
	public void setDe_sp_info_no(int de_sp_info_no) {
		this.de_sp_info_no = de_sp_info_no;
	}
	public int getSelect_use_no() {
		return select_use_no;
	}
	public void setSelect_use_no(int select_use_no) {
		this.select_use_no = select_use_no;
	}
	

	
}
