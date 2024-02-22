package com.kh.areyout.manager.askmessage.service;

import java.util.List;

import com.kh.areyout.manager.askmessage.domain.AskMessageVO;
import com.kh.areyout.manager.askmessage.domain.PageInfo;

public interface AskMessageService {

	/**
	 * 전체 문의 메세지 갯수 Service
	 * @return result
	 */
	int getTotalCount();

	/**
	 * 문의 메세지 목록 조회 Service
	 * @param pInfo
	 * @return amList
	 */
	List<AskMessageVO> selectAskMessageList(PageInfo pInfo);

	/**
	 * 메세지 삭제 Service
	 * @param num
	 * @return	result
	 */
	int deleteMessage(int num);

	/**
	 * 답변 메세지 쓰기 창 Service
	 * @param askMessageNo
	 * @return askMessage
	 */
	AskMessageVO selectAskMessageByNo(int askMessageNo);

	/**
	 * 문의 메세지 상세 조회 Service
	 * @param askMessage
	 */
	void changeYn(int askMessageNo);

}
