package cat2.rsrvt.vo;

public class RsrvtVO {
	private int rsrvt_no;
	private String rsrvt_dateAplct;
	private int client_no;
	private int guest_no;
	private int de_sp_info;
	private int rsrvt_amnt;
	private String rsrvt_date;
	private String rsrvt_time;
	private int rsrvt_prsnl;
	private String rsrvt_status;
	
	
	public RsrvtVO() {
		super();
	}


	public RsrvtVO(int rsrvt_no, String rsrvt_dateAplct, int client_no, int guest_no, int de_sp_info, int rsrvt_amnt,
			String rsrvt_date, String rsrvt_time, int rsrvt_prsnl, String rsrvt_status) {
		super();
		this.rsrvt_no = rsrvt_no;
		this.rsrvt_dateAplct = rsrvt_dateAplct;
		this.client_no = client_no;
		this.guest_no = guest_no;
		this.de_sp_info = de_sp_info;
		this.rsrvt_amnt = rsrvt_amnt;
		this.rsrvt_date = rsrvt_date;
		this.rsrvt_time = rsrvt_time;
		this.rsrvt_prsnl = rsrvt_prsnl;
		this.rsrvt_status = rsrvt_status;
	}


	public RsrvtVO(String rsrvt_dateAplct, int client_no, int guest_no, int de_sp_info, int rsrvt_amnt,
			String rsrvt_date, String rsrvt_time, int rsrvt_prsnl, String rsrvt_status) {
		super();
		this.rsrvt_dateAplct = rsrvt_dateAplct;
		this.client_no = client_no;
		this.guest_no = guest_no;
		this.de_sp_info = de_sp_info;
		this.rsrvt_amnt = rsrvt_amnt;
		this.rsrvt_date = rsrvt_date;
		this.rsrvt_time = rsrvt_time;
		this.rsrvt_prsnl = rsrvt_prsnl;
		this.rsrvt_status = rsrvt_status;
	}


	public int getRsrvt_no() {
		return rsrvt_no;
	}


	public void setRsrvt_no(int rsrvt_no) {
		this.rsrvt_no = rsrvt_no;
	}


	public String getRsrvt_dateAplct() {
		return rsrvt_dateAplct;
	}


	public void setRsrvt_dateAplct(String rsrvt_dateAplct) {
		this.rsrvt_dateAplct = rsrvt_dateAplct;
	}


	public int getClient_no() {
		return client_no;
	}


	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}


	public int getGuest_no() {
		return guest_no;
	}


	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}


	public int getDe_sp_info() {
		return de_sp_info;
	}


	public void setDe_sp_info(int de_sp_info) {
		this.de_sp_info = de_sp_info;
	}


	public int getRsrvt_amnt() {
		return rsrvt_amnt;
	}


	public void setRsrvt_amnt(int rsrvt_amnt) {
		this.rsrvt_amnt = rsrvt_amnt;
	}


	public String getRsrvt_date() {
		return rsrvt_date;
	}


	public void setRsrvt_date(String rsrvt_date) {
		this.rsrvt_date = rsrvt_date;
	}


	public String getRsrvt_time() {
		return rsrvt_time;
	}


	public void setRsrvt_time(String rsrvt_time) {
		this.rsrvt_time = rsrvt_time;
	}


	public int getRsrvt_prsnl() {
		return rsrvt_prsnl;
	}


	public void setRsrvt_prsnl(int rsrvt_prsnl) {
		this.rsrvt_prsnl = rsrvt_prsnl;
	}


	public String getRsrvt_status() {
		return rsrvt_status;
	}


	public void setRsrvt_status(String rsrvt_status) {
		this.rsrvt_status = rsrvt_status;
	}


	
}
