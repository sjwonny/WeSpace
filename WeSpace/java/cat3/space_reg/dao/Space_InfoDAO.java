package cat3.space_reg.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cat3.space_reg.vo.Space_InfoVO;

public class Space_InfoDAO {
	
	private SqlSession sqlSession;
	
	public Space_InfoDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int space_info_insert(Space_InfoVO vo) {
		return sqlSession.insert("space_info.space_info_insert",vo);
	}
	
	
	  public int space_info_seq() { 
		  return sqlSession.selectOne("space_info.space_info_seq"); 
	}
	  public int space_info_currseq() { 
		  return sqlSession.selectOne("space_info.space_info_currseq"); 
	  }
	 
	  public List<Map<String,Object>> select_spaceAll() {
		  return sqlSession.selectList("space_info.select_spaceAll");
	  }
	  public List<Map<String,Object>> select_spaceUses(int no) {
		  return sqlSession.selectList("space_info.select_spaceUses",no);
	  }
	  public List<Map<String,Object>> select_spaceTheme(int no) {
		  return sqlSession.selectList("space_info.select_spaceTheme",no);
	  }
	
	
}
