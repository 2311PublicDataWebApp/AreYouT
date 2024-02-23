package com.kh.areyout.manager.askmessage.store;

import java.util.List;
import java.util.Map;

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

	/**
	 * 문의 메세지 답변 전송 Store
	 * @param session
	 * @param askMessage
	 * @return
	 */
	int sendAskMessage(SqlSession session, AskMessageVO askMessage);

	/**
	 * 문의 메세지 검색 메세지 갯수 Store
	 * @param session
	 * @param searchMap
	 * @return result
	 */
	int getSearchTotalCount(SqlSession session, Map<String, Object> searchMap);

	/**
	 * 문의 메세지 검색 조회 Store
	 * @param session
	 * @param pInfo
	 * @return amList
	 */
	List<AskMessageVO> searchAskMessageList(SqlSession session, PageInfo pInfo);

}
