package cat3.space_reg.vo;

public class Usage_InfoVO {
	private int usage_info_no;
	private int tm_no_start;
	private int tm_no_end;
	private String usage_info_floor;
	private int usage_info_park;
	private int usage_info_elvtr;
	
	public Usage_InfoVO(int usage_info_no, int tm_no_start, int tm_no_end, String usage_info_floor, int usage_info_park,
			int usage_info_elvtr) {
		super();
		this.usage_info_no = usage_info_no;
		this.tm_no_start = tm_no_start;
		this.tm_no_end = tm_no_end;
		this.usage_info_floor = usage_info_floor;
		this.usage_info_park = usage_info_park;
		this.usage_info_elvtr = usage_info_elvtr;
	}
	public Usage_InfoVO() {
		super();
	}
	public int getUsage_info_no() {
		return usage_info_no;
	}
	public void setUsage_info_no(int usage_info_no) {
		this.usage_info_no = usage_info_no;
	}
	public int getTm_no_start() {
		return tm_no_start;
	}
	public void setTm_no_start(int tm_no_start) {
		this.tm_no_start = tm_no_start;
	}
	public int getTm_no_end() {
		return tm_no_end;
	}
	public void setTm_no_end(int tm_no_end) {
		this.tm_no_end = tm_no_end;
	}
	public String getUsage_info_floor() {
		return usage_info_floor;
	}
	public void setUsage_info_floor(String usage_info_floor) {
		this.usage_info_floor = usage_info_floor;
	}
	public int getUsage_info_park() {
		return usage_info_park;
	}
	public void setUsage_info_park(int usage_info_park) {
		this.usage_info_park = usage_info_park;
	}
	public int getUsage_info_elvtr() {
		return usage_info_elvtr;
	}
	public void setUsage_info_elvtr(int usage_info_elvtr) {
		this.usage_info_elvtr = usage_info_elvtr;
	}

	
	
	
	
	
}
