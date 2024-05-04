package cat3.bsns_info.vo;

public class Account_InfoVO {
	private int account_info_no;
	private int bank_no;
	private String account_info_num;
	private String account_info_name;
	
	
	public Account_InfoVO(int account_info_no, int bank_no, String account_info_num, String account_info_name) {
		super();
		this.account_info_no = account_info_no;
		this.bank_no = bank_no;
		this.account_info_num = account_info_num;
		this.account_info_name = account_info_name;
	}
	public Account_InfoVO() {
		super();
	}
	public int getAccount_info_no() {
		return account_info_no;
	}
	public void setAccount_info_no(int account_info_no) {
		this.account_info_no = account_info_no;
	}
	public int getBank_no() {
		return bank_no;
	}
	public void setBank_no(int bank_no) {
		this.bank_no = bank_no;
	}
	public String getAccount_info_num() {
		return account_info_num;
	}
	public void setAccount_info_num(String account_info_num) {
		this.account_info_num = account_info_num;
	}
	public String getAccount_info_name() {
		return account_info_name;
	}
	public void setAccount_info_name(String account_info_name) {
		this.account_info_name = account_info_name;
	}
	
	
	
	
	
	
	
	
}
