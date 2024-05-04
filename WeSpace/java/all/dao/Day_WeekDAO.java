package all.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import all.vo.Day_WeekVO;


public class Day_WeekDAO {
	private SqlSession sqlSession;
	
	
	public Day_WeekDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<Day_WeekVO> weekList(int no){
		return sqlSession.selectList("etc.weekList",no);
	}
	
	public List<Day_WeekVO> dayWeekList(){
		return sqlSession.selectList("etc.dayWeekList");
	}
	

}












