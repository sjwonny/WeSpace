package cat3.bsns_info.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat3.bsns_info.vo.Bsns_TypeVO;

public class Bsns_TypeDAO {

private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Bsns_TypeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Bsns_TypeVO> businessmanList(){
		return sqlSession.selectList("etc.businessmanList");
	}
}
