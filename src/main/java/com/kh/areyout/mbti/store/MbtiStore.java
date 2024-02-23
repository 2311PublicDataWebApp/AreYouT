package com.kh.areyout.mbti.store;

import org.apache.ibatis.session.SqlSession;

import com.kh.areyout.member.domain.MemberVO;

public interface MbtiStore {

	int updateMbti(SqlSession session, MemberVO member);

}
