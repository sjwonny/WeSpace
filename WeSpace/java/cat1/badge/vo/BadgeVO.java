package cat1.badge.vo;



public class BadgeVO {
	private int badge_no;
	private String badge_name;
	private String badge_info;
	
	
	public BadgeVO() {
		super();
	}


	public BadgeVO(int badge_no, String badge_name, String badge_info) {
		super();
		this.badge_no = badge_no;
		this.badge_name = badge_name;
		this.badge_info = badge_info;
	}


	public BadgeVO(String badge_name, String badge_info) {
		super();
		this.badge_name = badge_name;
		this.badge_info = badge_info;
	}


	public int getBadge_no() {
		return badge_no;
	}


	public void setBadge_no(int badge_no) {
		this.badge_no = badge_no;
	}


	public String getBadge_name() {
		return badge_name;
	}


	public void setBadge_name(String badge_name) {
		this.badge_name = badge_name;
	}


	public String getBadge_info() {
		return badge_info;
	}


	public void setBadge_info(String badge_info) {
		this.badge_info = badge_info;
	}


}
