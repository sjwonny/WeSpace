package cat1.profile.dao;

import java.util.List;





import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import all.vo.GuestVO;
import cat1.profile.vo.DetaareaVO;
import cat1.profile.vo.InterestVO;
import cat1.profile.vo.LfstyVO;
import cat1.profile.vo.ProfileVO;

public class InterestDAO {
	private SqlSession sqlSession;
	
	
	public InterestDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	 
	public int insertInterest(InterestVO vo) {
		return sqlSession.insert("interest.insertInterest",vo);
	}
	
	public int deleteInterest(int no) {
		return sqlSession.delete("interest.deleteInterest",no);
	}
}