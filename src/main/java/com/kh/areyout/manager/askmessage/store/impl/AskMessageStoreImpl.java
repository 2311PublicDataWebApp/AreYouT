package com.kh.areyout.manager.askmessage.store.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.areyout.manager.askmessage.domain.AskMessageVO;
import com.kh.areyout.manager.askmessage.domain.PageInfo;
import com.kh.areyout.manager.askmessage.store.AskMessageStore;

@Repository
public class AskMessageStoreImpl implements AskMessageStore{

	//전체 문의 메세지 갯수
	@Override
	public int getTotalCount(SqlSession session) {
		int result = session.selectOne("AskMessageMapper.selectTotalCount");
		return result;
	}

	//문의 메세지 목록
	@Override
	public List<AskMessageVO> selectAskMessageList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<AskMessageVO> amList = session.selectList("AskMessageMapper.selectAskMessageList", null, rowBounds);
		return amList;
	}

	//메세지 삭제
	@Override
	public int deleteMessage(SqlSession session, int num) {
		int result = session.delete("AskMessageMapper.deleteAskMessage", num);
		return result;
	}

	//메세지 쓰기 창 조회
	@Override
	public AskMessageVO selectAskMessageByNo(SqlSession session, int askMessageNo) {
		AskMessageVO askMessage = session.selectOne("AskMessageMapper.selectAskMessage", askMessageNo);
		return askMessage;
	}

	//읽음/안읽음 상태 조회
	@Override
	public void changeYn(SqlSession session, int askMessageNo) {
		session.update("AskMessageMapper.changeYn", askMessageNo);
	}

	//문의 메세지 답변 전송
	@Override
	public int sendAskMessage(SqlSession session, AskMessageVO askMessage) {
		int result = session.insert("AskMessageMapper.sendAskMessage", askMessage);
		return result;
	}

	//검색 문의 메세지 갯수
	@Override
	public int getSearchTotalCount(SqlSession session, Map<String, Object> searchMap) {
		int result = session.selectOne("AskMessageMapper.searchTotalCount", searchMap);
		return result;
	}

	//검색 문의 메세지 조회
	@Override
	public List<AskMessageVO> searchAskMessageList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("keyword", pInfo.getSearchKeyword()); // 검색할 키워드
	    paramMap.put("type", pInfo.getSearchType());     // 검색할 타입
		
	    List<AskMessageVO> amList = session.selectList("AskMessageMapper.selectSearchList", paramMap, rowBounds);
		return amList;
	}

}
