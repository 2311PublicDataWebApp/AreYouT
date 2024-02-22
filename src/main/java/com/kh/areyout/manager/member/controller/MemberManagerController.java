package com.kh.areyout.manager.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.areyout.manager.member.domain.MemberVO;
import com.kh.areyout.manager.member.domain.PageInfo;
import com.kh.areyout.manager.member.service.MemberManagerService;

@Controller
public class MemberManagerController {
	@Autowired
	MemberManagerService mmService;
	
	//블랙리스트 해제 처리
	@RequestMapping(value = "manager/member/white.do", method = RequestMethod.POST)
	public String whiteMember(@RequestParam("check-white-members") String selectMembers, Model model) {
		try {
			String[] members = selectMembers.split(",");
			int result = 0;
			for(String memberId : members) {
				result = mmService.whiteMembers(memberId);
				if(result > 0) {
					continue;
				}
				else {
					model.addAttribute("msg", memberId + "계정의 정지를 풀 수 없습니다.");
					return "common/errorPage";
				}
			}
			return "redirect:/manager/member/blacklist.do";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	
	//일반 회원 탈퇴처리
	@RequestMapping(value = "/manager/member/delete.do", method = RequestMethod.POST)
	public String deleteMember(@RequestParam("check-delete-members") String selectMembers, Model model) {
		try {
			String[] members = selectMembers.split(",");
			int result = 0;
			for(String memberId : members) {
				result = mmService.deleteMembers(memberId);
				if(result > 0) {
					continue;
				}
				else {
					model.addAttribute("msg", memberId + "계정을 삭제 할 수 없습니다.");
					return "common/errorPage";
				}
			}
			return "redirect:/manager/member/list.do";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	//정지 회원 탈퇴처리
		@RequestMapping(value = "/manager/member/blackdelete.do", method = RequestMethod.POST)
		public String blackdeleteMember(@RequestParam("check-delete-members") String selectMembers, Model model) {
			try {
				String[] members = selectMembers.split(",");
				int result = 0;
				for(String memberId : members) {
					result = mmService.deleteMembers(memberId);
					if(result > 0) {
						continue;
					}
					else {
						model.addAttribute("msg", memberId + "계정을 삭제 할 수 없습니다.");
						return "common/errorPage";
					}
				}
				return "redirect:/manager/member/blacklist.do";
			} catch (Exception e) {
				model.addAttribute("msg", e.getMessage());
				return "common/errorPage";
			}
		}
	
	//일반 회원 정지 처리
	@RequestMapping(value = "/manager/member/black.do", method = RequestMethod.POST)
	public String blackMember(@RequestParam("check-black-members") String selectMembers, Model model) {
		try {
			String[] members = selectMembers.split(",");
			int result = 0;
			for(String memberId : members) {
				result = mmService.blackMembers(memberId);
				if(result > 0) {
					continue;
				}
				else {
					model.addAttribute("msg", memberId + "계정을 정지할 수 없습니다.");
					return "common/errorPage";
				}
			}
			return "redirect:/manager/member/list.do";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	//블랙리스트 조회
	@RequestMapping(value = "/manager/member/blacklist.do", method = RequestMethod.GET)
	public ModelAndView showBlackList(ModelAndView mv
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
		try {
			int totalCount = mmService.getBlackTotalCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<MemberVO> mmList = mmService.selectBlackList(pInfo);
			mv.addObject("mmList", mmList);
			mv.addObject("pInfo", pInfo);
			mv.setViewName("manager/member/blacklist");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//검색 조회
	@RequestMapping(value = "/manager/member/search.do", method = RequestMethod.GET)
	public ModelAndView showSearchMember(ModelAndView mv
			, @RequestParam("search-type") String type
			, @RequestParam("search-keyword") String keyword
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
		try {
			Map<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("type", type);
			searchMap.put("keyword", keyword);
			int totalCount = mmService.getSearchTotalCount(searchMap);
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			pInfo.setSearchType(type);
			pInfo.setSearchKeyword(keyword);
			
			
			List<MemberVO> mmList = mmService.selectSearchList(pInfo);
			mv.addObject("mmList", mmList);
			mv.addObject("pInfo", pInfo);
			mv.setViewName("manager/member/search");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//블랙리스트 검색 조회
	@RequestMapping(value = "/manager/member/blacksearch.do", method = RequestMethod.GET)
	public ModelAndView showSearchBlack(ModelAndView mv
			, @RequestParam("search-type") String type
			, @RequestParam("search-keyword") String keyword
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
		try {
			Map<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("type", type);
			searchMap.put("keyword", keyword);
			int totalCount = mmService.getBlackSearchTotalCount(searchMap);
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			pInfo.setSearchType(type);
			pInfo.setSearchKeyword(keyword);
			
			
			List<MemberVO> mmList = mmService.searchBlackList(pInfo);
			mv.addObject("mmList", mmList);
			mv.addObject("pInfo", pInfo);
			mv.setViewName("manager/member/blacksearch");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//회원 목록조회
	@RequestMapping(value = "/manager/member/list.do", method = RequestMethod.GET)
	public ModelAndView showMemberList(ModelAndView mv
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
		try {
			int totalCount = mmService.getTotalCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<MemberVO> mmList = mmService.selectMemberList(pInfo);
			mv.addObject("mmList", mmList);
			mv.addObject("pInfo", pInfo);
			mv.setViewName("manager/member/list");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	private PageInfo getPageInfo(Integer currentPage, int totalCount) {
		PageInfo pi =null;
		int recordCountPerPage = 10;	//한 페이지당 보여줄 게시물 갯수
		int naviCountPerPage = 5;		//한 페이지당 보여줄 페이지 범위의 갯수
		int naviTotalCount;				//범위의 총갯수
		int startNavi;
		int endNavi;
		
		naviTotalCount = (int)((double)totalCount / recordCountPerPage + 0.9);
		startNavi = (((int)((double)currentPage / naviCountPerPage + 0.9)) - 1) * naviCountPerPage + 1;
		endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi = new PageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
		
		return pi;
	}
}
