package cat1.profile.dao;

import java.util.List;






import org.apache.ibatis.session.SqlSession;

import all.vo.GuestVO;
import cat1.profile.vo.LfstyVO;

public class LfstyDAO {
	private SqlSession sqlSession;
	
	
	public LfstyDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	public List<LfstyVO> selectstyleList(){
		return sqlSession.selectList("lfsty.selectstyleList");
	}
	
	public List<LfstyVO> myLfsty(int no){
		return sqlSession.selectList("lfsty.myLfsty",no);
	}
}