package cat4.detail.dao;

import org.apache.ibatis.session.SqlSession;

import cat4.detail.vo.DE_SP_AddVO;

public class DE_SP_ADDDAO {
private SqlSession sqlSession;
	
	public DE_SP_ADDDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int de_sp_add_insert(DE_SP_AddVO vo) {
		return sqlSession.insert("de_sp.de_sp_add_insert",vo);
	}
	
	public int de_sp_add_currseq() {
		return sqlSession.selectOne("de_sp.de_sp_add_currseq");
	}
	
	public int de_sp_add_update() {
		return sqlSession.update("de_sp.de_sp_add_update");
	}
}
