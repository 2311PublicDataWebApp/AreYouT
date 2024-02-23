package com.kh.areyout.notice.store.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.areyout.notice.domain.NoticeVO;
import com.kh.areyout.notice.domain.PageInfo;
import com.kh.areyout.notice.store.NoticeStore;

@Repository
public class NoticeStoreImpl implements NoticeStore {

	/**
	 * 공지사항 리스트 Store
	 * @param pInfo 
	 * @return nList
	 */
	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<NoticeVO> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nList;
	}

	/**
	 * 공지사항 상세조회 Store
	 * @param noticeNo
	 * @return notice
	 */
	@Override
	public NoticeVO selectByNoticeNo(SqlSession session, int noticeNo) {
		NoticeVO notice = session.selectOne("NoticeMapper.selectByNoticeNo", noticeNo);
		return notice;
	}
	
	/**
	 * 공지사항 검색 Store
	 */
	@Override
	public List<NoticeVO> selectNoticesByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<NoticeVO> searchList = session.selectList("NoticeMapper.selectNoticesByKeyword", paramMap, rowBounds);
		return searchList;
	}

	/**
	 * 전체 게시물 갯수 Store
	 * @return totalCount
	 */
	@Override
	public int selectTotalCount(SqlSession session) {
		// TODO Auto-generated method stub
		int totalCount = session.selectOne("NoticeMapper.selectTotalCount");
		return totalCount;
	}
	
	/**
	 * 검색 게시물 갯수 Store
	 * @return totalCount
	 */
	@Override
	public int selectTotalCount(SqlSession session, Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		int totalCount = session.selectOne("NoticeMapper.searchTotalCount", paramMap);
		return totalCount;
	}

	/**
	 * 공지사항 등록 Store
	 * @param notice
	 * @return result
	 */
	@Override
	public int insertNotice(SqlSession session, NoticeVO notice) {
		// TODO Auto-generated method stub
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	/**
	 * 공지사항 수정 Store
	 * @param notice
	 * @return result
	 */
	@Override
	public int updateNotice(SqlSession session, NoticeVO notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	/**
	 * 공지사항 삭제 Store
	 * @param notice
	 * @return result
	 */
	@Override
	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

}
