package com.su.service;

import java.io.IOException;

import com.su.model.PageInfo;

public interface FlowerService {
	PageInfo show(int pagenum,int pagesize,String name,double price) throws IOException;
}
