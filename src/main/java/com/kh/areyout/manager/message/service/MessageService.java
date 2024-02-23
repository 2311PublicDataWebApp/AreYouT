package com.kh.areyout.manager.message.service;

import java.util.List;
import java.util.Map;

import com.kh.areyout.manager.message.domain.MessageVO;
import com.kh.areyout.manager.message.domain.PageInfo;

public interface MessageService {

	/**
	 * 전체 메세지 갯수 Service
	 * @return result
	 */
	int getTotalCount();

	/**
	 * 전체 메세지 목록 조회 Service
	 * @param pInfo
	 * @return mList
	 */
	List<MessageVO> selectMessageList(PageInfo pInfo);

	/**
	 * 메세지 삭제 Service
	 * @param num
	 * @return result
	 */
	int deleteMessage(int num);

	/**
	 * 메세지 상세 조회 Service
	 * @param messageNo
	 * @return message
	 */
	MessageVO selectMessageByNo(int messageNo);

	/**
	 * 검색된 메세지 총 갯수 Service
	 * @param searchMap
	 * @return result
	 */
	int getSearchTotalCount(Map<String, Object> searchMap);

	/**
	 * 검색 메세지 목록 조회 Service
	 * @param pInfo
	 * @return mList
	 */
	List<MessageVO> searchMessageList(PageInfo pInfo);

	/**
	 * 읽음/안읽음 상태 변경 Service
	 * @param message
	 * @return	result
	 */
	int changeYn(int messageNo);

	/**
	 * OverLoading
	 * 유저 쪽지함 쪽지 갯수 Service
	 * @param memberId
	 * @return result
	 */
	int getTotalCount(String memberId);

	/**
	 * OverLoading
	 * 유저 쪽지함 목록 Service
	 * @param pInfo
	 * @param memberId
	 * @return mList
	 */
	List<MessageVO> selectMessageList(PageInfo pInfo, String memberId);

}
