package cat3.connection.dao;

import org.apache.ibatis.session.SqlSession;

import cat3.connection.vo.Select_UseVO;



public class Select_UseDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Select_UseDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public int select_use_insert(int no) {
		return sqlSession.insert("space_info.select_use_insert",no);
	}

	
}
