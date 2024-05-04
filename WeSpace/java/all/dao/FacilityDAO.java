package all.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import all.vo.FACILITY_SelVO;
import all.vo.FacilityVO;
import all.vo.Space_usesVO;

public class FacilityDAO {

	
private SqlSession sqlSession;
	
	public FacilityDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<FacilityVO> selectList() {
		return sqlSession.selectList("facility.selectList");
	}
	
	public FacilityVO selectOne(int no) {
		return sqlSession.selectOne("facility.selectOne", no);
	}
	
	public int insert(FacilityVO vo) {
		return sqlSession.insert("facility.insert",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("facility.delete", no);
	}
	
	public int update(FacilityVO vo) {
		return sqlSession.update("facility.update",vo);
	}
	

	public List<FacilityVO> detailFacility(int no) {
		return sqlSession.selectList("facility.detailFacility",no);
	}
	
}
