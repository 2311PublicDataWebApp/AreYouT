package com.kh.areyout.notice.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.areyout.notice.domain.NoticeVO;
import com.kh.areyout.notice.domain.PageInfo;
import com.kh.areyout.notice.service.NoticeService;
import com.kh.areyout.notice.store.NoticeStore;


@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeStore nStore;
	@Autowired
	private SqlSession session;
	
	/**
	 * 공지사항 리스트 Service
	 */
	@Override
	public List<NoticeVO> selectNoticeList(PageInfo pInfo) {
		// TODO Auto-generated method stub
		List<NoticeVO> nList = nStore.selectNoticeList(session, pInfo);
		return nList;
	}

	/**
	 * 공지사항 상세조회 Service
	 */
	@Override
	public NoticeVO selectByNoticeNo(Integer noticeNo) {
		// TODO Auto-generated method stub
		NoticeVO notice = nStore.selectByNoticeNo(session, noticeNo);
		return notice;
	}

	/**
	 * 공지사항 검색 Service
	 */
	@Override
	public List<NoticeVO> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		List<NoticeVO> searchList = nStore.selectNoticesByKeyword(session, pInfo, paramMap);
		return searchList;
	}

	/**
	 * 전체 게시물 갯수 조회 Service
	 */
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		int totalCount = nStore.selectTotalCount(session);
		return totalCount;
	}
	
	/**
	 * 검색 게시물 전체 갯수 Service
	 * @param paramMap
	 * @return int
	 */
	@Override
	public int getTotalCount(Map<String, String> paramMap) {
		int totalCount = nStore.selectTotalCount(session, paramMap);
		return totalCount;
	}

	/**
	 * 공지사항 등록 Service
	 */
	@Override
	public int insertNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		int result = nStore.insertNotice(session, notice);
		return result;
	}

	/**
	 * 공지사항 수정 Service
	 */
	@Override
	public int updateNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		int result = nStore.updateNotice(session, notice);
		return result;
	}

	/**
	 * 공지사항 삭제 Service
	 */
	@Override
	public int deleteNotice(int noticeNo) {
		// TODO Auto-generated method stub
		int result = nStore.deleteNotice(session, noticeNo);
		return result;
	}


}