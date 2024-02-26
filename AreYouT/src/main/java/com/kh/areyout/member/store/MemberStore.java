package com.kh.areyout.member.store;

import org.apache.ibatis.session.SqlSession;

import com.kh.areyout.member.domain.MemberVO;

public interface MemberStore {
	
	/**
	 * 회원 정보 등록
	 * @param session
	 * @param member
	 * @return result
	 */
	int insertMember(SqlSession session, MemberVO member);

	/**
	 * 회원 로그인
	 * @param session
	 * @param member
	 * @return mOne
	 */
	MemberVO checkMemberLogin(SqlSession session, MemberVO member);

	/**
	 * 회원 아이디 검색
	 * @param session
	 * @param memberId
	 * @return
	 */
	MemberVO selectOnebyId(SqlSession session, String memberId);

	/**
	 * 회원 정보 수정
	 * @param session
	 * @param member
	 * @return result
	 */
	int modifyMember(SqlSession session, MemberVO member);

	/**
	 * 회원 탈퇴 Service
	 * @param session
	 * @param memberId
	 * @return result
	 */
	int deleteMember(SqlSession session, MemberVO member);
	
	/**
	 * 회원 아이디 찾기
	 * @param session
	 * @param member
	 * @return
	 */
	MemberVO findId(SqlSession session, MemberVO member);

	/**
	 * 회원 비밀번호 찾기
	 * @param session
	 * @param member
	 * @return
	 */
	int findPw(SqlSession session, MemberVO member);

	MemberVO findIdForm(SqlSession session, MemberVO member);
	
	
	
	/**
	 * 프로필 수정
	 * @param session
	 * @param member
	 * @return
	 */
	int modifyProfile(SqlSession session, MemberVO member);

}
