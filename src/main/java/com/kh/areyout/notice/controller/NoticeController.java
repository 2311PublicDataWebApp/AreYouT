package com.kh.areyout.notice.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.areyout.notice.domain.NoticeVO;
import com.kh.areyout.notice.domain.PageInfo;
import com.kh.areyout.notice.service.NoticeService;



@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService nService;
	
//	@RequestMapping(value = "/notice/insert.kh", method = RequestMethod.GET)
//	public String showInsertForm() {
//		return "/notice/register";
//	}
	
	
	@RequestMapping(value = "/notice/list.kh", method = RequestMethod.GET)
	public ModelAndView showNoticeList(ModelAndView mv,
	        @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage) {
	    try {
	        int totalCount = nService.getTotalCount();
	        PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
	        List<NoticeVO> nList = nService.selectNoticeList(pInfo);
	        mv.addObject("nList", nList);
	        mv.addObject("pInfo", pInfo);
	        
	        if ("/".equals(mv.getViewName())) {
	            // "/" 경로로 들어왔을 때의 추가 처리
	        } else if ("notice/list".equals(mv.getViewName())) {
	            // "/notice/list.kh" 경로로 들어왔을 때의 추가 처리
	        }

	    } catch (Exception e) {
	        mv.addObject("msg", e.getMessage());
	        mv.setViewName("common/errorPage");
	    }
	    return mv;
	}
	
	
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView showHomeList(ModelAndView mv
//			, @RequestParam(value = "page", required = false, defaultValue = "1") 
//				Integer currentPage) {
//		try {
//			int totalCount = nService.getTotalCount();
//			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
//			List<NoticeVO> nList = nService.selectNoticeList(pInfo);
//			mv.addObject("nList", nList);
//			mv.addObject("pInfo", pInfo);
//			mv.setViewName("/");
//		} catch (Exception e) {
//			// TODO: handle exception
//			mv.addObject("msg", e.getMessage());
//			mv.setViewName("common/errorPage");
//		}
//		return mv;
//	}
//	
//	
//	// 怨듭��궗�빆 紐⑸줉
//	@RequestMapping(value = "/notice/list.kh", method = RequestMethod.GET)
//	public ModelAndView showNoticeList(ModelAndView mv
//			, @RequestParam(value = "page", required = false, defaultValue = "1") 
//				Integer currentPage) {
//		try {
//			int totalCount = nService.getTotalCount();
//			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
//			List<NoticeVO> nList = nService.selectNoticeList(pInfo);
//			mv.addObject("nList", nList);
//			mv.addObject("pInfo", pInfo);
//			mv.setViewName("notice/list");
//		} catch (Exception e) {
//			// TODO: handle exception
//			mv.addObject("msg", e.getMessage());
//			mv.setViewName("common/errorPage");
//		}
//		return mv;
//	}
//	
	// 怨듭��궗�빆 寃��깋
	@RequestMapping(value="/notice/search.kh", method=RequestMethod.GET)
	public ModelAndView searchNoticeList(ModelAndView mv
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword
			, @RequestParam(value="page", required=false, defaultValue="1") Integer currentPage) {
		/*
		 * 2媛쒖쓽 媛믪쓣 �븯�굹�쓽 蹂��닔濡� �떎猷⑤뒗 諛⑸쾿
		 * 1. VO �겢�옒�뒪瑜� 留뚮뱶�뒗 諛⑸쾿(�씠誘� �빐遊�)
		 * 2. HashMap �궗�슜�븯�뒗 諛⑸쾿(�씠誘� �빐遊�)
		 */
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchKeyword", searchKeyword);
		int totalCount = nService.getTotalCount(paramMap);
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<NoticeVO> searchList = nService.searchNoticesByKeyword(pInfo, paramMap);
		mv.addObject("sList", searchList);
		mv.addObject("pInfo", pInfo);
		mv.addObject("searchCondition", searchCondition);
		mv.addObject("searchKeyword", searchKeyword);
		mv.setViewName("notice/search");
		return mv;
	}
	
	// 怨듭��궗�빆 �벑濡� GET
	@RequestMapping(value="/notice/insert.kh", method=RequestMethod.GET)
    public ModelAndView showInsertForm(ModelAndView mv) {
        mv.setViewName("notice/register");
        return mv;
    }
	
	// 怨듭��궗�빆 �벑濡� POST
	@RequestMapping(value = "/notice/insert.kh", method = RequestMethod.POST)
	public ModelAndView insertNotice(ModelAndView mv
			, @ModelAttribute NoticeVO notice
			, @RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile
			, HttpServletRequest request) {
		try {
			if (uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				Map<String, Object> infoMap = this.saveFile(uploadFile, request);
				String fileName 	= (String) infoMap.get("fileName");
				String fileRename 	= (String) infoMap.get("fileRename");
				String filePath 	= (String) infoMap.get("filePath");
				long fileLength 	= (long) infoMap.get("fileSize");
				
				notice.setNoticeFilename(fileName);
				notice.setNoticeFileRename(fileRename);
				notice.setNoticeFilePath(filePath);
				notice.setNoticeFileLength(fileLength);
			}
			int result = nService.insertNotice(notice);
			if (result > 0) {
				mv.setViewName("redirect:/notice/list.kh");
			} else {
				mv.addObject("msg", "怨듭��궗�빆 �벑濡앹씠 �셿猷뚮릺吏� 紐삵뻽�뒿�땲�떎.");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 怨듭��궗�빆 �긽�꽭
	@RequestMapping(value = "notice/detail.kh", method = RequestMethod.GET)
	public ModelAndView showNoticeDetail(ModelAndView mv, int noticeNo) {
		try {
			NoticeVO notice = nService.selectByNoticeNo(noticeNo);
			if (notice != null) {
				// 硫붿냼�뱶 梨꾩씠�떇 諛⑹떇
				mv.addObject("notice", notice).setViewName("notice/detail");
			} else {
				mv.addObject("msg", "�뜲�씠�꽣 遺덈윭�삤湲곌� �셿猷뚮릺吏� 紐삵뻽�뒿�땲�떎.");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}

	// 공지사항 수정 GET
	@RequestMapping(value = "/notice/modify.kh", method = RequestMethod.GET)
	public ModelAndView showModifyForm(ModelAndView mv, @RequestParam(value = "noticeNo") Integer noticeNo) {
	    try {
	        NoticeVO notice = nService.selectByNoticeNo(noticeNo);
	        if (notice != null) {
	            mv.addObject("notice", notice);
	            mv.setViewName("notice/modify");
	        } else {
	            mv.addObject("msg", "해당 데이터가 존재하지 않습니다.");
	            mv.setViewName("common/errorPage");
	        }
	    } catch (Exception e) {
	        mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
	    }
	    return mv;
	}

	// 공지사항 수정 POST
	// 컨트롤러에서의 메소드
	@RequestMapping(value = "/notice/modify.kh", method = RequestMethod.POST)
	public ModelAndView modifyNotice(ModelAndView mv, @ModelAttribute NoticeVO modifiedNotice,
	        @RequestParam(value = "reloadFile", required = false) MultipartFile reloadFile,
	        HttpServletRequest request) {
	    try {
	        // 기존 파일 삭제 등 필요한 로직 수행

	        // 새로운 파일 저장 및 정보 설정
	        if (reloadFile != null && !reloadFile.isEmpty()) {
	            Map<String, Object> infoMap = this.saveFile(reloadFile, request);
	            modifiedNotice.setNoticeFilename((String) infoMap.get("fileName"));
	            modifiedNotice.setNoticeFileRename((String) infoMap.get("fileRename"));
	            modifiedNotice.setNoticeFilePath((String) infoMap.get("filePath"));
	            modifiedNotice.setNoticeFileLength((long) infoMap.get("fileSize"));
	        }

	        // 수정된 내용으로 DB 업데이트
	        Integer result = nService.updateNotice(modifiedNotice);
	        if (result > 0) {
	            mv.setViewName("redirect:/notice/detail.kh?noticeNo=" + modifiedNotice.getNoticeNo());
	        } else {
	            mv.addObject("msg", "공지사항 수정이 실패하였습니다.");
	            mv.setViewName("common/errorPage");
	        }
	    } catch (Exception e) {
	        mv.addObject("msg", e.getMessage());
	        mv.setViewName("common/errorPage");
	    }
	    return mv;
	}



	
	// 怨듭��궗�빆 �궘�젣
	@RequestMapping(value = "/notice/delete.kh", method = RequestMethod.GET)
	public ModelAndView deleteNotice(ModelAndView mv, int noticeNo) {
		try {
			int result = nService.deleteNotice(noticeNo);
			if (result > 0) {
				mv.setViewName("redirect:/notice/list.kh");
			} else {
				mv.addObject("msg", "�뜲�씠�꽣媛� 議댁옱�븯吏� �븡�뒿�땲�떎.").setViewName("common/errorPage");
			}
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("msg", e.getMessage()).setViewName("common/errorPage");
		}
		return mv;
	}
	
	// �럹�씠吏� 泥섎━
	private PageInfo getPageInfo(Integer currentPage, int totalCount) {
		PageInfo pi = null;
		int recordCountPerPage = 10; // �븳 �럹�씠吏��떦 蹂댁뿬以� 寃뚯떆臾쇱쓽 媛��닔
		int naviCountPerPage = 5; 	 // �븳 �럹�씠吏��떦 蹂댁뿬以� 踰붿쐞�쓽 媛��닔
		int naviTotalCount; 		 // 踰붿쐞�쓽 珥� 媛��닔
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
	
	// 泥⑤��뙆�씪 ���옣
	private Map<String, Object> saveFile(MultipartFile uploadFile, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		// �뙆�씪 �씠由�
		String fileName = uploadFile.getOriginalFilename();
		// ���옣 寃쎈줈
		String projectPath 	 = request.getSession().getServletContext().getRealPath("resources");
		String saveDirectory = projectPath + "\\nuploadFiles";
		File sDir 			 = new File(saveDirectory);
		if (!sDir.exists()) {
			sDir.mkdir(); //nuploadFile �뤃�뜑媛� �뾾�쑝硫� �옄�룞�쑝濡� 留뚮뱾�뼱以�
		}
		// �뙆�씪 由щ꽕�엫�쓽 �븘�슂�꽦!!
		// �궗�슜�옄A�� �궗�슜�옄B媛� 紐⑤몢 �궡�슜�� �떎瑜댁�留� �씠由꾩씠 媛숈� 1.PNG �뙆�씪�쓣 �삱湲� 寃쎌슦瑜� ��鍮꾪빐
		// �쐞�� 媛숈� �뙆�씪�쓣 援щ퀎�븯湲� �쐞�빐�꽌 由щ꽕�엫�쓣 �븷 �븣�뿉�뒗 �삱由� �떆媛꾩쓣 湲곗��쑝濡� �뙆�씪�씠由꾩쓣 留뚮뱾�뼱�꽌 �뵲濡� ���옣(NOTICE_FILERENAME)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); // �굹以묒뿉 ��臾몄옄 SS�� �냼臾몄옄 ss 鍮꾧탳�빐蹂닿린
		String strResult = sdf.format(new Date(System.currentTimeMillis())); // �썝蹂명뙆�씪�쓽 �솗�옣�옄 湲��옄遺��꽣 �떆�옉�릺�룄濡� +1 �빐以�
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		String fileRename = strResult + "." + ext;
//		Date date = new Date();
		
		String savePath 	 = saveDirectory + "\\" + fileRename;
		File file = new File(savePath);
		// �뙆�씪 ���옣
		uploadFile.transferTo(file);
		// DB�뿉 ���옣�븷 �뙆�씪�젙蹂� �뀑�똿
		// 1. �뙆�씪�씠由�, 2. �뙆�씪由щ꽕�엫, 3. �뙆�씪寃쎈줈, 4. �뙆�씪�겕湲�
		long fileLength = uploadFile.getSize();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put("fileName"	, fileName);
		infoMap.put("fileRename", fileRename);
		infoMap.put("filePath"	, savePath);
		infoMap.put("fileSize"	, fileLength);
		return infoMap;
	}
	
	// �뙆�씪 �옱�뾽濡쒕뱶 �떆, 湲곗〈 �뙆�씪 �궘�젣
	private void deleteFile(HttpServletRequest request, String fileName) {
		// TODO Auto-generated method stub
		String rPath = request.getSession().getServletContext().getRealPath("resources");
		String delFilePath = rPath + "\\nuploadFiles\\" + fileName;
		File delFile = new File(delFilePath);
		if (delFile.exists()) {
			delFile.delete();
		}
		
	}
}
