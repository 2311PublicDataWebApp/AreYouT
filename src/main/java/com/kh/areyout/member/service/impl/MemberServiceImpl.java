package com.kh.areyout.member.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.areyout.member.domain.MemberVO;
import com.kh.areyout.member.service.MemberService;
import com.kh.areyout.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession session;

	@Override
	public MemberVO checkMemberLogin(MemberVO member) {
		MemberVO mOne = mStore.checkMemberLogin(session, member);
		return mOne;
	}

	@Override
	public int insertMember(MemberVO member) {
		int result = mStore.insertMember(session, member);
		return result;
	}

	@Override
	public MemberVO getOneById(String memberId) {
		MemberVO member = mStore.selectOnebyId(session, memberId);
		return member;
	}

	@Override
	public int modifyMember(MemberVO member) {
		int result = mStore.modifyMember(session, member);
		return result;
	}

	@Override
	public int deleteMember(MemberVO member) {
		int result = mStore.deleteMember(session, member);
		return result;
	}

	@Override
	public MemberVO findId(MemberVO member) {
		MemberVO mOne = mStore.findId(session, member);
		return mOne;
	}

	@Override
	public int findPw(MemberVO member) {
		int result = mStore.findPw(session, member);
		return result;
	}

	@Override
	public MemberVO findPwForm(MemberVO member) {
		MemberVO mOne = mStore.findIdForm(session, member);
		return mOne;
	}

	

	@Override
	public int modifyProfile(MemberVO member) {
		int result = mStore.modifyProfile(session, member);
		return result;
	}
}
