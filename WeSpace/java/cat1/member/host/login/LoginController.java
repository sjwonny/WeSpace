package cat1.member.host.login;

import java.io.File;



import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.ViewPath;
import all.vo.GuestVO;
import all.vo.HostVO;

@Controller
@RequestMapping("/host/")
public class LoginController {

	private LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	
	@Autowired //해당 필드에 알맞은 의존성을 자동으로 주입.
	private ServletContext application;
	
	
	@RequestMapping("joinform") 
	public String joinForm() {
		return ViewPath.HOST + "joinForm.jsp";
	}
	
	
	
	@RequestMapping("loginform")
	public String loginForm(HttpServletRequest request,String host_email) {
		
boolean check = false; 
		
		if(host_email == null) {
			Cookie[] cks = request.getCookies();
			
			if(cks != null) { 
				for(Cookie ck : cks) { 
					if(ck.getName().equals("ckid")) {
						host_email = ck.getValue();
						check = true; //체크는 true
						break; //탈출
					}
				}
			}
		}
		
		request.setAttribute("host_email", host_email); //아이디 전달
		request.setAttribute("check", check);
		
		
		
		return ViewPath.HOST + "loginForm.jsp";
	}
	

	
	@RequestMapping("login/check")
	public String checkLogin(HttpServletRequest request, HttpServletResponse response, HostVO vo) {

		int no = loginService.checkLogin(vo);
		HostVO hvo = loginService.selectOne(no);

		String msg = null;
		String url = null;
		boolean check = false;

		if (no != 0) {
			msg = "로그인 성공!";
			url = "/space/";
			check = true;

			request.getSession().setAttribute("login", no);
			request.getSession().setAttribute("hvo", hvo);
			

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
					ck = new Cookie("ckid", vo.getHost_email());

					// root로 경로 설정
					ck.setPath("/");

					// 유효시간 설정
					ck.setMaxAge(60 * 60 * 24);

					// 클라이언트에게 쿠키파일 생성
					response.addCookie(ck);
				} else { 
					if (!ck.getValue().equals(vo.getHost_email())) {
						ck.setValue(vo.getHost_email());
						ck.setPath("/");
						response.addCookie(ck);
					}
				}
			} else { 
				if (ck != null) {
					if (ck.getValue().equals(vo.getHost_email())) {
						ck.setPath("/");
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
				}
			}

		} else {
			msg = "이메일 혹은 비밀번호가 잘못되었습니다.";
			url = "/space/host/loginform";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("check", check);

		return ViewPath.HOST + "loginResult.jsp";

	}
	
	
	@RequestMapping(value = "checkId",produces = "application/text;charset=utf8")
	@ResponseBody // 리턴되는 문자열이 HTTP 응답의 본문으로 전송됨
	public String checkId(String host_nick) {
		if(loginService.checkId(host_nick)) { 
			return "이미 사용중인 닉네임입니다."; 
		}else { 
			return "사용 가능한 닉네임입니다";
		}
	}
	
	 @RequestMapping("join")
	 public String join(Model model,HostVO vo){
	    	int su = loginService.insertJoin(vo);
	    	 
	    	String msg= null;
	    	String url= null;
	    	
	    	if(su != 0) {
	    		msg="회원가입 성공! 로그인 페이지로...";
	    		url="/space/host/loginform?host_email="+ vo.getHost_email();
	    	}else {
	    		msg="회원가입 실패! 이전페이지로...";
	    		url="history.back()";
	    	}
	    
	    	model.addAttribute("url",url);
	    	model.addAttribute("msg",msg);
	    	
	    	return ViewPath.HOST + "joinResult.jsp";
	    }
	 
	 
	 @RequestMapping("findemail") 
		public String findemail() {
		
			return ViewPath.HOST + "findemail.jsp";
		}
	 
	 @RequestMapping("findpw") 
	 public String findpw() {
		 
		 return ViewPath.HOST + "findpw.jsp";
	 }
	 @RequestMapping("find") 
		public String find(Model model,HostVO vo,String mode) { 
			
		String find = null;	
			
			if(vo.getHost_email() == null) { 
				find = loginService.findHost_email(vo); 
			}else {
				find = loginService.findHost_pw(vo);
			} 
			
			
			boolean check = false;
			if(find != null){ 
				check = true; 
				
				
				if(mode.equals("host_email")){ 
					model.addAttribute("host_email", find); 
				}else{ 
					model.addAttribute("host_pw",find); 
				}
			}
			
			model.addAttribute("check", check);
			
			
			return ViewPath.HOST + "findresult.jsp"; 
		}
	 
	 
	 @RequestMapping("logout") //헤더에서 여기로 보냄
		public String logout(HttpSession session) {
			session.invalidate(); //세션을 무효화-> 사용자의 로그인 상태와 관련된 정보 등이 소멸
			
			return ViewPath.HOST + "logout.jsp";
		}
	 
