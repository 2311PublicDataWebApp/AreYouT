package com.kh.areyout.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.areyout.manager.member.domain.MemberVO;
import com.kh.areyout.manager.member.service.MemberManagerService;
import com.kh.areyout.manager.message.domain.MessageVO;
import com.kh.areyout.manager.message.service.MessageService;
import com.kh.areyout.manager.notice.service.NoticeManagerService;
import com.kh.areyout.notice.domain.NoticeVO;

@Controller
public class ManagerController {
	@Autowired
	MemberManagerService mmService;
	@Autowired
	MessageService mService;
	@Autowired
	NoticeManagerService nmService;
	
	//대쉬 보드 창 띄우기
	@RequestMapping(value = "/manager/main.kh", method = RequestMethod.GET)
	public ModelAndView showDashboard(ModelAndView mv
			, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
		try {
			List<MessageVO> mList;
			List<NoticeVO> nList;
			List<MemberVO> mmList;
			int totalCount;
			
			totalCount = 20;
			PageInfo pInfo1 = this.getPageInfo1(currentPage, totalCount);
			PageInfo pInfo2 = this.getPageInfo2(currentPage, totalCount);
			
			mList = mService.selectMessageList(pInfo1);
			nList = nmService.selectNoticeList(pInfo1);
			
			mmList = mmService.selectMemberList(pInfo2);
			mv.addObject("mList",mList);
			mv.addObject("mmList",mmList);
			mv.addObject("nList",nList);
			
			mv.setViewName("manager/main");
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	private PageInfo getPageInfo1(Integer currentPage, int totalCount) {
		PageInfo pi =null;
		int recordCountPerPage = 6;	//한 페이지당 보여줄 게시물 갯수
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
	
	private PageInfo getPageInfo2(Integer currentPage, int totalCount) {
		PageInfo pi =null;
		int recordCountPerPage = 20;	//한 페이지당 보여줄 게시물 갯수
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
