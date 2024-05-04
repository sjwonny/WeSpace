package cat1.profile.vo;

public class InterestVO {
	private int interest_no;
	private int lfsty_no;
	private int guest_no;
	
	
	public InterestVO() {
		super();
	}


	public InterestVO(int interest_no, int lfsty_no, int guest_no) {
		super();
		this.interest_no = interest_no;
		this.lfsty_no = lfsty_no;
		this.guest_no = guest_no;
	}


	public InterestVO(int lfsty_no, int guest_no) {
		super();
		this.lfsty_no = lfsty_no;
		this.guest_no = guest_no;
	}


	public int getInterest_no() {
		return interest_no;
	}


	public void setInterest_no(int interest_no) {
		this.interest_no = interest_no;
	}


	public int getLfsty_no() {
		return lfsty_no;
	}


	public void setLfsty_no(int lfsty_no) {
		this.lfsty_no = lfsty_no;
	}


	public int getGuest_no() {
		return guest_no;
	}


	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}



	
	
}
