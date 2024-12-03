package cat1.profile.controller;

import java.io.File;





import java.util.Arrays;
import java.util.List;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
import cat1.badge.vo.BadgeVO;
import cat1.badge.vo.MybadgeVO;
import cat1.coupon.service.CpnService;
import cat1.coupon.vo.CpnVO;
import cat1.profile.service.ProfileService;
import cat1.profile.vo.DetaareaVO;
import cat1.profile.vo.InterestVO;
import cat1.profile.vo.IntrareaVO;
import cat1.profile.vo.LfstyVO;
import cat1.profile.vo.ProfileVO;

@Controller
@RequestMapping("/profile/")
public class ProfileController {

	private ProfileService profileService;
	private CpnService cpnService;

	public ProfileController(ProfileService profileService,CpnService cpnService) {
		this.profileService = profileService;
		this.cpnService = cpnService;
	}

	
	@Autowired //해당 필드에 알맞은 의존성을 자동으로 주입.
	private ServletContext application;
	
	
	@RequestMapping("update")
	public String writeForm(Model model,HttpSession session,String detaarea_city) { 
		Integer no = (Integer) session.getAttribute("login");
		
		if (no == null) {
			return "redirect:/guest/loginform";
		}
		List<DetaareaVO> dlist = profileService.selectList(); //시/도명
		List<DetaareaVO> alist = profileService.selectAll(); //시도명과 지역명 모두 가져옴
		List<ProfileVO> plist = profileService.selectprofileList(); //프로필 문구
		List<LfstyVO> llist = profileService.selectstyleList(); //라이프 스타일
		model.addAttribute("dlist",dlist);
		model.addAttribute("alist",alist);
		model.addAttribute("plist",plist);
		model.addAttribute("llist",llist);
		return ViewPath.PROFILE + "writeForm.jsp";
		}
	

	
	@RequestMapping("write")
	public String write(Model model,HttpServletRequest request,GuestVO gvo) { 
		Integer no = (Integer)request.getSession().getAttribute("login"); //이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
		if (no == null) {
			return "redirect:/guest/loginform";
		}
		
		
		String profile_no= request.getParameter("profile_no");
		String district= request.getParameter("district"); //시퀀스 들어있음
		String lfsty_no =request.getParameter("lfsty_no"); //시퀀스 들어있음
		
		profileService.deleteInterest(no); //선택하기전에 초기화? 지금 생각하니까 update하면 될것같음 왜 삭제,삽입으로 했지?
		profileService.deleteIntrarea(no);
		
		String[] lvalues = lfsty_no.split(",");
		String[] dvalues = district.split(",");
		
		List<String> lifeList = Arrays.asList(lvalues); //숫자가 들어갈 list공간
		int i = 0;
		for(String num : lifeList) {
			InterestVO vo = new InterestVO();
			vo.setLfsty_no(Integer.parseInt(lvalues[i]));
			vo.setGuest_no(no);
		    profileService.insertInterest(vo);
			i += 1; //이게 있어야지 라이프스타일 고를때 3개 골랐으면 첫번째 선택, 두번째 선택, 세번째 선택한 값이 들어감(이거 안해주면 첫번째 고른 값만 중복으로 계속 저장됨) 
		}
		List<String> districtList = Arrays.asList(dvalues); //숫자가 들어갈 list공간
		
	     i = 0; //이거 해줘야 그 다음 반복문이 초기화 된 후에 실행됨(아니면 밑에 반복문에 i대신 j이런 다른 문자를 넣던가)
	     
		for(String num : districtList) {
			
			IntrareaVO vo = new IntrareaVO();
			vo.setDetaarea_no(Integer.parseInt(dvalues[i]));
			vo.setGuest_no(no);
			profileService.insertArea(vo);
			i += 1; //이게 있어야지 라이프스타일 고를때 3개 골랐으면 첫번째 선택, 두번째 선택, 세번째 선택한 값이 들어감(이거 안해주면 첫번째 고른 값만 중복으로 계속 저장됨) 
		}
		
		
	    GuestVO vo = new GuestVO();
	    vo.setProfile_no(Integer.parseInt(profile_no));
	    vo.setGuest_no(no);
	    int su = profileService.updateProfile(vo);
	    
		
		String msg= null;
		String url= null;
   
    	
    	if(su != 0 ) {
    		msg="관심사 수정 성공!";
    		url="/space/";
    	}else {
    		msg="관심사 수정 실패!";
    		url="history.back()";
    	}
    
    	model.addAttribute("msg",msg);
    	model.addAttribute("url",url);

    	return ViewPath.GUEST+ "joinResult.jsp";
	}
	
