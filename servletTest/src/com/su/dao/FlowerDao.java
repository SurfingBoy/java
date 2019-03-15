package com.su.dao;

import java.util.List;

import com.su.model.Flower;

public interface FlowerDao {
	List<Flower> selAll();
	int add(Flower flower);
}
