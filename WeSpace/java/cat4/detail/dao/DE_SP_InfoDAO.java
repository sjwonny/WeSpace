package cat4.detail.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cat4.detail.vo.DE_SP_InfoVO;

public class DE_SP_InfoDAO {

private SqlSession sqlSession;
	
	public DE_SP_InfoDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<DE_SP_InfoVO> selectAll() {
		return sqlSession.selectList("de_sp.de_sp_info_List");
	}
	
	public List<Map<String,Object>> selectUse(int no){
		return sqlSession.selectList("select_use",no);
	}
	
	public DE_SP_InfoVO selectOne(int no) {
		return sqlSession.selectOne("de_sp.de_sp_info_One", no);
	}
	
	public int de_sp_info_insert(DE_SP_InfoVO vo) {
		return sqlSession.insert("de_sp.de_sp_info_insert",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("de_sp.de_sp_info_delete", no);
	}
	
	public int update(DE_SP_InfoVO vo) {
		return sqlSession.update("de_sp.de_sp_info_update",vo);
	}
	
	public int de_sp_info_currseq() {
		return sqlSession.selectOne("de_sp.de_sp_info_currseq");
	}
	
	public Map<String,Object> spaceAndDetail (int no){
		return sqlSession.selectOne("de_sp.spaceAndDetail",no);
	}
}
