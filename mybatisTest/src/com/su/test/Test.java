package com.su.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.su.model.Flower;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream iStream =Resources.getResourceAsStream("mybaits.xml");
		//使用工厂设计模式
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(iStream);
		//生产sqlsession
		SqlSession session=factory.openSession();
		
		List<Flower> list=session.selectList("a.b.selAll");
		
		Flower flower=session.selectOne("a.b.selOne", 3);
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id",2);
		map.put("name","月季");
		Flower flower2=session.selectOne("a.b.selByMap",map);
		System.out.println(flower2.toString()); 
//		for (Flower flower : list) {
//			System.out.println(flower.toString());
//		}
		
		//增删改需要
		session.commit();
		session.close();
	}
}
