package com.su.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.su.mapper.FlowerMapper;
import com.su.model.Flower;
import com.su.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{
	private FlowerMapper flowerMapper;
	
	@Value("${second.test}")
	private String test;
	public FlowerMapper getFlowerMapper() {
		return flowerMapper;
	}

	public void setFlowerMapper(FlowerMapper flowerMapper) {
		this.flowerMapper = flowerMapper;
	}

	@Override
	public List<Flower> show() {
		// TODO Auto-generated method stub
		System.out.println(test);
		return flowerMapper.selAll();
	}

}
