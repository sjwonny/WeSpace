package cat3.space_reg.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cat3.space_reg.vo.Basic_InfoVO;


public class Basic_InfoDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int basic_info_insert(Basic_InfoVO vo) {
		return sqlSession.insert("space_info.basic_info_insert",vo);
	}
	
	public int basic_info_currseq() {
		return sqlSession.selectOne("space_info.basic_info_currseq");
	}

	public List<Map<Integer,Object>> select_host_space(int no){
		return sqlSession.selectList("space_info.select_host_space",no);
		
	}
}
