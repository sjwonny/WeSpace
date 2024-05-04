package all.dao;




import org.apache.ibatis.session.SqlSession;

import all.vo.GuestVO;

public class GuestDAO {
	private SqlSession sqlSession;
	
	
	public GuestDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	public int checkLogin(GuestVO vo) {

		int no = 0;

		try {
			no = sqlSession.selectOne("guest.checkLogin", vo);
		} catch (NullPointerException e) {//예외가 발생하면 
			e.printStackTrace();
		}

		return no;
	}
	
	
	public String checkId(String guest_nickname) {
		return sqlSession.selectOne("guest.checkId",guest_nickname);
	}
	
	
	public int insertJoin(GuestVO vo) {
		return sqlSession.insert("guest.insertJoin",vo);
	}
	
	public String findGuest_email(GuestVO vo) {
		return sqlSession.selectOne("guest.findGuest_email",vo);
	}
	public String findGuest_pw(GuestVO vo) {
		return sqlSession.selectOne("guest.findGuest_pw",vo);
	}
	
	
	public int updateProfile(GuestVO vo) {
		return sqlSession.update("guest.updateProfile",vo);
	}
	
	public int updateImg(GuestVO vo) {
		return sqlSession.update("guest.updateImg",vo);
	}
	
	public GuestVO selectOne(int no) {
		return sqlSession.selectOne("guest.selectOne",no);
	}
	
	public int updateInfo(GuestVO vo) {
		return sqlSession.update("guest.updateInfo",vo);
	}

	//회원탈퇴
	public int unregister(int no) {
		return sqlSession.delete("guest.unregister",no);
	}

	
}
