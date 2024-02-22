package com.kh.areyout.manager.message.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.areyout.manager.message.domain.MessageVO;
import com.kh.areyout.manager.message.domain.PageInfo;

public interface MessageStore {

	/**
	 * 메세지 총 갯수 Store
	 * @param session
	 * @return result
	 */
	int getTotalCount(SqlSession session);

	/**
	 * 전체 메세지 목록 조회 Store
	 * @param pInfo
	 * @param session
	 * @return
	 */
	List<MessageVO> selectMessageList(PageInfo pInfo, SqlSession session);

	/**
	 * 메세지 삭제 Store
	 * @param session
	 * @param num
	 * @return result
	 */
	int deleteMessage(SqlSession session, int num);

	/**
	 * 메세지 상세 조회 Store
	 * @param session
	 * @param messageNo
	 * @return message
	 */
	MessageVO selectMessageByNo(SqlSession session, int messageNo);

	/**
	 * 검색된 메세지 총 갯수 Store
	 * @param searchMap
	 * @param session
	 * @return result
	 */
	int getSearchTotalCount(Map<String, Object> searchMap, SqlSession session);

	/**
	 * 검색 메세지 목록 조회 Store
	 * @param session
	 * @param pInfo
	 * @return mList
	 */
	List<MessageVO> searchMessageList(SqlSession session, PageInfo pInfo);

	/**
	 * 읽기 상태 변경
	 * @param session
	 * @param messageNo
	 * @return result
	 */
	int changeYn(SqlSession session, int messageNo);

}
