package cat2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import all.dao.FacilityDAO;
import all.dao.Space_themeDAO;
import all.dao.Space_typeDAO;
import all.dao.Space_usesDAO;
import all.vo.Day_WeekVO;
import all.vo.FacilityVO;
import all.vo.Space_themeVO;
import all.vo.Space_typeVO;
import all.vo.Space_usesVO;
import cat3.connection.dao.Fclty_GuideDAO;
import cat3.connection.dao.Reg_ClosedDAO;
import cat3.connection.dao.Rsrvt_NotesDAO;
import cat3.connection.dao.Space_TagDAO;
import cat3.connection.vo.Fclty_GuideVO;
import cat3.connection.vo.Reg_ClosedVO;
import cat3.connection.vo.Rsrvt_NotesVO;
import cat3.connection.vo.Space_TagVO;
import cat3.space_reg.dao.Space_InfoDAO;
import cat3.space_reg.vo.Space_InfoVO;
import cat4.day.dao.DAY_TM_PrDAO;
import cat4.detail.dao.DE_SP_InfoDAO;
import cat4.detail.dao.DE_SP_TyseDAO;
import cat4.detail.vo.DE_SP_TyseVO;


public class SpaceService {
	private Space_typeDAO space_typeDao;
	private Space_usesDAO space_usesDao;
	private Space_themeDAO space_themeDao;
	private Space_InfoDAO space_infoDao;
	private DE_SP_InfoDAO de_sp_infoDao;
	private Fclty_GuideDAO fclty_guideDao;
	private Rsrvt_NotesDAO rsrvt_notesDao;
	private Space_TagDAO space_tagDao;
	private FacilityDAO facilityDao;
	private DE_SP_TyseDAO de_sp_tyseDao;
	private Reg_ClosedDAO reg_closedDao;
	private DAY_TM_PrDAO day_tm_prDao;
	
	public SpaceService(
			Space_typeDAO space_typeDao,
			Space_usesDAO space_usesDao,
			Space_themeDAO space_themeDao,
			Space_InfoDAO space_infoDao,
			DE_SP_InfoDAO de_sp_infoDao,
			Fclty_GuideDAO fclty_guideDao,
		    Rsrvt_NotesDAO rsrvt_notesDao,
		    Space_TagDAO space_tagDao,
		    FacilityDAO facilityDao,
		    DE_SP_TyseDAO de_sp_tyseDao,
		    Reg_ClosedDAO reg_closedDao,
		    DAY_TM_PrDAO day_tm_prDao
			) {

		this.space_usesDao = space_usesDao;
		this.space_typeDao = space_typeDao;
		this.space_themeDao = space_themeDao;
		this.space_infoDao = space_infoDao;
		this.de_sp_infoDao = de_sp_infoDao;
		this.fclty_guideDao = fclty_guideDao;
		this.rsrvt_notesDao = rsrvt_notesDao;
		this.space_tagDao = space_tagDao;
		this.facilityDao = facilityDao;
		this.de_sp_tyseDao = de_sp_tyseDao;
		this.reg_closedDao = reg_closedDao;
		this.day_tm_prDao = day_tm_prDao;
	}
	
	public List<Map<String,Object>> usesList(){
		return space_usesDao.usesList();
	}

	public List<Map<String, Object>> themeList(){
		return space_themeDao.themeList();
	}
	
	
	// space_type
	
	public List<Space_typeVO> typeSelectAll() {
		return space_typeDao.selectAll();
	}
	
	public Space_typeVO typeSelectOne(int no) {
		return space_typeDao.selectOne(no);
	}
	
	public int insert(Space_typeVO vo) {
		return space_typeDao.insert(vo);
	}
	
	
	public int typeDelete(int no) {
		return space_typeDao.delete(no);
	}
	
	public int update(Space_typeVO vo) {
		return space_typeDao.update(vo);
	}
	
	
	public List<Space_usesVO> usesSelectAll() {
		return space_usesDao.selectAll();
	}
	
	public Space_usesVO usesSelectOne(int no) {
		return space_usesDao.selectOne(no);
	}
	
	public int insert(Space_usesVO vo) {
		return space_usesDao.insert(vo);
	}
	
	
	public int usesDelete(int no) {
		return space_usesDao.delete(no);
	}
	
	public int update(Space_usesVO vo) {
		return space_usesDao.update(vo);
	}
	
	
	public List<Space_themeVO> themeSelectAll() {
		return space_themeDao.selectAll();
	}
	
	public Space_themeVO themeSelectOne(int no) {
		return space_themeDao.selectOne(no);
	}
	
	public int insert(Space_themeVO vo) {
		return space_themeDao.insert(vo);
	}
	
	public int themeDelete(int no) {
		return space_themeDao.delete(no);
	}
	
	public int update(Space_themeVO vo) {
		return space_themeDao.update(vo);
	}

	
	
	public List<Map<Integer,Object>> showMyUses( Map<String, Object> params){
		return space_usesDao.showMyUses(params);
	}
	
	
	public List<Map<String,Object>> select_spaceAll(){
		return space_infoDao.select_spaceAll();
	}
	public List<Map<String,Object>> select_spaceUses(int no){
		return space_infoDao.select_spaceUses(no);
	}
	public List<Map<String,Object>> select_spaceTheme(int no){
		return space_infoDao.select_spaceTheme(no);
	}
	
	public Map<String,Object> spaceAndDetail(int no){
		return de_sp_infoDao.spaceAndDetail(no);
	}
	
	public List<Fclty_GuideVO> selectGuide(int no){
		return fclty_guideDao.selectGuide(no);
	}
	
	public List<Rsrvt_NotesVO> selectNotes(int no){
		return rsrvt_notesDao.selectNotes(no);
	}
	
	public List<Space_TagVO> selectTag(int no){
		return space_tagDao.selectTag(no);
	}
	
	public List<FacilityVO> detailFacility(int no){
		return facilityDao.detailFacility(no);
	}
	public List<Space_usesVO> selectType(int no){
		return de_sp_tyseDao.selectType(no);
	}
	
	public List<Day_WeekVO> closedDay(int no){
		return reg_closedDao.closedDay(no);
	}
	
	public int selectMinPrice(int no) {
		return day_tm_prDao.selectMinPrice(no);
	}
}
