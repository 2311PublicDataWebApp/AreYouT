package com.kh.areyout.mbti.storeImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.areyout.mbti.store.MbtiStore;
import com.kh.areyout.member.domain.MemberVO;

@Repository
public class MbtiStoreImpl implements MbtiStore{
	
//	@Autowired
//	private SqlSession session;

//	@Override
//	public int matchingMbti(SqlSession session, MemberVO member) {
//		int result = session.selectOne("MemberMapper.matchingMbti", member);
//		return result;
//	}
	
	@Override
	public int updateMbti(SqlSession session, MemberVO member) {
		int result = session.update("MemberMapper.updateMbti", member);
		return result;
	}

//	@Override
//	public List<MemberVO> getMatchingMbti(MemberVO member) {
//		// TODO Auto-generated method stub
//		return session.selectList("MemberMapper.matchingMbti", member);
//	}

	@Override
	public List<MemberVO> getMatchingMembersByMbti(SqlSession session, MemberVO member) {
	    List<MemberVO> matchingList = session.selectList("MemberMapper.getMatchingMembersByMbti", member);
	    // �α� �߰�
	    return matchingList;
	}

	@Override
	public MemberVO selectOnebyId(SqlSession session, String memberId) {
		// TODO Auto-generated method stub
		MemberVO mOne = session.selectOne("MemberMapper.selectOnebyId", memberId);
		return mOne;
	}

	/*
	 * @Override public List<MemberVO> getMatchingMembersByMbti() { List<MemberVO>
	 * matchingList = session.selectList("MemberMapper.getMatchingMembersByMbti");
	 * // �α� �߰� return matchingList; }
	 */



//	@Override
//	public MemberVO selectOnebyId(SqlSession session, String memberId) {
//		MemberVO mOne = session.selectOne("MemberMapper.matchingMbti", memberId);
//		return mOne;
//	}


}
