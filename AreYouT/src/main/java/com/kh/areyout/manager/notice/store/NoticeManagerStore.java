package com.kh.areyout.manager.notice.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.areyout.manager.PageInfo;
import com.kh.areyout.notice.domain.NoticeVO;

public interface NoticeManagerStore {

	/**
	 * 전체 게시물 갯수 Store
	 * @param session
	 * @return result
	 */
	int getTotalCount(SqlSession session);

	/**
	 * 전체 게시물 목록 조회 Store
	 * @param session
	 * @param pInfo
	 * @return nmList
	 */
	List<NoticeVO> selectNoticeList(SqlSession session, PageInfo pInfo);

	/**
	 * 게시물 삭제 Store
	 * @param session
	 * @param noticeNo
	 * @return result
	 */
	int deleteNotice(SqlSession session, int noticeNo);
	
	/**
	 * 게시물 상세 조회 Store
	 * @param session
	 * @param noticeNo
	 * @return notice
	 */
	NoticeVO selectByNoticeNo(SqlSession session, int noticeNo);

	/**
	 * 검색된 게시물 수 Store
	 * @param session
	 * @param searchMap
	 * @return result
	 */
	int getSearchTotalCount(SqlSession session, Map<String, Object> searchMap);

	/**
	 * 검색 게시물 목록 Store
	 * @param session
	 * @param pInfo
	 * @return nmList
	 */
	List<NoticeVO> searchNoticeList(SqlSession session, PageInfo pInfo);

}
