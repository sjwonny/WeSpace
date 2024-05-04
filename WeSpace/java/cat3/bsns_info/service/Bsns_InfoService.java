package cat3.bsns_info.service;

import java.util.List;

import cat3.bsns_info.dao.Account_InfoDAO;
import cat3.bsns_info.dao.Bsns_InfoDAO;
import cat3.bsns_info.dao.Bsns_TypeDAO;
import cat3.bsns_info.dao.Refund_StandardDAO;
import cat3.bsns_info.vo.Account_InfoVO;
import cat3.bsns_info.vo.Bsns_InfoVO;
import cat3.bsns_info.vo.Bsns_TypeVO;
import cat3.bsns_info.vo.Refund_StandardVO;

public class Bsns_InfoService {

	
	private Bsns_TypeDAO bsns_typeDao;
	private Refund_StandardDAO refund_standardDao;
	private Account_InfoDAO account_infoDao;
	private Bsns_InfoDAO bsns_infoDao;
	
	

	
	public Bsns_InfoService(Bsns_TypeDAO bsns_typeDao,Refund_StandardDAO refund_standardDao,Account_InfoDAO account_infoDao,Bsns_InfoDAO bsns_infoDao) {
		this.bsns_typeDao = bsns_typeDao;
		this.refund_standardDao = refund_standardDao;
		this.account_infoDao = account_infoDao;
		this.bsns_infoDao = bsns_infoDao;
	}
	
	public List<Bsns_TypeVO> businessmanList(){ //사업가 유형리스트
		return bsns_typeDao.businessmanList();
	}

	public int account_info_insert(Account_InfoVO vo) {
		return account_infoDao.account_info_insert(vo);
	}
	
	public int refund_standard_insert(Refund_StandardVO vo) {
		return refund_standardDao.refund_standard_insert(vo);
	}
	
	public int bsns_info_insert(Bsns_InfoVO vo) {
		return bsns_infoDao.bsns_info_insert(vo);
	}
	
	public int bsns_info_currseq() {
		return bsns_infoDao.bsns_info_currseq();
	}
}



