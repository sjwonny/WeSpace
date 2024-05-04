package cat1.badge.dao;

import java.util.List;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cat1.badge.vo.BadgeVO;
import cat1.coupon.vo.CpnVO;
import cat1.coupon.vo.MyCpnVO;

public class BadgeDAO {
	private SqlSession sqlSession;
	
	
	public BadgeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<BadgeVO>  badgeList(){
		return sqlSession.selectList("badge.badgeList");
	}
	
	
	public BadgeVO badgeInfo(int badge_no) {
		return sqlSession.selectOne("badge.badgeInfo",badge_no);
	}
	
	public List<String> isgetBadge(int guest_no) {
		return sqlSession.selectList("badge.isgetBadge",guest_no);
	}
}