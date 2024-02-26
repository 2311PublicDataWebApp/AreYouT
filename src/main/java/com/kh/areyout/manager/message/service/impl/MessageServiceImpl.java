package com.kh.areyout.manager.message.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.areyout.manager.message.domain.MessageVO;
import com.kh.areyout.manager.message.domain.PageInfo;
import com.kh.areyout.manager.message.service.MessageService;
import com.kh.areyout.manager.message.store.MessageStore;

@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	MessageStore mStore;
	@Autowired
	SqlSession session;
	
	//메세지 총 갯수
	@Override
	public int getTotalCount() {
		int result = mStore.getTotalCount(session);
		return result;
	}

	//전체 메세지 목록
	@Override
	public List<MessageVO> selectMessageList(PageInfo pInfo) {
		List<MessageVO> mList = mStore.selectMessageList(pInfo, session);
		return mList;
	}

	//메세지 삭제
	@Override
	public int deleteMessage(int num) {
		int result = mStore.deleteMessage(session, num);
		return result;
	}

	//메세지 상세 조회
	@Override
	public MessageVO selectMessageByNo(int messageNo) {
		MessageVO message = mStore.selectMessageByNo(session, messageNo);
		return message;
	}

	//검색 메세지 총 갯수
	@Override
	public int getSearchTotalCount(Map<String, Object> searchMap) {
		int result= mStore.getSearchTotalCount(searchMap, session);
		return result;
	}

	//검색 메세지 목록 조회
	@Override
	public List<MessageVO> searchMessageList(PageInfo pInfo) {
		List<MessageVO> mList = mStore.searchMessageList(session, pInfo);
		return mList;
	}

	//읽기 상태 변화
	@Override
	public int changeYn(int messageNo) {
		int result = mStore.changeYn(session, messageNo);
		return result;
	}

	//유저 쪽지함 쪽지 갯수
	@Override
	public int getTotalCount(String memberId) {
		int result = mStore.getTotalCount(memberId, session);
		return result;
	}

	//유저 쪽지함 목록
	@Override
	public List<MessageVO> selectMessageList(PageInfo pInfo, String memberId) {
		List<MessageVO> mList = mStore.selectMessageList(session, pInfo, memberId);
		return mList;
	}
}
