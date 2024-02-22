package com.kh.areyout.manager.travel.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class TravelVO {
	private int			travelListNo;
	private String		travelListTitle;
	private String		travelListContent;
	private String		travelListWriter;
	private int			travelListCount;
	private Date		travelListDate;
	private Timestamp	travelStartDate;
	private Timestamp	travelEndDate;
	
	public TravelVO() {}
	
	public int getTravelListNo() {
		return travelListNo;
	}
	public void setTravelListNo(int travelListNo) {
		this.travelListNo = travelListNo;
	}
	public String getTravelListTitle() {
		return travelListTitle;
	}
	public void setTravelListTitle(String travelListTitle) {
		this.travelListTitle = travelListTitle;
	}
	public String getTravelListContent() {
		return travelListContent;
	}
	public void setTravelListContent(String travelListContent) {
		this.travelListContent = travelListContent;
	}
	public String getTravelListWriter() {
		return travelListWriter;
	}
	public void setTravelListWriter(String travelListWriter) {
		this.travelListWriter = travelListWriter;
	}
	public int getTravelListCount() {
		return travelListCount;
	}
	public void setTravelListCount(int travelListCount) {
		this.travelListCount = travelListCount;
	}
	public Date getTravelListDate() {
		return travelListDate;
	}
	public void setTravelListDate(Date travelListDate) {
		this.travelListDate = travelListDate;
	}
	public Timestamp getTravelStartDate() {
		return travelStartDate;
	}
	public void setTravelStartDate(Timestamp travelStartDate) {
		this.travelStartDate = travelStartDate;
	}
	public Timestamp getTravelEndDate() {
		return travelEndDate;
	}
	public void setTravelEndDate(Timestamp travelEndDate) {
		this.travelEndDate = travelEndDate;
	}

	@Override
	public String toString() {
		return "TravelVO [travelListNo=" + travelListNo + ", travelListTitle=" + travelListTitle
				+ ", travelListContent=" + travelListContent + ", travelListWriter=" + travelListWriter
				+ ", travelListCount=" + travelListCount + ", travelListDate=" + travelListDate + ", travelStartDate="
				+ travelStartDate + ", travelEndDate=" + travelEndDate + "]";
	}
}
