package cat3.space_reg.service;

import java.util.List;
import java.util.Map;

import cat3.space_reg.dao.Basic_InfoDAO;
import cat3.space_reg.dao.Contact_InfoDAO;
import cat3.space_reg.dao.Space_InfoDAO;
import cat3.space_reg.dao.Usage_InfoDAO;
import cat3.space_reg.vo.Basic_InfoVO;
import cat3.space_reg.vo.Contact_InfoVO;
import cat3.space_reg.vo.Space_InfoVO;
import cat3.space_reg.vo.Usage_InfoVO;

public class Space_RegService {
	private Space_InfoDAO space_infoDao; //공간정보
	private Contact_InfoDAO contact_infoDao; //연락처정보
	private Usage_InfoDAO usage_infoDao;//이용정보
	private Basic_InfoDAO basic_infoDao;//기본정보
	
	
	
	public Space_RegService(Space_InfoDAO space_infoDao, Contact_InfoDAO contact_infoDao,Usage_InfoDAO usage_infoDao,Basic_InfoDAO basic_infoDao) {
		super();
		this.space_infoDao = space_infoDao;
		this.contact_infoDao = contact_infoDao;
		this.usage_infoDao = usage_infoDao;
		this.basic_infoDao = basic_infoDao;
	}
	
	public int space_info_insert(Space_InfoVO vo) {
		return space_infoDao.space_info_insert(vo);
	}
	
	public int contact_info_insert(Contact_InfoVO vo) {
		return contact_infoDao.contact_info_insert(vo);
	}
	
	public int usage_info_insert(Usage_InfoVO vo) {
		return usage_infoDao.usage_info_insert(vo);
	}
	
	public int basic_info_insert(Basic_InfoVO vo) {
		return basic_infoDao.basic_info_insert(vo);
	}
	
	public List<Map<Integer,Object>> select_host_space(int no){
		return basic_infoDao.select_host_space(no);
	}
	
	public Usage_InfoVO selectUsageTm(int no){
		return usage_infoDao.selectUsageTm(no);
	}
	
	public int selectusageSeq(int no) {
		return usage_infoDao.selectusageSeq(no);
	}
	
 
	
	 public int space_info_seq() { return space_infoDao.space_info_seq(); }
	 
	 public int space_info_currseq() { return space_infoDao.space_info_currseq(); }
	 
	 public int contact_info_currseq() { return contact_infoDao.contact_info_currseq(); }
	 
	 public int usage_info_currseq() { return usage_infoDao.usage_info_currseq(); }
	 
	 public int basic_info_currseq() { return basic_infoDao.basic_info_currseq(); }
	 
	
	 public int usage_info_seq() { return usage_infoDao.usage_info_seq(); }
	
}
