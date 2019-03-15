package com.su.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.su.model.Flower;

public interface FlowerMapper {
	@Select("select *from flower")
	List<Flower> selAll();
}
