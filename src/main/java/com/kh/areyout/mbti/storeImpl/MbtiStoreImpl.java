package com.kh.areyout.mbti.storeImpl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.areyout.mbti.store.MbtiStore;
import com.kh.areyout.member.domain.MemberVO;

@Repository
public class MbtiStoreImpl implements MbtiStore{

	@Override
	public int updateMbti(SqlSession session, MemberVO member) {
		int result = session.update("MemberMapper.updateMbti", member);
		return result;
	}

}
