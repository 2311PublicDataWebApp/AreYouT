package com.kh.areyout.mbti.serviceImpl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.areyout.mbti.service.MbtiService;
import com.kh.areyout.mbti.store.MbtiStore;
import com.kh.areyout.member.domain.MemberVO;


@Service
public class MbtiServiceImpl implements MbtiService{
	
	@Autowired
	private MbtiStore mStore;
	@Autowired
	private SqlSession session;

	@Override
	public int updateMbti(MemberVO member) {
		int result = mStore.updateMbti(session, member);
		return result;
	}
	
	
}
