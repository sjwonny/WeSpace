package all.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import all.vo.TmVO;

public class TmDAO {

	
private SqlSession sqlSession;
	
	public TmDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<TmVO> tm_List() {
		return sqlSession.selectList("tm.tm_List");
	}
}
