package cat3.bsns_info.vo;

public class Bsns_TypeVO {

	private int bsns_type_no;
	private String bsns_type_name;
	
	
	public Bsns_TypeVO() {
		super();
	}
	
	
	public Bsns_TypeVO(int bsns_type_no, String bsns_type_name) {
		super();
		this.bsns_type_no = bsns_type_no;
		this.bsns_type_name = bsns_type_name;
	}


	public int getBsns_type_no() {
		return bsns_type_no;
	}


	public void setBsns_type_no(int bsns_type_no) {
		this.bsns_type_no = bsns_type_no;
	}


	public String getBsns_type_name() {
		return bsns_type_name;
	}


	public void setBsns_type_name(String bsns_type_name) {
		this.bsns_type_name = bsns_type_name;
	}
	
	
	
	
}
