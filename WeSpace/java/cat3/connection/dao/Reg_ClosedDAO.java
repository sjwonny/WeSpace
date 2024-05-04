package cat3.connection.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import all.vo.Day_WeekVO;
import cat3.connection.vo.Reg_ClosedVO;



public class Reg_ClosedDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Reg_ClosedDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public int reg_closed_insert(Reg_ClosedVO vo) {
		return sqlSession.insert("space_info.reg_closed_insert",vo);
	}

	public List<Day_WeekVO> closedDay(int no){
		return sqlSession.selectList("space_info.closedDay",no);
	}
}
