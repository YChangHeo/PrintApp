package model;

import java.util.Date;

public class ProcessDefinition {
	private String OrderID;
	private String ProcessID;
	private int ProcessSeq;
	private String Time;
	private Date StartDate;
	private Date EndDate;
	
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public String getProcessID() {
		return ProcessID;
	}
	public void setProcessID(String processID) {
		ProcessID = processID;
	}
	public int getProcessSeq() {
		return ProcessSeq;
	}
	public void setProcessSeq(int processSeq) {
		ProcessSeq = processSeq;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
}
