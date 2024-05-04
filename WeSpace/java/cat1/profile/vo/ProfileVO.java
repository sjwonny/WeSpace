package cat1.profile.vo;

public class ProfileVO {
	private int profile_no;
	private String profile_item;
	
	
	public ProfileVO() {
		super();
	}


	public ProfileVO(int profile_no, String profile_item) {
		super();
		this.profile_no = profile_no;
		this.profile_item = profile_item;
	}


	public ProfileVO(String profile_item) {
		super();
		this.profile_item = profile_item;
	}


	public int getProfile_no() {
		return profile_no;
	}


	public void setProfile_no(int profile_no) {
		this.profile_no = profile_no;
	}


	public String getProfile_item() {
		return profile_item;
	}


	public void setProfile_item(String profile_item) {
		this.profile_item = profile_item;
	}


	
	
}
