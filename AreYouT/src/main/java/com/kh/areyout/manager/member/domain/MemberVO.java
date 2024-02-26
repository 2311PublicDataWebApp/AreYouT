package com.kh.areyout.manager.member.domain;

import java.sql.Date;

public class MemberVO {
	private String	memberId;
	private String	memberNickname;
	private String	memberPw;
	private String	memberName;
	private int		memberAge;
	private String	memberGender;
	private String	memberMbti;
	private String	memberEmail;
	private String	memberPhone;
	private Date	memberDate;
	private char	memberBlockYn;
	
	public MemberVO() {}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
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
	public char getMemberBlockYn() {
		return memberBlockYn;
	}
	public void setMemberBlockYn(char memberBlockYn) {
		this.memberBlockYn = memberBlockYn;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberNickname=" + memberNickname + ", memberPw=" + memberPw
				+ ", memberName=" + memberName + ", memberAge=" + memberAge + ", memberGender=" + memberGender
				+ ", memberMbti=" + memberMbti + ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone
				+ ", memberDate=" + memberDate + ", memberBlockYn=" + memberBlockYn + "]";
	}
}
