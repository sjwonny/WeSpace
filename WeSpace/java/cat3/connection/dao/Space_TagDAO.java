package cat3.connection.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cat3.connection.vo.Space_TagVO;





public class Space_TagDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Space_TagDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public int space_tag_insert(String val) {
		return sqlSession.insert("space_info.space_tag_insert",val);
	}

	public List<Space_TagVO> selectTag(int no){
		return sqlSession.selectList("space_info.selectTag",no);
	}
}
