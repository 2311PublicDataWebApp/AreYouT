package com.kh.areyout.manager.askmessage.controller;

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

import com.kh.areyout.manager.askmessage.domain.AskMessageVO;
import com.kh.areyout.manager.PageInfo;
import com.kh.areyout.manager.askmessage.service.AskMessageService;

@Controller
public class AskMessageController {
	@Autowired
	AskMessageService amService;
	
	//문의 하기
		@RequestMapping(value = "/message/asksend.kh", method = RequestMethod.POST)
		public ModelAndView UserAskMessage(ModelAndView mv
				,HttpSession session
				, @ModelAttribute AskMessageVO askMessage) {
			try {
				String memberId = (String)session.getAttribute("memberId");
				askMessage.setAskMessageSender(memberId);
				int result = amService.UserAskMessage(askMessage);
				if(result > 0) { 
					mv.setViewName("redirect:/message/list.kh");
				} 
			} catch (Exception e) {
				mv.addObject("msg", e.getMessage());
				mv.setViewName("common/errorPage");
			}
			
			return mv;
		}
	
	//문의하기 창 조회
	@RequestMapping(value = "/message/asksend.kh", method = RequestMethod.GET)
	public ModelAndView showUserAskSendForm(ModelAndView mv
			,HttpSession session) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			mv.addObject("memberId", memberId);
			mv.setViewName("message/asksend");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	//문의 메세지 검색
	@RequestMapping(value = "/manager/message/asksearch.kh", method = RequestMethod.GET)
	public ModelAndView searchAskMessage(ModelAndView mv
			, @RequestParam("search-type") String type
			, @RequestParam("search-keyword") String keyword
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
		try {
			Map<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("type", type);
			searchMap.put("keyword", keyword);
			int totalCount = amService.getSearchTotalCount(searchMap);
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			pInfo.setSearchType(type);
			pInfo.setSearchKeyword(keyword);
			
			List<AskMessageVO> amList = amService.searchAskMessageList(pInfo);
			mv.addObject("amList",amList);
			mv.addObject("pInfo", pInfo);
			mv.setViewName("manager/message/asksearch");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	//문의 메세지 답변 전송
	@RequestMapping(value = "/manager/message/sendmessage.kh", method = RequestMethod.POST)
	public ModelAndView sendAskMessage(ModelAndView mv
			, @ModelAttribute AskMessageVO askMessage) {
		try {
			int result = amService.sendAskMessage(askMessage);
			if(result > 0) { 
				mv.setViewName("manager/message/close");
			} 
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	//문의 메세지 작성창 조회
	@RequestMapping(value = "/manager/message/asksend.kh", method = RequestMethod.GET)
	public ModelAndView showSendForm(ModelAndView mv) {
		try {
			mv.setViewName("manager/message/asksend");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	//문의 메세지 상세 조회
	@RequestMapping(value = "/manager/message/askdetail.kh", method = RequestMethod.GET)
	public ModelAndView showAskDetail(ModelAndView mv, int askMessageNo) {
		try {
			AskMessageVO askMessage = amService.selectAskMessageByNo(askMessageNo);
			amService.changeYn(askMessageNo);
			if(askMessage != null) {
				mv.addObject("askMessage", askMessage).setViewName("manager/message/askdetail");
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
	
	//문의 메세지 삭제
	@RequestMapping(value = "/manager/message/askdelete.kh", method = RequestMethod.POST)
	public String messageDelete(@RequestParam("check-delete-message") String selectMessage, Model model) {
		try {
			String[] messages = selectMessage.split(",");
			int result = 0;
			int num;
			for(String messageNo : messages) {
				num = Integer.parseInt(messageNo);
				result = amService.deleteMessage(num);
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
		return "redirect:/manager/message/askmessage.kh";
	}
	
	//문의 메세지함
	@RequestMapping(value = "/manager/message/askmessage.kh", method = RequestMethod.GET)
	public ModelAndView showAskMessageList(ModelAndView mv
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
		try {
			int totalCount = amService.getTotalCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<AskMessageVO> amList = amService.selectAskMessageList(pInfo);
			mv.addObject("amList", amList);
			mv.addObject("pInfo", pInfo);
			mv.setViewName("manager/message/askmessage");
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
