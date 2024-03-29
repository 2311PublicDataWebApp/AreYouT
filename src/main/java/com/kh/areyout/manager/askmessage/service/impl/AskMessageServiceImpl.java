package com.kh.areyout.manager.askmessage.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.areyout.manager.askmessage.domain.AskMessageVO;
import com.kh.areyout.manager.PageInfo;
import com.kh.areyout.manager.askmessage.service.AskMessageService;
import com.kh.areyout.manager.askmessage.store.AskMessageStore;

@Service
public class AskMessageServiceImpl implements AskMessageService{
	@Autowired
	AskMessageStore amStore;
	@Autowired
	SqlSession session;
	
	@Override
	public int getTotalCount() {
		int result = amStore.getTotalCount(session);
		return result;
	}

	@Override
	public List<AskMessageVO> selectAskMessageList(PageInfo pInfo) {
		List<AskMessageVO> amList = amStore.selectAskMessageList(session, pInfo);
		return amList;
	}

	@Override
	public int deleteMessage(int num) {
		int result = amStore.deleteMessage(session, num);
		return result;
	}

	@Override
	public AskMessageVO selectAskMessageByNo(int askMessageNo) {
		AskMessageVO askMessage = amStore.selectAskMessageByNo(session, askMessageNo);
		return askMessage;
	}

	@Override
	public void changeYn(int askMessageNo) {
		amStore.changeYn(session, askMessageNo);
	}

	@Override
	public int sendAskMessage(AskMessageVO askMessage) {
		int result = amStore.sendAskMessage(session, askMessage);
		return result;
	}

	@Override
	public int getSearchTotalCount(Map<String, Object> searchMap) {
		int result = amStore.getSearchTotalCount(session, searchMap);
		return result;
	}

	@Override
	public List<AskMessageVO> searchAskMessageList(PageInfo pInfo) {
		List<AskMessageVO> amList = amStore.searchAskMessageList(session, pInfo);
		return amList;
	}

	@Override
	public int UserAskMessage(AskMessageVO askMessage) {
		int result = amStore.UserAskMessage(session, askMessage);
		return result;
	}

}
