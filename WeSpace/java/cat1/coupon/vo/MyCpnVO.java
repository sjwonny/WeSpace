package cat1.coupon.vo;

import java.util.Date;

public class MyCpnVO {
	private int mycpn_no;
	private int mycpn_status;
	private String mycpn_date;
	private int guest_no;
	private int cpn_no;
	
	
	public MyCpnVO() {
		super();
	}


	public MyCpnVO(int mycpn_no, int mycpn_status, String mycpn_date, int guest_no, int cpn_no) {
		super();
		this.mycpn_no = mycpn_no;
		this.mycpn_status = mycpn_status;
		this.mycpn_date = mycpn_date;
		this.guest_no = guest_no;
		this.cpn_no = cpn_no;
	}


	public MyCpnVO(int mycpn_status, String mycpn_date, int guest_no, int cpn_no) {
		super();
		this.mycpn_status = mycpn_status;
		this.mycpn_date = mycpn_date;
		this.guest_no = guest_no;
		this.cpn_no = cpn_no;
	}


	public int getMycpn_no() {
		return mycpn_no;
	}


	public void setMycpn_no(int mycpn_no) {
		this.mycpn_no = mycpn_no;
	}


	public int getMycpn_status() {
		return mycpn_status;
	}


	public void setMycpn_status(int mycpn_status) {
		this.mycpn_status = mycpn_status;
	}


	public String getMycpn_date() {
		return mycpn_date;
	}


	public void setMycpn_date(String mycpn_date) {
		this.mycpn_date = mycpn_date;
	}


	public int getGuest_no() {
		return guest_no;
	}


	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}


	public int getCpn_no() {
		return cpn_no;
	}


	public void setCpn_no(int cpn_no) {
		this.cpn_no = cpn_no;
	}

	
	
}
