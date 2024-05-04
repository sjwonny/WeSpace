package all.vo;

import org.springframework.web.multipart.MultipartFile;

public class HostVO {
	private int host_no;
	private String host_nick;
	private String host_email;
	private String host_pw;
	private String host_phone;
	private String host_img;
	private int email_agree;
	private int sns_agree;
	private int snscnnt_agree;
	private String host_name;
	private String host_gender;
	private String host_birth;
	
	private MultipartFile img;
	
	//이미지까지 넣은 애
	
	public HostVO() {
		super();
	}

	public HostVO(int host_no, String host_nick, String host_email, String host_pw, String host_phone, String host_img,
			int email_agree, int sns_agree, int snscnnt_agree, String host_name, String host_gender, String host_birth,
			MultipartFile img) {
		super();
		this.host_no = host_no;
		this.host_nick = host_nick;
		this.host_email = host_email;
		this.host_pw = host_pw;
		this.host_phone = host_phone;
		this.host_img = host_img;
		this.email_agree = email_agree;
		this.sns_agree = sns_agree;
		this.snscnnt_agree = snscnnt_agree;
		this.host_name = host_name;
		this.host_gender = host_gender;
		this.host_birth = host_birth;
		this.img = img;
	}

	public HostVO(int host_no, String host_nick, String host_email, String host_pw, String host_phone, String host_img,
			int email_agree, int sns_agree, int snscnnt_agree, String host_name, String host_gender,
			String host_birth) {
		super();
		this.host_no = host_no;
		this.host_nick = host_nick;
		this.host_email = host_email;
		this.host_pw = host_pw;
		this.host_phone = host_phone;
		this.host_img = host_img;
		this.email_agree = email_agree;
		this.sns_agree = sns_agree;
		this.snscnnt_agree = snscnnt_agree;
		this.host_name = host_name;
		this.host_gender = host_gender;
		this.host_birth = host_birth;
	}
	
	
	
	
	public HostVO(String host_nick, String host_email, String host_pw, String host_phone, String host_img,
			int email_agree, int sns_agree, int snscnnt_agree, String host_name, String host_gender,
			String host_birth) {
		super();
		this.host_nick = host_nick;
		this.host_email = host_email;
		this.host_pw = host_pw;
		this.host_phone = host_phone;
		this.host_img = host_img;
		this.email_agree = email_agree;
		this.sns_agree = sns_agree;
		this.snscnnt_agree = snscnnt_agree;
		this.host_name = host_name;
		this.host_gender = host_gender;
		this.host_birth = host_birth;
	}

	public int getHost_no() {
		return host_no;
	}
	public void setHost_no(int host_no) {
		this.host_no = host_no;
	}
	public String getHost_nick() {
		return host_nick;
	}
	public void setHost_nick(String host_nick) {
		this.host_nick = host_nick;
	}
	public String getHost_email() {
		return host_email;
	}
	public void setHost_email(String host_email) {
		this.host_email = host_email;
	}
	public String getHost_pw() {
		return host_pw;
	}
	public void setHost_pw(String host_pw) {
		this.host_pw = host_pw;
	}
	public String getHost_phone() {
		return host_phone;
	}
	public void setHost_phone(String host_phone) {
		this.host_phone = host_phone;
	}
	public String getHost_img() {
		return host_img;
	}
	public void setHost_img(String host_img) {
		this.host_img = host_img;
	}
	public int getEmail_agree() {
		return email_agree;
	}
	public void setEmail_agree(int email_agree) {
		this.email_agree = email_agree;
	}
	public int getSns_agree() {
		return sns_agree;
	}
	public void setSns_agree(int sns_agree) {
		this.sns_agree = sns_agree;
	}
	public int getSnscnnt_agree() {
		return snscnnt_agree;
	}
	public void setSnscnnt_agree(int snscnnt_agree) {
		this.snscnnt_agree = snscnnt_agree;
	}
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	public String getHost_gender() {
		return host_gender;
	}
	public void setHost_gender(String host_gender) {
		this.host_gender = host_gender;
	}
	public String getHost_birth() {
		return host_birth;
	}
	public void setHost_birth(String host_birth) {
		this.host_birth = host_birth;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}
	
	
	
	
	
	
}
