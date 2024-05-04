package cat4.detail.vo;

import org.springframework.web.multipart.MultipartFile;

public class DE_SP_ImgVO { //세부공간이미지

	private int de_sp_img_no;
	private int de_sp_info_no;
	private String de_sp_img_addr;
	
	private MultipartFile[] dephoto;	
	
	
	public DE_SP_ImgVO() {

	}

	public DE_SP_ImgVO(int de_sp_img_no, int de_sp_info_no, String de_sp_img_addr, MultipartFile[] dephoto) {
		super();
		this.de_sp_img_no = de_sp_img_no;
		this.de_sp_info_no = de_sp_info_no;
		this.de_sp_img_addr = de_sp_img_addr;
		this.dephoto = dephoto;
	}

	public int getDe_sp_img_no() {
		return de_sp_img_no;
	}

	public void setDe_sp_img_no(int de_sp_img_no) {
		this.de_sp_img_no = de_sp_img_no;
	}

	public int getDe_sp_info_no() {
		return de_sp_info_no;
	}

	public void setDe_sp_info_no(int de_sp_info_no) {
		this.de_sp_info_no = de_sp_info_no;
	}

	public String getDe_sp_img_addr() {
		return de_sp_img_addr;
	}

	public void setDe_sp_img_addr(String de_sp_img_addr) {
		this.de_sp_img_addr = de_sp_img_addr;
	}

	public MultipartFile[] getDephoto() {
		return dephoto;
	}

	public void setDephoto(MultipartFile[] dephoto) {
		this.dephoto = dephoto;
	}
	
	
	
}
