package cat1.profile.vo;

public class LfstyVO {
	private int lfsty_no;
	private String lfsty_item;
	
	
	public LfstyVO() {
		super();
	}


	public LfstyVO(int lfsty_no, String lfsty_item) {
		super();
		this.lfsty_no = lfsty_no;
		this.lfsty_item = lfsty_item;
	}


	public LfstyVO(String lfsty_item) {
		super();
		this.lfsty_item = lfsty_item;
	}


	public int getLfsty_no() {
		return lfsty_no;
	}


	public void setLfsty_no(int lfsty_no) {
		this.lfsty_no = lfsty_no;
	}


	public String getLfsty_item() {
		return lfsty_item;
	}


	public void setLfsty_item(String lfsty_item) {
		this.lfsty_item = lfsty_item;
	}


	



	
	
}
