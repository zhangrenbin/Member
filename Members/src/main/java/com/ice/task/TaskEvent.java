package com.ice.task;

import com.ice.sh1.po.Member;
import com.ice.sh1.po.Remits;

public class TaskEvent {
	
	public static TaskEvent ACTIVE_EVENT = new TaskEvent("active_event");
	
	public static TaskEvent REMIT_EVENT = new TaskEvent("remit_event");
	
	private Member m;
	
	private Remits remits;
	
	private String type;

	private TaskEvent(String type) {
		this.type = type;
	}
	
	public boolean isActiveEvent() {
		if("active_event".equals(type)) {
			return true;
		}
		return false;
	}
	
	public boolean isRemitEvent() {
		if("remit_event".equals(type)) {
			return true;
		}
		return false;
	}

	public Member getM() {
		return m;
	}

	public void setM(Member m) {
		this.m = m;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Remits getRemits() {
		return remits;
	}

	public void setRemits(Remits remits) {
		this.remits = remits;
	}
	
}
