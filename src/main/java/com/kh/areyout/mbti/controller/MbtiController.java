package com.kh.areyout.mbti.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = "/mbti/matching.kh", method = RequestMethod.GET)
	public String mbtimatch(HttpSession session, Model model) {		
		return "mbti/matching";
	}
	
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
//            // 여기서 서비스 계층을 호출하여 데이터베이스에 imageNumber를 저장하는 로직을 구현합니다.
//            // 예를 들어, MbtiService 클래스에 saveImageNumber 메서드를 추가하고 호출하는 식으로 작성할 수 있습니다.
//            // MbtiService.saveImageNumber(imageNumber);
//
//            // 아래는 성공 시의 응답 코드입니다.
//        	Membe
//            mv.addObject("msg", "imageNumber 저장이 완료되었습니다.");
//            mv.setViewName("member/profile");
//        } catch (Exception e) {
//            // 실패 시의 응답 코드입니다.
//            mv.addObject("msg", e.getMessage());
//            mv.setViewName("common/errorPage");
//        }
//        return mv;
//    }
	@RequestMapping(value = "/mbti/mbtiresult.kh", method = RequestMethod.GET)
	public String mbtiresult(HttpSession session, Model model, String mbti) {	
//		System.out.println(mbti);
		try {
			MemberVO member = new MemberVO();
			String memberId = (String) session.getAttribute("memberId");
			member.setMemberId(memberId);
			member.setMemberMbti(mbti);
			int result = mService.updateMbti(member);
			if (result > 0) {
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
//				model.addAttribute("msg", "수정을 완료하지 못했습니다.");
//				return "common/errorPage";
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			model.addAttribute("msg", e.getMessage());
//			return "common/errorPage";
//		}
//	}
}
