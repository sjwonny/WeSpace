package all.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import all.vo.Space_usesVO;

public class Space_usesDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	public List<Map<String,Object>> usesList(){ //용도 나열
		return sqlSession.selectList("space_uses.usesList");
	}
	
	
	
	 public List<Space_usesVO> selectAll() { List<Space_usesVO> list =
	   sqlSession.selectList("space_uses.selectAll"); System.out.println(list);
	 return list; } 
	 

	
	public Space_usesVO selectOne(int no) {
		return sqlSession.selectOne("space_uses.selectOne", no);
	}
	
	public int insert(Space_usesVO vo) {
		return sqlSession.insert("space_uses.insert",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("space_uses.delete", no);
	}
	
	public int update(Space_usesVO vo) {
		return sqlSession.update("space_uses.update",vo);
	}

	public List<Map<Integer,Object>>showMyUses(Map<String, Object> params){
		return sqlSession.selectList("space_uses.showMyUses", params);
	}
	
}
