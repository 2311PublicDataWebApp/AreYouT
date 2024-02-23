package com.kh.areyout.message.domain;

import java.sql.Date;

public class MessageVO {
	private int		messageNo;
	private String	messageReceive;
	private String	messageSender;
	private Date	sendDate;
	private String	messageTitle;
	private String	messageContent;
	private char	readYn;
	
	public MessageVO() {}
	
	public int getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}
	public String getMessageReceive() {
		return messageReceive;
	}
	public void setMessageReceive(String messageReceive) {
		this.messageReceive = messageReceive;
	}
	public String getMessageSender() {
		return messageSender;
	}
	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public char getReadYn() {
		return readYn;
	}
	public void setReadYn(char readYn) {
		this.readYn = readYn;
	}
	
	@Override
	public String toString() {
		return "MessageVO [messageNo=" + messageNo + ", messageReceive=" + messageReceive + ", messageSender="
				+ messageSender + ", sendDate=" + sendDate + ", messageTitle=" + messageTitle + ", messageContent="
				+ messageContent + ", readYn=" + readYn + "]";
	}
}
