package cat1.profile.service;

import java.util.List;




import all.dao.GuestDAO;
import all.vo.GuestVO;
import cat1.badge.dao.BadgeDAO;
import cat1.badge.dao.MybadgeDAO;
import cat1.badge.vo.BadgeVO;
import cat1.badge.vo.MybadgeVO;
import cat1.profile.dao.DetaareaDAO;
import cat1.profile.dao.InterestDAO;
import cat1.profile.dao.IntrareaDAO;
import cat1.profile.dao.LfstyDAO;
import cat1.profile.dao.ProfileDAO;
import cat1.profile.vo.DetaareaVO;
import cat1.profile.vo.InterestVO;
import cat1.profile.vo.IntrareaVO;
import cat1.profile.vo.LfstyVO;
import cat1.profile.vo.ProfileVO;

public class ProfileService {

	private DetaareaDAO detaareaDao;
	private ProfileDAO profileDao;
	private LfstyDAO lfstyDao;
	private GuestDAO guestDao;
	private InterestDAO interestDao;
	private IntrareaDAO intrareaDao;
	private BadgeDAO badgeDao;
	private MybadgeDAO mybadgeDao;
	
	public ProfileService(DetaareaDAO detaareaDao,ProfileDAO profileDao,LfstyDAO lfstyDao,GuestDAO guestDao,InterestDAO interestDao,IntrareaDAO intrareaDao,BadgeDAO badgeDao,MybadgeDAO mybadgeDao) {
		this.detaareaDao = detaareaDao;
		this.profileDao = profileDao;
		this.lfstyDao = lfstyDao;
		this.guestDao = guestDao;
		this.interestDao = interestDao;
		this.intrareaDao = intrareaDao;
		this.badgeDao = badgeDao;
		this.mybadgeDao = mybadgeDao;
	}
	

	public List<DetaareaVO> selectList() {
		List<DetaareaVO> list = detaareaDao.selectList();
		return list;
	}
	

	
	public List<DetaareaVO> selectAll() {
		return detaareaDao.selectAll();
	}
	
	public List<ProfileVO> selectprofileList(){
		return profileDao.selectprofileList();
	}
	
	public List<LfstyVO> selectstyleList(){
		return lfstyDao.selectstyleList();
	}
	
	
	public int updateProfile(GuestVO vo){
		return guestDao.updateProfile(vo);
	}
	
 	public int insertInterest(InterestVO vo) {
 		return interestDao.insertInterest(vo);
 	}
	
 	public int insertArea(IntrareaVO vo) {
 		return intrareaDao.insertArea(vo);
 	}
 	
	public int updateImg(GuestVO vo) {
		return guestDao.updateImg(vo);
	}
	
	public int deleteInterest(int no) {
		return interestDao.deleteInterest(no);
	}
	
	public int deleteIntrarea(int no) {
		return intrareaDao.deleteIntrarea(no);
	}
	
	public List<DetaareaVO> selectDetaarea(int no){
		return detaareaDao.selectDetaarea(no);
	}
	
	public ProfileVO myProfile(int no) {
		return profileDao.myProfile(no);
	}
	
	public List<LfstyVO> myLfsty(int no){
		return lfstyDao.myLfsty(no);
	}
	
	public GuestVO selectOne(int no) {
		return guestDao.selectOne(no);
	}
	
	public int updateInfo(GuestVO vo) {
		return guestDao.updateInfo(vo);
	}
	
	public List<BadgeVO> badgeList(){
		return badgeDao.badgeList();
	}
	
	public BadgeVO badgeInfo(int badge_no) {
		return badgeDao.badgeInfo(badge_no);
	}
	
	public List<String> isgetBadge(int no){
		return badgeDao.isgetBadge(no);
	}
	
	public int badgeCnt(int no) {
		return mybadgeDao.badgeCnt(no);
	}
	
}
