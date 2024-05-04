package cat1.profile.dao;

import java.util.List;




import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import all.vo.GuestVO;
import cat1.profile.vo.DetaareaVO;
import cat1.profile.vo.IntrareaVO;

public class DetaareaDAO {
	private SqlSession sqlSession;
	
	
	public DetaareaDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	public List<DetaareaVO> selectList(){
		return sqlSession.selectList("detaarea.selectList");
	}
	
	
	public List<DetaareaVO> selectAll() {
		return sqlSession.selectList("detaarea.selectAll");
	}
	
	public List<DetaareaVO> selectDetaarea(int no){
		return sqlSession.selectList("detaarea.selectDetaarea",no);
	}
	
}