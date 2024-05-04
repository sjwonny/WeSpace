package cat2.rsrvt.dao;



import org.apache.ibatis.session.SqlSession;


public class RsrvtDAO {
	private SqlSession sqlSession;
	
	
	public RsrvtDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int selectrsrvtCnt(int no) {
		return sqlSession.selectOne("rsrvt.selectrsrvtCnt",no);
	}

	
	
}