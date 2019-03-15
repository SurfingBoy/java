package com.su.service;

import java.util.List;

import com.su.model.Flower;

public interface FlowerService {
	List<Flower> show();
	
	int add(Flower flower);
}
