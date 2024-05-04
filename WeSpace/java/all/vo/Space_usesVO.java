package all.vo;

public class Space_usesVO {

	private int space_uses_no;
	private String space_uses_name;
	private int space_type_no;
	private String space_icon;
	
	public Space_usesVO() {
		super();
	}
	
	public Space_usesVO(int space_uses_no, String space_uses_name, int space_type_no, String space_icon) {
		super();
		this.space_uses_no = space_uses_no;
		this.space_uses_name = space_uses_name;
		this.space_type_no = space_type_no;
		this.space_icon = space_icon;
	}
	
	public int getSpace_uses_no() {
		return space_uses_no;
	}
	public void setSpace_uses_no(int space_uses_no) {
		this.space_uses_no = space_uses_no;
	}
	public String getSpace_uses_name() {
		return space_uses_name;
	}
	public void setSpace_uses_name(String space_uses_name) {
		this.space_uses_name = space_uses_name;
	}
	public int getSpace_type_no() {
		return space_type_no;
	}
	public void setSpace_type_no(int space_type_no) {
		this.space_type_no = space_type_no;
	}
	public String getSpace_icon() {
		return space_icon;
	}
	public void setSpace_icon(String space_icon) {
		this.space_icon = space_icon;
	}
	
}
