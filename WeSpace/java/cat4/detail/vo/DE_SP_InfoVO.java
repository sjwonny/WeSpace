package cat4.detail.vo;

import org.springframework.web.multipart.MultipartFile;

public class DE_SP_InfoVO { //세부공간정보

	private int de_sp_info_no;
	private String de_sp_info_name;
	private String de_sp_info_exp;
	private int de_sp_info_area;
	private String de_sp_info_img;
	private int de_sp_info_mintime;
	private int de_sp_info_minPerson;
	private int de_sp_info_maxPerson;
	
	private MultipartFile photo;
	
	public DE_SP_InfoVO() {

	}

	public DE_SP_InfoVO(int de_sp_info_no, String de_sp_info_name, String de_sp_info_exp,
			int de_sp_info_area, String de_sp_info_img, int de_sp_info_mintime, int de_sp_info_minPerson,
			int de_sp_info_maxPerson,MultipartFile photo) {
		super();
		this.de_sp_info_no = de_sp_info_no;
		this.de_sp_info_name = de_sp_info_name;
		this.de_sp_info_exp = de_sp_info_exp;
		this.de_sp_info_area = de_sp_info_area;
		this.de_sp_info_img = de_sp_info_img;
		this.de_sp_info_mintime = de_sp_info_mintime;
		this.de_sp_info_minPerson = de_sp_info_minPerson;
		this.de_sp_info_maxPerson = de_sp_info_maxPerson;
		this.photo = photo;
	}

	public int getDe_sp_info_no() {
		return de_sp_info_no;
	}

	public void setDe_sp_info_no(int de_sp_info_no) {
		this.de_sp_info_no = de_sp_info_no;
	}


	public String getDe_sp_info_name() {
		return de_sp_info_name;
	}

	public void setDe_sp_info_name(String de_sp_info_name) {
		this.de_sp_info_name = de_sp_info_name;
	}

	public String getDe_sp_info_exp() {
		return de_sp_info_exp;
	}

	public void setDe_sp_info_exp(String de_sp_info_exp) {
		this.de_sp_info_exp = de_sp_info_exp;
	}

	public int getDe_sp_info_area() {
		return de_sp_info_area;
	}

	public void setDe_sp_info_area(int de_sp_info_area) {
		this.de_sp_info_area = de_sp_info_area;
	}

	public String getDe_sp_info_img() {
		return de_sp_info_img;
	}

	public void setDe_sp_info_img(String de_sp_info_img) {
		this.de_sp_info_img = de_sp_info_img;
	}

	public int getDe_sp_info_mintime() {
		return de_sp_info_mintime;
	}

	public void setDe_sp_info_mintime(int de_sp_info_mintime) {
		this.de_sp_info_mintime = de_sp_info_mintime;
	}

	public int getDe_sp_info_minPerson() {
		return de_sp_info_minPerson;
	}

	public void setDe_sp_info_minPerson(int de_sp_info_minPerson) {
		this.de_sp_info_minPerson = de_sp_info_minPerson;
	}

	public int getDe_sp_info_maxPerson() {
		return de_sp_info_maxPerson;
	}

	public void setDe_sp_info_maxPerson(int de_sp_info_maxPerson) {
		this.de_sp_info_maxPerson = de_sp_info_maxPerson;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	
}
