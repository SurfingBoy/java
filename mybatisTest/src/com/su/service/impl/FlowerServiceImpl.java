package com.su.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.su.model.Flower;
import com.su.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{

	@Override
	public List<Flower> show() throws IOException {
		InputStream iStream =Resources.getResourceAsStream("mybaits.xml");
		//使用工厂设计模式
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(iStream);
		//生产sqlsession
		SqlSession session=factory.openSession();
		
		List<Flower> list=session.selectList("a.b.selAll");
		
		return list;
	}

}
