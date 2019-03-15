package com.su.service.impl;

import java.util.List;

import com.su.mapper.FlowerMapper;
import com.su.model.Flower;
import com.su.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{
	private FlowerMapper flowerMapper;
	
	public FlowerMapper getFlowerMapper() {
		return flowerMapper;
	}

	public void setFlowerMapper(FlowerMapper flowerMapper) {
		this.flowerMapper = flowerMapper;
	}

	@Override
	public List<Flower> show() {
		// TODO Auto-generated method stub
		return flowerMapper.selAll();
	}

}
