package cat3.space_reg.vo;

public class Basic_InfoVO {
	private int basic_info_no;
	private int space_info_no;
	private int contact_info_no;
	private int usage_info_no;
	private int bsns_info_no;
	private int host_no;
	private String rgst_date;
	
	
	public Basic_InfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Basic_InfoVO(int basic_info_no, int space_info_no, int contact_info_no, int usage_info_no, int bsns_info_no,
			int host_no, String rgst_date) {
		super();
		this.basic_info_no = basic_info_no;
		this.space_info_no = space_info_no;
		this.contact_info_no = contact_info_no;
		this.usage_info_no = usage_info_no;
		this.bsns_info_no = bsns_info_no;
		this.host_no = host_no;
		this.rgst_date = rgst_date;
	}
	public int getBasic_info_no() {
		return basic_info_no;
	}
	public void setBasic_info_no(int basic_info_no) {
		this.basic_info_no = basic_info_no;
	}
	public int getSpace_info_no() {
		return space_info_no;
	}
	public void setSpace_info_no(int space_info_no) {
		this.space_info_no = space_info_no;
	}
	public int getContact_info_no() {
		return contact_info_no;
	}
	public void setContact_info_no(int contact_info_no) {
		this.contact_info_no = contact_info_no;
	}
	public int getUsage_info_no() {
		return usage_info_no;
	}
	public void setUsage_info_no(int usage_info_no) {
		this.usage_info_no = usage_info_no;
	}
	public int getBsns_info_no() {
		return bsns_info_no;
	}
	public void setBsns_info_no(int bsns_info_no) {
		this.bsns_info_no = bsns_info_no;
	}
	public int getHost_no() {
		return host_no;
	}
	public void setHost_no(int host_no) {
		this.host_no = host_no;
	}
	public String getRgst_date() {
		return rgst_date;
	}
	public void setRgst_date(String rgst_date) {
		this.rgst_date = rgst_date;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
