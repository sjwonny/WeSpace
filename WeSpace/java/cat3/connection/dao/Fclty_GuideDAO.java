package cat3.connection.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat3.connection.vo.Fclty_GuideVO;



public class Fclty_GuideDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Fclty_GuideDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public int fclty_guide_insert(String val) {
		return sqlSession.insert("space_info.fclty_guide_insert",val);
	}
	
	public List<Fclty_GuideVO> selectGuide(int no){
		return sqlSession.selectList("space_info.selectGuide",no);
	}

}
