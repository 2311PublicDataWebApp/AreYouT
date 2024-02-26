package com.kh.areyout.member.store.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.areyout.member.domain.MemberVO;
import com.kh.areyout.member.store.MemberStore;



@Repository
public class MemberStoreImpl implements MemberStore {
	
	@Override
	public MemberVO checkMemberLogin(SqlSession session, MemberVO member) {
		// TODO Auto-generated method stub
		MemberVO mOne = session.selectOne("MemberMapper.checkMemberLogin", member);
		return mOne;
	}

	@Override
	public int insertMember(SqlSession session, MemberVO member) {
		// TODO Auto-generated method stub
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public MemberVO selectOnebyId(SqlSession session, String memberId) {
		// TODO Auto-generated method stub
		MemberVO mOne = session.selectOne("MemberMapper.selectOnebyId", memberId);
		return mOne;
	}

	@Override
	public int modifyMember(SqlSession session, MemberVO member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, MemberVO member) {
		int result = session.delete("MemberMapper.deleteMember", member);
		return result;
	}

	@Override
	public MemberVO findId(SqlSession session, MemberVO member) {
		MemberVO mOne = session.selectOne("MemberMapper.findId", member);
		return mOne;
	}

	@Override
	public int findPw(SqlSession session, MemberVO member) {
		int result = session.update("MemberMapper.findPw", member);
		return result;
	}

	@Override
	public MemberVO findIdForm(SqlSession session, MemberVO member) {
		MemberVO mOne = session.selectOne("MemberMapper.findPwForm", member);
		return mOne;
	}

	
	@Override
	public int modifyProfile(SqlSession session, MemberVO member) {
		int result = session.update("MemberMapper.updateProfile", member);
		return result;
	}
}