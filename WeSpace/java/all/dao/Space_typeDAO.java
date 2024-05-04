package all.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import all.vo.Space_typeVO;


public class Space_typeDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Space_typeVO> selectAll() {
		System.out.println("dao");
		return sqlSession.selectList("space_type.selectAll");
	}
	
	public Space_typeVO selectOne(int no) {
		return sqlSession.selectOne("space_type.selectOne", no);
	}
	
	public int insert(Space_typeVO vo) {
		return sqlSession.insert("space_type.insert",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("space_type.delete", no);
	}
	
	public int update(Space_typeVO vo) {
		return sqlSession.update("space_type.update",vo);
	}

}
