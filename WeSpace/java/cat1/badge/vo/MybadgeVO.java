package cat1.badge.vo;



public class MybadgeVO {
	private int mybadge_no;
	private int badge_no;
	private int guest_no;
	
	
	public MybadgeVO() {
		super();
	}


	public MybadgeVO(int mybadge_no, int badge_no, int guest_no) {
		super();
		this.mybadge_no = mybadge_no;
		this.badge_no = badge_no;
		this.guest_no = guest_no;
	}


	public MybadgeVO(int badge_no, int guest_no) {
		super();
		this.badge_no = badge_no;
		this.guest_no = guest_no;
	}


	public int getMybadge_no() {
		return mybadge_no;
	}


	public void setMybadge_no(int mybadge_no) {
		this.mybadge_no = mybadge_no;
	}


	public int getBadge_no() {
		return badge_no;
	}


	public void setBadge_no(int badge_no) {
		this.badge_no = badge_no;
	}


	public int getGuest_no() {
		return guest_no;
	}


	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}


	


}
