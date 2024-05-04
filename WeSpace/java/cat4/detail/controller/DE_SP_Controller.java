package cat4.detail.controller;

import java.io.File;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import all.service.EtcService;
import all.vo.Day_WeekVO;
import all.vo.FACILITY_SelVO;
import all.vo.FacilityVO;
import all.vo.TmVO;
import cat2.service.SpaceService;
import cat3.connection.service.ConnectionService;
import cat3.connection.vo.Select_UseVO;
import cat3.space_reg.service.Space_RegService;
import cat3.space_reg.vo.Basic_InfoVO;
import cat3.space_reg.vo.Usage_InfoVO;
import cat4.day.vo.DAY_PriceVO;
import cat4.day.vo.DAY_TM_PrVO;
import cat4.detail.service.DE_SP_Service;
import cat4.detail.vo.DE_SP_AddVO;
import cat4.detail.vo.DE_SP_ImgVO;
import cat4.detail.vo.DE_SP_InfoVO;
import cat4.detail.vo.DE_SP_TyseVO;
import cat4.hr.vo.SET_PX_HrVO;
import cat4.pckg.vo.ADD_PCKG_tVO;
import cat4.pckg.vo.PCKG_PrcstVO;
import common.ViewPath;

@Controller
@RequestMapping("/ds/")
public class DE_SP_Controller {

	 
	
	private DE_SP_Service de_sp_service;
	private SpaceService spaceService;
	private ConnectionService connectionService;
	private Space_RegService space_regService;
	private EtcService etcService;
	
	public DE_SP_Controller(DE_SP_Service de_sp_service, SpaceService spaceService,ConnectionService connectionService,Space_RegService space_regService,EtcService etcService) {
		this.de_sp_service = de_sp_service;
		this.spaceService = spaceService;
		this.connectionService = connectionService;
		this.space_regService = space_regService;
		this.etcService = etcService;
	} 
	@Autowired
	private ServletContext application;
	
	@RequestMapping("showMySpace")
	public String showMySpace(Model model, HttpServletRequest request) {
		Integer no = (Integer)request.getSession().getAttribute("login"); //이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
		if (no == null) {
			return "redirect:/host/loginform";
		}
		List<Map<Integer,Object>> basicInfo = space_regService.select_host_space(no);
		
		model.addAttribute("basicInfo", basicInfo);
		return ViewPath.DS + "MySpace.jsp";
	}
	
	
	@RequestMapping("selectSpace{space_info_no}/{basic_info_no}") 
	public String plusspace(Model model,@PathVariable("space_info_no") int space_info_no,@PathVariable("basic_info_no") int basic_info_no){
	
		String url = "/space/ds/dsAdd?basic_info_no=" + basic_info_no + "&space_info_no=" + space_info_no;
				
		model.addAttribute("url", url);

		return ViewPath.DS + "result.jsp";
	}
	
	
	
	
	@RequestMapping("dsAdd")//매개변수 주의//@RequestParam의 required 속성을 false로 설정하면 해당 매개변수가 필수적이지 않음을 나타냄(이게 꼭 필요하고 없으면 오류)
	public String inserForm(Model model, HttpServletRequest request, @RequestParam(name = "basic_info_no", required = false) Integer basic_info_no, @RequestParam(name = "space_info_no", required = false) Integer space_info_no) {
	   if(basic_info_no == null){ 
		  String msg = "공간 등록을 먼저 해주세요";
		  String url="/space/space_reg/insertform";
		 model.addAttribute("msg",msg); 
		 model.addAttribute("url",url); 
		   return ViewPath.SPACE_REG  + "regiResult.jsp";
	   }else {
		
		 Map<String, Object> params = new HashMap<>();
	        params.put("basic_info_no", basic_info_no);
	        params.put("space_info_no", space_info_no);
		List<Map<Integer,Object>> uses = spaceService.showMyUses(params); //내가 고른 용도명
		
		List<FacilityVO> flist = de_sp_service.selectList();//편의시설 리스트
		
		model.addAttribute("uses", uses);
		model.addAttribute("flist", flist);
		model.addAttribute("basic_info_no", basic_info_no);
		return ViewPath.DS +"dsAdd.jsp";
	   }
	}
	
