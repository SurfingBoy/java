package com.su.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tLocal=new ThreadLocal<SqlSession>();
	static {
		try {
			InputStream iStream =Resources.getResourceAsStream("mybaits.xml");
			factory = new SqlSessionFactoryBuilder().build(iStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		SqlSession session=tLocal.get();
		if(session==null) {
			tLocal.set(factory.openSession());
		}
		return tLocal.get();
	}
	
	public static void closeSession() {
		SqlSession session=tLocal.get();
		if(session!=null) {
			session.close();
		}
		tLocal.set(null);
	}
}
