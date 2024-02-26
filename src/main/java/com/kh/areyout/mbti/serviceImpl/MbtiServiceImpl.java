package com.kh.areyout.mbti.serviceImpl;

import java.util.List;

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

//	@Override
//	public int matchingMbti(MemberVO member) {
//		int result = mStore.matchingMbti(session, member);
//		return result;
//	}
//	
	@Override
	public int updateMbti(MemberVO member) {
		int result = mStore.updateMbti(session, member);
		return result;
	}

//	@Override
//	public MemberVO getOneById(String memberId) {
//		MemberVO member = mStore.selectOnebyId(session, memberId);
//		return member;
//	}

//	@Override
//	public List<MemberVO> getMatchingMbtiList(MemberVO member) {
//		return mStore.getMatchingMbti(member);
//	}


	@Override
	public List<MemberVO>getMatchingMembersByMbti(MemberVO member) {
	    List<MemberVO> matchingMembers = mStore.getMatchingMembersByMbti(session, member);
	    // �α� �߰�
	    System.out.println("Matching Members: " + matchingMembers);
	    return matchingMembers;
	}

	@Override
	public List<MemberVO> getMatchingMbtiList(String memberId) {
//		 List<MemberVO> matchingList = mStore.getMatchingMembersByMbti(memberId);
		 return null;
	}
	
	
	@Override
	public MemberVO getOneById(String memberId) {
		MemberVO member = mStore.selectOnebyId(session, memberId);
		return member;
	}

	


	
}
