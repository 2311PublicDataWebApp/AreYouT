package com.kh.areyout.member.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.areyout.member.domain.MemberVO;
import com.kh.areyout.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;
	
	
	
	@RequestMapping(value = "/member/register.kh", method = RequestMethod.GET)
	public String showInsertForm() {
		return "member/insert";
	}

	@RequestMapping(value = "/member/register.kh", method = RequestMethod.POST)
	public String insertMember(@ModelAttribute MemberVO member, Model model) {
		try {
			int result = mService.insertMember(member);
			if (result > 0) {
				model.addAttribute("msg", "회원가입이 완료되었습니다.");
				model.addAttribute("url", "/");
				return "common/alert";
				//return "redirect:/index.jsp";
			} else {
				model.addAttribute("msg", "회원가입이 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value = "/member/login.kh", method = RequestMethod.GET)
	public String showLoginForm() {
		return "member/login";
	}
	
	@RequestMapping(value = "/member/login.kh", method = RequestMethod.POST)
	public String memberLogin(String memberId, String memberPw, Model model, HttpSession session) {
		try {
			MemberVO member = new MemberVO();
			member.setMemberId(memberId);
			member.setMemberPw(memberPw);
			member = mService.checkMemberLogin(member);
			if (member != null) {
				session.setAttribute("memberId", member.getMemberId());
				session.setAttribute("memberName", member.getMemberName());
				session.setAttribute("memberFileRename", member.getMemberFileRename());
				return "redirect:/index.jsp";
			} else {
				model.addAttribute("msg", "로그인에 실패하였습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}

	}

	@RequestMapping(value = "/member/logout.kh", method = RequestMethod.GET)
	public String memberLogout(HttpSession session, Model model) {
		try {
			if (session != null) {
				session.invalidate();
				return "redirect:/index.jsp";
			} else {
				model.addAttribute("msg", "로그아웃을 완료하지 못하였습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	// 마이페이지 MypageController
	@RequestMapping(value = "/member/mypage.kh", method = RequestMethod.GET)
	public String showMyPage(HttpSession session, Model model) {
		try {
			String memberId = (String) session.getAttribute("memberId");
			MemberVO member = null;
			if (memberId != null) {
				member = mService.getOneById(memberId);
			} else {

			}
			if (member != null) {
				model.addAttribute("member", member);
				return "member/mypage";
			} else {
				model.addAttribute("msg", "회원 정보 조회를 완료하지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	// 수정페이지로 이동
	@RequestMapping(value = "/member/update.kh", method = RequestMethod.GET)
	public String showModifyForm(HttpSession session, Model model) {
		try {
			String memberId = (String) session.getAttribute("memberId");
			MemberVO member = null;
			if (memberId != null) {
				member = mService.getOneById(memberId);
			} else {
	
			}
			if (member != null) {
				model.addAttribute("member", member);
				return "member/update";
			} else {
				model.addAttribute("msg", "회원 정보 조회를 완료하지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/member/update.kh", method = RequestMethod.POST)
	public String modifyMember(
			@ModelAttribute MemberVO member
			, Model model) {
		try {
			int result = mService.modifyMember(member);
			if (result > 0) {
				model.addAttribute("member", member);
				model.addAttribute("msg", "정보 수정이 완료되었습니다.");
				model.addAttribute("url", "/member/mypage.kh");
				return "common/alert";
			} else {
				model.addAttribute("msg", "정보 수정을 완료하지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	//프로필 조회
	@RequestMapping(value = "/member/profile.kh", method = RequestMethod.GET)
	public String showMyProfile(HttpSession session, Model model) {
		try {
			String memberId = (String) session.getAttribute("memberId");
			MemberVO member = null;
			if (memberId != null) {
				member = mService.getOneById(memberId);
			} else {

			}
			if (member != null) {
				session.setAttribute("memberFileRename", member.getMemberFileRename());
				model.addAttribute("member", member);
				return "member/profile";
			} else {
				model.addAttribute("msg", "회원 정보 조회를 완료하지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	//프로필 수정 페이지로 이동
	@RequestMapping(value = "/member/updateprofile.kh", method = RequestMethod.GET)
	public String showModifyProfileForm(HttpSession session, Model model) {
		try {
			String memberId = (String) session.getAttribute("memberId");
			MemberVO member = null;
			
			if (memberId != null) {
				member = mService.getOneById(memberId);
			} else {

			}
			if (member != null) {
				model.addAttribute("member", member);
				return "member/updateprofile";
			} else {
				model.addAttribute("msg", "회원 정보 조회를 완료하지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	// 프로필 수정
	@RequestMapping(value = "/member/updateprofile.kh", method = RequestMethod.POST)
	public String modifyProfile(
			@ModelAttribute MemberVO member
			, Model model
			, @RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile
			, HttpServletRequest request) {
		try {
			if (uploadFile != null && !uploadFile.isEmpty()) {
				String fileName = member.getMemberFileRename();
				if (fileName != null) {
					// 있으면 파일 삭제
					this.deleteFile(request, fileName);
				}
				// 없으면 새로 업로드하려는 파일 저장
				Map<String, Object> infoMap = this.saveFile(uploadFile, request);
				String memberFilename = (String) infoMap.get("fileName");
				member.setMemberFilename(memberFilename);
				member.setMemberFileRename((String) infoMap.get("fileRename"));
				member.setMemberFilePath((String) infoMap.get("filePath"));
				member.setMemberFileLength((long) infoMap.get("fileSize"));
			}
			int result = mService.modifyProfile(member);
			if (result > 0) {
				model.addAttribute("member", member);
				model.addAttribute("msg", "프로필 수정이 완료되었습니다.");
				model.addAttribute("url", "/member/profile.kh");
				return "common/alert";
			} else {
				model.addAttribute("msg", "프로필 수정을 완료하지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	// 첨부파일 저장
		private Map<String, Object> saveFile(MultipartFile uploadFile, HttpServletRequest request) throws Exception {
			// TODO Auto-generated method stub
			// 파일 이름
			String fileName = uploadFile.getOriginalFilename();
			// 저장 경로
			String projectPath 	 = request.getSession().getServletContext().getRealPath("resources");
			String saveDirectory = projectPath + "\\muploadFiles";
			File sDir 			 = new File(saveDirectory);
			if (!sDir.exists()) {
				sDir.mkdir(); //nuploadFile 폴더가 없으면 자동으로 만들어줌
			}
			// 파일 리네임의 필요성!!
			// 사용자A와 사용자B가 모두 내용은 다르지만 이름이 같은 1.PNG 파일을 올길 경우를 대비해
			// 위와 같은 파일을 구별하기 위해서 리네임을 할 때에는 올린 시간을 기준으로 파일이름을 만들어서 따로 저장(NOTICE_FILERENAME)
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); // 나중에 대문자 SS와 소문자 ss 비교해보기
			String strResult = sdf.format(new Date(System.currentTimeMillis())); // 원본파일의 확장자 글자부터 시작되도록 +1 해줌
			String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
			String fileRename = strResult + "." + ext;
//			Date date = new Date();
			
			String savePath 	 = saveDirectory + "\\" + fileRename;
			File file = new File(savePath);
			// 파일 저장
			uploadFile.transferTo(file);
			// DB에 저장할 파일정보 셋팅
			// 1. 파일이름, 2. 파일리네임, 3. 파일경로, 4. 파일크기
			long fileLength = uploadFile.getSize();
			Map<String, Object> infoMap = new HashMap<String, Object>();
			infoMap.put("fileName"	, fileName);
			infoMap.put("fileRename", fileRename);
			infoMap.put("filePath"	, savePath);
			infoMap.put("fileSize"	, fileLength);
			return infoMap;
		}
		
		// 파일 재업로드 시, 기존 파일 삭제
		private void deleteFile(HttpServletRequest request, String fileName) {
			// TODO Auto-generated method stub
			String rPath = request.getSession().getServletContext().getRealPath("resources");
			String delFilePath = rPath + "\\muploadFiles\\" + fileName;
			File delFile = new File(delFilePath);
			if (delFile.exists()) {
				delFile.delete();
			}
			
		}
	
	@RequestMapping(value = "/member/deletecheck.kh", method = RequestMethod.GET)
	public String deleteView() {
		return "member/delete";
	}

	// 삭제페이지
	@RequestMapping(value = "/member/delete.kh", method = RequestMethod.POST)
	public String deleteMember(String memberId, String memberPw, HttpSession session, Model model) {
		try {
			String sessionId = (String) session.getAttribute("memberId");
	
			MemberVO member = mService.getOneById(sessionId);
	
			// 비밀번호 확인
			member.setMemberPw(memberPw);
			int result = 0;
	
			// 세션아이디와 아이디 일치하는지
			if (sessionId != null && sessionId.equals(memberId)) {
				result = mService.deleteMember(member);
			} else {
				model.addAttribute("msg", "로그인을 먼저 진행해주세요.");
				return "common/errorPage";
			}
			// 탈퇴가 성공했는지 확인
			if (result > 0) {
				return "redirect:/member/logout.kh";
			} else {
				model.addAttribute("msg", "탈퇴가 완료되지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/member/findid.kh", method = RequestMethod.GET)
	public String findIdView() throws Exception {
		return "member/findid";
	}

	@RequestMapping(value = "/member/findidresult.kh", method = RequestMethod.POST)
	public String findId(String memberName, String memberEmail, Model model) throws Exception {
		try {
			MemberVO member = new MemberVO();
			member.setMemberName(memberName);
			member.setMemberEmail(memberEmail);
			member = mService.findId(member);
			if (member != null) {
				model.addAttribute("member", member);
				return "member/findidresult";
			} else {
				// 실패하면 에러페이지
				model.addAttribute("msg", "아이디를 찾지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	@RequestMapping(value = "/member/findpw.kh", method = RequestMethod.GET)
	public String findPwView() throws Exception {
		return "member/findpw";
	}
	
	// 비밀번호 찾기
	@RequestMapping(value = "/member/findpw.kh", method = RequestMethod.POST)
	public String findPwForm(String memberId, String memberEmail, Model model) throws Exception {
		try {
			MemberVO member = new MemberVO();
			member.setMemberId(memberId);
			member.setMemberEmail(memberEmail);
			member = mService.findPwForm(member);

			if (member != null) {
				model.addAttribute("member", member);
				return "member/findpwresult";
			} else {
				// 실패하면 에러페이지
				model.addAttribute("msg", "비밀번호를 찾지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	// 회원 비밀번호 재설정
	@RequestMapping(value = "/member/updatepw.kh", method = RequestMethod.POST)
	public String findPw(@ModelAttribute MemberVO member, Model model) throws Exception {
		try {
			int result = mService.findPw(member);
			if (result > 0) {
				model.addAttribute("member", member);
				model.addAttribute("msg", "비밀번호가 변경되었습니다.");
				model.addAttribute("url", "/");
				return "common/alert";
			} else {
				model.addAttribute("msg", "수정을 완료하지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

}
