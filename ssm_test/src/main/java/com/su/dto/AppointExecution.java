package com.su.dto;

import com.su.entity.Appointment;
import com.su.enums.AppointStateEnum;

/**
 * 预约结果
 * @author Administrator
 *
 */
public class AppointExecution {
	private long bookId;
	private int state;
	private String stateInfo;
	private Appointment appointment;
	
	//预约失败
	public AppointExecution(long bookId,AppointStateEnum stateEnum) {
		this.bookId=bookId;
		this.state=stateEnum.getState();
		this.stateInfo=stateEnum.getStateInfo();
	}
	
	//预约成功
	public AppointExecution(long bookId,AppointStateEnum stateEnum,Appointment appointment) {
		this.bookId=bookId;
		this.state=stateEnum.getState();
		this.stateInfo=stateEnum.getStateInfo();
		this.appointment=appointment;
	}
	
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfoString() {
		return stateInfo;
	}
	public void setStateInfoString(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "AppointExecution [bookId=" + bookId + ", state=" + state + ", stateInfoString=" + stateInfo
				+ ", appointment=" + appointment + "]";
	}
	
	
}
