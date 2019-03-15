package com.su.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class HelloAction {
	/**
	 * 在struts2中所有业务方法都是public 
	 * 返回值都为String类型，所有业务方法都没有参数
	 * 方法名可以自定义，默认为execute
	 * @return
	 */
	public String execute()  {
		//获取application
		ActionContext.getContext().getApplication().put("application", "application的值");
		System.out.println("哈哈哈");
		return Action.SUCCESS;
	}
}
