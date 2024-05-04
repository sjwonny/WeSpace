package all.vo;

public class Space_typeVO {

	private int space_type_no;
	private String space_type_name;
	private int space_type_cat;
	
	public Space_typeVO() {
		super();
	}
	
	public Space_typeVO(int space_type_no, String space_type_name, int space_type_cat) {
		super();
		this.space_type_no = space_type_no;
		this.space_type_name = space_type_name;
		this.space_type_cat = space_type_cat;
	}
	
	public int getSpace_type_no() {
		return space_type_no;
	}
	
	public void setSpace_type_no(int space_type_no) {
		this.space_type_no = space_type_no;
	}
	
	public String getSpace_type_name() {
		return space_type_name;
	}
	
	public void setSpace_type_name(String space_type_name) {
		this.space_type_name = space_type_name;
	}

	public int getSpace_type_cat() {
		return space_type_cat;
	}

	public void setSpace_type_cat(int space_type_cat) {
		this.space_type_cat = space_type_cat;
	}
	
	

	
}
