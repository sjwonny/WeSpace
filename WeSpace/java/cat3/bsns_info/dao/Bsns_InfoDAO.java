package cat3.bsns_info.dao;

import org.apache.ibatis.session.SqlSession;

import cat3.bsns_info.vo.Bsns_InfoVO;

public class Bsns_InfoDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int bsns_info_insert(Bsns_InfoVO vo) {
		return sqlSession.insert("bsns_info.bsns_info_insert",vo);
	}
	
	
	public int bsns_info_currseq() {
		return sqlSession.selectOne("bsns_info.bsns_info_currseq");
	}
}
