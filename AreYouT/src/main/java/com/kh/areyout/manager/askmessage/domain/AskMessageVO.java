package com.kh.areyout.manager.askmessage.domain;

import java.sql.Date;

public class AskMessageVO {
	private int		askMessageNo;
	private String	askMessageReceive;
	private String	askMessageSender;
	private Date	askSendDate;
	private String	askMessageTitle;
	private String	askMessageContent;
	private char	askReadYn;
	
	public AskMessageVO() {}
	
	public int getAskMessageNo() {
		return askMessageNo;
	}
	public void setAskMessageNo(int askMessageNo) {
		this.askMessageNo = askMessageNo;
	}
	public String getAskMessageReceive() {
		return askMessageReceive;
	}
	public void setAskMessageReceive(String askMessageReceive) {
		this.askMessageReceive = askMessageReceive;
	}
	public String getAskMessageSender() {
		return askMessageSender;
	}
	public void setAskMessageSender(String askMessageSender) {
		this.askMessageSender = askMessageSender;
	}
	public Date getAskSendDate() {
		return askSendDate;
	}
	public void setAskSendDate(Date askSendDatel) {
		this.askSendDate = askSendDatel;
	}
	public String getAskMessageTitle() {
		return askMessageTitle;
	}
	public void setAskMessageTitle(String askMessageTitle) {
		this.askMessageTitle = askMessageTitle;
	}
	public String getAskMessageContent() {
		return askMessageContent;
	}
	public void setAskMessageContent(String askMessageContent) {
		this.askMessageContent = askMessageContent;
	}
	public char getAskReadYn() {
		return askReadYn;
	}
	public void setAskReadYn(char askReadYn) {
		this.askReadYn = askReadYn;
	}
	
	@Override
	public String toString() {
		return "AskMessageVO [askMessageNo=" + askMessageNo + ", askMessageReceive=" + askMessageReceive
				+ ", askMessageSender=" + askMessageSender + ", askSendDate=" + askSendDate + ", askMessageTitle="
				+ askMessageTitle + ", askMessageContent=" + askMessageContent + ", askReadYn=" + askReadYn + "]";
	}
}
