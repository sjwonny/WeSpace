package cat1.profile.vo;

public class DetaareaVO {
	private int detaarea_no;
	private String detaarea_city;
	private String detaarea_detail;
	
	
	public DetaareaVO() {
		super();
	}


	public DetaareaVO(int detaarea_no, String detaarea_city, String detaarea_detail) {
		super();
		this.detaarea_no = detaarea_no;
		this.detaarea_city = detaarea_city;
		this.detaarea_detail = detaarea_detail;
	}


	public DetaareaVO(String detaarea_city, String detaarea_detail) {
		super();
		this.detaarea_city = detaarea_city;
		this.detaarea_detail = detaarea_detail;
	}


	public int getDetaarea_no() {
		return detaarea_no;
	}


	public void setDetaarea_no(int detaarea_no) {
		this.detaarea_no = detaarea_no;
	}


	public String getDetaarea_city() {
		return detaarea_city;
	}


	public void setDetaarea_city(String detaarea_city) {
		this.detaarea_city = detaarea_city;
	}


	public String getDetaarea_detail() {
		return detaarea_detail;
	}


	public void setDetaarea_detail(String detaarea_detail) {
		this.detaarea_detail = detaarea_detail;
	}



	
	
}
