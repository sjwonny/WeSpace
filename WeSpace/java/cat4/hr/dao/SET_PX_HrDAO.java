package cat4.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat4.hr.vo.SET_PX_HrVO;

public class SET_PX_HrDAO {

private SqlSession sqlSession;
	
	public SET_PX_HrDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<SET_PX_HrVO> selectAll() {
		return sqlSession.selectList("hr.set_px_hr_List");
	}
	
	public SET_PX_HrVO selectOne(int no) {
		return sqlSession.selectOne("hr.set_px_hr_One", no);
	}
	
	public int set_px_hr_insert(SET_PX_HrVO vo) {
		return sqlSession.insert("hr.set_px_hr_insert",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("hr.set_px_hr_delete", no);
	}
	
	public int update(SET_PX_HrVO vo) {
		return sqlSession.update("hr.set_px_hr_update",vo);
	}
	
	public int set_px_hr_currseq() {
		return sqlSession.selectOne("hr.set_px_hr_currseq");
	}
	
	public int set_px_hr_update(SET_PX_HrVO vo) {
		return sqlSession.update("hr.set_px_hr_update",vo);
	}
	
}
