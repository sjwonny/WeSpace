package cat2.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.ViewPath;
import cat2.service.SpaceService;
import cat3.connection.vo.Fclty_GuideVO;
import cat3.connection.vo.Reg_ClosedVO;
import cat3.connection.vo.Rsrvt_NotesVO;
import cat3.connection.vo.Space_TagVO;
import cat3.space_reg.vo.Space_InfoVO;
import cat4.detail.vo.DE_SP_TyseVO;
import all.vo.Day_WeekVO;
import all.vo.FacilityVO;
import all.vo.GuestVO;
import all.vo.Space_themeVO;
import all.vo.Space_typeVO;
import all.vo.Space_usesVO;

@Controller
public class SpaceController {

	private SpaceService spaceService;
	
	@Autowired
	public SpaceController(
			SpaceService spaceService
			) {
		this.spaceService = spaceService;
	}
	
	@RequestMapping("/")
	public String home(Model model,HttpServletRequest request) {
			
		List<Space_usesVO> useslist = spaceService.usesSelectAll(); 
		List<Space_typeVO> typelist = spaceService.typeSelectAll();
		List<Space_themeVO> themelist = spaceService.themeSelectAll();
		
		List<Map<String,Object>> allspaceList = spaceService.select_spaceAll();

		model.addAttribute("uses", useslist); //용도
		model.addAttribute("type", typelist); //유형
		model.addAttribute("theme", themelist); //테마
		model.addAttribute("allspaceList",allspaceList);

		return ViewPath.INDEX + "index.jsp";
	}
	
	@RequestMapping("/space/detail")
	public String detail(Model model,int de_sp_add_no,int space_info_no,int de_sp_info_no,int usage_info_no) {
			
		Map<String,Object> allDetail = spaceService.spaceAndDetail(de_sp_add_no);
		List<Fclty_GuideVO> gList = spaceService.selectGuide(space_info_no); //시설 안내
		List<Rsrvt_NotesVO> nList = spaceService.selectNotes(space_info_no); //주의사항
		List<Space_TagVO> tList = spaceService.selectTag(space_info_no); //태그
		List<FacilityVO> fList = spaceService.detailFacility(de_sp_info_no); //편의시설
		List<Space_usesVO> sList = spaceService.selectType(de_sp_info_no); //공간유형
		
		List<Day_WeekVO> rList = spaceService.closedDay(usage_info_no); //휴무일
		int minPrice = spaceService.selectMinPrice(de_sp_add_no); //시간별가격(최저가)
		
		model.addAttribute("allDetail", allDetail);
		model.addAttribute("gList",gList);
		model.addAttribute("nList",nList);
		model.addAttribute("tList",tList);
		model.addAttribute("fList",fList);
		model.addAttribute("sList",sList);
		model.addAttribute("rList",rList);
		model.addAttribute("minPrice",minPrice);
		
		return ViewPath.SPACE + "detail.jsp";
	}
	
	//카테고리 선택
	@RequestMapping("/space/showUses")
	public String showUses(Model model,int space_uses_no, String space_uses_name) {
		List<Map<String,Object>> UsesSpaceList = spaceService.select_spaceUses(space_uses_no);
		
		model.addAttribute("UsesSpaceList",UsesSpaceList);
		model.addAttribute("space_uses_name",space_uses_name);
		
	
		return ViewPath.SPACE + "showUses.jsp";
		
	}
	
	//테마 선택
	@RequestMapping("/space/showTheme")
	public String showTheme(Model model,int space_theme_no, String space_theme_name) {
		List<Map<String,Object>> ThemeSpaceList = spaceService.select_spaceTheme(space_theme_no);
		
		model.addAttribute("ThemeSpaceList",ThemeSpaceList);
		model.addAttribute("space_theme_name",space_theme_name);
		
		
		return ViewPath.SPACE + "showTheme.jsp";
		
	}
	
	
	
	@RequestMapping("/space/reservation")
	public String reservation(Model model) {
			

		return ViewPath.SPACE + "reservation.jsp";
	}
	
}
