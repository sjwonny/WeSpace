package all.vo;



import org.springframework.web.multipart.MultipartFile;

public class GuestVO {
	private int guest_no;
	private String guest_nickname;
	private String guest_email;
	private String guest_pw;
	private String guest_phone;
	private String guest_img;
	private String guest_name;
	private String guest_gndr;
	private String guest_birth;
	private int profile_no;
	private int status;
	
	private MultipartFile img;
	
	
	//이미지까지 넣은 애 
	public GuestVO(int guest_no, String guest_nickname, String guest_email, String guest_pw, String guest_phone,
			String guest_img,String guest_name, String guest_gndr,
			String guest_birth, int profile_no,int status, MultipartFile img) {
		super();
		this.guest_no = guest_no;
		this.guest_nickname = guest_nickname;
		this.guest_email = guest_email;
		this.guest_pw = guest_pw;
		this.guest_phone = guest_phone;
		this.guest_img = guest_img;
		this.guest_name = guest_name;
		this.guest_gndr = guest_gndr;
		this.guest_birth = guest_birth;
		this.profile_no = profile_no;
		this.status = status;
		this.img = img;
	}



	public GuestVO() {
		super();
	}



	public GuestVO(int guest_no, String guest_nickname, String guest_email, String guest_pw, String guest_phone,
			String guest_img, String guest_name, String guest_gndr,
			String guest_birth,int profile_no,int status) {
		super();
		this.guest_no = guest_no;
		this.guest_nickname = guest_nickname;
		this.guest_email = guest_email;
		this.guest_pw = guest_pw;
		this.guest_phone = guest_phone;
		this.guest_img = guest_img;
		this.guest_name = guest_name;
		this.guest_gndr = guest_gndr;
		this.guest_birth = guest_birth;
		this.profile_no = profile_no;
		this.status = status;
	}



	public GuestVO(String guest_nickname, String guest_email, String guest_pw, String guest_phone, String guest_img,
			String guest_name, String guest_gndr, String guest_birth,
			int profile_no, int status) {
		super();
		this.guest_nickname = guest_nickname;
		this.guest_email = guest_email;
		this.guest_pw = guest_pw;
		this.guest_phone = guest_phone;
		this.guest_img = guest_img;
		this.guest_name = guest_name;
		this.guest_gndr = guest_gndr;
		this.guest_birth = guest_birth;
		this.profile_no = profile_no;
		this.status = status;
	}



	public int getGuest_no() {
		return guest_no;
	}



	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}



	public String getGuest_nickname() {
		return guest_nickname;
	}



	public void setGuest_nickname(String guest_nickname) {
		this.guest_nickname = guest_nickname;
	}



	public String getGuest_email() {
		return guest_email;
	}



	public void setGuest_email(String guest_email) {
		this.guest_email = guest_email;
	}



	public String getGuest_pw() {
		return guest_pw;
	}



	public void setGuest_pw(String guest_pw) {
		this.guest_pw = guest_pw;
	}



	public String getGuest_phone() {
		return guest_phone;
	}



	public void setGuest_phone(String guest_phone) {
		this.guest_phone = guest_phone;
	}



	public String getGuest_img() {
		return guest_img;
	}



	public void setGuest_img(String guest_img) {
		this.guest_img = guest_img;
	}




	public String getGuest_name() {
		return guest_name;
	}



	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}



	public String getGuest_gndr() {
		return guest_gndr;
	}



	public void setGuest_gndr(String guest_gndr) {
		this.guest_gndr = guest_gndr;
	}



	public String getGuest_birth() {
		return guest_birth;
	}



	public void setGuest_birth(String guest_birth) {
		this.guest_birth = guest_birth;
	}



	public int getProfile_no() {
		return profile_no;
	}



	public void setProfile_no(int profile_no) {
		this.profile_no = profile_no;
	}



	public MultipartFile getImg() { //이미지 게터 세터도 만듦
		return img;
	}



	public void setImg(MultipartFile img) {
		this.img = img;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}


	
}
