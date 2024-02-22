package com.kh.areyout.manager.askmessage.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.areyout.manager.askmessage.domain.AskMessageVO;
import com.kh.areyout.manager.askmessage.domain.PageInfo;

public interface AskMessageStore {

	/**
	 * 전체 문의 메세지 갯수 Store
	 * @param session
	 * @return result
	 */
	int getTotalCount(SqlSession session);

	/**
	 * 문의 메세지 목록 조회 Store
	 * @param session
	 * @param pInfo
	 * @return amList
	 */
	List<AskMessageVO> selectAskMessageList(SqlSession session, PageInfo pInfo);

	/**
	 * 메세지 삭제 Store
	 * @param session
	 * @param num
	 * @return
	 */
	int deleteMessage(SqlSession session, int num);

	/**
	 * 메세지 쓰기 창 Store
	 * @param session
	 * @param askMessageNo
	 * @return askMessage
	 */
	AskMessageVO selectAskMessageByNo(SqlSession session, int askMessageNo);

	/**
	 * 문의 메세지 상세 조회 Store
	 * @param session
	 * @param askMessageNo
	 */
	void changeYn(SqlSession session, int askMessageNo);

}
