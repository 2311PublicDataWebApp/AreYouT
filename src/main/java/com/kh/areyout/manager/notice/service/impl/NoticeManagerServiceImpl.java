package com.kh.areyout.manager.notice.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.areyout.manager.notice.domain.PageInfo;
import com.kh.areyout.manager.notice.service.NoticeManagerService;
import com.kh.areyout.manager.notice.store.NoticeManagerStore;
import com.kh.areyout.notice.domain.NoticeVO;

@Service
public class NoticeManagerServiceImpl implements NoticeManagerService{
	@Autowired
	SqlSession session;
	@Autowired
	NoticeManagerStore nmStore;
	
	@Override
	public int getTotalCount() {
		int result = nmStore.getTotalCount(session);
		return result;
	}

	@Override
	public List<NoticeVO> selectNoticeList(PageInfo pInfo) {
		List<NoticeVO> nmList = nmStore.selectNoticeList(session, pInfo);
		return nmList;
	}

	@Override
	public int deleteNotice(int noticeNo) {
		int result = nmStore.deleteNotice(session, noticeNo);
		return result;
	}

	@Override
	public NoticeVO selectByNoticeNo(int noticeNo) {
		NoticeVO notice = nmStore.selectByNoticeNo(session, noticeNo);
		return notice;
	}

	@Override
	public int getSearchTotalCount(Map<String, Object> searchMap) {
		int result = nmStore.getSearchTotalCount(session, searchMap);
		return result;
	}

	@Override
	public List<NoticeVO> searchNoticeList(PageInfo pInfo) {
		List<NoticeVO> nmList = nmStore.searchNoticeList(session, pInfo);
		return nmList;
	}

}
