package com.kh.areyout.manager.notice.store.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.areyout.manager.PageInfo;
import com.kh.areyout.manager.notice.store.NoticeManagerStore;
import com.kh.areyout.notice.domain.NoticeVO;

@Repository
public class NoticeManagerStoreImpl implements NoticeManagerStore{

	@Override
	public int getTotalCount(SqlSession session) {
		int result = session.selectOne("NoticeMapper.selectTotalCount");
		return result;
	}

	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<NoticeVO> nmList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nmList;
	}

	@Override
	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	@Override
	public NoticeVO selectByNoticeNo(SqlSession session, int noticeNo) {
		NoticeVO notice = session.selectOne("NoticeMapper.selectByNoticeNo", noticeNo);
		return notice;
	}

	@Override
	public int getSearchTotalCount(SqlSession session, Map<String, Object> searchMap) {
		int result = session.selectOne("NoticeMapper.searchNoticeTotalCount", searchMap);
		return result;
	}

	@Override
	public List<NoticeVO> searchNoticeList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("searchKeyword", pInfo.getSearchKeyword()); // 검색할 키워드
	    paramMap.put("searchCondition", pInfo.getSearchType());     // 검색할 타입
	    List<NoticeVO> nmList = session.selectList("NoticeMapper.selectNoticesByKeyword", paramMap, rowBounds);
		return nmList;
	}
	
}
