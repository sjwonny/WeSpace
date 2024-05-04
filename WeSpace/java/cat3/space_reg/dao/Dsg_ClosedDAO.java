package cat3.space_reg.dao;

import org.apache.ibatis.session.SqlSession;

public class Dsg_ClosedDAO {

	private SqlSession sqlSession;
	
	public Dsg_ClosedDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
}
