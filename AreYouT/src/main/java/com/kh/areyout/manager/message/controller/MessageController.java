package com.kh.areyout.manager.message.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.areyout.manager.PageInfo;
import com.kh.areyout.manager.message.domain.MessageVO;
import com.kh.areyout.manager.message.service.MessageService;

@Controller
public class MessageController {
	@Autowired
	MessageService mService;
	
	//메세지 관리 목록 검색 조회
	@RequestMapping(value = "/manager/message/search.kh", method = RequestMethod.GET)
	public ModelAndView showSearchMessage(ModelAndView mv
			, @RequestParam("search-type") String type
			, @RequestParam("search-keyword") String keyword
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
		try {
			Map<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("type", type);
			searchMap.put("keyword", keyword);
			int totalCount = mService.getSearchTotalCount(searchMap);
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			pInfo.setSearchType(type);
			pInfo.setSearchKeyword(keyword);
			
			List<MessageVO> mList = mService.searchMessageList(pInfo);
			mv.addObject("mList",mList);
			mv.addObject("pInfo", pInfo);
			mv.setViewName("manager/message/search");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//메세지 상세 조회
	@RequestMapping(value = "/manager/message/detail.kh", method = RequestMethod.GET)
	public ModelAndView showDetailMessage(ModelAndView mv, int messageNo) {
		try {
			MessageVO message = mService.selectMessageByNo(messageNo);
			if(message != null) {
				mv.addObject("message", message).setViewName("manager/message/detail");
			}
			else {
				mv.addObject("msg", "메세지가 존재하지 않습니다.");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//관리자 메세지 삭제
	@RequestMapping(value = "/manager/message/delete.kh", method = RequestMethod.POST)
	public String messageDelete(@RequestParam("check-delete-message") String selectMessage, Model model) {
		try {
			String[] messages = selectMessage.split(",");
			int result = 0;
			int num;
			for(String messageNo : messages) {
				num = Integer.parseInt(messageNo);
				result = mService.deleteMessage(num);
				if(result > 0) {
					continue;
				}
				else {
					model.addAttribute("msg", messageNo + "번 메세지를 삭제 할 수 없습니다.");
					return "common/errorPage";
				}
			}
		} catch (Exception e){
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
		return "redirect:/manager/message/list.kh";
	}
	
	//메세지 관리 목록 조회
	@RequestMapping(value = "/manager/message/list.kh", method = RequestMethod.GET)
	public ModelAndView showMessageList(ModelAndView mv
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
		try {
			int totalCount = mService.getTotalCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<MessageVO> mList = mService.selectMessageList(pInfo);
			mv.addObject("mList",mList);
			mv.addObject("pInfo", pInfo);
			mv.setViewName("manager/message/list");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//쪽지 검색
		@RequestMapping(value = "/message/search.kh", method = RequestMethod.GET)
		public ModelAndView showUserSearchMessage(ModelAndView mv
				, HttpSession session
				, @RequestParam("search-type") String type
				, @RequestParam("search-keyword") String keyword
				, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
			try {
				String memberId = (String)session.getAttribute("memberId");
				Map<String, Object> searchMap = new HashMap<String, Object>();
				searchMap.put("type", type);
				searchMap.put("keyword", keyword);
				searchMap.put("memberId", memberId);
				int totalCount = mService.getSearchTotalCount(searchMap);
				PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
				pInfo.setSearchType(type);
				pInfo.setSearchKeyword(keyword);
				pInfo.setMemberId(memberId);
				
				List<MessageVO> mList = mService.searchMessageList(pInfo);
				mv.addObject("mList",mList);
				mv.addObject("pInfo", pInfo);
				mv.setViewName("message/search");
			} catch (Exception e) {
				mv.addObject("msg", e.getMessage());
				mv.setViewName("common/errorPage");
			}
			return mv;
		}
	
	//쪽지 전송
		@RequestMapping(value = "/message/send.kh", method = RequestMethod.POST)
		public ModelAndView sendAskMessage(ModelAndView mv
				, @ModelAttribute MessageVO message) {
			try {
				int result = mService.sendMessage(message);
				if(result > 0) { 
					mv.setViewName("redirect:/message/list.kh");
				}
				else {
					mv.addObject("msg", "메세지 전송에 실패하였습니다.");
					mv.setViewName("common/errorPage");
				}
			} catch (Exception e) {
				mv.addObject("msg", e.getMessage());
				mv.setViewName("common/errorPage");
			}
			
			return mv;
		}
	
	//메세지 작성창 조회
		@RequestMapping(value = "/message/send.kh", method = RequestMethod.GET)
		public ModelAndView showSendForm(ModelAndView mv
				, HttpSession session) {
			try {
				String memberId = (String)session.getAttribute("memberId");
				mv.addObject("memberId", memberId);
				mv.setViewName("message/send");
			} catch (Exception e) {
				mv.addObject("msg", e.getMessage());
				mv.setViewName("common/errorPage");
			}
			
			return mv;
		}
	//유저 메세지 상세 조회
		@RequestMapping(value = "/message/detail.kh", method = RequestMethod.GET)
		public ModelAndView showUserDetailMessage(ModelAndView mv, int messageNo) {
			try {
				MessageVO message = mService.selectMessageByNo(messageNo);
				mService.changeYn(messageNo);
				if(message != null) {
					mv.addObject("message", message).setViewName("message/detail");
				}
				else {
					mv.addObject("msg", "메세지가 존재하지 않습니다.");
					mv.setViewName("common/errorPage");
				}
			} catch (Exception e) {
				mv.addObject("msg", e.getMessage());
				mv.setViewName("common/errorPage");
			}
			return mv;
		}
	
	//유저 메세지 삭제
		@RequestMapping(value = "/message/delete.kh", method = RequestMethod.POST)
		public String userMessageDelete(@RequestParam("check-delete-message") String selectMessage, Model model) {
			try {
				String[] messages = selectMessage.split(",");
				int result = 0;
				int num;
				for(String messageNo : messages) {
					num = Integer.parseInt(messageNo);
					result = mService.deleteMessage(num);
					if(result > 0) {
						continue;
					}
					else {
						model.addAttribute("msg", messageNo + "번 메세지를 삭제 할 수 없습니다.");
						return "common/errorPage";
					}
				}
			} catch (Exception e){
				model.addAttribute("msg", e.getMessage());
				return "common/errorPage";
			}
			return "redirect:/message/list.kh";
		}
	
	//쪽지함 목록 조회
		@RequestMapping(value = "/message/list.kh", method = RequestMethod.GET)
		public ModelAndView showUserMessageList(ModelAndView mv
				, HttpSession session
				, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
			try {
				String memberId = (String)session.getAttribute("memberId");
				int totalCount = mService.getTotalCount(memberId);
				PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
				List<MessageVO> mList = mService.selectMessageList(pInfo, memberId);
				mv.addObject("mList",mList);
				mv.addObject("pInfo", pInfo);
				mv.setViewName("message/list");
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
