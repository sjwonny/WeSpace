package cat1.profile.dao;

import java.util.List;




import org.apache.ibatis.session.SqlSession;

import all.vo.GuestVO;
import cat1.profile.vo.DetaareaVO;
import cat1.profile.vo.ProfileVO;

public class ProfileDAO {
	private SqlSession sqlSession;
	
	
	public ProfileDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	public List<ProfileVO> selectprofileList(){
		return sqlSession.selectList("profile.selectprofileList");
	}
	
	public ProfileVO myProfile(int no){
		return sqlSession.selectOne("profile.myProfile",no);
	}
	
}