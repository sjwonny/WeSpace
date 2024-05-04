package all.service;

import java.util.List;



import all.dao.BankDAO;
import all.dao.Day_WeekDAO;
import all.dao.TmDAO;
import all.vo.BankVO;
import all.vo.Day_WeekVO;
import all.vo.TmVO;



public class EtcService {
	private BankDAO bankDao;  //은행명
	private Day_WeekDAO day_weekDao; //요일
	private TmDAO tmDao; //시간
	

	public EtcService(BankDAO bankDao, Day_WeekDAO day_weekDao, TmDAO tmDao) {
		super();
		this.bankDao = bankDao;
		this.day_weekDao = day_weekDao;
		this.tmDao = tmDao;
	}

	public List<BankVO> bankList(){
		return bankDao.bankList();
	}
	
	public List<Day_WeekVO> weekList(int no){
		return day_weekDao.weekList(no);
	}
	
	public List<TmVO> tm_List(){
		return tmDao.tm_List();
	}
	
	public List<Day_WeekVO> dayWeekList(){
		return day_weekDao.dayWeekList();
	}

}
