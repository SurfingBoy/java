package com.su.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.su.model.Point;

public class PointAction {
	private Point point;
	
	
	public Point getPoint() {
		return point;
	}


	public void setPoint(Point point) {
		this.point = point;
	}


	public String execute() {
		//获取request
		return Action.SUCCESS;
	}
	
}
