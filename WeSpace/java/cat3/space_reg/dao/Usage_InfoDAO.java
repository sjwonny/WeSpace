package cat3.space_reg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat3.space_reg.vo.Usage_InfoVO;

public class Usage_InfoDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int usage_info_insert(Usage_InfoVO vo) {
		return sqlSession.insert("space_info.usage_info_insert",vo);
	}

	public int usage_info_seq() {
		return sqlSession.selectOne("space_info.usage_info_seq");
	}
	

	public int usage_info_currseq() {
		return sqlSession.selectOne("space_info.usage_info_currseq");
	}
	
	public Usage_InfoVO selectUsageTm(int no){
		return sqlSession.selectOne("space_info.selectUsageTm",no);
	}
	
	public int selectusageSeq(int no){
		return sqlSession.selectOne("space_info.selectusageSeq",no);
	}
}
