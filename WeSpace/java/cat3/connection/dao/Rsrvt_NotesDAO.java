package cat3.connection.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat3.connection.vo.Rsrvt_NotesVO;



public class Rsrvt_NotesDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Rsrvt_NotesDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public int rsrvt_notes_insert(String val) {
		return sqlSession.insert("space_info.rsrvt_notes_insert",val);
	}
	
	public List<Rsrvt_NotesVO> selectNotes(int no){
		return sqlSession.selectList("space_info.selectNotes",no);
	}

}
