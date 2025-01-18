package cat3.space_reg.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import all.service.EtcService;
import all.vo.BankVO;
import all.vo.Day_WeekVO;
import all.vo.GuestVO;
import all.vo.HostVO;
import all.vo.Space_typeVO;
import all.vo.Space_usesVO;
import all.vo.TmVO;
import cat1.profile.vo.InterestVO;
import cat2.service.SpaceService;
import cat3.bsns_info.service.Bsns_InfoService;
import cat3.bsns_info.vo.Account_InfoVO;
import cat3.bsns_info.vo.Bsns_InfoVO;
import cat3.bsns_info.vo.Bsns_TypeVO;
import cat3.bsns_info.vo.Refund_StandardVO;
import cat3.connection.dao.Dsg_ClosedDAO;
import cat3.connection.service.ConnectionService;
import cat3.connection.vo.Dsg_ClosedVO;
import cat3.connection.vo.Reg_ClosedVO;
import cat3.space_reg.service.Space_RegService;
import cat3.space_reg.vo.Basic_InfoVO;
import cat3.space_reg.vo.Contact_InfoVO;
import cat3.space_reg.vo.Space_InfoVO;
import cat3.space_reg.vo.Usage_InfoVO;
import common.ViewPath;

@Controller
@RequestMapping("/space_reg/")
public class Space_RegController {

	private Space_RegService space_regService;
	private ConnectionService connectionService;
	private SpaceService spaceService;
	private EtcService etcService;
	private Bsns_InfoService bsns_infoService;

	public Space_RegController(Space_RegService space_regService, SpaceService spaceService, EtcService etcService,
			ConnectionService connectionService, Bsns_InfoService bsns_infoService) {
		super();
		this.etcService = etcService;
		this.space_regService = space_regService;
		this.connectionService = connectionService;
		this.spaceService = spaceService;
		this.bsns_infoService = bsns_infoService;
	}

	@Autowired // 해당 필드에 알맞은 의존성을 자동으로 주입.
	private ServletContext application;

	@RequestMapping("insertform")
	public String Space_reg_insertForm(Model model, HttpServletRequest request) {
		
		  Integer no = (Integer) request.getSession().getAttribute("login"); // 이렇게 써도됨(그럼 매개변수에 세션 없어도 됨) 
		  if (no == null) { return "redirect:/host/loginform"; }
		 
		List<Space_typeVO> type = spaceService.typeSelectAll(); // 모임~공부/업무(유형0,1 둘 다 포함)

		List<Map<String, Object>> uses = spaceService.usesList(); // 용도명
		List<Map<String, Object>> theme = spaceService.themeList(); // 테마명(20개 이상 모임 등)

		model.addAttribute("type", type);
		model.addAttribute("uses", uses);
		model.addAttribute("theme", theme);

		return ViewPath.SPACE_REG + "insertForm.jsp";

	}
	 @RequestMapping("insert")
	    public String spaceRegInsert(Model model, Space_InfoVO vo, HttpServletRequest request) {
	        // Save path for the image
	        String savePath = "C:\\spaceimg";

	        // Parse request parameters
	        String spaceUsesNo = request.getParameter("space_uses_no");
	        String spaceTagName = request.getParameter("space_tag_name");
	        String fcltyGuideContent = request.getParameter("fclty_guide_content");
	        String rsrvtNotesContent = request.getParameter("rsrvt_notes_content");

	        String[] usesValues = spaceUsesNo.split(",");
	        String[] tagValues = spaceTagName.split(",");
	        String[] guideValues = fcltyGuideContent.split(",");
	        String[] noteValues = rsrvtNotesContent.split(",");

	        // Call service for transaction
	        boolean isInserted = space_regService.insertSpaceInfo(vo, usesValues, tagValues, guideValues, noteValues, savePath);

	        if (isInserted) {
	            int spaceInfoNo = space_regService.space_info_currseq();
	            model.addAttribute("space_info_no", spaceInfoNo);
	            return "redirect:/space_reg/insertform2";
	        } else {
	            return "redirect:/space_reg/insertform";
	        }
	    }

	@RequestMapping("insertform2")
	public String insertForm2(Model model, HttpServletRequest request,
			@RequestParam("space_info_no") int space_info_no) {
		Integer no = (Integer) request.getSession().getAttribute("login"); // 이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
		if (no == null) {
			return "redirect:/host/loginform";
		}
		model.addAttribute("space_info_no", space_info_no);
		return ViewPath.SPACE_REG + "insertForm2.jsp";

	}

