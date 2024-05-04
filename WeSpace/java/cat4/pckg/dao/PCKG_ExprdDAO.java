package cat4.pckg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat4.pckg.vo.PCKG_ExprdVO;

public class PCKG_ExprdDAO {

private SqlSession sqlSession;
	
	public PCKG_ExprdDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<PCKG_ExprdVO> selectAll() {
		return sqlSession.selectList("pckg.pckg_exprd_List");
	}
	
	public PCKG_ExprdVO selectOne(int no) {
		return sqlSession.selectOne("pckg.pckg_exprd_One", no);
	}
	
	public int insert(PCKG_ExprdVO vo) {
		return sqlSession.insert("pckg.pckg_exprd_insert",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("pckg.pckg_exprd_delete", no);
	}
	
	public int update(PCKG_ExprdVO vo) {
		return sqlSession.update("pckg.pckg_exprd_update",vo);
	}
}
