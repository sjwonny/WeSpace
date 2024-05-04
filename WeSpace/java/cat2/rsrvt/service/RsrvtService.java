package cat2.rsrvt.service;



import cat2.rsrvt.dao.RsrvtDAO;

public class RsrvtService {

	private RsrvtDAO rsrvtDao;
	
	
	public RsrvtService(RsrvtDAO rsrvtDao) {
		this.rsrvtDao= rsrvtDao;
	}
	
	public int selectrsrvtCnt(int no) {
		return rsrvtDao.selectrsrvtCnt(no);
	}
	
	
	
}
