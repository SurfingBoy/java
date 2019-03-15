package com.su.service.impl;

import java.util.List;

import com.su.dao.FlowerDao;
import com.su.dao.impl.FlowerDaoImpl;
import com.su.model.Flower;
import com.su.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{
	private FlowerDao dao=new FlowerDaoImpl();
	@Override
	public List<Flower> show() {
		// TODO Auto-generated method stub
		return dao.selAll();
	}
	@Override
	public int add(Flower flower) {
		// TODO Auto-generated method stub
		return dao.add(flower);
	}

}
