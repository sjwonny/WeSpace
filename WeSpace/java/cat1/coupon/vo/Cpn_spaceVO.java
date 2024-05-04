package cat1.coupon.vo;


public class Cpn_spaceVO {
	private int cpn_space_no;
	private int cpn_no;
	private int space_info_no;
	
	public Cpn_spaceVO() {
		super();
	}

	public Cpn_spaceVO(int cpn_space_no, int cpn_no, int space_info_no) {
		super();
		this.cpn_space_no = cpn_space_no;
		this.cpn_no = cpn_no;
		this.space_info_no = space_info_no;
	}

	public Cpn_spaceVO(int cpn_no, int space_info_no) {
		super();
		this.cpn_no = cpn_no;
		this.space_info_no = space_info_no;
	}

	public int getCpn_space_no() {
		return cpn_space_no;
	}

	public void setCpn_space_no(int cpn_space_no) {
		this.cpn_space_no = cpn_space_no;
	}

	public int getCpn_no() {
		return cpn_no;
	}

	public void setCpn_no(int cpn_no) {
		this.cpn_no = cpn_no;
	}

	public int getSpace_info_no() {
		return space_info_no;
	}

	public void setSpace_info_no(int space_info_no) {
		this.space_info_no = space_info_no;
	}


	



	
	
}
