package com.kh.areyout.mbti.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.areyout.mbti.service.MbtiService;
import com.kh.areyout.member.domain.MemberVO;
import com.kh.areyout.member.service.MemberService;
import com.kh.areyout.notice.domain.NoticeVO;

@Controller
public class MbtiController {

	@Autowired
	private MbtiService mService;

//	 @GetMapping("/mbti/matching.kh")
//	    public String matchingForm() {
//	        return "mbti/matching"; // 입력 폼이 있는 JSP 페이지로 이동
//	    }

	@RequestMapping(value = "/mbti/matching.kh", method = RequestMethod.GET)
	public String matchingForm(HttpSession session, Model model) {
		try {
			String memberId = (String) session.getAttribute("memberId");
			MemberVO member = mService.getOneById(memberId);
			if(member.getMemberMbti() != null) {
				List<MemberVO> matchingMembers =
						mService.getMatchingMembersByMbti(member);
				model.addAttribute("matchingMembers", matchingMembers); 
				return "mbti/matchinglist"; 
			}else {
				return "redirect:/mbti/mbtitest.kh";
			}
//			if (memberId != null) {
//				member = mService.getOneById(memberId);
//			} else {
//
//			}
//			if (member != null) {
//				model.addAttribute("member", member);
//				return "mbti/matching";
//			} else {
//				model.addAttribute("msg", "오류났어요");
//				return "common/errorPage";
//			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

//	 @PostMapping("/mbti/matching.kh")
//	    public String mbtiMatching(Model model, @RequestParam("memberMbti") String memberMbti) {
//	        try {
//	            // 사용자가 입력한 MBTI 정보를 이용하여 매칭된 회원을 조회
//	            List<MemberVO> matchingMembers = mService.getMatchingMembersByMbti(memberMbti);
//	            model.addAttribute("matchingMembers", matchingMembers);
//	            return "mbti/matchinglist"; // 매칭된 회원 목록을 보여주는 JSP 페이지로 이동
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            model.addAttribute("msg", e.getMessage());
//	            return "common/errorPage";
//	        }
//	    }

	@PostMapping("/mbti/matching.kh") 
	public String mbtiMatching(Model model, @RequestParam("memberMbti") String memberMbti) { 
		try { 
			// 사용자가 입력한 MBTI 정보를 이용하여 매칭된 회원을 조회 
			List<MemberVO> matchingMembers = null;
			model.addAttribute("matchingMembers", matchingMembers); 
			return "mbti/matchinglist"; 
			// 매칭된 회원 목록을 보여주는 JSP 페이지로 이동 
			} catch (Exception e) {
				  e.printStackTrace(); 
				  model.addAttribute("msg", e.getMessage()); 
				  return
				  "common/errorPage"; 
				}
			}

//	
//	 @PostMapping("/mbti/matching.kh")
//	    public String mbtiMatching(Model model, @RequestParam("memberMbti") String[] memberMbti) {
//	        try {
//	            // 사용자가 선택한 MBTI 정보 배열을 이용하여 매칭된 회원을 조회
//	            List<MemberVO> matchingMembers = mService.getMatchingMembersByMbti(memberMbti);
//	            model.addAttribute("matchingMembers", matchingMembers);
//	            return "mbti/matchingList";
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            model.addAttribute("msg", e.getMessage());
//	            return "common/errorPage";
//	        }
//	    }


//		@RequestMapping(value = "/mbti/matching.kh", method = RequestMethod.GET)
//		public String mbtiMatching(HttpSession session, Model model) {
//			try {
//				String memberId = (String) session.getAttribute("memberId");
//				MemberVO member = null;
//				if (memberId != null) {
//					member = mService.getOneById(memberId);
//				} else {
//
//				}
//				if (member != null) {
//					model.addAttribute("member", member);
//					return "member/matching";
//				} else {
//					model.addAttribute("msg", 
//					return "common/errorPage";
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//				model.addAttribute("msg", e.getMessage());
//				return "common/errorPage";
//			}
//		}

//	@RequestMapping(value = "/mbti/matching.kh", method = RequestMethod.GET)
//	public String mbtimatch(HttpSession session, Model model) {	
//		
//		return "mbti/matching";
//	}

	@RequestMapping(value = "/mbti/mbtitest.kh", method = RequestMethod.GET)
	public String mbtitest(HttpSession session, Model model) {
		return "mbti/mbtitest";
	}

//    @RequestMapping(value = "/mbti/save-image-number", method = RequestMethod.GET)
//    public ModelAndView saveImageNumber(
//            ModelAndView mv,
//            @RequestParam(name = "imageNumber") int imageNumber
//    ) {
//        try {

//        	Membe

//            mv.setViewName("member/profile");
//        } catch (Exception e) {

//            mv.addObject("msg", e.getMessage());
//            mv.setViewName("common/errorPage");
//        }
//        return mv;
//    }
	@RequestMapping(value = "/mbti/mbtiresult.kh", method = RequestMethod.GET)
	public String mbtiresult(HttpSession session, Model model, String mbti) {
		try {
			MemberVO member = new MemberVO();
			String memberId = (String) session.getAttribute("memberId");
			member.setMemberId(memberId);
			member.setMemberMbti(mbti);
			int result = mService.updateMbti(member);
			if (result > 0) {
				session.setAttribute("mbti", mbti);
				model.addAttribute("member", member);
				return "mbti/mbtiresult";
			} else {
				model.addAttribute("msg", "테스트를 완료하지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

//	@RequestMapping(value = "/member/update.kh", method = RequestMethod.POST)
//	public String modifyMember(
//			@ModelAttribute MemberVO member
//			, Model model) {
//		try {
//			int result = mService.updateMember(member);
//			if (result > 0) {
//				model.addAttribute("member", member);
//				return "redirect:/member/mypage.kh";
//			} else {
//				model.addAttribute("msg", ");
//				return "common/errorPage";
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			model.addAttribute("msg", e.getMessage());
//			return "common/errorPage";
//		}
//	}
}
