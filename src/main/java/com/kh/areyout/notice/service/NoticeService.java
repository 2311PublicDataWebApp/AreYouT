package com.kh.areyout.notice.service;

import java.util.List;
import java.util.Map;

import com.kh.areyout.notice.domain.NoticeVO;
import com.kh.areyout.notice.domain.PageInfo;



public interface NoticeService {

	/**
	 * 공지사항 리스트 Service
	 * @param pInfo 
	 * @return nList
	 */
	List<NoticeVO> selectNoticeList(PageInfo pInfo);

	/**
	 * 공지사항 상세조회 Service
	 * @param noticeNo
	 * @return notice
	 */
	NoticeVO selectByNoticeNo(Integer noticeNo);

	/**
	 * 공지사항 검색 Service
	 * @param pInfo 
	 * @param paramMap
	 * @return List
	 */
	List<NoticeVO> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap);

	/**
	 * 전체 게시물 갯수 Service
	 * @return totalCount
	 */
	int getTotalCount();
	
	
	/**
	 * 검색 게시물 전체 갯수 Service
	 * @param paramMap
	 * @return int
	 */
	int getTotalCount(Map<String, String> paramMap);

	/**
	 * 공지사항 등록 Service
	 * @param notice
	 * @return result
	 */
	int insertNotice(NoticeVO notice);

	/**
	 * 공지사항 수정 Service
	 * @param notice
	 * @return result
	 */
	int updateNotice(NoticeVO notice);

	/**
	 * 공지사항 삭제 Service
	 * @param notice
	 * @return result
	 */
	int deleteNotice(int noticeNo);

}
