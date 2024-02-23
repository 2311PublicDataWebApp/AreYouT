package com.kh.areyout.member.service;

import java.util.List;

import com.kh.areyout.member.domain.MemberVO;

public interface MemberService {

	/**
	 * 회원 로그인
	 * 
	 * @param member
	 * @return member
	 */
	MemberVO checkMemberLogin(MemberVO member);

	/**
	 * 회원 정보 등록
	 * 
	 * @param member
	 * @return result
	 */
	int insertMember(MemberVO member);

	/**
	 * 회원 아이디 검색 Service
	 * @param memberId
	 * @return mOne
	 */
	MemberVO getOneById(String memberId);

	/**
	 * 회원 정보 수정
	 * @param member
	 * @return result
	 */
	int updateMember(MemberVO member);

	/**
	 * 회원 탈퇴 Service
	 * @param memberId
	 * @return result
	 */
	int deleteMember(MemberVO member);
	
	/**
	 * 회원 아이디 찾기
	 * @param member
	 * @return
	 */
	MemberVO findId(MemberVO member);
	
	/**
	 * 회원 비밀번호 찾기
	 * @param member
	 * @return
	 */
	int findPw(MemberVO member);

	MemberVO findPwForm(MemberVO member);
	
	
	
	/**
	 * 프로필 수정
	 * @param member
	 * @return
	 */
	int updateProfile(MemberVO member);
}
