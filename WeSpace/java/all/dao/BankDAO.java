package all.dao;

import java.util.List;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import all.vo.BankVO;
import all.vo.Day_WeekVO;


public class BankDAO {
	private SqlSession sqlSession;
	
	
	public BankDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<BankVO> bankList(){
		return sqlSession.selectList("etc.bankList");
	}

}












