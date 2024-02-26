package com.kh.areyout.notice.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.areyout.notice.domain.NoticeVO;
import com.kh.areyout.notice.domain.PageInfo;



public interface NoticeStore {

	/**
	 * 공지사항 리스트 Store
	 * @param session
	 * @param pInfo 
	 * @return nList
	 */
	List<NoticeVO> selectNoticeList(SqlSession session, PageInfo pInfo);

	/**
	 * 공지사항 상세조회 Store
	 * @param noticeNo
	 * @return notice
	 */
	NoticeVO selectByNoticeNo(SqlSession session, Integer noticeNo);

	/**
	 * 공지사항 검색 Store
	 * @param session
	 * @param pInfo 
	 * @param paramMap
	 * @return List
	 */
	List<NoticeVO> selectNoticesByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);

	/**
	 * 전체 게시물 갯수 Store
	 * @return totalCount
	 */
	int selectTotalCount(SqlSession session);
	
	/**
	 * 검색 게시물 갯수 Store
	 * @param session
	 * @param paramMap
	 * @return int
	 */
	int selectTotalCount(SqlSession session, Map<String, String> paramMap);

	/**
	 * 공지사항 등록 Store
	 * @param session
	 * @param notice
	 * @return result
	 */
	int insertNotice(SqlSession session, NoticeVO notice);

	/**
	 * 공지사항 수정 Store
	 * @param notice
	 * @return result
	 */
	int updateNotice(SqlSession session, NoticeVO notice);

	/**
	 * 공지사항 삭제 Store
	 * @param notice
	 * @return result
	 */
	int deleteNotice(SqlSession session, int noticeNo);

}