	@RequestMapping("mypage")
	public String show(Model model,HttpServletRequest request,GuestVO gvo) { 
		Integer no = (Integer)request.getSession().getAttribute("login"); //이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
		if (no == null) {
			return "redirect:/guest/loginform";
		}
		
		
	    //관심지역 셀랙트
	    List<DetaareaVO> dlist = profileService.selectDetaarea(no);
		
		//프로필 셀랙트
		ProfileVO pvo = profileService.myProfile(no);
		
		//관심사 셀랙트
		List<LfstyVO> llist = profileService.myLfsty(no);
		
		//회원정보 셀렉트
		gvo = profileService.selectOne(no);
		
	
    	
		model.addAttribute("dlist",dlist);
		model.addAttribute("pvo",pvo);
		model.addAttribute("gvo",gvo);
		model.addAttribute("llist",llist);
		
		return ViewPath.PROFILE + "profile.jsp";
	}
	
	

	@RequestMapping("coupon")
	public String couponList(Model model,HttpServletRequest request) { 
		Integer no = (Integer)request.getSession().getAttribute("login"); //이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
		if (no == null) {
			return "redirect:/guest/loginform";
		}
		//쿠폰 셀렉트
				List<Map<String,Object>> clist = cpnService.selectMycpn(no); 
				
				int countCpn = cpnService.countMyCpn(no);
				
				model.addAttribute("clist",clist);
				model.addAttribute("countCpn",countCpn);
				
		return ViewPath.COUPON + "list.jsp";
	
	}
	
	
	
	
	

		@RequestMapping(value = "img",produces = "application/text;charset=utf8") 
		@ResponseBody 
		 public ResponseEntity<String> uploadImage(@RequestParam("img") MultipartFile img,HttpServletRequest request) {

			
			System.out.println("화긴스" );
			Integer no = (Integer)request.getSession().getAttribute("login"); //이렇게 써도 됨(그럼 매개변수에 세션 없어도 됨)
			
	        if (!img.isEmpty()) {
	      
	            try {
	                // 여기에서 img를 사용하여 업로드된 파일 처리
	                // 예를 들어, 파일을 저장하거나 다른 작업을 수행할 수 있습니다.
	            	String savePath = "C:\\img";
	            	System.out.println("세이브패스" + savePath);
	            	
	            	
	            	 // DB에서 현재 게스트의 정보를 조회하여 기존 이미지 파일명 가져오기
	                GuestVO existingGuest = profileService.selectOne(no);
	                String oldFilename = existingGuest.getGuest_img(); // 'guest_img' 컬럼에서 기존 파일 이름 가져오기
	                
	                // 기존 이미지 파일 삭제
	                if (oldFilename != null && !oldFilename.isEmpty()) {
	                    File oldFile = new File(savePath, oldFilename);
	                    if (oldFile.exists()) {
	                        boolean isDeleted = oldFile.delete();
	                        if (isDeleted) {
	                            System.out.println("기존 파일 삭제 성공: " + oldFilename);
	                        } else {
	                            System.out.println("기존 파일 삭제 실패: " + oldFilename);
	                        }
	                    } else {
	                        System.out.println("기존 파일이 존재하지 않습니다: " + oldFilename);
	                    }
	            	
	            	// 업로드된 파일의 원래 파일 이름
	                String originalFilename = img.getOriginalFilename();

	                // 실제 파일 저장 경로
	                File saveFile = new File(savePath,originalFilename);

	                // 파일 저장
	                img.transferTo(saveFile);
	                
	                
	                GuestVO vo = new GuestVO();
	                

	            	vo.setGuest_img(originalFilename);
	            	vo.setGuest_no(no);
	            	
	                int su = profileService.updateImg(vo);
	                
	                //업데이트 후의 게스트 정보 가져오기
	                GuestVO gvo = profileService.selectOne(no);
	            	//세션 업데이트
	        	    request.getSession().setAttribute("gvo",gvo);	     
	        	    
	        	    
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
		
		@RequestMapping("badge")
		public String badge(Model model,HttpServletRequest request) { 
			Integer no = (Integer)request.getSession().getAttribute("login");
			if (no == null) {
				return "redirect:/guest/loginform";
			}
			
			List<BadgeVO> list = profileService.badgeList();
		    List<String> myList = profileService.isgetBadge(no);
			model.addAttribute("list",list);
			model.addAttribute("myList",myList);
			
			return ViewPath.PROFILE + "badge.jsp";
		}


		@RequestMapping("badgeNo")
		@ResponseBody 
		public BadgeVO getNo(@RequestParam("badge_no") int badge_no,HttpServletRequest request) { 
			
			BadgeVO bvo = profileService.badgeInfo(badge_no);
			
			return bvo;
		}
		
}
		
		
		
		
		
		
		
		
	
	