	 @RequestMapping("mypage")
		public String show(Model model,HttpServletRequest request,HostVO hvo) { 
			Integer no = (Integer)request.getSession().getAttribute("login"); //이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
			if (no == null) {
				return "redirect:/host/loginform";
			}
			
			//회원정보 셀렉트
			hvo = loginService.selectOne(no);
			
	    	
			model.addAttribute("hvo",hvo);
			
			return ViewPath.HOST + "mypage.jsp";
		}
		
	 @RequestMapping("updateform")
		public String writeForm(Model model,HttpSession session,String detaarea_city) { 
			Integer no = (Integer) session.getAttribute("login");
			
			if (no == null) {
				return "redirect:/host/loginform";
			}
			return ViewPath.HOST + "updateform.jsp";
			}
		
	 
	 
	 @RequestMapping("write")
		public String write(Model model,HttpServletRequest request,HostVO hvo) { 
			Integer no = (Integer)request.getSession().getAttribute("login"); //이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
			if (no == null) {
				return "redirect:/host/loginform";
			}
			

			//회원정보 업데이트
			hvo.setHost_no(no);
			int su = loginService.updateInfo(hvo);
			
			
			//업데이트 후의 게스트 정보 가져오기
			HostVO hhvo = loginService.selectOne(no);
			//세션 업데이트
			request.getSession().setAttribute("hvo", hhvo);
		    
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
	    	

			return ViewPath.HOST + "joinResult.jsp";
		}
	 

		@RequestMapping(value = "img",produces = "application/text;charset=utf8") 
		@ResponseBody 
		 public ResponseEntity<String> uploadImage(@RequestParam("img") MultipartFile img,HttpServletRequest request) {
			
			Integer no = (Integer)request.getSession().getAttribute("login"); //이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
			
	        if (!img.isEmpty()) {
	      
	            try {
	                // 여기에서 img를 사용하여 업로드된 파일 처리
	                // 예를 들어, 파일을 저장하거나 다른 작업을 수행할 수 있습니다.
	            	String savePath = application.getRealPath("/resources/update/");
	            	// 업로드된 파일의 원래 파일 이름
	                String originalFilename = img.getOriginalFilename();

	                // 실제 파일 저장 경로
	                File saveFile = new File(savePath,originalFilename);

	                // 파일 저장
	                img.transferTo(saveFile);
	                
	                
	                HostVO vo = new HostVO();
	                

	            	vo.setHost_img(originalFilename);
	            	vo.setHost_no(no);
	            	
	            	int su = loginService.updateImg(vo);
	            	
	            	 //업데이트 후의 게스트 정보 가져오기
	                HostVO hvo = loginService.selectOne(no);
	            	//세션 업데이트
	        	    request.getSession().setAttribute("hvo",hvo);	   
	            
	                // 파일을 저장하고 나면 성공 응답을 반환
	                return new ResponseEntity<>("업로드 성공", HttpStatus.OK);
	            } catch (Exception e) {
	                e.printStackTrace();
	                // 파일 처리 중 오류가 발생한 경우 실패 응답을 반환
	                return new ResponseEntity<>("업로드 실패", HttpStatus.INTERNAL_SERVER_ERROR);
	            }
	        } else {
	            // 업로드된 파일이 없는 경우 실패 응답을 반환
	            return new ResponseEntity<>("파일이 선택되지 않았습니다.", HttpStatus.BAD_REQUEST);
	        }
	
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
		    		HostVO vo = loginService.selectOne(no);
		    		Cookie[] cks = request.getCookies();  //cks 배열에는 가져온 모든 쿠키가 저장(쿠키가 여러개니까 배열로 받음)
		    		
		    		
		    		if(cks != null) { //쿠키값이 있다면
		    			for(Cookie ck:cks) {//쿠키 배열 cks를 반복문으로 순회. ck는 배열의 각 쿠키를 나타냄.
		    				if(ck.getName().equals("ckid")) {//순회 중인 쿠키의 이름이 "ckid"이라면
		    					if(ck.getValue().equals(vo.getHost_email())) {// 순회 중인 쿠키의 값(쿠키에 있는 아이디??)과 vo.getId()(로그인한 사람의 아이디)의 값이 일치한다면
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
		    	
		    	return ViewPath.HOST + "joinResult.jsp";
	}
}

		    		
		    		
		    		
		    		