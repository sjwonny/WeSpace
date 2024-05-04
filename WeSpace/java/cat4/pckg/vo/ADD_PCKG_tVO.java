package cat4.pckg.vo;

public class ADD_PCKG_tVO { // 패키지시간추가

	private int add_pckg_t_no;
	private int tm_no_start;
	private int tm_no_end;
	private int pckg_prcst_no;
	private String add_pckg_t_name;
	
	public ADD_PCKG_tVO() {

	}

	public ADD_PCKG_tVO(int add_pckg_t_no, int tm_no_start, int tm_no_end, int pckg_prcst_no, String add_pckg_t_name) {
		super();
		this.add_pckg_t_no = add_pckg_t_no;
		this.tm_no_start = tm_no_start;
		this.tm_no_end = tm_no_end;
		this.pckg_prcst_no = pckg_prcst_no;
		this.add_pckg_t_name = add_pckg_t_name;
	}

	public int getAdd_pckg_t_no() {
		return add_pckg_t_no;
	}

	public void setAdd_pckg_t_no(int add_pckg_t_no) {
		this.add_pckg_t_no = add_pckg_t_no;
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

	public int getPckg_prcst_no() {
		return pckg_prcst_no;
	}

	public void setPckg_prcst_no(int pckg_prcst_no) {
		this.pckg_prcst_no = pckg_prcst_no;
	}

	public String getAdd_pckg_t_name() {
		return add_pckg_t_name;
	}

	public void setAdd_pckg_t_name(String add_pckg_t_name) {
		this.add_pckg_t_name = add_pckg_t_name;
	}
	
	
}
