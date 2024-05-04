package cat3.bsns_info.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat3.bsns_info.vo.Refund_StandardVO;


public class Refund_StandardDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int refund_standard_insert(Refund_StandardVO vo) {
		return sqlSession.insert("bsns_info.refund_standard_insert",vo);
	}
	
}
