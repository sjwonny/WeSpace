package all.dao;






import org.apache.ibatis.session.SqlSession;

import all.vo.HostVO;

public class HostDAO {
	private SqlSession sqlSession;
	
	
	public HostDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	public int checkLogin(HostVO vo) {

		int no = 0;

		try {
			no = sqlSession.selectOne("host.checkLogin", vo);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return no;
	}
	
	
	public String checkId(String host_nick) {
		return sqlSession.selectOne("host.checkId",host_nick);
	}
	
	
	public int insertJoin(HostVO vo) {
		return sqlSession.insert("host.insertJoin",vo);
	}
	
	public String findHost_email(HostVO vo) {
		return sqlSession.selectOne("host.findHost_email",vo);
	}
	public String findHost_pw(HostVO vo) {
		return sqlSession.selectOne("host.findHost_pw",vo);
	}
	
	
	public int updateImg(HostVO vo) {
		return sqlSession.update("host.updateImg",vo);
	}
	
	public HostVO selectOne(int no) {
		return sqlSession.selectOne("host.selectOne",no);
	}
	
	public int updateInfo(HostVO vo) {
		return sqlSession.update("host.updateInfo",vo);
	}
	
	//회원탈퇴
	public int unregister(int no) {
		return sqlSession.delete("host.unregister",no);
	}
	
}