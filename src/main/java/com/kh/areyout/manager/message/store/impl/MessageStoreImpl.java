package com.kh.areyout.manager.message.store.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.areyout.manager.message.domain.MessageVO;
import com.kh.areyout.manager.message.domain.PageInfo;
import com.kh.areyout.manager.message.store.MessageStore;

@Repository
public class MessageStoreImpl implements MessageStore{

	@Override
	public int getTotalCount(SqlSession session) {
		int result = session.selectOne("MesaageManagerMapper.selectTotalCount");
		return result;
	}

	@Override
	public List<MessageVO> selectMessageList(PageInfo pInfo, SqlSession session) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<MessageVO> mList = session.selectList("MesaageManagerMapper.selectMessageList", null, rowBounds);		
		return mList;
	}

	@Override
	public int deleteMessage(SqlSession session, int num) {
		int result = session.delete("MesaageManagerMapper.deleteMessage", num);
		return result;
	}

	@Override
	public MessageVO selectMessageByNo(SqlSession session, int messageNo) {
		MessageVO message = session.selectOne("MesaageManagerMapper.selectMessage", messageNo);
		return message;
	}

	@Override
	public int getSearchTotalCount(Map<String, Object> searchMap, SqlSession session) {
		int result = session.selectOne("MesaageManagerMapper.searchTotalCount", searchMap);
		return result;
	}

	@Override
	public List<MessageVO> searchMessageList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("keyword", pInfo.getSearchKeyword()); // 검색할 키워드
	    paramMap.put("type", pInfo.getSearchType());     // 검색할 타입
		
		List<MessageVO> mList = session.selectList("MesaageManagerMapper.selectSearchList", paramMap, rowBounds);
		return mList;
	}

	@Override
	public int changeYn(SqlSession session, int messageNo) {
		int result = session.update("MesaageManagerMapper.changeReadYn", messageNo);
		return result;
	}

}
