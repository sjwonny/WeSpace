package all.vo;

public class Space_themeVO {

	private int space_theme_no;
	private String space_theme_name;
	private int space_type_no;
	
	public Space_themeVO() {
		super();
	}

	public Space_themeVO(int space_theme_no, String space_theme_name, int space_type_no) {
		super();
		this.space_theme_no = space_theme_no;
		this.space_theme_name = space_theme_name;
		this.space_type_no = space_type_no;
	}

	public int getSpace_theme_no() {
		return space_theme_no;
	}

	public void setSpace_theme_no(int space_theme_no) {
		this.space_theme_no = space_theme_no;
	}

	public String getSpace_theme_name() {
		return space_theme_name;
	}

	public void setSpace_theme_name(String space_theme_name) {
		this.space_theme_name = space_theme_name;
	}

	public int getSpace_type_no() {
		return space_type_no;
	}

	public void setSpace_type_no(int space_type_no) {
		this.space_type_no = space_type_no;
	}
	
}
