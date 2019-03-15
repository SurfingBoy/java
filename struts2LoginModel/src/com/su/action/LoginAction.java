package com.su.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.su.model.User;

public class LoginAction implements ModelDriven<User>{
	private User user=new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	public String login() {
		System.out.println("登录成功llll");
		//获取request
		ActionContext.getContext().get("request");
		Map<String, Object> reqMap=(Map<String, Object>)ActionContext.getContext().get("request");
		reqMap.put("pwd", user.getPassword());
		//session
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("user", user.getUsername());
		return Action.SUCCESS;
	}
	
}
