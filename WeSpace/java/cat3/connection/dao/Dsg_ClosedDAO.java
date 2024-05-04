package cat3.connection.dao;

import org.apache.ibatis.session.SqlSession;

import cat3.connection.vo.Dsg_ClosedVO;



public class Dsg_ClosedDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Dsg_ClosedDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public int dsg_closed_insert(Dsg_ClosedVO vo) {
		return sqlSession.insert("space_info.dsg_closed_insert",vo);
	}

}
