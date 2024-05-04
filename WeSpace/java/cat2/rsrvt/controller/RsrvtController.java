package cat2.rsrvt.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import all.vo.GuestVO;
import cat1.member.guest.login.LoginService;
import cat1.profile.service.ProfileService;
import common.ViewPath;
import cat2.rsrvt.service.RsrvtService;
import cat2.rsrvt.vo.RsrvtVO;

@Controller
@RequestMapping("/rsrvt/")
public class RsrvtController {

	private RsrvtService rsrvtService;
	
	
	public RsrvtController(RsrvtService rsrvtService) {
		this.rsrvtService = rsrvtService;
	}

	 @RequestMapping("level")
	 	public String showlevel(Model model, HttpServletRequest request) {
		 Integer no = (Integer)request.getSession().getAttribute("login");
			if (no == null) {
				return "redirect:/guest/loginform";
			}
			RsrvtVO vo = new RsrvtVO();
		    vo.setGuest_no(no);
			int cnt = rsrvtService.selectrsrvtCnt(no);
			
			model.addAttribute("cnt",cnt);
			
			return  ViewPath.LEVEL + "modal.jsp";
	 }
	
}
