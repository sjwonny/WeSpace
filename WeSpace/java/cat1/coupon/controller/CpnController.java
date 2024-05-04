package cat1.coupon.controller;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import all.vo.GuestVO;
import all.vo.HostVO;
import cat1.coupon.service.CpnService;
import cat1.coupon.vo.CpnVO;
import cat1.coupon.vo.MyCpnVO;
import cat1.profile.service.ProfileService;
import cat1.profile.vo.DetaareaVO;
import cat1.profile.vo.InterestVO;
import cat1.profile.vo.IntrareaVO;
import cat1.profile.vo.LfstyVO;
import cat1.profile.vo.ProfileVO;

@Controller
@RequestMapping("/coupon/")
public class CpnController {

	private CpnService cpnService;

	public CpnController(CpnService cpnService) {
		this.cpnService = cpnService;
	}

	
	@Autowired //해당 필드에 알맞은 의존성을 자동으로 주입. (??)
	private ServletContext application;
	
	
	@RequestMapping("create")
	public String createForm(HttpSession session) { 
		Integer no = (Integer) session.getAttribute("login");//관리자 로그인??이어야하는건가(일단 게스트로그인으로 해둠)
		
		if (no == null) {
			return "redirect:/guest/loginform";
		}
		
		return ViewPath.COUPON + "createCoupon.jsp";
		}
	

	@RequestMapping("save")
	public String save(Model model,HttpSession session,CpnVO vo) { 
		Integer no = (Integer)session.getAttribute("login");//관리자 로그인??이어야하는건가(일단 게스트로그인으로 해둠)
		if (no == null) {
			return "redirect:/guest/loginform";
		}
		String msg= null;
    	String url= null;
    	vo.setCpn_type("0");
    	int su = cpnService.insertCoupon(vo);
    	
		
		  if(su != 0) { msg="쿠폰생성 성공! 로그인 페이지로..."; 
		  	  url="/space/";
		  }else {
			  msg="쿠폰생성 실패! 이전페이지로..."; url="history.back()";
		  }
		 
    
    	model.addAttribute("url",url);
    	model.addAttribute("msg",msg);
		return ViewPath.COUPON + "couponResult.jsp";
		}

	
		
		
	
	
}
	
	
	
	
	
	

