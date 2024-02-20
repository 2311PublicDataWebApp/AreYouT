package com.kh.areyout.manager.member.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.areyout.manager.member.domain.MemberVO;
import com.kh.areyout.manager.member.domain.PageInfo;

public interface MemberManagerStore {

	/**
	 * 일반 회원 전체 수 조회 Store
	 * @param session
	 * @return result
	 */
	int selectTotalCount(SqlSession session);
	
	/**
	 * 일반 회원 목록 조회 Store
	 * @param session
	 * @param pInfo
	 * @return mmList
	 */
	List<MemberVO> selectMemberList(SqlSession session, PageInfo pInfo);

	/**
	 * 일반 회원 목록 검색 조회 Store
	 * @param session
	 * @param pInfo
	 * @return mmList
	 */
	List<MemberVO> selectSearchList(SqlSession session, PageInfo pInfo);

	/**
	 * 검색 일반 회원 수 조회 Store
	 * @param session
	 * @param searchMap
	 * @return result
	 */
	int searchTotalCount(SqlSession session, Map<String, Object> searchMap);

	/**
	 * 선택 일반 회원 삭제 Store
	 * @param session
	 * @param memberId
	 * @return result
	 */
	int deleteMembers(SqlSession session, String memberId);

	/**
	 * 정지 회원 전체 수 조회 Store
	 * @param session
	 * @return
	 */
	int getBlackTotalCount(SqlSession session);

	/**
	 * 정지 회원 목록 조회 Store
	 * @param session
	 * @param pInfo
	 * @return mmList
	 */
	List<MemberVO> selectBlackList(SqlSession session, PageInfo pInfo);

	/**
	 * 일반 회원 정지 처리 Store
	 * @param session
	 * @param memberId
	 * @return result
	 */
	int blackMembers(SqlSession session, String memberId);

	/**
	 * 정지 회원 정지 취소 처리 Store
	 * @param session
	 * @param memberId
	 * @return result
	 */
	int whiteMembers(SqlSession session, String memberId);

	/**
	 * 검색 정지 회원 수 조회 Store
	 * @param session
	 * @param searchMap
	 * @return result
	 */
	int getBlackSearchTotalCount(SqlSession session, Map<String, Object> searchMap);

}
