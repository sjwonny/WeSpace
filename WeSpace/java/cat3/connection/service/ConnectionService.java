package cat3.connection.service;

import cat3.connection.dao.Dsg_ClosedDAO;
import cat3.connection.dao.Fclty_GuideDAO;
import cat3.connection.dao.Reg_ClosedDAO;
import cat3.connection.dao.Rsrvt_NotesDAO;
import cat3.connection.dao.Select_UseDAO;
import cat3.connection.dao.Space_ImgDAO;
import cat3.connection.dao.Space_TagDAO;
import cat3.connection.vo.Dsg_ClosedVO;
import cat3.connection.vo.Fclty_GuideVO;
import cat3.connection.vo.Reg_ClosedVO;
import cat3.connection.vo.Rsrvt_NotesVO;
import cat3.connection.vo.Select_UseVO;
import cat3.connection.vo.Space_ImgVO;
import cat3.connection.vo.Space_TagVO;

public class ConnectionService {
	private Dsg_ClosedDAO dsg_closedDao; //
	private Fclty_GuideDAO fclty_guideDao; //
	private Reg_ClosedDAO reg_closedDao; //
	private Rsrvt_NotesDAO rsrvt_notesDao; //
	private Select_UseDAO select_useDao; //
	private Space_ImgDAO space_imgDao; //
	private Space_TagDAO space_tagDao; //
	
	
	public ConnectionService(Dsg_ClosedDAO dsg_closedDao, Fclty_GuideDAO fclty_guideDao, Reg_ClosedDAO reg_closedDao,
			Rsrvt_NotesDAO rsrvt_notesDao, Select_UseDAO select_useDao, Space_ImgDAO space_imgDao,
			Space_TagDAO space_tagDao) {
		super();
		this.dsg_closedDao = dsg_closedDao;
		this.fclty_guideDao = fclty_guideDao;
		this.reg_closedDao = reg_closedDao;
		this.rsrvt_notesDao = rsrvt_notesDao;
		this.select_useDao = select_useDao;
		this.space_imgDao = space_imgDao;
		this.space_tagDao = space_tagDao;
	}


	public int dsg_closed_insert(Dsg_ClosedVO vo) {
		return dsg_closedDao.dsg_closed_insert(vo);
	}
	public int reg_closed_insert(Reg_ClosedVO vo) {
		return reg_closedDao.reg_closed_insert(vo);
	}
	public int space_img_insert(Space_ImgVO vo) {
		return space_imgDao.space_img_insert(vo);
	}
	public int fclty_guide_insert(String val) {
		return fclty_guideDao.fclty_guide_insert(val);
	}
	public int rsrvt_notes_insert(String val) {
		return rsrvt_notesDao.rsrvt_notes_insert(val);
	}
	public int space_tag_insert(String val) {
		return space_tagDao.space_tag_insert(val);
	}
	public int select_use_insert(int no) {
		return select_useDao.select_use_insert(no);
	}
	
	
}
