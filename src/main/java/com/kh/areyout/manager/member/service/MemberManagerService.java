package com.kh.areyout.manager.member.service;

import java.util.List;
import java.util.Map;

import com.kh.areyout.manager.member.domain.MemberVO;
import com.kh.areyout.manager.PageInfo;

public interface MemberManagerService {
	/**
	 * 전체 일반 회원 수 조회 Service
	 * @return result
	 */
	int getTotalCount();

	/**
	 * 일반 회원 목록 조회 Service
	 * @param pInfo
	 * @return mmList
	 */
	List<MemberVO> selectMemberList(PageInfo pInfo);
	
	/**
	 * 일반 회원 목록 검색 조회 Service
	 * @param pInfo
	 * @return mmList
	 */
	List<MemberVO> selectSearchList(PageInfo pInfo);

	/**
	 * 검색 일반 회원 수 조회 Service
	 * @param searchMap
	 * @return result
	 */
	int getSearchTotalCount(Map<String, Object> searchMap);

	/**
	 * 선택 일반 회원 삭제 Service
	 * @param memberId
	 * @return result
	 */
	int deleteMembers(String memberId);

	/**
	 * 블랙리스트 회원 조회 Service
	 * @param pInfo
	 * @return mmList
	 */
	List<MemberVO> selectBlackList(PageInfo pInfo);

	/**
	 * 블랙리스트 회원 수 조회 Service
	 * @return
	 */
	int getBlackTotalCount();

	/**
	 * 일반 회원 정지 처리 Service
	 * @param memberId
	 * @return result
	 */
	int blackMembers(String memberId);

	/**
	 * 정지 회원 정지 취소 처리 Service
	 * @param memberId
	 * @return result
	 */
	int whiteMembers(String memberId);

	/**
	 * 전체 정지 회원 수 조회 Service
	 * @return result
	 */
	int getBlackSearchTotalCount(Map<String, Object> searchMap);
	/**
	 * 정지 회원 검색 조회 Service
	 * @param pInfo
	 * @return mmList
	 */
	List<MemberVO> searchBlackList(PageInfo pInfo);

}
