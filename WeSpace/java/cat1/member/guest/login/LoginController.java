package cat1.member.guest.login;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

import common.ViewPath;
import all.vo.GuestVO;
import cat1.coupon.service.CpnService;
import cat1.profile.service.ProfileService;
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
	public String checkLogin(HttpServletRequest request, HttpServletResponse response,Model model, GuestVO vo, @RequestParam(value = "guest_nickname", required = false) String guestNickname) {
		int no = 0;
		String msg = null;
		String url = null;
		boolean check = false;
		    if (vo != null && vo.getGuest_email() != null && vo.getGuest_pw() != null) {
		        // loginForm.jsp에서 온 경우: 이메일과 비밀번호를 통해 로그인 체크
		        no = loginService.checkLogin(vo);
		    } else if (guestNickname != null) {
		        // kakaoLogin.jsp에서 온 경우: 닉네임을 통해 로그인 정보 조회
		        no = loginService.kakaoInfo(guestNickname);
		    } 
		
		
		int badgeCnt = profileService.badgeCnt(no);
		GuestVO gvo = profileService.selectOne(no);
		int countCpn = cpnService.countMyCpn(no);
		
		

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

		}   // 로그인 실패 시
	    else {
	       msg = "로그인 정보가 올바르지 않습니다. 다시 로그인해 주세요.";

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
	 
		@RequestMapping(value = "getKakaoAuthUrl")
		public @ResponseBody String getKakaoAuthUrl( //카카오 인증페이지로 이동하게하기 위함.
				HttpServletRequest request) throws Exception {
			String reqUrl = 
					"https://kauth.kakao.com/oauth/authorize"
					+ "?client_id=6b9cc9b9332b5f3938aa598be9333394" //rest api
					+ "&redirect_uri=http://localhost:8080/space/guest/kakao" //redirect uri
					+ "&response_type=code"; //인증코드 받을 것을 지정.
			
			return reqUrl;
		}
		// 카카오 연동정보 조회
		@RequestMapping(value = "kakao")
		public String oauthKakao( //전달받은 인증코드를 이용해 액세스 토큰 요청
				@RequestParam(value = "code", required = false) String code
				, Model model) throws Exception {

	        String access_Token = getAccessToken(code); //토큰발급 메소드 호출
	        HashMap<String, Object> userInfo = getUserInfo(access_Token); //사용자 정보조회 메소드 호출
	        JSONObject kakaoInfo =  new JSONObject(userInfo);
	        
	        model.addAttribute("kakaoInfo", kakaoInfo);
	        
	       return ViewPath.GUEST +"kakaoLogin.jsp"; //본인 원하는 경로 설정 (사용자 조회 정보를 여기로 전달)
		}
		
		//토큰발급
		public String getAccessToken(String authorize_code) {
		    String access_Token = "";
		    String reqURL = "https://kauth.kakao.com/oauth/token"; // 액세스 토큰을 받을 URL
		    String result = "";

		    try {
		        // URL 연결 설정
		        URL url = new URL(reqURL);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("POST");
		        conn.setDoOutput(true); // POST 방식으로 데이터 전송

		        // 요청 파라미터 작성
		        String params = "grant_type=authorization_code" +
		                        "&client_id=6b9cc9b9332b5f3938aa598be9333394" + // 클라이언트 ID
		                        "&redirect_uri=http://localhost:8080/space/guest/kakao" + // 리다이렉트 URI
		                        "&code=" + authorize_code; // 인증 코드

		        // 요청 데이터 전송
		        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"))) {
		            bw.write(params);
		            bw.flush();
		        }

		        // 서버 응답 읽기
		        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
		            String line;
		            while ((line = br.readLine()) != null) {
		                result += line; // 응답 결과를 누적
		            }
		        }

		        // 응답 결과에서 access_token 추출
		        JsonElement element = JsonParser.parseString(result);
		        access_Token = element.getAsJsonObject().get("access_token").getAsString();

		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    return access_Token;
		}
		//유저정보조회
		public HashMap<String, Object> getUserInfo(String access_Token) {
		    HashMap<String, Object> userInfo = new HashMap<>();
		    String reqURL = "https://kapi.kakao.com/v2/user/me";
		    String result = ""; // result 변수 선언(서버 응답 저장 변수)

		    try {
		        URL url = new URL(reqURL);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Authorization", "Bearer " + access_Token);

		        int responseCode = conn.getResponseCode(); //응답 코드
//		        System.out.println("responseCode : " + responseCode);

		        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		        String line = "";
		        System.out.println("카카오 getUserInfo 성공 ");
		        while ((line = br.readLine()) != null) {
		            result += line; //응답 결과 저장
		        }
		        System.out.println("response body : " + result);

		        JsonElement element = JsonParser.parseString(result);
		        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
		        JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

		        String nickname = properties.getAsJsonObject().get("nickname").getAsString(); //닉네임 추출

		        userInfo.put("accessToken", access_Token);
		        userInfo.put("nickname", nickname);

		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    return userInfo;
		}

	 }