	@RequestMapping("insert2")
	public String insert2(Model model, Contact_InfoVO vo, HttpServletRequest request,
			@RequestParam("space_info_no") int space_info_no) { // SPACE_INFO_no 전달중
		Integer no = (Integer) request.getSession().getAttribute("login"); // 이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
		if (no == null) {
			return "redirect:/host/loginform";
		}

		int res = space_regService.contact_info_insert(vo);
		int contact_info_no = space_regService.contact_info_currseq();

		if (res != 0) {
			model.addAttribute("contact_info_no", contact_info_no);
			model.addAttribute("space_info_no", space_info_no);
			return "redirect:/space_reg/insertform3";
		} else {
			return "redirect:/space_reg/insertform2";
		}

	}

	@RequestMapping("insertform3")
	public String insertForm3(Model model, HttpServletRequest request, @RequestParam("space_info_no") int space_info_no,
			@RequestParam("contact_info_no") int contact_info_no) {
		Integer no = (Integer) request.getSession().getAttribute("login"); // 이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
		if (no == null) {
			return "redirect:/host/loginform";
		}
		List<TmVO> tlist = etcService.tm_List(); // 시간 리스트
		List<Day_WeekVO> dList = etcService.dayWeekList();//요일리스트

		model.addAttribute("tlist", tlist);
		model.addAttribute("dList", dList);

		model.addAttribute("contact_info_no", contact_info_no);
		model.addAttribute("space_info_no", space_info_no);
		return ViewPath.SPACE_REG + "insertForm3.jsp";

	}

	@RequestMapping("insert3")
	public String insert3(Model model, Usage_InfoVO uvo, Reg_ClosedVO rvo, Dsg_ClosedVO dvo, HttpServletRequest request,
	                      @RequestParam("space_info_no") int space_info_no, @RequestParam("contact_info_no") int contact_info_no,
	                      @RequestParam("dayWeekNo[]") String[] dayWeekNos) {
	    Integer no = (Integer) request.getSession().getAttribute("login"); // 세션에서 로그인 정보 확인
	    if (no == null) {
	        return "redirect:/host/loginform";
	    }

	    try {
	        // 전체 DB 작업을 트랜잭션으로 묶은 서비스 메서드 호출
	        space_regService.insertUsageInfoAndRelatedData(uvo, rvo, dvo, dayWeekNos);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "redirect:/space_reg/insertform3"; // 트랜잭션 실패 시 돌아갈 페이지
	    }

	    int usage_info_no = space_regService.usage_info_currseq();

	    model.addAttribute("contact_info_no", contact_info_no);
	    model.addAttribute("space_info_no", space_info_no);
	    model.addAttribute("usage_info_no", usage_info_no);

	    return "redirect:/space_reg/insertform4";
	}

	@RequestMapping("insertform4")
	public String insertForm4(Model model, HttpServletRequest request, @RequestParam("space_info_no") int space_info_no,
			@RequestParam("contact_info_no") int contact_info_no, @RequestParam("usage_info_no") int usage_info_no) {
		Integer no = (Integer) request.getSession().getAttribute("login"); // 이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
		if (no == null) {
			return "redirect:/host/loginform";
		}

		List<BankVO> blist = etcService.bankList(); // 은행명
		List<Bsns_TypeVO> btlist = bsns_infoService.businessmanList(); // 사업자 유형

		model.addAttribute("blist", blist); // 은행명 리스트
		model.addAttribute("btlist", btlist); // 사업가 유형 리스트

		model.addAttribute("contact_info_no", contact_info_no);
		model.addAttribute("space_info_no", space_info_no);
		model.addAttribute("usage_info_no", usage_info_no);
		return ViewPath.SPACE_REG + "insertForm4.jsp";

	}

	@RequestMapping("insert4")
    public String insert4(Model model, Account_InfoVO avo, Refund_StandardVO rvo, Bsns_InfoVO bvo,
                          @RequestParam("space_info_no") int space_info_no,
                          @RequestParam("contact_info_no") int contact_info_no,
                          @RequestParam("usage_info_no") int usage_info_no, HttpServletRequest request) {

        // 세션에서 로그인된 사용자의 번호 가져오기
        Integer no = (Integer) request.getSession().getAttribute("login");
        if (no == null) {
            return "redirect:/host/loginform"; // 로그인하지 않으면 로그인 페이지로 리다이렉트
        }

        // 서비스 호출 (트랜잭션 처리)
        int basic_info_no =  space_regService.insert4(avo, rvo, bvo, space_info_no, contact_info_no, usage_info_no, no);

        // 트랜잭션 성공 여부에 따라 메시지와 URL 설정
        String msg = null;
        String url = null;

        if (basic_info_no > 0) {
            msg = "공간 등록 완료! 이제 세부 공간 및 가격 정보를 입력해주세요.";
            url = "/space/ds/dsAdd?basic_info_no=" + basic_info_no + "&space_info_no=" + space_info_no; // get방식으로 보내기
        } else {
            msg = "공간 등록 실패! 다시 시도해주세요.";
            url = "/space/register"; // 실패 시 등록 페이지로 이동
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        return ViewPath.SPACE_REG + "regiResult.jsp"; // 결과 페이지로 리턴
    }

}
