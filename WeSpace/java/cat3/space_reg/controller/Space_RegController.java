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
	public String Space_reg_insert(Model model, Space_InfoVO vo, HttpServletRequest request) {
		
		
		
        String savePath = application.getRealPath("/resources/imgfile/");//저장해줄 경로
		
		MultipartFile img = vo.getPhoto();
		
		vo.setSpace_info_repimg(img.getOriginalFilename()); 
		File saveFile = new File(savePath,vo.getSpace_info_repimg());
		saveFile.mkdirs();
		 
	    try {
	    	img.transferTo(saveFile);
	    } catch (IllegalStateException | IOException e) {
	    	e.printStackTrace();
	    }
		
		
		
		
		
		String space_uses_no = request.getParameter("space_uses_no"); // 공간용도 여러개
		String space_tag_name = request.getParameter("space_tag_name"); // 태그 여러개
		String fclty_guide_content = request.getParameter("fclty_guide_content"); // 시설 안내 여러개
		String rsrvt_notes_content = request.getParameter("rsrvt_notes_content"); // 예약시 주의사항 여러개

		String[] uses_values = space_uses_no.split(",");
		String[] tag_values = space_tag_name.split(",");
		String[] guide_values = fclty_guide_content.split(",");
		String[] note_values = rsrvt_notes_content.split(",");

		int seq = space_regService.space_info_seq(); // currval쓰려면 있어야함

		int res = space_regService.space_info_insert(vo); // 공간정보 인서트 //뒤에 기본정보 테이블 insert를 위해 계속 model로 넘겨줘야함.


		
		
		/*
		 * Boolean result = Boolean.FALSE; try { Space_InfoVO svo = new Space_InfoVO();
		 * String dirName = application.getRealPath("/resources/imgfile/"); File folder
		 * = new File(dirName); if (!folder.exists()) { folder.mkdirs(); }
		 * 
		 * // 파일 경로 설정 String filePath = dirName + File.separator +
		 * photo.getOriginalFilename(); File destination = new File(filePath);
		 * 
		 * // 파일 저장 photo.transferTo(destination);
		 * 
		 * // Space_InfoVO에 파일 경로 설정 svo.setSpace_info_repimg(filePath);
		 * 
		 * result = Boolean.TRUE; } catch (IOException e) { e.printStackTrace(); }
		 */

		if (res != 0) { // 공간정보를 입력했다면
			List<String> uses_List = Arrays.asList(uses_values); // 숫자가 들어갈 list공간
			for (String num : uses_List) {
				int no = Integer.parseInt(num);
				int su = connectionService.select_use_insert(no); // 연결테이블 인서트 (기본정보 xml에 존재)
			}

			List<String> tag_List = Arrays.asList(tag_values);
			for (String val : tag_List) {
				int su = connectionService.space_tag_insert(val); // 태그 인서트
			}

			List<String> guide_List = Arrays.asList(guide_values);
			for (String val : guide_List) {
				int su = connectionService.fclty_guide_insert(val); // 시설안내 인서트
			}

			List<String> note_List = Arrays.asList(note_values);
			for (String val : note_List) {
				int su = connectionService.rsrvt_notes_insert(val); // 예약시 주의사항 인서트
			}

			int space_info_no = space_regService.space_info_currseq();
			model.addAttribute("space_info_no", space_info_no); // 밑에 메소드에서는 뺴도 됨 얘만 있으면 ok

			return "redirect:/space_reg/insertform2"; // 두번째 입력페이지
		} else { // 공간정보를 입력하지 않았다면 인서트 창으로

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
	public String insert3(Model model, Usage_InfoVO uvo, Reg_ClosedVO rvo,Dsg_ClosedVO dvo, HttpServletRequest request,
			@RequestParam("space_info_no") int space_info_no, @RequestParam("contact_info_no") int contact_info_no, @RequestParam("dayWeekNo[]") String[] dayWeekNos) {
		Integer no = (Integer) request.getSession().getAttribute("login"); // 이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
		if (no == null) {
			return "redirect:/host/loginform";
		}
		int seq = space_regService.usage_info_seq(); // currval사용하려고

		int res = space_regService.usage_info_insert(uvo);
	
		
		 for(int i=0; i < dayWeekNos.length; i++) {
			 rvo.setDay_week_no(Integer.parseInt(dayWeekNos[i]));
			int su2 = connectionService.reg_closed_insert(rvo);
		 }
		
		
		
		int su3 = connectionService.dsg_closed_insert(dvo);

		int usage_info_no = space_regService.usage_info_currseq();

		if (res != 0) {
			model.addAttribute("contact_info_no", contact_info_no);
			model.addAttribute("space_info_no", space_info_no);
			model.addAttribute("usage_info_no", usage_info_no);
			return "redirect:/space_reg/insertform4";
		} else {
			return "redirect:/space_reg/insertform3";
		}

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
			HttpServletRequest request, @RequestParam("space_info_no") int space_info_no,
			@RequestParam("contact_info_no") int contact_info_no, @RequestParam("usage_info_no") int usage_info_no) {
		Integer no = (Integer) request.getSession().getAttribute("login"); // 이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
		if (no == null) {
			return "redirect:/host/loginform";
		}
		int su = bsns_infoService.account_info_insert(avo); // 순서 중요
		int su1 = bsns_infoService.refund_standard_insert(rvo); // 얘랑 위에 먼저 insert 해야함.

		String msg = null;
		String url = null;
		int su2 = bsns_infoService.bsns_info_insert(bvo);

		int bsns_info_no = bsns_infoService.bsns_info_currseq();

		Basic_InfoVO vo = new Basic_InfoVO(); // 객체 생성

		vo.setSpace_info_no(space_info_no);
		vo.setContact_info_no(contact_info_no);
		vo.setUsage_info_no(usage_info_no);
		vo.setBsns_info_no(bsns_info_no);
		vo.setHost_no(no);

		int res = space_regService.basic_info_insert(vo);
		int basic_info_no = space_regService.basic_info_currseq();

		if (res != 0) {
			msg = "공간 등록 완료! 이제 세부 공간 및 가격 정보를 입력해주세요.";
			url = "/space/ds/dsAdd?basic_info_no=" + basic_info_no + "&space_info_no=" + space_info_no; // get방식으로 보내기
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return ViewPath.SPACE_REG + "regiResult.jsp";
	}

}
