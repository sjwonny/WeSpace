package cat3.space_reg.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import cat3.bsns_info.service.Bsns_InfoService;
import cat3.bsns_info.vo.Account_InfoVO;
import cat3.bsns_info.vo.Bsns_InfoVO;
import cat3.bsns_info.vo.Refund_StandardVO;
import cat3.connection.service.ConnectionService;
import cat3.connection.vo.Dsg_ClosedVO;
import cat3.connection.vo.Reg_ClosedVO;
import cat3.space_reg.dao.Basic_InfoDAO;
import cat3.space_reg.dao.Contact_InfoDAO;
import cat3.space_reg.dao.Space_InfoDAO;
import cat3.space_reg.dao.Usage_InfoDAO;
import cat3.space_reg.vo.Basic_InfoVO;
import cat3.space_reg.vo.Contact_InfoVO;
import cat3.space_reg.vo.Space_InfoVO;
import cat3.space_reg.vo.Usage_InfoVO;

public class Space_RegService {
	private Space_InfoDAO space_infoDao; //공간정보
	private Contact_InfoDAO contact_infoDao; //연락처정보
	private Usage_InfoDAO usage_infoDao;//이용정보
	private Basic_InfoDAO basic_infoDao;//기본정보
	private ConnectionService connectionService;
	private Bsns_InfoService bsns_infoService;

	
	public Space_RegService(Space_InfoDAO space_infoDao, Contact_InfoDAO contact_infoDao,Usage_InfoDAO usage_infoDao,Basic_InfoDAO basic_infoDao,ConnectionService connectionService
			, Bsns_InfoService bsns_infoService) {
		this.space_infoDao = space_infoDao;
		this.contact_infoDao = contact_infoDao;
		this.usage_infoDao = usage_infoDao;
		this.basic_infoDao = basic_infoDao;
		this.connectionService = connectionService;
		this.bsns_infoService = bsns_infoService;
	}
	
	public int space_info_insert(Space_InfoVO vo) {
		return space_infoDao.space_info_insert(vo);
	}
	
	public int contact_info_insert(Contact_InfoVO vo) {
		return contact_infoDao.contact_info_insert(vo);
	}
	
	public int usage_info_insert(Usage_InfoVO vo) {
		return usage_infoDao.usage_info_insert(vo);
	}
	
	public int basic_info_insert(Basic_InfoVO vo) {
		return basic_infoDao.basic_info_insert(vo);
	}
	
	public List<Map<Integer,Object>> select_host_space(int no){
		return basic_infoDao.select_host_space(no);
	}
	
	public Usage_InfoVO selectUsageTm(int no){
		return usage_infoDao.selectUsageTm(no);
	}
	
	public int selectusageSeq(int no) {
		return usage_infoDao.selectusageSeq(no);
	}
	
 
	
	 public int space_info_seq() { return space_infoDao.space_info_seq(); }
	 
	 public int space_info_currseq() { return space_infoDao.space_info_currseq(); }
	 
	 public int contact_info_currseq() { return contact_infoDao.contact_info_currseq(); }
	 
	 public int usage_info_currseq() { return usage_infoDao.usage_info_currseq(); }
	 
	 public int basic_info_currseq() { return basic_infoDao.basic_info_currseq(); }
	 
	
	 public int usage_info_seq() { return usage_infoDao.usage_info_seq(); }
	
	 
	 @Transactional
	    public boolean insertSpaceInfo(Space_InfoVO vo, String[] usesValues, String[] tagValues, String[] guideValues, String[] noteValues, String savePath) {
	        try {
	            // 1. Save image
	            MultipartFile img = vo.getPhoto();
	            vo.setSpace_info_repimg(img.getOriginalFilename());
	            File saveFile = new File(savePath, vo.getSpace_info_repimg());
	            saveFile.mkdirs();
	            img.transferTo(saveFile);

	            // 2. Insert space information
	            int res = space_infoDao.space_info_insert(vo);
	            if (res == 0) {
	                return false;
	            }
	            // 3. Insert uses
	            for (String num : usesValues) {
					/* int no = Integer.parseInt(num); */
	                
	                connectionService.select_use_insert(Integer.parseInt(num));
	            }

	            
	            // 4. Insert tags
	            for (String val : tagValues) {
	                connectionService.space_tag_insert(val);
	            }

	            // 5. Insert facility guides
	            for (String val : guideValues) {
	                connectionService.fclty_guide_insert(val);
	            }

	            // 6. Insert reservation notes
	            for (String val : noteValues) {
	                connectionService.rsrvt_notes_insert(val);
	            }

	            return true;
	        } catch (IOException | IllegalStateException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to insert space information", e);
	        }
	    }
	 @Transactional
	    public void insertUsageInfoAndRelatedData(Usage_InfoVO uvo, Reg_ClosedVO rvo, Dsg_ClosedVO dvo, String[] dayWeekNos) {
	        // Step 1: Insert usage info
	        int res = usage_infoDao.usage_info_insert(uvo);
	        if (res == 0) {
	            throw new RuntimeException("Failed to insert usage info.");
	        }

	        // Step 2: Insert reg closed info for each dayWeekNo
	        for (String dayWeekNo : dayWeekNos) {
	            rvo.setDay_week_no(Integer.parseInt(dayWeekNo));
	            int su2 = connectionService.reg_closed_insert(rvo);
	            if (su2 == 0) {
	                throw new RuntimeException("Failed to insert reg closed info.");
	            }
	        }

	        // Step 3: Insert dsg closed info
	        int su3 = connectionService.dsg_closed_insert(dvo);
	        if (su3 == 0) {
	            throw new RuntimeException("Failed to insert dsg closed info.");
	        }
	    }

	 
	 @Transactional
	 public int insert4(Account_InfoVO avo, Refund_StandardVO rvo, Bsns_InfoVO bvo,
	                    int space_info_no, int contact_info_no, int usage_info_no, int no) {
	     try {
	         // 비즈니스 정보 처리
	         int su = bsns_infoService.account_info_insert(avo);
	         int su1 = bsns_infoService.refund_standard_insert(rvo);
	         int su2 = bsns_infoService.bsns_info_insert(bvo);
	         int bsns_info_no = bsns_infoService.bsns_info_currseq(); // 사업 정보 번호 가져오기

	         // 기본 정보 처리
	         Basic_InfoVO vo = new Basic_InfoVO();
	         vo.setSpace_info_no(space_info_no);
	         vo.setContact_info_no(contact_info_no);
	         vo.setUsage_info_no(usage_info_no);
	         vo.setBsns_info_no(bsns_info_no);
	         vo.setHost_no(no);

	         // 기본 정보 등록
	         int res = basic_infoDao.basic_info_insert(vo);
	         int basic_info_no = basic_infoDao.basic_info_currseq(); // 기본 정보 번호 가져오기

	         // 기본 정보가 잘 등록되었으면 기본 정보 번호 반환
	         if (res != 0) {
	             return basic_info_no; // 기본 정보 번호 반환
	         } else {
	             throw new RuntimeException("기본 정보 등록에 실패했습니다.");
	         }

	     } catch (Exception e) {
	         e.printStackTrace();
	         throw new RuntimeException("트랜잭션 처리 중 오류가 발생했습니다.", e); // 예외 발생 시 롤백
	     }
	 }
	

}
