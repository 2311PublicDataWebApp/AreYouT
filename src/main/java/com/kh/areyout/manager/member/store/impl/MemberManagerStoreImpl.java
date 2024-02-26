package com.kh.areyout.manager.member.store.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.areyout.manager.member.domain.MemberVO;
import com.kh.areyout.manager.PageInfo;
import com.kh.areyout.manager.member.store.MemberManagerStore;

@Repository
public class MemberManagerStoreImpl implements MemberManagerStore{

	@Override
	public int selectTotalCount(SqlSession session) {
		int result = session.selectOne("MemberManagerMapper.selectTotalCount");
		return result;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<MemberVO> mmList = session.selectList("MemberManagerMapper.selectMemberList", null, rowBounds);		
		return mmList;
	}

	@Override
	public List<MemberVO> selectSearchList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("keyword", pInfo.getSearchKeyword()); // 검색할 키워드
	    paramMap.put("type", pInfo.getSearchType());     // 검색할 타입
		
		List<MemberVO> mmList = session.selectList("MemberManagerMapper.selectSearchList", paramMap, rowBounds);		
		return mmList;
	}

	@Override
	public int searchTotalCount(SqlSession session, Map<String, Object> searchMap) {
		int result = session.selectOne("MemberManagerMapper.searchTotalCount", searchMap);
		return result;
	}

	@Override
	public int deleteMembers(SqlSession session, String memberId) {
		int result = session.delete("MemberManagerMapper.deleteMember", memberId);
		return result;
	}

	@Override
	public int getBlackTotalCount(SqlSession session) {
		int result = session.selectOne("MemberManagerMapper.blackTotalCount");
		return result;
	}

	@Override
	public List<MemberVO> selectBlackList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<MemberVO> mmList = session.selectList("MemberManagerMapper.selectBlackList", null, rowBounds);		
		return mmList;
	}

	@Override
	public int blackMembers(SqlSession session, String memberId) {
		int result = session.update("MemberManagerMapper.blackMember", memberId);
		return result;
	}

	@Override
	public int whiteMembers(SqlSession session, String memberId) {
		int result = session.update("MemberManagerMapper.whiteMember", memberId);
		return result;
	}

	@Override
	public int getBlackSearchTotalCount(SqlSession session, Map<String, Object> searchMap) {
		int result = session.selectOne("MemberManagerMapper.searchBlackTotalCount", searchMap);
		return result;
	}

	@Override
	public List<MemberVO> searchBlackList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("keyword", pInfo.getSearchKeyword()); // 검색할 키워드
	    paramMap.put("type", pInfo.getSearchType());     // 검색할 타입
		
		List<MemberVO> mmList = session.selectList("MemberManagerMapper.searchBlackList", paramMap, rowBounds);		
		return mmList;
	}

}
