package cat3.space_reg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat3.space_reg.vo.Contact_InfoVO;

public class Contact_InfoDAO {
	
	private SqlSession sqlSession;
	
	public Contact_InfoDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int contact_info_insert(Contact_InfoVO vo) {
		return sqlSession.insert("space_info.contact_info_insert",vo);
	}

	
	 public int contact_info_currseq() { 
		  return sqlSession.selectOne("space_info.contact_info_currseq"); 
	  }
}
