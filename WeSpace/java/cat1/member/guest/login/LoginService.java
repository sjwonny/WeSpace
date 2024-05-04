package cat1.member.guest.login;

import java.util.List;


import all.dao.GuestDAO;
import all.vo.GuestVO;
import all.vo.HostVO;

public class LoginService {

	private GuestDAO guestDao;
	
	public LoginService(GuestDAO guestDao) {
		this.guestDao = guestDao;
	}
	
	
	public int checkLogin(GuestVO vo) {
		return guestDao.checkLogin(vo);
	}
	
	 public boolean checkId(String guest_nickname) {
	    	return guestDao.checkId(guest_nickname) != null;
	    }
	    
	 
	 public int insertJoin(GuestVO vo) {
	    	return guestDao.insertJoin(vo);
	    }
	 public String findGuest_email(GuestVO vo) {
		 return guestDao.findGuest_email(vo);
	 }
	 public String findGuest_pw(GuestVO vo) {
		 return guestDao.findGuest_pw(vo);
	 }
	 
	 
	 public int unregister(int no) {
		 return guestDao.unregister(no);
	 }

	 public GuestVO selectOne(int no) {
			return guestDao.selectOne(no);
		}
		
}
