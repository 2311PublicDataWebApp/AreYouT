package com.kh.areyout.manager.member.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.areyout.manager.member.domain.MemberVO;
import com.kh.areyout.manager.member.domain.PageInfo;
import com.kh.areyout.manager.member.service.MemberManagerService;
import com.kh.areyout.manager.member.store.MemberManagerStore;

@Service
public class MemberManagerServiceImpl implements MemberManagerService{
	@Autowired
	private MemberManagerStore mmStore;
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		int result = mmStore.selectTotalCount(session);
		return result;
	}

	@Override
	public List<MemberVO> selectMemberList(PageInfo pInfo) {
		List<MemberVO> mmList = mmStore.selectMemberList(session, pInfo);
		return mmList;
	}

	@Override
	public List<MemberVO> selectSearchList(PageInfo pInfo) {
		List<MemberVO> mmList = mmStore.selectSearchList(session, pInfo);
		return mmList;
	}

	@Override
	public int getSearchTotalCount(Map<String, Object> searchMap) {
		int result = mmStore.searchTotalCount(session, searchMap);
		return result;
	}

	@Override
	public int deleteMembers(String memberId) {
		int result = mmStore.deleteMembers(session, memberId);
		return result;
	}

	@Override
	public List<MemberVO> selectBlackList(PageInfo pInfo) {
		List<MemberVO> mmList = mmStore.selectBlackList(session, pInfo);
		return mmList;
	}

	@Override
	public int getBlackTotalCount() {
		int result = mmStore.getBlackTotalCount(session);
		return result;
	}

	@Override
	public int blackMembers(String memberId) {
		int result = mmStore.blackMembers(session, memberId);
		return result;
	}

	@Override
	public int whiteMembers(String memberId) {
		int result = mmStore.whiteMembers(session, memberId);
		return result;
	}

	@Override
	public int getBlackSearchTotalCount(Map<String, Object> searchMap) {
		int result = mmStore.getBlackSearchTotalCount(session, searchMap);
		return result;
	}
	
}
