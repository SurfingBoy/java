package com.su.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import com.su.model.Flower;
import com.su.model.PageInfo;
import com.su.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{

	@Override
	public PageInfo show(int pagenum, int pagesize,String name,double price) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream iStream = Resources.getResourceAsStream("mybaits.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(iStream);
		SqlSession session=factory.openSession();
		PageInfo pInfo=new PageInfo();
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startPage", pagesize*(pagenum-1));
		map.put("pageSize", pagesize);
		map.put("name",name);
		map.put("price",price);
		List<Flower> infoList=session.selectList("a.b.selByPage",map);
		int total=session.selectOne("a.b.selCount");
		session.close();
		pInfo.setName(name);
		pInfo.setPrice(price);
		pInfo.setPagesize(pagesize);
		pInfo.setPagenum(pagenum);
		pInfo.setPagetotal(total%pagesize==0?total/pagesize:(total/pagesize+1));
		pInfo.setInfoList(infoList);
		return pInfo;
	}

}
