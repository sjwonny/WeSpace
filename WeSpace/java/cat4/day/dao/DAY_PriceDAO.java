package cat4.day.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat4.day.vo.DAY_PriceVO;

public class DAY_PriceDAO {

	private SqlSession sqlSession;

	public DAY_PriceDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<DAY_PriceVO> selectAll() {
		return sqlSession.selectList("day.day_price_List");
	}

	public DAY_PriceVO selectOne(int no) {
		return sqlSession.selectOne("day.day_price_One", no);
	}

	public int day_price_insert(DAY_PriceVO vo) {
		return sqlSession.insert("day.day_price_insert", vo);
	}

	public int update(DAY_PriceVO vo) {
		return sqlSession.update("day.day_price_update", vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("day.day_price_delete", no);
	}
}
