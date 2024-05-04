package cat4.day.vo;

public class DAY_PriceVO { // 요일가격

	private int day_price_no;
	private int day_week_no;
	private int add_pckg_t_no;
	private int day_price_price;
	
	public DAY_PriceVO() {

	}

	public DAY_PriceVO(int day_price_no, int day_week_no, int add_pckg_t_no, int day_price_price) {
		super();
		this.day_price_no = day_price_no;
		this.day_week_no = day_week_no;
		this.add_pckg_t_no = add_pckg_t_no;
		this.day_price_price = day_price_price;
	}

	public int getDay_price_no() {
		return day_price_no;
	}

	public void setDay_price_no(int day_price_no) {
		this.day_price_no = day_price_no;
	}

	public int getDay_week_no() {
		return day_week_no;
	}

	public void setDay_week_no(int day_week_no) {
		this.day_week_no = day_week_no;
	}

	public int getAdd_pckg_t_no() {
		return add_pckg_t_no;
	}

	public void setAdd_pckg_t_no(int add_pckg_t_no) {
		this.add_pckg_t_no = add_pckg_t_no;
	}

	public int getDay_price_price() {
		return day_price_price;
	}

	public void setDay_price_price(int day_price_price) {
		this.day_price_price = day_price_price;
	}
	
}
