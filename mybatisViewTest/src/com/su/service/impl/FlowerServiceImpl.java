package com.su.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.su.mapper.FlowerMapper;
import com.su.model.Flower;
import com.su.service.FlowerService;
import com.su.util.MyBatisUtil;

public class FlowerServiceImpl implements FlowerService{

	@Override
	public int ins(Flower flower) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisUtil.getSession();
		FlowerMapper mapper = session.getMapper(FlowerMapper.class);
		return mapper.ins(flower);
	}

}
