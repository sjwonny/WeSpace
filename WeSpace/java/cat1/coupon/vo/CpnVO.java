package cat1.coupon.vo;

import java.util.Date;

public class CpnVO {
	private int cpn_no;
	private String cpn_name;
	private int cpn_price;
	private String cpn_miniper;
	private int cpn_cnt;
	private String cpn_per;
	private String cpn_type;
	
	
	public CpnVO() {
		super();
	}


	public CpnVO(int cpn_no,String cpn_name, int cpn_price, String cpn_miniper, int cpn_cnt,
			String cpn_per, String cpn_type) {
		super();
		this.cpn_no = cpn_no;
		this.cpn_name = cpn_name;
		this.cpn_price = cpn_price;
		this.cpn_miniper = cpn_miniper;
		this.cpn_cnt = cpn_cnt;
		this.cpn_per = cpn_per;
		this.cpn_type = cpn_type;
	}


	public CpnVO(String cpn_name, int cpn_price, String cpn_miniper, int cpn_cnt, String cpn_per,
			String cpn_type) {
		super();
		this.cpn_name = cpn_name;
		this.cpn_price = cpn_price;
		this.cpn_miniper = cpn_miniper;
		this.cpn_cnt = cpn_cnt;
		this.cpn_per = cpn_per;
		this.cpn_type = cpn_type;
	}


	public int getCpn_no() {
		return cpn_no;
	}


	public void setCpn_no(int cpn_no) {
		this.cpn_no = cpn_no;
	}


	public String getCpn_name() {
		return cpn_name;
	}


	public void setCpn_name(String cpn_name) {
		this.cpn_name = cpn_name;
	}


	public int getCpn_price() {
		return cpn_price;
	}


	public void setCpn_price(int cpn_price) {
		this.cpn_price = cpn_price;
	}


	public String getCpn_miniper() {
		return cpn_miniper;
	}


	public void setCpn_miniper(String cpn_miniper) {
		this.cpn_miniper = cpn_miniper;
	}


	public int getCpn_cnt() {
		return cpn_cnt;
	}


	public void setCpn_cnt(int cpn_cnt) {
		this.cpn_cnt = cpn_cnt;
	}


	public String getCpn_per() {
		return cpn_per;
	}


	public void setCpn_per(String cpn_per) {
		this.cpn_per = cpn_per;
	}


	public String getCpn_type() {
		return cpn_type;
	}


	public void setCpn_type(String cpn_type) {
		this.cpn_type = cpn_type;
	}



	
	
}
