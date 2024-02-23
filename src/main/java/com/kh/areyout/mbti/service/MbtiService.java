package com.kh.areyout.mbti.service;

import org.springframework.stereotype.Service;

import com.kh.areyout.member.domain.MemberVO;

@Service
public interface MbtiService {

	int updateMbti(MemberVO member);
	
	

}
