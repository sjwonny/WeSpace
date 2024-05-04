package all.dao;

import org.apache.ibatis.session.SqlSession;

import all.vo.FACILITY_SelVO;

public class Facility_selDAO {

	private SqlSession sqlSession;
	
	public Facility_selDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int facility_selinsert(int no) {
		return sqlSession.insert("facility.facility_selinsert",no);
	}
}

	