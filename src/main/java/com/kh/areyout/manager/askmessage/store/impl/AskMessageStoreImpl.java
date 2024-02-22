package com.kh.areyout.manager.askmessage.store.impl;

import java.util.List;

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

	@Override
	public void changeYn(SqlSession session, int askMessageNo) {
		session.update("AskMessageMapper.changeYn", askMessageNo);
	}

}
