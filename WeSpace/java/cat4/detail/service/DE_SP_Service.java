package cat4.detail.service;

import java.util.List;

import java.util.Map;

import all.dao.FacilityDAO;
import all.dao.Facility_selDAO;
import all.vo.FACILITY_SelVO;
import all.vo.FacilityVO;
import cat4.day.dao.DAY_PriceDAO;
import cat4.day.dao.DAY_TM_PrDAO;
import cat4.day.vo.DAY_PriceVO;
import cat4.day.vo.DAY_TM_PrVO;
import cat4.detail.dao.DE_SP_ADDDAO;
import cat4.detail.dao.DE_SP_InfoDAO;
import cat4.detail.dao.DE_SP_TyseDAO;
import cat4.detail.vo.DE_SP_AddVO;
import cat4.detail.vo.DE_SP_InfoVO;
import cat4.detail.vo.DE_SP_TyseVO;
import cat4.hr.dao.SET_PX_HrDAO;
import cat4.hr.vo.SET_PX_HrVO;
import cat4.pckg.dao.ADD_PCKG_tDAO;
import cat4.pckg.dao.PCKG_PrcstDAO;
import cat4.pckg.vo.ADD_PCKG_tVO;
import cat4.pckg.vo.PCKG_PrcstVO;

public class DE_SP_Service {
	
	private DE_SP_InfoDAO de_sp_infoDao;
	private FacilityDAO facilityDao;
	private Facility_selDAO facility_selDao;
	private DE_SP_TyseDAO de_sp_tyseDao;
	private DE_SP_ADDDAO de_sp_addDao;
	private SET_PX_HrDAO set_px_hrDao;
	private DAY_TM_PrDAO day_tm_prDao;
	private PCKG_PrcstDAO pckg_prcstDao;
	private ADD_PCKG_tDAO add_pckg_tDao;
	private DAY_PriceDAO day_priceDao;
	
	public DE_SP_Service(DE_SP_InfoDAO de_sp_infoDao,FacilityDAO facilityDao, 
			Facility_selDAO facility_selDao, DE_SP_TyseDAO de_sp_tyseDao,DE_SP_ADDDAO de_sp_addDao,
			SET_PX_HrDAO set_px_hrDao,DAY_TM_PrDAO day_tm_prDao,PCKG_PrcstDAO pckg_prcstDao,ADD_PCKG_tDAO add_pckg_tDao,
			DAY_PriceDAO day_priceDao) {
		this.de_sp_infoDao = de_sp_infoDao;
		this.facilityDao = facilityDao;
		this.facility_selDao = facility_selDao;
		this.de_sp_tyseDao = de_sp_tyseDao;
		this.de_sp_addDao = de_sp_addDao;
		this.set_px_hrDao = set_px_hrDao;
		this.day_tm_prDao = day_tm_prDao;
		this.pckg_prcstDao = pckg_prcstDao;
		this.add_pckg_tDao = add_pckg_tDao;
		this.day_priceDao = day_priceDao;
	}
	
//	de_sp_info
	
	public List<DE_SP_InfoVO> infoSelectList() {
		return de_sp_infoDao.selectAll();
	}
		
	public DE_SP_InfoVO infoSelectOne(int no) {
		return de_sp_infoDao.selectOne(no);
	}
	
	public int de_sp_info_insert(DE_SP_InfoVO vo) {
		return de_sp_infoDao.de_sp_info_insert(vo);
	}
	
	public int infoDelete(int no) {
		return de_sp_infoDao.delete(no);
	}
	
	public int update(DE_SP_InfoVO vo) {
		return de_sp_infoDao.update(vo);
	}
//	select_use
	
	public List<Map<String,Object>> selectUse(int no){
		return de_sp_infoDao.selectUse(no);
	}
	
	
	

	
	//편의시설
	public List<FacilityVO> selectList(){
		return facilityDao.selectList();
	}
	
	public int facility_selinsert(int no) {
		return facility_selDao.facility_selinsert(no);
	}
   
	
	public int de_sp_tyse_insert(int no) { //공간 용도 선택
		return de_sp_tyseDao.de_sp_tyse_insert(no);
	}
	
	public int de_sp_info_currseq() {
		return de_sp_infoDao.de_sp_info_currseq();
	}
	
	//세부공간 추가
	
	public int de_sp_add_insert(DE_SP_AddVO vo) {
		return de_sp_addDao.de_sp_add_insert(vo);
	}
	
	//시퀀스 가져오기
	public int de_sp_add_currseq() {
		return de_sp_addDao.de_sp_add_currseq();
	}
	
	public int set_px_hr_insert(SET_PX_HrVO vo) {
		return set_px_hrDao.set_px_hr_insert(vo);
	}
	public int day_tm_pr_insert(DAY_TM_PrVO vo) {
		return day_tm_prDao.day_tm_pr_insert(vo);
	}
	public int set_px_hr_currseq() {
		return set_px_hrDao.set_px_hr_currseq();
	}
	public int set_px_hr_update(SET_PX_HrVO vo) {
		return set_px_hrDao.set_px_hr_update(vo);
	}
	
	public int pckg_prcst_insert(PCKG_PrcstVO vo) {
		return pckg_prcstDao.pckg_prcst_insert(vo);
	}
	
	public int pckg_prcst_currseq() {
		return pckg_prcstDao.pckg_prcst_currseq();
	}
	
	public int add_pckg_t_insert(ADD_PCKG_tVO vo) {
		return add_pckg_tDao.add_pckg_t_insert(vo);
	}
	
	public int add_pckg_t_currseq() {
		return add_pckg_tDao.add_pckg_t_currseq();
	}
	
	public int day_price_insert(DAY_PriceVO vo) {
		return day_priceDao. day_price_insert(vo);
	}
	
	public int pckg_prcst_update(PCKG_PrcstVO vo) {
		return pckg_prcstDao.pckg_prcst_update(vo);
	}
	
	
	public int de_sp_add_update() {
		return de_sp_addDao.de_sp_add_update();
	}
}

