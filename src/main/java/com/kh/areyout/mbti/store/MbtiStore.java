package com.kh.areyout.mbti.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.areyout.member.domain.MemberVO;

public interface MbtiStore {
//
//	int matchingMbti(SqlSession session, MemberVO member);
	
	int updateMbti(SqlSession session, MemberVO member);

//	MemberVO selectOnebyId(SqlSession session, String memberId);

//	List<MemberVO> getMatchingMbti(MemberVO member);

	List<MemberVO> getMatchingMembersByMbti(SqlSession session, MemberVO member);

	MemberVO selectOnebyId(SqlSession session, String memberId);




}
