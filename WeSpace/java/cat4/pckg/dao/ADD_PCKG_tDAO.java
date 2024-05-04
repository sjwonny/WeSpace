package cat4.pckg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat4.pckg.vo.ADD_PCKG_tVO;

public class ADD_PCKG_tDAO {

private SqlSession sqlSession;
	
	public ADD_PCKG_tDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<ADD_PCKG_tVO> selectAll() {
		return sqlSession.selectList("pckg.add_pckg_t_List");
	}
	
	public ADD_PCKG_tVO selectOne(int no) {
		return sqlSession.selectOne("pckg.add_pckg_t_One", no);
	}
	
	public int add_pckg_t_insert(ADD_PCKG_tVO vo) {
		return sqlSession.insert("pckg.add_pckg_t_insert",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("pckg.add_pckg_t_delete", no);
	}
	
	public int update(ADD_PCKG_tVO vo) {
		return sqlSession.update("pckg.add_pckg_t_update",vo);
	}
	
	public int add_pckg_t_currseq() {
		return sqlSession.selectOne("pckg.add_pckg_t_currseq");
	}
}
