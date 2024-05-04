package cat4.detail.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import all.vo.Space_usesVO;
import cat4.detail.vo.DE_SP_TyseVO;

public class DE_SP_TyseDAO {

private SqlSession sqlSession;
	
	public DE_SP_TyseDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int de_sp_tyse_insert(int no) {
		return sqlSession.update("de_sp.de_sp_tyse_insert",no);
	}
	
	public List<Space_usesVO> selectType(int no){
		return sqlSession.selectList("de_sp.selectType",no);
	}
}
