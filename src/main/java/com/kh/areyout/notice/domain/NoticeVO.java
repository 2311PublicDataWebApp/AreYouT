package com.kh.areyout.notice.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class NoticeVO {
	private int noticeNo;
	private String noticeSubject;
	private String noticeContent;
	private String noticeWriter;
	private Date noticeDate;
	private Timestamp updateDate;
	private String noticeFilename;
	private String noticeFileRename;
	private String noticeFilePath;
	private long noticeFileLength;
	
	
	public NoticeVO() {}
	
	
	
	public NoticeVO(int noticeNo, String noticeSubject, String noticeContent, String noticeWriter, Date noticeDate,
			Timestamp updateDate, String noticeFilename, String noticeFileRename, String noticeFilePath,
			long noticeFileLength) {
		super();
		this.noticeNo = noticeNo;
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.updateDate = updateDate;
		this.noticeFilename = noticeFilename;
		this.noticeFileRename = noticeFileRename;
		this.noticeFilePath = noticeFilePath;
		this.noticeFileLength = noticeFileLength;
	}



	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeSubject() {
		return noticeSubject;
	}

	public void setNoticeSubject(String noticeSubject) {
		this.noticeSubject = noticeSubject;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getNoticeFilename() {
		return noticeFilename;
	}

	public void setNoticeFilename(String noticeFilename) {
		this.noticeFilename = noticeFilename;
	}

	public String getNoticeFileRename() {
		return noticeFileRename;
	}

	public void setNoticeFileRename(String noticeFileRename) {
		this.noticeFileRename = noticeFileRename;
	}

	public String getNoticeFilePath() {
		return noticeFilePath;
	}

	public void setNoticeFilePath(String noticeFilePath) {
		this.noticeFilePath = noticeFilePath;
	}

	public long getNoticeFileLength() {
		return noticeFileLength;
	}

	public void setNoticeFileLength(long noticeFileLength) {
		this.noticeFileLength = noticeFileLength;
	}

	@Override
	public String toString() {
		return "NoticeVO [noticeNo=" + noticeNo + ", noticeSubject=" + noticeSubject + ", noticeContent="
				+ noticeContent + ", noticeWriter=" + noticeWriter + ", noticeDate=" + noticeDate + ", updateDate="
				+ updateDate + ", noticeFilename=" + noticeFilename + ", noticeFileRename=" + noticeFileRename
				+ ", noticeFilePath=" + noticeFilePath + ", noticeFileLength=" + noticeFileLength + "]";
	}

}
