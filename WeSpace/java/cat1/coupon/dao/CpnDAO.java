package cat1.coupon.dao;

import java.util.List;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cat1.coupon.vo.CpnVO;
import cat1.coupon.vo.MyCpnVO;

public class CpnDAO {
	private SqlSession sqlSession;
	
	
	public CpnDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	public int insertCoupon(CpnVO vo){
		return sqlSession.insert("cpn.insertCoupon",vo);
	}
	
	
	
}