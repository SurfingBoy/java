package com.su.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticationDemo {
	public static void main(String[] args) {
		//1.获取SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//2.得到SecurityManager实例，并绑定给SecurityUtils
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3.得到Subject及创建用户名/密码身份验证Token
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("lisi","123");
		//4.进行身份验证
		subject.login(token);
		if(subject.isAuthenticated()) {
			System.out.println("登录成功");
			Session session=subject.getSession();
			System.out.println(session.getHost());
			System.out.println(session.getId());
			System.out.println(session.getLastAccessTime());
			System.out.println(session.getTimeout());
		}
		
		//5.退出
		subject.logout();
	}
}
