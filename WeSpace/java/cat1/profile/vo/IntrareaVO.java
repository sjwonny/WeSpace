package cat1.profile.vo;

public class IntrareaVO {
	private int intrarea_no;
	private int detaarea_no;
	private int guest_no;
	
	
	
	
	
	public IntrareaVO() {
		super();
	}





	public IntrareaVO(int intrarea_no, int detaarea_no, int guest_no) {
		super();
		this.intrarea_no = intrarea_no;
		this.detaarea_no = detaarea_no;
		this.guest_no = guest_no;
	}





	public IntrareaVO(int detaarea_no, int guest_no) {
		super();
		this.detaarea_no = detaarea_no;
		this.guest_no = guest_no;
	}





	public int getIntrarea_no() {
		return intrarea_no;
	}





	public void setIntrarea_no(int intrarea_no) {
		this.intrarea_no = intrarea_no;
	}





	public int getDetaarea_no() {
		return detaarea_no;
	}





	public void setDetaarea_no(int detaarea_no) {
		this.detaarea_no = detaarea_no;
	}





	public int getGuest_no() {
		return guest_no;
	}





	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}


	
	
}
