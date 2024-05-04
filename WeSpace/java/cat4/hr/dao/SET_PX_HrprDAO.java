package cat4.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat4.hr.vo.SET_PX_HrprVO;

public class SET_PX_HrprDAO {

	private SqlSession sqlSession;

	public SET_PX_HrprDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<SET_PX_HrprVO> selectAll() {
		return sqlSession.selectList("hr.set_px_hrpr_List");
	}

	public SET_PX_HrprVO selectOne(int no) {
		return sqlSession.selectOne("hr.set_px_hrpr_One", no);
	}

//	public int insert(SET_PX_HrprVO vo) {
//		return sqlSession.insert("hr.set_px_hrpr_insert", vo);
//	}
//
//	public int update(SET_PX_HrprVO vo) {
//		return sqlSession.update("hr.set_px_hrpr_update", vo);
//	}
	
	public int delete(int no) {
		return sqlSession.delete("hr.set_px_hrpr_delete", no);
	}
}
