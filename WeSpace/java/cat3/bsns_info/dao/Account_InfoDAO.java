package cat3.bsns_info.dao;

import org.apache.ibatis.session.SqlSession;

import cat3.bsns_info.vo.Account_InfoVO;

public class Account_InfoDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int account_info_insert(Account_InfoVO vo) {
		return sqlSession.insert("bsns_info.account_info_insert",vo);
	}
}
