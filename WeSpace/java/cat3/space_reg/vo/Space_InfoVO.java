package cat3.space_reg.vo;

import org.springframework.web.multipart.MultipartFile;

public class Space_InfoVO {
	private int space_info_no;
	private String space_info_name;
	private String space_info_tip;
	private String space_info_intrd;
	private String space_info_repimg;
	private String space_info_adr;
	private String space_info_adrinfo;
	private String space_info_url;
	private int space_theme_no;
	
	private MultipartFile photo;
	
	
	
	
	public Space_InfoVO(int space_info_no, String space_info_name, String space_info_tip, String space_info_intrd,
			String space_info_repimg, String space_info_adr, String space_info_adrinfo, String space_info_url,
			int space_theme_no, MultipartFile photo) {
		super();
		this.space_info_no = space_info_no;
		this.space_info_name = space_info_name;
		this.space_info_tip = space_info_tip;
		this.space_info_intrd = space_info_intrd;
		this.space_info_repimg = space_info_repimg;
		this.space_info_adr = space_info_adr;
		this.space_info_adrinfo = space_info_adrinfo;
		this.space_info_url = space_info_url;
		this.space_theme_no = space_theme_no;
		this.photo = photo;
	}
	
	
	public Space_InfoVO(int space_info_no, String space_info_name, String space_info_tip, String space_info_intrd,
			String space_info_repimg, String space_info_adr, String space_info_adrinfo, String space_info_url,
			int space_theme_no) {
		super();
		this.space_info_no = space_info_no;
		this.space_info_name = space_info_name;
		this.space_info_tip = space_info_tip;
		this.space_info_intrd = space_info_intrd;
		this.space_info_repimg = space_info_repimg;
		this.space_info_adr = space_info_adr;
		this.space_info_adrinfo = space_info_adrinfo;
		this.space_info_url = space_info_url;
		this.space_theme_no = space_theme_no;
	}
	
	public Space_InfoVO( String space_info_name, String space_info_tip, String space_info_intrd,
			String space_info_repimg, String space_info_adr, String space_info_adrinfo, String space_info_url,
			int space_theme_no) {
		super();
		this.space_info_name = space_info_name;
		this.space_info_tip = space_info_tip;
		this.space_info_intrd = space_info_intrd;
		this.space_info_repimg = space_info_repimg;
		this.space_info_adr = space_info_adr;
		this.space_info_adrinfo = space_info_adrinfo;
		this.space_info_url = space_info_url;
		this.space_theme_no = space_theme_no;
	}
	
	
	
	public Space_InfoVO() {
		super();
	}
	
	
	
	public int getSpace_info_no() {
		return space_info_no;
	}
	public void setSpace_info_no(int space_info_no) {
		this.space_info_no = space_info_no;
	}
	public String getSpace_info_name() {
		return space_info_name;
	}
	public void setSpace_info_name(String space_info_name) {
		this.space_info_name = space_info_name;
	}
	public String getSpace_info_tip() {
		return space_info_tip;
	}
	public void setSpace_info_tip(String space_info_tip) {
		this.space_info_tip = space_info_tip;
	}
	public String getSpace_info_intrd() {
		return space_info_intrd;
	}
	public void setSpace_info_intrd(String space_info_intrd) {
		this.space_info_intrd = space_info_intrd;
	}
	public String getSpace_info_repimg() {
		return space_info_repimg;
	}
	public void setSpace_info_repimg(String space_info_repimg) {
		this.space_info_repimg = space_info_repimg;
	}
	public String getSpace_info_adr() {
		return space_info_adr;
	}
	public void setSpace_info_adr(String space_info_adr) {
		this.space_info_adr = space_info_adr;
	}
	public String getSpace_info_adrinfo() {
		return space_info_adrinfo;
	}
	public void setSpace_info_adrinfo(String space_info_adrinfo) {
		this.space_info_adrinfo = space_info_adrinfo;
	}
	public String getSpace_info_url() {
		return space_info_url;
	}
	public void setSpace_info_url(String space_info_url) {
		this.space_info_url = space_info_url;
	}
	public int getSpace_theme_no() {
		return space_theme_no;
	}
	public void setSpace_theme_no(int space_theme_no) {
		this.space_theme_no = space_theme_no;
	}


	public MultipartFile getPhoto() {
		return photo;
	}


	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	
	
	
	
	
	
	
	
}