	@RequestMapping("insert1")
	public String insert(Model model, DE_SP_InfoVO dvo/* ,DE_SP_ImgVO dIvo,FACILITY_SelVO fvo*/,DE_SP_TyseVO dtvo,@RequestParam("basic_info_no") int basic_info_no, HttpServletRequest request) {
		String savePath = application.getRealPath("/resources/imgfile/");//저장해줄 경로
		
		MultipartFile img = dvo.getPhoto(); //세부공간이미지
		
		dvo.setDe_sp_info_img(img.getOriginalFilename());
		File saveFile = new File(savePath,dvo.getDe_sp_info_img());
		saveFile.mkdirs();
		
		try {
			img.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		int res = de_sp_service.de_sp_info_insert(dvo); //세부공간정보
		 
		
		
		 String space_uses_no= request.getParameter("space_uses_no"); 
		 String facility_no= request.getParameter("facility_no");
		 
		 String[] uses_values = space_uses_no.split(",");
		 String[] facility_values = facility_no.split(",");
		 
		 if(res != 0) { //세부공간정보를 입력했다면
	    	  List<String> uses_List = Arrays.asList(uses_values); //숫자가 들어갈 list공간
		      for(String num : uses_List) {
		    	 int no = Integer.parseInt(num);
		         int su = de_sp_service.de_sp_tyse_insert(no); //세부공간 유형 선택 insert
		      }
		      List<String> facility_List = Arrays.asList(facility_values);
		      for(String num : facility_List) {
		    	  int no = Integer.parseInt(num);
		    	  int su = de_sp_service.facility_selinsert(no); //편의시설 선택 insert
		      }
		      
		      int de_sp_info_no = de_sp_service.de_sp_info_currseq(); 
		      DE_SP_AddVO dsvo = new DE_SP_AddVO(); //객체 생성
				
			    dsvo.setDe_sp_info_no(de_sp_info_no);
			    dsvo.setBasic_info_no(basic_info_no);
			    
			    int res2 = de_sp_service.de_sp_add_insert(dsvo);
			    int de_sp_add_no = de_sp_service.de_sp_add_currseq(); 
			    
			    model.addAttribute("de_sp_add_no",de_sp_add_no);
		 }
		 
			 model.addAttribute("basic_info_no", basic_info_no);
			
		 return ViewPath.DS + "reUnit.jsp"; 
		
	}
	
	@RequestMapping("reUnit") //그냥 페이지 이동만 하려는 애 
	public String timeForm(Model model) {
		 return ViewPath.DS + "reUnit.jsp";
	}

	@RequestMapping("time")
	public String timeForm(Model model,@RequestParam(name = "basic_info_no", required = false) Integer basic_info_no,@RequestParam(name = "de_sp_add_no", required = false) Integer de_sp_add_no) {
		
		int useq = space_regService.selectusageSeq(basic_info_no);
		
		List<Day_WeekVO> dlist = etcService.weekList(useq); //요일 리스트
		Usage_InfoVO usageTm = space_regService.selectUsageTm(basic_info_no); //공간 등록때 설정했던 이용시간
		
		
		  int start = usageTm.getTm_no_start(); //이용 시작시간(의 시퀀스)
		  int end = usageTm.getTm_no_end(); //이용 마감시간(의 시퀀스)
		  
		  List<String> Times = new ArrayList<>(); 
		  List<Integer> StartTime = new ArrayList<>(); 
		  List<Integer> EndTime = new ArrayList<>(); 
		  
		  for(int i =0; i<end-start;i++) {
			  Times.add((start+i-1)+"~"+(start+i)); //ex)0 ~ 1(시)
				 StartTime.add(start+i); 
				 EndTime.add(start+i+1);
		  }
		  
		  
	    model.addAttribute("de_sp_add_no",de_sp_add_no);
		model.addAttribute("Times", Times); 
		model.addAttribute("StartTime",StartTime); 
		model.addAttribute("EndTime", EndTime); 
		
		model.addAttribute("dlist",dlist); //요일
		
		return ViewPath.DS +"time.jsp";
	}
	
	@RequestMapping(value = "timeinsert")
	@ResponseBody //저장버튼 눌렀을 때 
	public int timeinsert(Model model,SET_PX_HrVO vo, HttpServletRequest request) {
		int su  = de_sp_service.set_px_hr_insert(vo);
		
			int seq  = de_sp_service.set_px_hr_currseq();
		
		return seq;
	}
	


	@RequestMapping(value = "timePrice", produces = "application/text;charset=utf8" ) //등록하기 눌렀을 때 
	@ResponseBody
	public String timePrice(Model model, HttpServletRequest request, HttpServletResponse response,@RequestParam("set_px_hr_no") int hrNo) {
		
	    Map<String, String[]> parameterMap = request.getParameterMap(); // 요청에서 전달된 모든 파라미터 가져와 변수에 저장.
	    
	    try {
	        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) { // 반복문 실행
	            String paramName = entry.getKey(); // entry.getKey()로 파라미터의 이름을 가져오고,
	            String[] paramValues = entry.getValue(); // entry.getValue()로 해당 파라미터의 값을 가져옵니다.

	            // 시간대별 가격을 입력하는 요청인지 확인합니다.
	            if (paramName.startsWith("day_tm_pr_price_")) {// 파라미터 이름이 이걸로 시작한다면,
	                String[] tokens = paramName.split("_"); // 파라미터의 이름을 "_"로 분할해 토큰 배열 만들기
	                int dayWeekNo = Integer.parseInt(tokens[4]); // 4번째 글자(숫자) 가져옴
	                int start = Integer.parseInt(tokens[5]); // 5번째 
	                int end = Integer.parseInt(tokens[6]); // 6번째
	                
	                for (int i = 0; i < paramValues.length; i++) { // 파라미터 개수만큼 반복
	                    String paramValue = paramValues[i]; // 시간대별 가격 나타냄
	                    int price = Integer.parseInt(paramValue); // 정수 값으로 바꾸기.

	                    // 데이터베이스에 저장할 VO 객체를 생성합니다.
	                    DAY_TM_PrVO dvo = new DAY_TM_PrVO();
	                    dvo.setDay_week_no(dayWeekNo);
	                    dvo.setTm_no_start(start + i - 1);
	                    dvo.setTm_no_end(start + i);
	                    dvo.setSet_px_hr_no(hrNo);
	                    dvo.setDay_tm_pr_price(price);

	                    // 데이터베이스에 가격 정보를 저장합니다.
	                    int su = de_sp_service.day_tm_pr_insert(dvo);
	                    if (su == 0) {
	                        return  "요일별 가격 설정에 실패했습니다.";
	                    }
	                }
	            }
	        }
	        return "요일별 가격을 설정했습니다.";
	    } catch (NumberFormatException e) {
	    	return "파라미터 값이 잘못되었습니다.";
	    } catch (Exception e) {
	    	return "서버 오류가 발생했습니다."; 
	    }
	}
	
	
	

