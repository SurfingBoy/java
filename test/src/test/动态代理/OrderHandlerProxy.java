package test.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.xml.bind.Binder;


public class OrderHandlerProxy implements InvocationHandler{
	
	private Object target;
	
	public Object bind(Object target) {
		this.target=target;
		
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), 
				this.target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if(method.getName().equalsIgnoreCase("handler")) {
			System.out.println(method.getName()+"开始执行");
			String orderId=(String)args[0];
			if(orderId.length()>10) {
				orderId=orderId.substring(0,10);
			}
			Object invoke=method.invoke(target, orderId);
			System.out.println(method.getName()+"执行结束");
			return invoke;
		}else {
			return method.invoke(target, args);
		}
		
		
	}

}
