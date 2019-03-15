package com.su.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	
	private String username;
	public String password;
	
	
	public String login() {
		//获取request
		ActionContext.getContext().get("request");
		Map<String, Object> reqMap=(Map<String, Object>)ActionContext.getContext().get("request");
		reqMap.put("pwd", username);
		System.out.println("登录成功");
		return Action.SUCCESS;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
