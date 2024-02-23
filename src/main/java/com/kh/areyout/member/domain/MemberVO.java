package com.kh.areyout.member.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberNickname;
	private int memberAge;
	private String memberGender;
	private String memberMbti;
	private String memberEmail;
	private String memberPhone;
	private Date memberDate;
	private char blackListYn;
	private String memberFilename;
	private String memberFileRename;
	private String memberFilePath;
	private long memberFileLength;
	
	public MemberVO() {}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberMbti() {
		return memberMbti;
	}

	public void setMemberMbti(String memberMbti) {
		this.memberMbti = memberMbti;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public Date getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}

	public char getBlackListYn() {
		return blackListYn;
	}

	public void setBlackListYn(char blackListYn) {
		this.blackListYn = blackListYn;
	}

	public String getMemberFilename() {
		return memberFilename;
	}

	public void setMemberFilename(String memberFilename) {
		this.memberFilename = memberFilename;
	}

	public String getMemberFileRename() {
		return memberFileRename;
	}

	public void setMemberFileRename(String memberFileRename) {
		this.memberFileRename = memberFileRename;
	}

	public String getMemberFilePath() {
		return memberFilePath;
	}

	public void setMemberFilePath(String memberFilePath) {
		this.memberFilePath = memberFilePath;
	}

	public long getMemberFileLength() {
		return memberFileLength;
	}

	public void setMemberFileLength(long memberFileLength) {
		this.memberFileLength = memberFileLength;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberNickname=" + memberNickname + ", memberAge=" + memberAge + ", memberGender=" + memberGender
				+ ", memberMbti=" + memberMbti + ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone
				+ ", memberDate=" + memberDate + ", blackListYn=" + blackListYn + ", memberFilename=" + memberFilename
				+ ", memberFileRename=" + memberFileRename + ", memberFilePath=" + memberFilePath
				+ ", memberFileLength=" + memberFileLength + "]";
	}
	
}
