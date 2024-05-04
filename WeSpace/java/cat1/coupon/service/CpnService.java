package cat1.coupon.service;

import java.util.List;
import java.util.Map;

import cat1.coupon.dao.CpnDAO;
import cat1.coupon.dao.MyCpnDAO;
import cat1.coupon.vo.CpnVO;
import cat1.coupon.vo.MyCpnVO;

public class CpnService {

	private CpnDAO cpnDao;
	private MyCpnDAO myCpnDao;

	
	public CpnService(CpnDAO cpnDao,MyCpnDAO myCpnDao) {
		this.cpnDao = cpnDao;
		this.myCpnDao = myCpnDao;
	}
	
	public int insertCoupon(CpnVO vo) {
		return cpnDao.insertCoupon(vo);
	}
	
	
	public List<Map<String,Object>> selectMycpn(int no){
		return myCpnDao.selectMycpn(no);
	}
	
	public int countMyCpn(int no) {
		return myCpnDao.countMyCpn(no);
	}
	
}
