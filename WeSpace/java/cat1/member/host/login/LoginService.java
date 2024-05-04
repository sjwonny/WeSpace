package cat1.member.host.login;





import all.dao.HostDAO;
import all.vo.HostVO;

public class LoginService {

	private HostDAO hostDao;
	
	public LoginService(HostDAO hostDao) {
		this.hostDao = hostDao;
	}
	
	
	public int checkLogin(HostVO vo) {
		return hostDao.checkLogin(vo);
	}
	
	 public boolean checkId(String host_nick) {
	    	return hostDao.checkId(host_nick) != null;
	    }
	    
	 
	 public int insertJoin(HostVO vo) {
	    	return hostDao.insertJoin(vo);
	    }
	 public String findHost_email(HostVO vo) {
		 return hostDao.findHost_email(vo);
	 }
	 public String findHost_pw(HostVO vo) {
		 return hostDao.findHost_pw(vo);
	 }
	 
	 
	 
	 public int updateImg(HostVO vo) {
			return hostDao.updateImg(vo);
		}
	 
	 public HostVO selectOne(int no) {
			return hostDao.selectOne(no);
		}
		
	public int updateInfo(HostVO vo) {
			return hostDao.updateInfo(vo);
		}
		
	 public int unregister(int no) {
		 return hostDao.unregister(no);
	 }
}	
