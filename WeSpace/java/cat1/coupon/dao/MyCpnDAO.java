package cat1.coupon.dao;

import java.util.List;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cat1.coupon.vo.CpnVO;
import cat1.coupon.vo.MyCpnVO;

public class MyCpnDAO {
	private SqlSession sqlSession;
	
	
	public MyCpnDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	
	public List<Map<String,Object>> selectMycpn(int no){
		return sqlSession.selectList("cpn.selectMycpn",no);
	}
	
	public int countMyCpn (int no) {
		return sqlSession.selectOne("cpn.countMyCpn",no);
	}
	
}