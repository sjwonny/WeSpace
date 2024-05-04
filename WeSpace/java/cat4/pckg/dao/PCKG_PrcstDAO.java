package cat4.pckg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat4.pckg.vo.PCKG_PrcstVO;

public class PCKG_PrcstDAO {

private SqlSession sqlSession;
	
	public PCKG_PrcstDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<PCKG_PrcstVO> selectAll() {
		return sqlSession.selectList("pckg.pckg_prcst_List");
	}
	
	public PCKG_PrcstVO selectOne(int no) {
		return sqlSession.selectOne("pckg.pckg_prcst_One", no);
	}
	
	public int pckg_prcst_insert(PCKG_PrcstVO vo) {
		return sqlSession.insert("pckg.pckg_prcst_insert",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("pckg.pckg_prcst_delete", no);
	}
	
	public int update(PCKG_PrcstVO vo) {
		return sqlSession.update("pckg.pckg_prcst_update",vo);
	}
	
	public int pckg_prcst_currseq() {
		return sqlSession.selectOne("pckg.pckg_prcst_currseq");
	}
	
	public int pckg_prcst_update(PCKG_PrcstVO vo) {
		return sqlSession.update("pckg.pckg_prcst_update",vo);
	}
	
	
}
