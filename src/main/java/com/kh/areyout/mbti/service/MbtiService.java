package com.kh.areyout.mbti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.areyout.member.domain.MemberVO;

@Service
public interface MbtiService {

//	int matchingMbti(MemberVO member);
	
	int updateMbti(MemberVO member);

//	MemberVO getOneById(String memberId);

//	List<MemberVO> getMatchingMbtiList(MemberVO member);

	List<MemberVO> getMatchingMembersByMbti(MemberVO member);

	List<MemberVO> getMatchingMbtiList(String memberId);

	MemberVO getOneById(String memberId);

	

	
	

}
