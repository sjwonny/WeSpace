package cat4.day.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat4.day.vo.DAY_TM_PrVO;

public class DAY_TM_PrDAO {

	private SqlSession sqlSession;

	public DAY_TM_PrDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<DAY_TM_PrVO> selectAll() {
		return sqlSession.selectList("day.day_tm_pr_List");
	}

	public DAY_TM_PrVO selectOne(int no) {
		return sqlSession.selectOne("day.day_tm_pr_One", no);
	}

	public int insert(DAY_TM_PrVO vo) {
		return sqlSession.insert("day.day_tm_pr_insert", vo);
	}

	public int update(DAY_TM_PrVO vo) {
		return sqlSession.update("day.day_tm_pr_update", vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("day.day_tm_pr_delete", no);
	}
	
	public int day_tm_pr_insert(DAY_TM_PrVO vo) {
		return sqlSession.insert("day.day_tm_pr_insert",vo);
	}
	
	public int selectMinPrice(int no) {
		return sqlSession.selectOne("de_sp.selectMinPrice",no);
	}
}