	@RequestMapping("timeUpdate")
	public String timeUpdate(Model model, HttpServletRequest request,SET_PX_HrVO vo,@RequestParam("hrNo") int hrNo) {
		
        vo.setSet_px_hr_no(hrNo);

		int su = de_sp_service.set_px_hr_update(vo);
		int su1 = de_sp_service.de_sp_add_update();
		
		String url = "/space/ds/reUnit";
		String msg = "";
		
		if( su != 0 ) {
		 msg = "저장 성공!";
		}else {
			msg = "저장 실패!";
		}
		model .addAttribute("msg",msg);
		model.addAttribute("url", url);

		return ViewPath.SPACE_REG + "regiResult.jsp"; 
	}
	
	@RequestMapping(value = "preInsert")
	 @ResponseBody 
		public int preInsert(Model model, PCKG_PrcstVO pvo,HttpServletRequest request) {
		 int su = de_sp_service.pckg_prcst_insert(pvo);
		
			 int seq = de_sp_service.pckg_prcst_currseq();
			 
			 return seq;
			
		 }
		
	
	 @RequestMapping(value = "packageInsert", produces = "application/text;charset=utf8")
	 @ResponseBody
	 public String packageInsert(Model model, ADD_PCKG_tVO avo , 
	                             @RequestParam("day_week_no[]") String[] dayWeekNos, 
	                             @RequestParam("day_price_price[]") String[] dayPricePrices, 
	                             @RequestParam("pckg_prcst_no") int pckg_prcst_no ,
	                             HttpServletRequest request) {
	     avo.setPckg_prcst_no(pckg_prcst_no);
	     int su1 = de_sp_service.add_pckg_t_insert(avo); 
	     int aseq = de_sp_service.add_pckg_t_currseq();
	     DAY_PriceVO dvo = new DAY_PriceVO();
	     if (su1 != 0) {
	         for (int i = 0; i < dayWeekNos.length; i++) {
	             dvo.setAdd_pckg_t_no(aseq);
	             dvo.setDay_week_no(Integer.parseInt(dayWeekNos[i]));
	             dvo.setDay_price_price(Integer.parseInt(dayPricePrices[i]));
	             int su2 = de_sp_service.day_price_insert(dvo);

	             if (su2 == 0) {
	                 // 하나라도 실패하면 저장 실패를 반환하고 종료
	                 return "저장 실패";
	             }
	         }
	         // 모든 요소가 성공적으로 저장되었을 때만 저장 성공 반환
	         return "저장 성공";
	     }
	     return "저장 실패";
	 }
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("package")
	public String packageForm(Model model,@RequestParam(name = "basic_info_no", required = false) Integer basic_info_no,@RequestParam(name = "de_sp_add_no", required = false) Integer de_sp_add_no) {
		
		int useq = space_regService.selectusageSeq(basic_info_no);
		List<Day_WeekVO> dlist = etcService.weekList(useq); //요일 리스트
		Usage_InfoVO usageTm = space_regService.selectUsageTm(basic_info_no); //공간 등록때 설정했던 이용시간
		
		 int start = usageTm.getTm_no_start(); //이용 시작시간(의 시퀀스)
		  int end = usageTm.getTm_no_end(); //이용 마감시간(의 시퀀스)
		  
		  List<Integer> StartTime = new ArrayList<>(); 
		  List<Integer> EndTime = new ArrayList<>(); 
		  for(int i =0; i<end-start;i++) {
			 
				 StartTime.add(start+i-1); 
				 EndTime.add(start+i);
		  }
		  
	    model.addAttribute("de_sp_add_no",de_sp_add_no);
		model.addAttribute("StartTime",StartTime); 
		model.addAttribute("EndTime", EndTime); 
		
		model.addAttribute("dlist",dlist); //요일
		
		
		return ViewPath.DS +"package.jsp";
	}
	
	
	@RequestMapping("pckgUpdate")
	public String pckgUpdate(Model model, HttpServletRequest request,PCKG_PrcstVO vo,@RequestParam("pckgNo") int pckgNo) {
		
        vo.setPckg_prcst_no(pckgNo);

		int su = de_sp_service.pckg_prcst_update(vo);
		int su1 = de_sp_service.de_sp_add_update();
		String url = "/space/ds/reUnit";
		String msg = "";
		
		if( su != 0 ) {
		 msg = "저장 성공!";
		}else {
			msg = "저장 실패!";
		}
		model .addAttribute("msg",msg);
		model.addAttribute("url", url);

		return ViewPath.SPACE_REG + "regiResult.jsp"; 
	}
	
	@RequestMapping("/ds/list")
	public String despList(Model model) {

		
		return ViewPath.DS + "deSpList.jsp";
	}
	
	
	@RequestMapping("/ds/updateform")
	public String updateForm(Model model, int seq) {
		DE_SP_InfoVO vo = de_sp_service.infoSelectOne(seq);
		
		model.addAttribute("vo",vo);
		
		return ViewPath.DS + "dsAdd.jsp";
	}
	
	
	// 수정 버튼눌르면 de_sp_info 입력칸으로 이동 ( 필요 x )
	@RequestMapping("/ds/update")
	public String update(Model model, DE_SP_InfoVO vo) {
		
		int su = de_sp_service.update(vo);
		
		model.addAttribute("su", su);
		
		return ViewPath.DS + "deSpList.jsp";
	}
	
	@RequestMapping("/ds/delete")
	public String delete(Model model, int seq) {
		
		int su = de_sp_service.infoDelete(seq);
		
		model.addAttribute("su", su);
		
		return ViewPath.DS + "deSpList.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
