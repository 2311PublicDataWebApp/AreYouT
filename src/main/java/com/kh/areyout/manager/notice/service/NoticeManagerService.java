package com.kh.areyout.manager.notice.service;

import java.util.List;
import java.util.Map;

import com.kh.areyout.manager.notice.domain.PageInfo;
import com.kh.areyout.notice.domain.NoticeVO;

public interface NoticeManagerService {

	/**
	 * 게시판 전체 갯수 Service
	 * @return result
	 */
	int getTotalCount();

	/**
	 * 게시물 목록 조회 Service
	 * @param pInfo
	 * @return nmList
	 */
	List<NoticeVO> selectNoticeList(PageInfo pInfo);

	/**
	 * 게시물 삭제 Service
	 * @param noticeNo
	 * @return result
	 */
	int deleteNotice(int noticeNo);

	/**
	 * 게시물 상세 조회 Service
	 * @param noticeNo
	 * @return notice
	 */
	NoticeVO selectByNoticeNo(int noticeNo);

	/**
	 * 검색된 게시물 수 Service
	 * @param searchMap
	 * @return result
	 */
	int getSearchTotalCount(Map<String, Object> searchMap);

	/**
	 * 검색 게시물 목록 Service
	 * @param pInfo
	 * @return nmList
	 */
	List<NoticeVO> searchNoticeList(PageInfo pInfo);

}
