package cat1.profile.dao;

import java.util.List;





import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cat1.profile.vo.IntrareaVO;

public class IntrareaDAO {
	private SqlSession sqlSession;
	
	
	public IntrareaDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	 
	public int insertArea(IntrareaVO vo) {
		return sqlSession.insert("intrarea.insertArea",vo);
	}
	
	public int deleteIntrarea(int no) {
		return sqlSession.delete("intrarea.deleteIntrarea",no);
	}
	
	
	
}