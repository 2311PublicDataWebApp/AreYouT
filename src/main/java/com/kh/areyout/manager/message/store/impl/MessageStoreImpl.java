package com.kh.areyout.manager.message.store.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.areyout.manager.message.domain.MessageVO;
import com.kh.areyout.manager.PageInfo;
import com.kh.areyout.manager.message.store.MessageStore;

@Repository
public class MessageStoreImpl implements MessageStore{

	@Override
	public int getTotalCount(SqlSession session) {
		int result = session.selectOne("MessageManagerMapper.selectTotalCount");
		return result;
	}

	@Override
	public List<MessageVO> selectMessageList(PageInfo pInfo, SqlSession session) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<MessageVO> mList = session.selectList("MessageManagerMapper.selectMessageList", null, rowBounds);		
		return mList;
	}

	@Override
	public int deleteMessage(SqlSession session, int num) {
		int result = session.delete("MessageManagerMapper.deleteMessage", num);
		return result;
	}

	@Override
	public MessageVO selectMessageByNo(SqlSession session, int messageNo) {
		MessageVO message = session.selectOne("MessageManagerMapper.selectMessage", messageNo);
		return message;
	}

	@Override
	public int getSearchTotalCount(Map<String, Object> searchMap, SqlSession session) {
		int result;
		if(searchMap.size() > 2) {
			result = session.selectOne("MessageManagerMapper.searchUserTotalCount", searchMap);			
		}
		else {
			result = session.selectOne("MessageManagerMapper.searchTotalCount", searchMap);
		}
		return result;
	}

	@Override
	public List<MessageVO> searchMessageList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<MessageVO> mList;
		
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("keyword", pInfo.getSearchKeyword()); // 검색할 키워드
	    paramMap.put("type", pInfo.getSearchType());    // 검색할 타입
	    if(pInfo.getMemberId() != null) {
	    	paramMap.put("memberId", pInfo.getMemberId());
	    }
		if(paramMap.size() > 2) {
			mList = session.selectList("MessageManagerMapper.selectUserSearchList", paramMap, rowBounds);
		}
		else {
			mList = session.selectList("MessageManagerMapper.selectSearchList", paramMap, rowBounds);			
		}
		return mList;
	}

	@Override
	public int changeYn(SqlSession session, int messageNo) {
		int result = session.update("MessageManagerMapper.changeReadYn", messageNo);
		return result;
	}

	@Override
	public int getTotalCount(String memberId, SqlSession session) {
		int result = session.selectOne("MessageManagerMapper.selectUserTotalCount", memberId);
		return result;
	}

	@Override
	public List<MessageVO> selectMessageList(SqlSession session, PageInfo pInfo, String memberId) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MessageVO> mList = session.selectList("MessageManagerMapper.selectUserMessage", memberId, rowBounds);
		return mList;
	}

	@Override
	public int sendMessage(SqlSession session, MessageVO message) {
		int result = session.insert("MessageManagerMapper.sendMessage", message);
		return result;
	}

}
