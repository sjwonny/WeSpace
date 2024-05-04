package all.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import all.vo.Space_themeVO;

public class Space_themeDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Map<String, Object>> themeList(){
		return sqlSession.selectList("space_theme.themeList");
	}
	
	public List<Space_themeVO> selectAll() {
		return sqlSession.selectList("space_theme.selectAll");
	}
	
	public Space_themeVO selectOne(int no) {
		return sqlSession.selectOne("space_theme.selectOne", no);
	}
	
	public int insert(Space_themeVO vo) {
		return sqlSession.insert("space_theme.insert",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("space_theme.delete", no);
	}
	
	public int update(Space_themeVO vo) {
		return sqlSession.update("space_theme.update",vo);
	}

}
