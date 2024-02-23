package com.kh.areyout.manager.notice.controller;

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

import com.kh.areyout.manager.notice.service.NoticeManagerService;
import com.kh.areyout.notice.domain.NoticeVO;
import com.kh.areyout.manager.notice.domain.PageInfo;

@Controller
public class NoticeManagerController {
	@Autowired
	NoticeManagerService nmService;
	
	//공지사항 검색
	@RequestMapping(value = "/manager/notice/search.kh", method = RequestMethod.GET)
	public ModelAndView showSearchNotice(ModelAndView mv
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
		try {
			Map<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("searchCondition", searchCondition);
			searchMap.put("searchKeyword", searchKeyword);
			int totalCount = nmService.getSearchTotalCount(searchMap);
			System.out.println(totalCount);
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			pInfo.setSearchType(searchCondition);
			pInfo.setSearchKeyword(searchKeyword);
			
			List<NoticeVO> nmList = nmService.searchNoticeList(pInfo);
			mv.addObject("nmList",nmList);
			mv.addObject("pInfo", pInfo);
			mv.setViewName("manager/notice/search");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 공지사항 상세
		@RequestMapping(value = "/manager/notice/detail.kh", method = RequestMethod.GET)
		public ModelAndView showNoticeDetail(ModelAndView mv, int noticeNo) {
			try {
				NoticeVO notice = nmService.selectByNoticeNo(noticeNo);
				if (notice != null) {
					// 메소드 채이닝 방식
					mv.addObject("notice", notice).setViewName("manager/notice/detail");
				} else {
					mv.addObject("msg", "데이터 불러오기가 완료되지 못했습니다.");
					mv.setViewName("common/errorPage");
				}
			} catch (Exception e) {
				// TODO: handle exception
				mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
			}
			return mv;
		}
	
	// 공지사항 삭제
		@RequestMapping(value = "/manager/notice/delete.kh", method = RequestMethod.POST)
		public String deleteNotice(@RequestParam("check-delete-notice") String selectNotices, Model model) {
			try {
				String[] notices = selectNotices.split(",");
				int result = 0;
				int num;
				for(String noticeNo : notices) {
					num = Integer.parseInt(noticeNo);
					result = nmService.deleteNotice(num);
					if(result > 0) {
						continue;
					}
					else {
						model.addAttribute("msg", noticeNo + "번 게시물을 삭제 할 수 없습니다.");
						return "common/errorPage";
					}
				}
				return "redirect:/manager/notice/list.kh";
			} catch (Exception e) {
				model.addAttribute("msg", e.getMessage());
				return "common/errorPage";
			}
		}
	
	@RequestMapping(value = "/manager/notice/list.kh", method = RequestMethod.GET)
	public ModelAndView showNoticeList(ModelAndView mv
			, @RequestParam(value = "page", required = false, defaultValue = "1") 
				Integer currentPage) {
		try {
			int totalCount = nmService.getTotalCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<NoticeVO> nmList = nmService.selectNoticeList(pInfo);
			mv.addObject("nmList", nmList);
			mv.addObject("pInfo", pInfo);
			mv.setViewName("manager/notice/list");
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 페이징 처리
	private PageInfo getPageInfo(Integer currentPage, int totalCount) {
		PageInfo pi = null;
		int recordCountPerPage = 10; // 한 페이지당 보여줄 게시물의 갯수
		int naviCountPerPage = 5; 	 // 한 페이지당 보여줄 범위의 갯수
		int naviTotalCount; 		 // 범위의 총 갯수
		int startNavi;
		int endNavi;
		
		naviTotalCount = (int)((double) totalCount / recordCountPerPage + 0.9);
		startNavi = (((int)((double) currentPage / naviCountPerPage + 0.9)) - 1) * naviCountPerPage + 1;
		endNavi = startNavi + naviCountPerPage - 1;
		if (endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi = new PageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi,
				endNavi);
		return pi;
	}
}
