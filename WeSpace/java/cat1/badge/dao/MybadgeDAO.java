package cat1.badge.dao;

import java.util.List;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cat1.badge.vo.BadgeVO;
import cat1.badge.vo.MybadgeVO;
import cat1.coupon.vo.CpnVO;
import cat1.coupon.vo.MyCpnVO;

public class MybadgeDAO {
	private SqlSession sqlSession;
	
	
	public MybadgeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	
	public int badgeCnt(int no) {
		return sqlSession.selectOne("mybadge.badgeCnt",no);
	}
	
}