package cat3.connection.dao;

import org.apache.ibatis.session.SqlSession;

import cat3.connection.vo.Space_ImgVO;



public class Space_ImgDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Space_ImgDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public int space_img_insert(Space_ImgVO vo) {
		return sqlSession.insert("space_info.space_img_insert",vo);
	}

}
