package all.vo;

public class TmVO { // 시간

	private int tm_no;
	private String tm_time;

	public TmVO() {
		super();
	}

	public TmVO(int tm_no, String tm_time) {
		super();
		this.tm_no = tm_no;
		this.tm_time = tm_time;
	}

	public int getTm_no() {
		return tm_no;
	}

	public void setTm_no(int tm_no) {
		this.tm_no = tm_no;
	}

	public String getTm_time() {
		return tm_time;
	}

	public void setTm_time(String tm_time) {
		this.tm_time = tm_time;
	}
	
	
}
