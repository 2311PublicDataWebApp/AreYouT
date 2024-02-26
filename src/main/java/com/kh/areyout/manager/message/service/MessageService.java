package com.kh.areyout.manager.message.service;

import java.util.List;
import java.util.Map;

import com.kh.areyout.manager.message.domain.MessageVO;
import com.kh.areyout.manager.PageInfo;

public interface MessageService {

	/**
	 * 전체 메세지 갯수 Service
	 * @return result
	 */
	public int getTotalCount();

	/**
	 * 전체 메세지 목록 조회 Service
	 * @param pInfo
	 * @return mList
	 */
	public List<MessageVO> selectMessageList(PageInfo pInfo);

	/**
	 * 메세지 삭제 Service
	 * @param num
	 * @return result
	 */
	public int deleteMessage(int num);

	/**
	 * 메세지 상세 조회 Service
	 * @param messageNo
	 * @return message
	 */
	public MessageVO selectMessageByNo(int messageNo);

	/**
	 * 검색된 메세지 총 갯수 Service
	 * @param searchMap
	 * @return result
	 */
	public int getSearchTotalCount(Map<String, Object> searchMap);

	/**
	 * 검색 메세지 목록 조회 Service
	 * @param pInfo
	 * @return mList
	 */
	public List<MessageVO> searchMessageList(PageInfo pInfo);

	/**
	 * 읽음/안읽음 상태 변경 Service
	 * @param message
	 * @return	result
	 */
	public int changeYn(int messageNo);

	/**
	 * OverLoading
	 * 유저 쪽지함 쪽지 갯수 Service
	 * @param memberId
	 * @return result
	 */
	public int getTotalCount(String memberId);

	/**
	 * OverLoading
	 * 유저 쪽지함 목록 Service
	 * @param pInfo
	 * @param memberId
	 * @return mList
	 */
	public List<MessageVO> selectMessageList(PageInfo pInfo, String memberId);

	/**
	 * 메세지 전송 Service
	 * @param askMessage
	 * @return
	 */
	public int sendMessage(MessageVO message);

}
