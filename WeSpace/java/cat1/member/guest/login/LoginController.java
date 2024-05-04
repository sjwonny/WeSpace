package cat1.member.guest.login;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.ViewPath;
import all.vo.GuestVO;
import all.vo.HostVO;
import cat1.coupon.service.CpnService;
import cat1.profile.service.ProfileService;
import cat1.profile.vo.DetaareaVO;
import cat1.profile.vo.InterestVO;
import cat1.profile.vo.IntrareaVO;
import cat1.profile.vo.LfstyVO;
import cat1.profile.vo.ProfileVO;
import cat2.rsrvt.service.RsrvtService;

@Controller
@RequestMapping("/guest/")
public class LoginController {

	private LoginService loginService;
	private ProfileService profileService;
	private RsrvtService rsrvtService;
	private CpnService cpnService;
	
	public LoginController(LoginService loginService,ProfileService profileService,RsrvtService rsrvtService,CpnService cpnService) {
		this.loginService = loginService;
		this.profileService = profileService;
		this.rsrvtService = rsrvtService;
		this.cpnService = cpnService;
	}

	
	@RequestMapping("joinform") 
	public String joinForm() {
		return ViewPath.GUEST + "joinForm.jsp";
	}
	
	
	
	@RequestMapping("loginform")
	public String loginForm(HttpServletRequest request,String guest_email) {
		
     boolean check = false; 
		
		if(guest_email == null) {
			Cookie[] cks = request.getCookies(); //쿠키를 가져와서 cks라는 배열에 담기
			
			if(cks != null) {  //쿠키가 있다면
				for(Cookie ck : cks) { //쿠키 수 만큼 반복
					if(ck.getName().equals("ckid")) { 
						guest_email = ck.getValue();
						check = true; //체크는 true
						break; //탈출
					}
				}
			}
		}
		
		request.setAttribute("guest_email", guest_email); //이메일 전달
		request.setAttribute("check", check);
		
		
		
		return ViewPath.GUEST + "loginForm.jsp";
	}
	

	
	@RequestMapping("login/check")
	public String checkLogin(HttpServletRequest request, HttpServletResponse response, GuestVO vo) {

		int no = loginService.checkLogin(vo);
		int badgeCnt = profileService.badgeCnt(no);
		GuestVO gvo = profileService.selectOne(no);
		int countCpn = cpnService.countMyCpn(no);
		
		String msg = null;
		String url = null;
		boolean check = false;

		if (no != 0) { //회원정보를 조회했으나 없었다면 0 있었다면 !=0(로그인 성공)
			msg = "로그인 성공!";
			url = "/space/";
			check = true;

			request.getSession().setAttribute("login", no);
			request.getSession().setAttribute("gvo", gvo);
			request.getSession().setAttribute("badgeCnt", badgeCnt);
			request.getSession().setAttribute("countCpn", countCpn);
			
			//예약 수
			int cnt = rsrvtService.selectrsrvtCnt(no);
			//세션 업데이트
			request.getSession().setAttribute("rsrvtCnt", cnt);
			
			//아이디 기억하기 체크 유무
			String ckid = request.getParameter("ckid");

			Cookie ck = null;

			//쿠키파일 읽어 오기
			Cookie[] cks = request.getCookies();

			// 기존 쿠키파일 검색
			if (cks != null) {
				for (Cookie c : cks) {
					if (c.getName().equals("ckid")) {
						ck = c;
						break;
					}
				}
			}

			if (ckid != null) { 
				if (ck == null) { 
					ck = new Cookie("ckid", vo.getGuest_email());

					// root로 경로 설정
					ck.setPath("/");

					// 유효시간 설정
					ck.setMaxAge(60 * 60 * 24);

					// 클라이언트에게 쿠키파일 생성
					response.addCookie(ck);
				} else { 
					if (!ck.getValue().equals(vo.getGuest_email())) {
						ck.setValue(vo.getGuest_email());
						ck.setPath("/");
						response.addCookie(ck);
					}
				}
			} else { 
				if (ck != null) {
					if (ck.getValue().equals(vo.getGuest_email())) {
						ck.setPath("/");
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
				}
			}

		} else {
			msg = "이메일 혹은 비밀번호가 잘못되었습니다.";
			url = "/space/guest/loginform";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("check", check);

		return ViewPath.GUEST + "loginResult.jsp";

	}
	
	
	@RequestMapping(value = "checkId",produces = "application/text;charset=utf8") // application/text;charset=utf8 : 텍스트 데이터를 생성하고, 문자 인코딩은 UTF-8로 설정되어 있다는 것을 의미
	@ResponseBody 
	public String checkId(String guest_nickname) { 
		
		
		if(loginService.checkId(guest_nickname)) { 
			return "이미 사용중인 닉네임입니다."; 
		}else { 
			return "사용 가능한 닉네임입니다";
		}
	}
	
	 @RequestMapping("join")
	 public String join(Model model,GuestVO vo){
		 
	    	int su = loginService.insertJoin(vo);
	    	 
	    	String msg= null;
	    	String url= null;
	    	
	    	if(su != 0) {
	    		msg="회원가입 성공! 로그인 페이지로...";
	    		url="/space/guest/loginform?guest_email="+ vo.getGuest_email();
	    	}else {
	    		msg="회원가입 실패! 이전페이지로...";
	    		url="history.back()";
	    	}
	    
	    	model.addAttribute("url",url);
	    	model.addAttribute("msg",msg);
	    	
	    	return ViewPath.GUEST + "joinResult.jsp";
	    }
	 
	 
	 @RequestMapping("findemail") 
		public String findemail() {
		
			return ViewPath.GUEST + "findemail.jsp";
		}
	 
	 @RequestMapping("findpw") 
	 public String findpw() {
		 
		 return ViewPath.GUEST + "findpw.jsp";
	 }
	 
	 @RequestMapping("find") 
		public String find(Model model,GuestVO vo,String mode) {
			
		String find = null;	
			
			if(vo.getGuest_email() == null) { 
				find = loginService.findGuest_email(vo); 
			}else {
				find = loginService.findGuest_pw(vo); 
			} 
			
			
			boolean check = false;
			if(find != null){ 
				check = true;
				
				if(mode.equals("guest_email")){ 
					model.addAttribute("guest_email", find); 
				}else{ 
					model.addAttribute("guest_pw", find); 
				}
			}
			
			model.addAttribute("check", check);
			
			
			return ViewPath.GUEST + "findresult.jsp"; 
		}
	 @RequestMapping("logout") //헤더에서 여기로 보냄
		public String logout(HttpSession session) {
			session.invalidate(); //세션을 무효화-> 사용자의 로그인 상태와 관련된 정보 등이 소멸
			
			return ViewPath.GUEST + "logout.jsp";
		}
	 
	 @RequestMapping("unregister")
	 	public String unregister(Model model, HttpServletRequest request,HttpServletResponse response) {
		 Integer no = (Integer)request.getSession().getAttribute("login"); //이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
			if (no == null) {
				return "redirect:/host/loginform";
			}
			
			int su = loginService.unregister(no);
			
			String msg= null;
	    	String url= null;
	    	
	    	if(su != 0) {
	    		GuestVO vo = loginService.selectOne(no);
	    		Cookie[] cks = request.getCookies();  //cks 배열에는 가져온 모든 쿠키가 저장(쿠키가 여러개니까 배열로 받음)
	    		
	    		
	    		if(cks != null) { //쿠키값이 있다면
	    			for(Cookie ck:cks) {//쿠키 배열 cks를 반복문으로 순회. ck는 배열의 각 쿠키를 나타냄.
	    				if(ck.getName().equals("ckid")) {//순회 중인 쿠키의 이름이 "ckid"이라면
	    					if(ck.getValue().equals(vo.getGuest_email())) {// 순회 중인 쿠키의 값(쿠키에 있는 아이디??)과 vo.getId()(로그인한 사람의 아이디)의 값이 일치한다면
	    						ck.setMaxAge(0); //일치하는 쿠키의 유효 기간을 0으로 설정하여 쿠키를 삭제(바로 지워짐)
	    						ck.setPath("/");  //쿠키의 경로를 루트 경로로 설정. 이는 현재 도메인의 모든 경로에서 쿠키에 접근할 수 있음을 의미
	    						response.addCookie(ck); //이를 통해 서버에서 클라이언트에게 변경된 쿠키 정보가 전달
	    						break;
	    					}
	    				}
	    			}
	    			request.getSession().invalidate(); //invalidate() 메서드를 호출하면 현재 세션은 무효화되어 모든 세션 데이터가 제거됩니다. 클라이언트와 서버 간의 세션 연결이 종료되고, 이후 요청에서는 새로운 세션이 생성됩니다. 일반적으로 세션을 무효화하는 경우는 로그아웃 또는 세션을 강제로 종료해야 할 때
		    		
					
					msg="회원탈퇴 되었습니다";
					url="/space/";
	  
			}else {
	    		msg= "회원탈퇴에 실패했습니다";
	    		url="history.back()";
	    	}
	
	 }
	    	model.addAttribute("url",url);
	    	model.addAttribute("msg",msg);
	    	
	    	return ViewPath.GUEST + "joinResult.jsp";
}

		@RequestMapping("updateform")
		public String writeForm(HttpSession session) { 
			Integer no = (Integer) session.getAttribute("login");
			
			if (no == null) {
				return "redirect:/guest/loginform";
			}
		
			return ViewPath.GUEST + "updateform.jsp";
			}
	
		
		
		@RequestMapping("update")
		public String write(Model model,HttpServletRequest request,GuestVO gvo) { 
			Integer no = (Integer)request.getSession().getAttribute("login"); //이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
			if (no == null) {
				return "redirect:/guest/loginform";
			}

			//회원정보 업데이트
			gvo.setGuest_no(no);
			int su = profileService.updateInfo(gvo);
			
			//업데이트 후의 게스트 정보 가져오기
			GuestVO ggvo = profileService.selectOne(no);
			//세션 업데이트
			request.getSession().setAttribute("gvo", ggvo);
			
			String msg= null;
			String url= null;
	   
	    	
	    	if(su != 0 ) {
	    		msg="회원정보 수정 성공!";
	    		url="/space/";
	    	}else {
	    		msg="회원정보 수정 실패!";
	    		url="history.back()";
	    	}
	    
	    	model.addAttribute("msg",msg);
	    	model.addAttribute("url",url);

	    	return ViewPath.GUEST+ "joinResult.jsp";
		}
	 
	 
}